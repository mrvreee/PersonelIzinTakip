/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;
import dao.PersonelDAO;
import model.Personel;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.TableModelListener;
import javax.swing.event.TableModelEvent;

/**
 *
 * @author mrveg
 */
public class RaporEkrani extends javax.swing.JFrame {
    private final PersonelDAO dao = new PersonelDAO();
    private DefaultTableModel tableModel;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(RaporEkrani.class.getName());

    /**
     */
    public RaporEkrani() {
        initComponents();
        initComponentsCustom(); 
        subeleriYukle();
        dao.otomatikYillikIzinGuncelle();
        tumRaporuYukle();
        revalidate(); 
        repaint();
    }
private void initComponentsCustom() {
    setLayout(new java.awt.BorderLayout());
    setTitle("Personel İzin Rapor Ekranı");
    setSize(900, 450);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE); 

    // 1. Üst Panel ve Butonların Oluşturulması
    javax.swing.JPanel topPanel = new javax.swing.JPanel();
    javax.swing.JLabel lblSube = new javax.swing.JLabel("Şube Seçiniz: ");
    cmbSube = new javax.swing.JComboBox<>();
    btnFiltrele = new javax.swing.JButton("Filtrele");
    btnTumunuGoster = new javax.swing.JButton("Tümünü Göster");
    btnSil = new javax.swing.JButton("Seçileni Sil");

    topPanel.add(lblSube);
    topPanel.add(cmbSube);
    topPanel.add(btnFiltrele);
    topPanel.add(btnTumunuGoster);
    topPanel.add(btnSil);

    // 2. Tablo Yapısı
    String[] columnNames = {"TC No", "Ad", "Soyad", "Şube", "Görev", "İşe Giriş Tarihi", "Hak Edilen", "Kullanılan", "Kalan İzin"};
    tableModel = new DefaultTableModel(columnNames, 0);
    tblRapor = new javax.swing.JTable(tableModel);
    javax.swing.JScrollPane scrollPane = new javax.swing.JScrollPane(tblRapor);

    getContentPane().add(topPanel, java.awt.BorderLayout.NORTH);
    getContentPane().add(scrollPane, java.awt.BorderLayout.CENTER);

    // 3. Buton Dinleyicileri
    btnFiltrele.addActionListener(evt -> subeyeGoreFiltrele());
    btnTumunuGoster.addActionListener(evt -> tumRaporuYukle());
    btnSil.addActionListener(evt -> personelSilIslemi());

 // 4. Tablodan Çift Tıklayıp Canlı Güncelleme Dinleyicisi
    tableModel.addTableModelListener(new javax.swing.event.TableModelListener() {
    @Override
    public void tableChanged(javax.swing.event.TableModelEvent evt) {
        // Sadece hücre güncellemelerinde çalışsın
        if (evt.getType() == javax.swing.event.TableModelEvent.UPDATE) {
            int row = evt.getFirstRow();
            int column = evt.getColumn();

            if (row < 0 || column < 0 || column == 8) {
                return; // Geçersiz satır/kolon veya Kalan İzin kolonu ise çık (sonsuz döngü engeli)
            }

            Object yeniDegerObj = tableModel.getValueAt(row, column);
            String yeniDeger = (yeniDegerObj != null) ? yeniDegerObj.toString().trim() : "";

            Object tcObj = tableModel.getValueAt(row, 0);
            Object adObj = tableModel.getValueAt(row, 1);
            Object soyadObj = tableModel.getValueAt(row, 2);

            String tcNo = (tcObj != null) ? tcObj.toString().trim() : "";
            String ad = (adObj != null) ? adObj.toString().trim() : "";
            String soyad = (soyadObj != null) ? soyadObj.toString().trim() : "";

            // --- İZİN KOLONLARI DEĞİŞTİĞİNDE (Hak Edilen: 6, Kullanılan: 7) ---
            if (column == 6 || column == 7) {
                try {
                    Object hakObj = tableModel.getValueAt(row, 6);
                    Object kulObj = tableModel.getValueAt(row, 7);

                    int hakEdilen = (hakObj != null && !hakObj.toString().trim().isEmpty()) ? Integer.parseInt(hakObj.toString().trim()) : 0;
                    int kullanilan = (kulObj != null && !kulObj.toString().trim().isEmpty()) ? Integer.parseInt(kulObj.toString().trim()) : 0;
                    int kalan = hakEdilen - kullanilan;

                    javax.swing.SwingUtilities.invokeLater(() -> {
                        tableModel.setValueAt(kalan, row, 8);
                    });

                    dao.personelIzinGuncelleByTcOrAd(tcNo, ad, soyad, hakEdilen, kullanilan, kalan);
                } catch (NumberFormatException e) {
                    System.out.println("Sayısal değer giriniz!");
                }
                return;
            }


            String sqlKolonAdi = null;
            switch (column) {
                case 0: sqlKolonAdi = "TCNo"; break;
                case 1: sqlKolonAdi = "Ad"; break;
                case 2: sqlKolonAdi = "Soyad"; break;
                case 3: sqlKolonAdi = "Sube"; break;
                case 4: sqlKolonAdi = "Gorev"; break;
                case 5: sqlKolonAdi = "IseGirisTarihi"; break;
                default: return;
            }

            boolean basarili = false;

            if (!tcNo.isEmpty()) {
                basarili = dao.personelHucreGuncelleByTc(tcNo, sqlKolonAdi, yeniDeger);
            } 
            
            if (!basarili && !ad.isEmpty() && !soyad.isEmpty()) {
                basarili = dao.personelHucreGuncelleByAdSoyad(ad, soyad, sqlKolonAdi, yeniDeger);
            }

            if (basarili) {
                System.out.println("✅ Güncellendi -> Kolon: " + sqlKolonAdi + " | Yeni Değer: " + yeniDeger);
            } else {
                System.out.println("❌ Güncelleme başarısız oldu!");
            }
        }
    }
    
});
}   
    private void personelSilIslemi() {
        int selectedRow = tblRapor.getSelectedRow();
        if (selectedRow == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Lütfen silmek istediğiniz personeli tablodan seçiniz!", "Uyarı", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }

        Object tcObj = tblRapor.getValueAt(selectedRow, 0); 
        Object adObj = tblRapor.getValueAt(selectedRow, 1); 
        Object soyadObj = tblRapor.getValueAt(selectedRow, 2); 

        if (tcObj == null || tcObj.toString().trim().isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Seçilen personelin TC No bilgisi bulunamadı!", "Hata", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }

        String tcNo = tcObj.toString();
        String adSoyad = (adObj != null ? adObj.toString() : "") + " " + (soyadObj != null ? soyadObj.toString() : "");

        int onay = javax.swing.JOptionPane.showConfirmDialog(
            this, 
            adSoyad + " (" + tcNo + ") isimli personeli silmek istediğinize emin misiniz?", 
            "Personel Sil Onayı", 
            javax.swing.JOptionPane.YES_NO_OPTION,
            javax.swing.JOptionPane.QUESTION_MESSAGE
        );

        if (onay == javax.swing.JOptionPane.YES_OPTION) {
            if (dao.personelSilByTc(tcNo)) {
                javax.swing.JOptionPane.showMessageDialog(this, "Personel başarıyla silindi.");
                tumRaporuYukle();
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "Silme işlemi sırasında hata oluştu!", "Hata", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    private void subeleriYukle() {
        cmbSube.removeAllItems();
        List<String> subeler = dao.subeleriGetir();
        if (subeler != null) {
            for (String sube : subeler) {
                cmbSube.addItem(sube);
            }
        }
    }


    private PersonelDAO personelDAO = new PersonelDAO();

    private void tumRaporuYukle() {
        DefaultTableModel model = (DefaultTableModel) tblRapor.getModel();
        model.setRowCount(0); 

        List<Personel> liste = personelDAO.tumPersonelRaporuGetir();

        for (Personel p : liste) {
            model.addRow(new Object[]{
                p.getTcNo(),           
                p.getAd(),             
                p.getSoyad(),          
                p.getSube(),           
                p.getGorev(),          
                p.getIseGirisTarihi(), 
                p.getHakEdilenIzin(),  
                p.getKullanilanIzin(), 
                p.getKalanIzin()       
            });
        }
    }
        private void subeyeGoreFiltrele() {
    String secilenSube = (String) cmbSube.getSelectedItem();
    if (secilenSube != null) {
        tableModel.setRowCount(0);
        List<Personel> liste = dao.birimIzinRaporuGetir(secilenSube);
        if (liste != null) {
            for (Personel p : liste) {
                tableModel.addRow(new Object[]{
                    (p.getTcNo() != null ? p.getTcNo() : ""),           
                    (p.getAd() != null ? p.getAd() : ""),               
                    (p.getSoyad() != null ? p.getSoyad() : ""),        
                    (p.getSube() != null ? p.getSube() : ""),          
                    (p.getGorev() != null ? p.getGorev() : ""),        
                    (p.getIseGirisTarihi() != null ? p.getIseGirisTarihi() : ""), 
                    p.getHakEdilenIzin(),                             
                    p.getKullanilanIzin(),                              
                    p.getKalanIzin()                                 
                });
            }
        }
    }
}  
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(RaporEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> new RaporEkrani().setVisible(true));
    }
    // Arayüz Değişken Tanımları
    private javax.swing.JComboBox<String> cmbSube;
    private javax.swing.JButton btnFiltrele;
    private javax.swing.JButton btnTumunuGoster;
    private javax.swing.JTable tblRapor;
    private javax.swing.JButton btnSil; 
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

