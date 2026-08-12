package ui;

import dao.PersonelDAO;
import model.Personel;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.TableModelEvent;
public class RaporEkrani extends javax.swing.JFrame {

    private final PersonelDAO dao = new PersonelDAO();
    private DefaultTableModel tableModel;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(RaporEkrani.class.getName());
    private boolean isUpdating = false;

    // Arayüz Elemanları
    private javax.swing.JComboBox<String> cmbSube;
    private javax.swing.JButton btnFiltrele;
    private javax.swing.JButton btnTumunuGoster;
    private javax.swing.JButton btnSil;
    private javax.swing.JButton btnExcelAktar;
    private javax.swing.JTable tblRapor;

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
        setSize(950, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);

        javax.swing.JPanel topPanel = new javax.swing.JPanel();
        javax.swing.JLabel lblSube = new javax.swing.JLabel("Şube Seçiniz: ");

        // Tüm Nesneler Oluşturuluyor (NullPointerException Önleme)
        cmbSube = new javax.swing.JComboBox<>();
        btnFiltrele = new javax.swing.JButton("Filtrele");
        btnTumunuGoster = new javax.swing.JButton("Tümünü Göster");
        btnSil = new javax.swing.JButton("Seçileni Sil");
        btnExcelAktar = new javax.swing.JButton("Excel'e Aktar"); // <-- DÜZELTİLDİ: new ile oluşturuldu

        topPanel.add(lblSube);
        topPanel.add(cmbSube);
        topPanel.add(btnFiltrele);
        topPanel.add(btnTumunuGoster);
        topPanel.add(btnSil);
        topPanel.add(btnExcelAktar);

        String[] columnNames = {"TC No", "Ad", "Soyad", "Şube", "Görev", "İşe Giriş Tarihi", "Hak Edilen", "Kullanılan", "Kalan İzin"};
        tableModel = new DefaultTableModel(columnNames, 0);
        tblRapor = new javax.swing.JTable(tableModel);
        javax.swing.JScrollPane scrollPane = new javax.swing.JScrollPane(tblRapor);

        getContentPane().add(topPanel, java.awt.BorderLayout.NORTH);
        getContentPane().add(scrollPane, java.awt.BorderLayout.CENTER);

        // Dinleyiciler (Listeners)
        btnFiltrele.addActionListener(evt -> subeyeGoreFiltrele());
        btnTumunuGoster.addActionListener(evt -> tumRaporuYukle());
        btnSil.addActionListener(evt -> personelSilIslemi());
        btnExcelAktar.addActionListener(evt -> excelAktar());

        // Tablo Düzenleme Dinleyicisi
        tableModel.addTableModelListener(evt -> {
            if (isUpdating) return;

            if (evt.getType() == TableModelEvent.UPDATE) {
                int row = evt.getFirstRow();
                int column = evt.getColumn();

                if (row < 0 || column < 0 || column == 8) return;

                Object yeniDegerObj = tableModel.getValueAt(row, column);
                String yeniDeger = (yeniDegerObj != null) ? yeniDegerObj.toString().trim() : "";

                Object tcObj = tableModel.getValueAt(row, 0);
                Object adObj = tableModel.getValueAt(row, 1);
                Object soyadObj = tableModel.getValueAt(row, 2);

                String tcNo = (tcObj != null) ? tcObj.toString().trim() : "";
                String ad = (adObj != null) ? adObj.toString().trim() : "";
                String soyad = (soyadObj != null) ? soyadObj.toString().trim() : "";

                if (column == 6 || column == 7) {
                    try {
                        Object hakObj = tableModel.getValueAt(row, 6);
                        Object kulObj = tableModel.getValueAt(row, 7);

                        int hakEdilen = (hakObj != null && !hakObj.toString().trim().isEmpty()) ? Integer.parseInt(hakObj.toString().trim()) : 0;
                        int kullanilan = (kulObj != null && !kulObj.toString().trim().isEmpty()) ? Integer.parseInt(kulObj.toString().trim()) : 0;
                        int kalan = hakEdilen - kullanilan;

                        isUpdating = true;
                        tableModel.setValueAt(kalan, row, 8);
                        isUpdating = false;

                        dao.personelIzinGuncelleByTcOrAd(tcNo, ad, soyad, hakEdilen, kullanilan, kalan);
                    } catch (Exception e) {
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

                if (!tcNo.isEmpty()) {
                    dao.personelHucreGuncelleByTc(tcNo, sqlKolonAdi, yeniDeger);
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

    private void tumRaporuYukle() {
        isUpdating = true; 
        tableModel.setRowCount(0);

        List<Personel> liste = dao.tumPersonelRaporuGetir();

        if (liste != null) {
            for (Personel p : liste) {
                tableModel.addRow(new Object[]{
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
        isUpdating = false;
    }

    private void subeyeGoreFiltrele() {
        String secilenSube = (String) cmbSube.getSelectedItem();
        if (secilenSube != null) {
            isUpdating = true;
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
            isUpdating = false;
        }
    }

    private void excelAktar() {
        if (tblRapor == null || tblRapor.getRowCount() == 0) {
            javax.swing.JOptionPane.showMessageDialog(this, "Aktarılacak veri bulunamadı!", "Uyarı", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }

        javax.swing.JFileChooser fileChooser = new javax.swing.JFileChooser();
        fileChooser.setDialogTitle("Raporu Excel Olarak Kaydet");
        fileChooser.setSelectedFile(new java.io.File("Personel_Izin_Raporu.csv"));

        int userSelection = fileChooser.showSaveDialog(this);

        if (userSelection == javax.swing.JFileChooser.APPROVE_OPTION) {
            java.io.File fileToSave = fileChooser.getSelectedFile();

            // Arka Plan İşlemi (Arayüz Donmasın Diye)
            new Thread(() -> {
                try (java.io.OutputStreamWriter writer = new java.io.OutputStreamWriter(
                        new java.io.FileOutputStream(fileToSave), java.nio.charset.StandardCharsets.UTF_8)) {

                    writer.write("\uFEFF"); // UTF-8 BOM (Türkçe Karakter Düzeltmesi)

                    int colCount = tblRapor.getColumnCount();
                    int rowCount = tblRapor.getRowCount();

                    for (int i = 0; i < colCount; i++) {
                        writer.write(tblRapor.getColumnName(i) + (i == colCount - 1 ? "" : ";"));
                    }
                    writer.write("\n");

                    for (int row = 0; row < rowCount; row++) {
                        for (int col = 0; col < colCount; col++) {
                            Object val = tblRapor.getValueAt(row, col);
                            String cellValue = (val != null ? val.toString().trim() : "");

                            if (col == 0 || cellValue.matches("\\d{4}-\\d{2}-\\d{2}")) {
                                cellValue = "\"" + cellValue + "\t\"";
                            }

                            writer.write(cellValue + (col == colCount - 1 ? "" : ";"));
                        }
                        writer.write("\n");
                    }

                    javax.swing.SwingUtilities.invokeLater(() ->
                        javax.swing.JOptionPane.showMessageDialog(this, "Rapor başarıyla Excel'e aktarıldı!", "Başarılı", javax.swing.JOptionPane.INFORMATION_MESSAGE)
                    );
                } catch (Exception e) {
                    javax.swing.SwingUtilities.invokeLater(() ->
                        javax.swing.JOptionPane.showMessageDialog(this, "Hata oluştu: " + e.getMessage(), "Hata", javax.swing.JOptionPane.ERROR_MESSAGE)
                    );
                }
            }).start();
        }
    }

    @SuppressWarnings("unchecked")

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(RaporEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> new RaporEkrani().setVisible(true));
    }
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
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

