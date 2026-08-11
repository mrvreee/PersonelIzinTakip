/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;
import dao.PersonelDAO;
import model.Personel;
import javax.swing.JOptionPane;
import ui.RaporEkrani;
/**
 *
 * @author mrveg
 */
public class AnaEkran extends javax.swing.JFrame {
    private Personel secilenPersonel;
    PersonelDAO dao = new PersonelDAO();
    public AnaEkran() {
        initComponents();
        setTitle("Personel İzin Takip Sistemi");
        new PersonelDAO().otomatikYillikIzinGuncelle();
}
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtAd = new javax.swing.JTextField();
        txtSoyad = new javax.swing.JTextField();
        btnAra = new javax.swing.JButton();
        LbLAd = new javax.swing.JLabel();
        LbLSoyad = new javax.swing.JLabel();
        LbLSube = new javax.swing.JLabel();
        LbLGorev = new javax.swing.JLabel();
        LbLHakEdilen = new javax.swing.JLabel();
        LbLKullanilan = new javax.swing.JLabel();
        LbLKalan = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtGun = new javax.swing.JTextField();
        bntIzinGunu = new javax.swing.JButton();
        btnRapor = new javax.swing.JButton();
        btnIzinGecmisi = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnIzinIade = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btnExcelAktar = new javax.swing.JButton();
        btnpersonelekle = new javax.swing.JButton();

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Personel İzin Takip Sistemi ");
        setLocationByPlatform(true);
        setResizable(false);

        jLabel1.setText("Personel Adı : ");

        jLabel2.setText("Personel Soyadı : ");

        txtSoyad.addActionListener(this::txtSoyadActionPerformed);
        txtSoyad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSoyadKeyReleased(evt);
            }
        });

        btnAra.setBackground(new java.awt.Color(51, 102, 255));
        btnAra.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAra.setText("ARA");
        btnAra.addActionListener(this::btnAraActionPerformed);

        LbLAd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LbLAd.setText("Ad :");

        LbLSoyad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LbLSoyad.setText("Soyad :");

        LbLSube.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LbLSube.setText("Şube : ");

        LbLGorev.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LbLGorev.setText("Görev : ");

        LbLHakEdilen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LbLHakEdilen.setText("Hak Edilen : ");

        LbLKullanilan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LbLKullanilan.setText("Kullanılan : ");

        LbLKalan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LbLKalan.setText("Kalan : ");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("İzin Günü : ");

        txtGun.addActionListener(this::txtGunActionPerformed);

        bntIzinGunu.setBackground(new java.awt.Color(102, 102, 102));
        bntIzinGunu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bntIzinGunu.setText("İZİN KULLAN");
        bntIzinGunu.addActionListener(this::bntIzinGunuActionPerformed);

        btnRapor.setBackground(new java.awt.Color(102, 102, 102));
        btnRapor.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRapor.setText("RAPOR");
        btnRapor.addActionListener(this::btnRaporActionPerformed);

        btnIzinGecmisi.setBackground(new java.awt.Color(102, 102, 102));
        btnIzinGecmisi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnIzinGecmisi.setText("İZİN GEÇMİŞİ");
        btnIzinGecmisi.addActionListener(this::btnIzinGecmisiActionPerformed);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 70, 140));
        jLabel5.setText("PERSONEL İZİN TAKİP SİSTEMİ");

        btnIzinIade.setBackground(new java.awt.Color(102, 102, 102));
        btnIzinIade.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnIzinIade.setText("İZİN İADE ET");
        btnIzinIade.addActionListener(this::btnIzinIadeActionPerformed);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setText("ÇORUM İL ÖZEL İDARESİ");

        btnExcelAktar.setBackground(new java.awt.Color(102, 102, 102));
        btnExcelAktar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnExcelAktar.setText(" EXCEL'DEN PERSONEL AKTAR");
        btnExcelAktar.addActionListener(this::btnExcelAktarActionPerformed);

        btnpersonelekle.setBackground(new java.awt.Color(0, 51, 51));
        btnpersonelekle.setText("PERSONEL EKLE");
        btnpersonelekle.addActionListener(this::btnpersonelekleActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(313, 313, 313))
            .addGroup(layout.createSequentialGroup()
                .addGap(316, 316, 316)
                .addComponent(btnAra, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(164, 164, 164)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnpersonelekle, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(bntIzinGunu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRapor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnIzinGecmisi, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                            .addComponent(btnIzinIade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(199, 199, 199))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LbLAd, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LbLSoyad, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LbLSube, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LbLGorev, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LbLHakEdilen, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LbLKullanilan, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LbLKalan, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnExcelAktar)
                                        .addGap(236, 236, 236)
                                        .addComponent(jLabel3)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtGun, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(42, 42, 42)
                                        .addComponent(txtAd, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(43, 43, 43)
                                        .addComponent(txtSoyad, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 169, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtAd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSoyad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(btnAra, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(LbLAd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LbLSoyad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LbLSube)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LbLGorev)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LbLHakEdilen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LbLKullanilan, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LbLKalan)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtGun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bntIzinGunu)
                    .addComponent(btnpersonelekle, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRapor, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnIzinGecmisi, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnIzinIade)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
                .addComponent(btnExcelAktar)
                .addGap(280, 280, 280))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSoyadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoyadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoyadActionPerformed

    private void btnAraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAraActionPerformed
                             
    String ad = txtAd.getText().trim();
    String soyad = txtSoyad.getText().trim();

    if (ad.isEmpty() || soyad.isEmpty()) {
        JOptionPane.showMessageDialog(this,
                "Lütfen ad ve soyad giriniz.");
        return;
    }

    secilenPersonel = dao.personelAra(ad, soyad);

    if (secilenPersonel != null) {
            LbLAd.setText("Ad : " + secilenPersonel.getAd());
            LbLSoyad.setText("Soyad : " + secilenPersonel.getSoyad());
            LbLSube.setText("Şube : " + secilenPersonel.getSube());
            LbLGorev.setText("Görev : " + secilenPersonel.getGorev());
            LbLHakEdilen.setText("Hak Edilen : " + secilenPersonel.getHakEdilenIzin());
            LbLKullanilan.setText("Kullanılan : " + secilenPersonel.getKullanilanIzin());
            LbLKalan.setText("Kalan : " + secilenPersonel.getKalanIzin());
            int kalan = secilenPersonel.getKalanIzin();
            LbLKalan.setText("Kalan : " + kalan);
       
        if (kalan <= 3) {
            LbLKalan.setForeground(java.awt.Color.RED);
            JOptionPane.showMessageDialog(this, 
                "DİKKAT: Bu personelin kalan izin hakkı kritik seviyededir (" + kalan + " gün)!", 
                "Kritik İzin Uyarısı", 
                JOptionPane.WARNING_MESSAGE);
        } else {
            LbLKalan.setForeground(java.awt.Color.BLACK); 
        }
   } else {
       if (evt != null) {
           JOptionPane.showMessageDialog(this,"Personel bulunamadı.");
       }
    }//GEN-LAST:event_btnAraActionPerformed
}    
    private void txtGunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGunActionPerformed
    
    }//GEN-LAST:event_txtGunActionPerformed

    private void bntIzinGunuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntIzinGunuActionPerformed
                                        
    if (secilenPersonel == null) {
        JOptionPane.showMessageDialog(this, "Lütfen önce bir personel arayın!", "Uyarı", JOptionPane.WARNING_MESSAGE);
        return;
    }
    String girilenGunStr = txtGun.getText().trim();
    if (girilenGunStr.isEmpty() || girilenGunStr.equals("Gün Giriniz")) {
        JOptionPane.showMessageDialog(this, "Lütfen kullanılacak izin gün sayısını giriniz!", "Uyarı", JOptionPane.WARNING_MESSAGE);
        return;
    }
    try {
        int dusulecekGun = Integer.parseInt(girilenGunStr);

        if (dusulecekGun <= 0) {
            JOptionPane.showMessageDialog(this, "Lütfen 0'dan büyük bir gün sayısı giriniz!", "Uyarı", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if (dusulecekGun > secilenPersonel.getKalanIzin()) {
            JOptionPane.showMessageDialog(this, "Girilen gün sayısı personelin kalan izninden (" + secilenPersonel.getKalanIzin() + " gün) fazla olamaz!", "Hata", JOptionPane.ERROR_MESSAGE);
            return;
        }
        boolean basarili = dao.izinDusu(secilenPersonel.getPersonelId(), dusulecekGun);
        if (basarili) {
            dao.izinGecmisiEkle(
                    secilenPersonel.getPersonelId(),
                    dusulecekGun,
                    "Yıllık İzin Kullanımı"
            );

            JOptionPane.showMessageDialog(this,dusulecekGun + " günlük izin başarıyla düşüldü ve geçmişe kaydedildi!");
            txtGun.setText("");
            btnAraActionPerformed(evt);
        } else {
            JOptionPane.showMessageDialog(this,"İzin düşülürken veritabanı hatası oluştu!","Hata",JOptionPane.ERROR_MESSAGE);
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Lütfen sadece sayısal bir değer giriniz!", "Hata", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_bntIzinGunuActionPerformed
}
    private void btnRaporActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRaporActionPerformed
                         
        RaporEkrani rapor = new RaporEkrani();
        rapor.setLocationRelativeTo(this);
        rapor.setVisible(true);
    }//GEN-LAST:event_btnRaporActionPerformed

    private void btnIzinGecmisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzinGecmisiActionPerformed

    IzinGecmisiEkrani ekran = new IzinGecmisiEkrani();
    ekran.setLocationRelativeTo(null);
    ekran.setVisible(true);
    }//GEN-LAST:event_btnIzinGecmisiActionPerformed

    private void txtSoyadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSoyadKeyReleased
       String ad = txtAd.getText().trim();
       String soyad = txtSoyad.getText().trim();

       if (!ad.isEmpty() && !soyad.isEmpty()) {
           btnAraActionPerformed(null);
       }
    }//GEN-LAST:event_txtSoyadKeyReleased

    private void btnIzinIadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzinIadeActionPerformed
                                           
    if (secilenPersonel == null) {
        javax.swing.JOptionPane.showMessageDialog(null, "Lütfen önce izin iadesi yapılacak personeli aratın!", "Uyarı", javax.swing.JOptionPane.WARNING_MESSAGE);
        return;
    }

    int personelId = secilenPersonel.getPersonelId();
    String adSoyad = secilenPersonel.getAd() + " " + secilenPersonel.getSoyad();

    String inputGun = javax.swing.JOptionPane.showInputDialog(null, 
        adSoyad + " için kaç gün izin iade edilecek?", "İzin İadesi", javax.swing.JOptionPane.QUESTION_MESSAGE);

    if (inputGun != null && !inputGun.trim().isEmpty()) {
        try {
            int iadeGun = Integer.parseInt(inputGun.trim());
            if (iadeGun <= 0) {
                javax.swing.JOptionPane.showMessageDialog(null, "Lütfen 0'dan büyük bir sayı girin!", "Uyarı", javax.swing.JOptionPane.WARNING_MESSAGE);
                return;
            }

            String aciklama = javax.swing.JOptionPane.showInputDialog(null, "İade Nedeni / Açıklama:", "Erken Dönüş");
            if (aciklama == null || aciklama.trim().isEmpty()) {
                aciklama = "Erken Dönüş İzin İadesi";
            }

            boolean basarili = dao.izinIadeEt(personelId, iadeGun, aciklama);
            if (basarili) {
                javax.swing.JOptionPane.showMessageDialog(null, iadeGun + " gün izin başarıyla iade edildi!");
                btnAraActionPerformed(null);
            } else {
                javax.swing.JOptionPane.showMessageDialog(null, "İade işlemi sırasında veritabanı hatası oluştu!", "Hata", javax.swing.JOptionPane.ERROR_MESSAGE);
            }

        } catch (NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(null, "Lütfen geçerli bir sayı girin!", "Hata", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnIzinIadeActionPerformed
    }
    private void btnExcelAktarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcelAktarActionPerformed
javax.swing.JFileChooser fileChooser = new javax.swing.JFileChooser();
    fileChooser.setDialogTitle("Personel Listesi Seç (CSV Formatında)");
    
    javax.swing.filechooser.FileNameExtensionFilter filter = 
        new javax.swing.filechooser.FileNameExtensionFilter("CSV Dosyaları (*.csv)", "csv");
    fileChooser.setFileFilter(filter);

    int userSelection = fileChooser.showOpenDialog(this);

    if (userSelection == javax.swing.JFileChooser.APPROVE_OPTION) {
        java.io.File fileToOpen = fileChooser.getSelectedFile();
        java.util.List<Object[]> personelListesi = new java.util.ArrayList<>();
        
        try (java.io.BufferedReader br = new java.io.BufferedReader(
                new java.io.InputStreamReader(new java.io.FileInputStream(fileToOpen), java.nio.charset.StandardCharsets.UTF_8))) {

            String line;
            boolean ilkSatir = true;

            while ((line = br.readLine()) != null) {
                if (ilkSatir) {
                    line = line.replace("\uFEFF", ""); // BOM temizliği
                    ilkSatir = false;
                    continue; 
                }
                String[] veriler = line.contains(";") ? line.split(";", -1) : line.split(",", -1);

                if (veriler.length > 2) {
                    String ad = veriler[1].trim();    
                    String soyad = veriler[2].trim(); 

                    String sube = (veriler.length > 5 && !veriler[5].trim().isEmpty()) ? veriler[5].trim() : "Merkez";
                    String gorev = (veriler.length > 7 && !veriler[7].trim().isEmpty()) ? veriler[7].trim() : "Personel";

                    int hakEdilen = 0, kullanilan = 0, kalan = 0;
                    try {
                        if (veriler.length > 17 && !veriler[17].trim().isEmpty()) 
                            hakEdilen = Integer.parseInt(veriler[17].trim().replaceAll("[^0-9]", ""));
                        if (veriler.length > 18 && !veriler[18].trim().isEmpty()) 
                            kullanilan = Integer.parseInt(veriler[18].trim().replaceAll("[^0-9]", ""));
                        if (veriler.length > 19 && !veriler[19].trim().isEmpty()) 
                            kalan = Integer.parseInt(veriler[19].trim().replaceAll("[^0-9]", ""));
                    } catch (Exception e) {
               
                    }

                    if (!ad.isEmpty() || !soyad.isEmpty()) {
                        personelListesi.add(new Object[]{ad, soyad, sube, gorev, hakEdilen, kullanilan, kalan});
                    }
                }
            }
            
            
            if (!personelListesi.isEmpty()) {
                dao.PersonelDAO dao = new dao.PersonelDAO();
                boolean basarili = dao.topluPersonelEkle(personelListesi);

                if (basarili) {
                    javax.swing.JOptionPane.showMessageDialog(this, 
                        personelListesi.size() + " adet personel izin bilgileriyle aktarıldı!", 
                        "Başarılı", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                } else {
                    javax.swing.JOptionPane.showMessageDialog(this, "Veritabanına kaydederken hata oluştu.", "Hata", javax.swing.JOptionPane.ERROR_MESSAGE);
                }
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "Geçerli veri bulunamadı.", "Uyarı", javax.swing.JOptionPane.WARNING_MESSAGE);
            }

        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Hata: " + e.getMessage(), "Hata", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }
  // TODO add your handling code here:
    }//GEN-LAST:event_btnExcelAktarActionPerformed

    private void btnpersonelekleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpersonelekleActionPerformed
 {
    javax.swing.JTextField txtTcNo = new javax.swing.JTextField();
    javax.swing.JTextField txtAd = new javax.swing.JTextField();
    javax.swing.JTextField txtSoyad = new javax.swing.JTextField();
    javax.swing.JTextField txtSube = new javax.swing.JTextField();
    javax.swing.JTextField txtGorev = new javax.swing.JTextField();
    javax.swing.JTextField txtIseGiris = new javax.swing.JTextField();
    javax.swing.JTextField txtHakEdilenIzin = new javax.swing.JTextField("14");

    javax.swing.JPanel panel = new javax.swing.JPanel(new java.awt.GridLayout(0, 2, 5, 5));
    panel.add(new javax.swing.JLabel("TC No:")); panel.add(txtTcNo);
    panel.add(new javax.swing.JLabel("Personel Adı:")); panel.add(txtAd);
    panel.add(new javax.swing.JLabel("Personel Soyadı:")); panel.add(txtSoyad);
    panel.add(new javax.swing.JLabel("Şube:")); panel.add(txtSube);
    panel.add(new javax.swing.JLabel("Görev:")); panel.add(txtGorev);
    panel.add(new javax.swing.JLabel("İşe Giriş Tarihi (YYYY-AA-GG):")); panel.add(txtIseGiris);
    panel.add(new javax.swing.JLabel("Hak Edilen İzin Günü:")); panel.add(txtHakEdilenIzin);

    int result = javax.swing.JOptionPane.showConfirmDialog(
            this, panel, "Yeni Personel Ekle", 
            javax.swing.JOptionPane.OK_CANCEL_OPTION, 
            javax.swing.JOptionPane.PLAIN_MESSAGE
    );

    if (result == javax.swing.JOptionPane.OK_OPTION) {
        try {
            Personel yeniPersonel = new Personel();
            yeniPersonel.setTcNo(txtTcNo.getText().trim());
            yeniPersonel.setAd(txtAd.getText().trim());
            yeniPersonel.setSoyad(txtSoyad.getText().trim());
            yeniPersonel.setSube(txtSube.getText().trim());
            yeniPersonel.setGorev(txtGorev.getText().trim());
            yeniPersonel.setIseGirisTarihi(txtIseGiris.getText().trim());
            
            int hakEdilen = Integer.parseInt(txtHakEdilenIzin.getText().trim());
            yeniPersonel.setHakEdilenIzin(hakEdilen);

            PersonelDAO dao = new PersonelDAO();
            boolean basarili = dao.personelEkle(yeniPersonel);

            if (basarili) {
                javax.swing.JOptionPane.showMessageDialog(this, "Personel ve İzin Hakları Başarıyla Eklendi!");
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "Personel eklenirken hata oluştu!", "Hata", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Lütfen İzin Gününü sayı olarak giriniz!", "Hata", javax.swing.JOptionPane.WARNING_MESSAGE);
        }
    }

    }//GEN-LAST:event_btnpersonelekleActionPerformed
    }
   public static void main(String args[]) {
        try {
  
            com.formdev.flatlaf.themes.FlatMacDarkLaf.setup();
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(AnaEkran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    new PersonelDAO().otomatikYillikIzinGuncelle();
        }
        
        

        java.awt.EventQueue.invokeLater(() -> new AnaEkran().setVisible(true));
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LbLAd;
    private javax.swing.JLabel LbLGorev;
    private javax.swing.JLabel LbLHakEdilen;
    private javax.swing.JLabel LbLKalan;
    private javax.swing.JLabel LbLKullanilan;
    private javax.swing.JLabel LbLSoyad;
    private javax.swing.JLabel LbLSube;
    private javax.swing.JButton bntIzinGunu;
    private javax.swing.JButton btnAra;
    private javax.swing.JButton btnExcelAktar;
    private javax.swing.JButton btnIzinGecmisi;
    private javax.swing.JButton btnIzinIade;
    private javax.swing.JButton btnRapor;
    private javax.swing.JButton btnpersonelekle;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txtAd;
    private javax.swing.JTextField txtGun;
    private javax.swing.JTextField txtSoyad;
    // End of variables declaration//GEN-END:variables
}