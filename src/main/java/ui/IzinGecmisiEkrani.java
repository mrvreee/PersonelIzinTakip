/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;
import dao.PersonelDAO;
import model.IzinGecmisi;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;

/**
 *
 * @author mrveg
 */
public class IzinGecmisiEkrani extends javax.swing.JFrame {
    private final PersonelDAO dao = new PersonelDAO();
private DefaultTableModel model;
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(IzinGecmisiEkrani.class.getName());

public IzinGecmisiEkrani() {
    initComponents();

    this.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE); 
    this.setLocationRelativeTo(null);

    model = (DefaultTableModel) jTable1.getModel();
    setTitle("Personel İzin Geçmişi Raporu");
    setLocationRelativeTo(null); 
    setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE); 

    bntExcel.setText("📊 EXCEL'E AKTAR");
    bntExcel.setBackground(new java.awt.Color(40, 167, 69)); 
    bntExcel.setForeground(java.awt.Color.WHITE);
    bntExcel.setFocusPainted(false);

    btnPdf.setText("📄 PDF / YAZDIR");
    btnPdf.setBackground(new java.awt.Color(220, 53, 69)); 
    btnPdf.setForeground(java.awt.Color.WHITE);
    btnPdf.setFocusPainted(false);

    jTable1.setRowHeight(28);
    jTable1.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 13));
    jTable1.getTableHeader().setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 13));
    jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

    model = (DefaultTableModel) jTable1.getModel();
    cmbSube.removeAllItems();
    cmbSube.addItem("Tümü");
    cmbYil.removeAllItems();
    cmbYil.addItem("Tümü");
    cmbYil.addItem("2026");
    cmbYil.addItem("2025");
    cmbYil.addItem("2024");
    
    cmbAy.removeAllItems();
    cmbAy.addItem("Tümü");
    for (int i = 1; i <= 12; i++) {
        cmbAy.addItem(String.valueOf(i));
    }

    PersonelDAO pDao = new PersonelDAO();
    for (String sube : pDao.subeleriGetir()) {
        cmbSube.addItem(sube);
    }

    tabloyuDoldur();
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        cmbSube = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cmbYil = new javax.swing.JComboBox<>();
        cmbAy = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        bntExcel = new javax.swing.JButton();
        btnPdf = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Ad", "Soyad", "Şube", "İzin Tarihi", "Kullanılan Gün", "Açıklama"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        cmbSube.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbSube.addActionListener(this::cmbSubeActionPerformed);

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Şube : ");

        cmbYil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbYil.addActionListener(this::cmbYilActionPerformed);

        cmbAy.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbAy.addActionListener(this::cmbAyActionPerformed);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Ay :");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Yıl :");

        bntExcel.setBackground(new java.awt.Color(102, 102, 102));
        bntExcel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bntExcel.setText("EXCEL'E AKTAR");
        bntExcel.addActionListener(this::bntExcelActionPerformed);

        btnPdf.setBackground(new java.awt.Color(102, 102, 102));
        btnPdf.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnPdf.setText("PDF'E AKTAR");
        btnPdf.addActionListener(this::btnPdfActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbSube, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbAy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbYil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bntExcel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPdf, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(195, 195, 195)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 910, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbSube, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(cmbYil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbAy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(bntExcel)
                    .addComponent(btnPdf))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbSubeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSubeActionPerformed
tabloyuDoldur();      
    }//GEN-LAST:event_cmbSubeActionPerformed

    private void cmbYilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbYilActionPerformed
tabloyuDoldur();
    }//GEN-LAST:event_cmbYilActionPerformed

    private void cmbAyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbAyActionPerformed
tabloyuDoldur();   
    }//GEN-LAST:event_cmbAyActionPerformed

    private void bntExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntExcelActionPerformed
    try {
    javax.swing.JFileChooser fileChooser = new javax.swing.JFileChooser();
    fileChooser.setDialogTitle("Excel / CSV Olarak Kaydet");
    fileChooser.setSelectedFile(new java.io.File("Izin_Gecmisi_Raporu.csv"));
    
    int userSelection = fileChooser.showSaveDialog(this);
    
    if (userSelection == javax.swing.JFileChooser.APPROVE_OPTION) {
        java.io.File fileToSave = fileChooser.getSelectedFile();
        
        java.io.OutputStreamWriter writer = new java.io.OutputStreamWriter(
                new java.io.FileOutputStream(fileToSave), java.nio.charset.StandardCharsets.UTF_8);
        
        writer.write("\uFEFF"); // UTF-8 BOM
        
        for (int i = 0; i < jTable1.getColumnCount(); i++) {
            writer.write(jTable1.getColumnName(i) + (i == jTable1.getColumnCount() - 1 ? "" : ";"));
        }
        writer.write("\n");
        
        
        for (int row = 0; row < jTable1.getRowCount(); row++) {
            for (int col = 0; col < jTable1.getColumnCount(); col++) {
                Object val = jTable1.getValueAt(row, col);
                String cellValue = (val != null ? val.toString() : "");
                
                if (col == 3 || cellValue.matches("\\d{4}-\\d{2}-\\d{2}")) {
                    cellValue = "\"" + cellValue + "\t\""; 
                }
                
                writer.write(cellValue + (col == jTable1.getColumnCount() - 1 ? "" : ";"));
            }
            writer.write("\n");
        }
        
        writer.close();
        javax.swing.JOptionPane.showMessageDialog(this, "Excel dosyası başarıyla oluşturuldu!", "Başarılı", javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }
} catch (Exception e) {
    javax.swing.JOptionPane.showMessageDialog(this, "Hata oluştu: " + e.getMessage(), "Hata", javax.swing.JOptionPane.ERROR_MESSAGE);
}
    }//GEN-LAST:event_bntExcelActionPerformed

    private void btnPdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPdfActionPerformed
    try {
    java.text.MessageFormat header = new java.text.MessageFormat("İzin Geçmişi Raporu");
    java.text.MessageFormat footer = new java.text.MessageFormat("Sayfa - {0}");

    boolean complete = jTable1.print(javax.swing.JTable.PrintMode.FIT_WIDTH, header, footer);

    if (complete) {
        javax.swing.JOptionPane.showMessageDialog(this, "PDF/Yazdırma işlemi tamamlandı!", "Başarılı", javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }
} catch (java.awt.print.PrinterException e) {
    javax.swing.JOptionPane.showMessageDialog(this, "PDF oluşturulurken hata: " + e.getMessage(), "Hata", javax.swing.JOptionPane.ERROR_MESSAGE);
}
    }//GEN-LAST:event_btnPdfActionPerformed

    private void tabloyuDoldur() {
    if (cmbSube.getSelectedItem() == null || cmbYil.getSelectedItem() == null || cmbAy.getSelectedItem() == null) {
        return;
    }

    model.setRowCount(0);

    String secilenSube = cmbSube.getSelectedItem().toString();
    String secilenYil = cmbYil.getSelectedItem().toString();
    String secilenAy = cmbAy.getSelectedItem().toString();

    List<IzinGecmisi> liste = dao.tumIzinGecmisiDetayliGetir();

    for (IzinGecmisi g : liste) {
        // YENİ HALİ:
        SimpleDateFormat dbFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat gorunumFormat = new SimpleDateFormat("dd.MM.yyyy"); 

        String tarihStr = (g.getIzinTarihi() != null) ? dbFormat.format(g.getIzinTarihi()) : "";
        String gorunenTarih = (g.getIzinTarihi() != null) ? gorunumFormat.format(g.getIzinTarihi()) : "";
        boolean subeUygungun = secilenSube.equals("Tümü") || g.getSube().equals(secilenSube);
        boolean yilUygun = true;
        boolean ayUygun = true;

        if (tarihStr != null && tarihStr.contains("-")) {
            String[] parcalar = tarihStr.split("-");
            String kayitYili = parcalar[0]; 
            String kayitAyi = parcalar[1];  

           
            if (!secilenYil.equals("Tümü")) {
                yilUygun = kayitYili.equals(secilenYil);
            }


            if (!secilenAy.equals("Tümü")) {
                int ayIndex = cmbAy.getSelectedIndex(); 
                String hedefAy = String.format("%02d", ayIndex); 
                ayUygun = kayitAyi.equals(hedefAy);
            }
        }
        
        if (subeUygungun && yilUygun && ayUygun) {
            model.addRow(new Object[]{
                g.getAd(),
                g.getSoyad(),
                g.getSube(),
                gorunenTarih,
                g.getIzinTarihi(),
                g.getGunSayisi(),
                g.getAciklama()
            });
        }
    }
}


    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new IzinGecmisiEkrani().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntExcel;
    private javax.swing.JButton btnPdf;
    private javax.swing.JComboBox<String> cmbAy;
    private javax.swing.JComboBox<String> cmbSube;
    private javax.swing.JComboBox<String> cmbYil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
