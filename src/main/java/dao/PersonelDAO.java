package dao;

import model.Personel;
import database.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import model.IzinGecmisi;
import java.util.ArrayList;
import java.sql.Statement;
public class PersonelDAO {

    public Personel personelAra(String ad, String soyad) { 
    Personel p = null;
    String sql = "SELECT p.PersonelID, p.TCNo, p.Ad, p.Soyad, p.Sube, p.Gorev, p.IseGirisTarihi, " +
                 "i.HakEdilenIzin, i.KullanilanIzin, i.KalanIzin " +
                 "FROM Personel p " +
                 "LEFT JOIN PersonelIzin i ON p.PersonelID = i.PersonelID " +
                 "WHERE p.Ad = ? AND p.Soyad = ?";

    try (Connection conn = DBConnection.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setString(1, ad.trim());
        pstmt.setString(2, soyad.trim());

        try (ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) { // while döngüsü kaldırıldı
                p = new Personel();
                p.setPersonelID(rs.getInt("PersonelID"));
                p.setAd(rs.getString("Ad"));
                p.setSoyad(rs.getString("Soyad"));
                p.setTcNo(rs.getString("TCNo"));
                p.setSube(rs.getString("Sube"));
                p.setGorev(rs.getString("Gorev"));
                p.setIseGirisTarihi(rs.getString("IseGirisTarihi"));
                p.setHakEdilenIzin(rs.getInt("HakEdilenIzin"));
                p.setKullanilanIzin(rs.getInt("KullanilanIzin"));
                p.setKalanIzin(rs.getInt("KalanIzin"));
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return p;
}
    public boolean izinDusu(int personelId, int dusulecekGun) {
    String sql = "UPDATE PersonelIzin SET KullanilanIzin = KullanilanIzin + ?, KalanIzin = KalanIzin - ? WHERE PersonelID = ?";
    
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        
        ps.setInt(1, dusulecekGun); 
        ps.setInt(2, dusulecekGun); 
        ps.setInt(3, personelId);
        
        int etkilenen = ps.executeUpdate();
        return etkilenen > 0;
        
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
   }
    
}
 public List<Personel> birimIzinRaporuGetir(String sube) {
    List<Personel> liste = new ArrayList<>();
    
    // Şubeye göre filtreleme yapan SQL sorgusu
    String sql = "SELECT p.TCNo, p.Ad, p.Soyad, p.Sube, p.Gorev, p.IseGirisTarihi, "
               + "i.HakEdilenIzin, i.KullanilanIzin, i.KalanIzin "
               + "FROM Personel p "
               + "LEFT JOIN PersonelIzin i ON p.PersonelID = i.PersonelID "
               + "WHERE p.Sube = ?";

    try (Connection con = DBConnection.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, sube);

        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Personel p = new Personel();
                
                
                p.setTcNo(rs.getString("TCNo"));                 
                p.setAd(rs.getString("Ad"));                     
                p.setSoyad(rs.getString("Soyad"));               
                p.setSube(rs.getString("Sube"));                 
                p.setGorev(rs.getString("Gorev"));               
                p.setIseGirisTarihi(rs.getString("IseGirisTarihi"));
                p.setHakEdilenIzin(rs.getInt("HakEdilenIzin"));  
                p.setKullanilanIzin(rs.getInt("KullanilanIzin"));
                p.setKalanIzin(rs.getInt("KalanIzin"));         
                liste.add(p);
            }
        }

    } catch (Exception e) {
        System.err.println("Birim İzin Raporu Getirme Hatası: " + e.getMessage());
        e.printStackTrace();
    }
    
    return liste;
}
    public java.util.List<String> subeleriGetir() {
        java.util.List<String> subeler = new java.util.ArrayList<>();
        String sql = "SELECT DISTINCT Sube FROM Personel";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                subeler.add(rs.getString("Sube"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return subeler;
    }

public List<Personel> birimeGorePersoneller(String sube) {
    List<Personel> liste = new ArrayList<>();
    String sql = "SELECT p.PersonelID, p.Ad, p.Soyad, p.TCNo, p.Sube, p.Gorev, p.IseGirisTarihi, " +
                 "i.HakEdilenIzin, i.KullanilanIzin, i.KalanIzin " +
                 "FROM Personel p " +
                 "LEFT JOIN PersonelIzin i ON p.PersonelID = i.PersonelID " +
                 "WHERE p.Sube = ?";

    try (Connection con = DBConnection.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, sube);

        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Personel p = new Personel();
                p.setPersonelID(rs.getInt("PersonelID")); // Büyük ID
                p.setAd(rs.getString("Ad"));
                p.setSoyad(rs.getString("Soyad"));
                p.setTcNo(rs.getString("TCNo"));
                p.setSube(rs.getString("Sube"));
                p.setGorev(rs.getString("Gorev"));
                p.setIseGirisTarihi(rs.getString("IseGirisTarihi"));
                p.setHakEdilenIzin(rs.getInt("HakEdilenIzin"));
                p.setKullanilanIzin(rs.getInt("KullanilanIzin"));
                p.setKalanIzin(rs.getInt("KalanIzin"));

                liste.add(p);
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    return liste;
}


    public List<Personel> tumPersonelRaporuGetir() {
    List<Personel> liste = new ArrayList<>();

    String sql = "SELECT p.PersonelID, p.TCNo, p.Ad, p.Soyad, p.Sube, p.Gorev, p.IseGirisTarihi, " +
                 "ISNULL(i.HakEdilenIzin, 0) AS HakEdilenIzin, " +
                 "ISNULL(i.KullanilanIzin, 0) AS KullanilanIzin, " +
                 "ISNULL(i.KalanIzin, 0) AS KalanIzin " +
                 "FROM Personel p " +
                 "LEFT JOIN PersonelIzin i ON p.PersonelID = i.PersonelID";

    try (Connection con = DBConnection.getConnection();
         PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            Personel p = new Personel();

            p.setPersonelID(rs.getInt("PersonelID"));
            p.setTcNo(rs.getString("TCNo"));
            p.setAd(rs.getString("Ad"));
            p.setSoyad(rs.getString("Soyad"));
            p.setSube(rs.getString("Sube"));
            p.setGorev(rs.getString("Gorev"));
            p.setIseGirisTarihi(rs.getString("IseGirisTarihi"));

            p.setHakEdilenIzin(rs.getInt("HakEdilenIzin"));
            p.setKullanilanIzin(rs.getInt("KullanilanIzin"));
            p.setKalanIzin(rs.getInt("KalanIzin"));

            liste.add(p);
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return liste;
}

    public boolean izinGecmisiEkle(int personelId, int gunSayisi, String aciklama) {
        String sql = "INSERT INTO personel_izin_gecmisi (personel_id, izin_baslangic, gun_sayisi, aciklama) VALUES (?, GETDATE(), ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, personelId);
            stmt.setInt(2, gunSayisi);
            stmt.setString(3, aciklama != null ? aciklama : "Yıllık İzin");
            
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<IzinGecmisi> izinGecmisiniGetir(int personelId) {
        List<IzinGecmisi> liste = new ArrayList<>();
        String sql = "SELECT * FROM personel_izin_gecmisi WHERE personel_id = ? ORDER BY izin_baslangic DESC";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, personelId);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                IzinGecmisi ig = new IzinGecmisi();
                ig.setId(rs.getInt("id"));
                ig.setPersonelId(rs.getInt("personel_id"));
                ig.setIzinTarihi(rs.getDate("izin_baslangic"));
                ig.setGunSayisi(rs.getInt("gun_sayisi"));
                ig.setAciklama(rs.getString("aciklama"));
                liste.add(ig);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return liste;
    }


    public List<IzinGecmisi> tumIzinGecmisiniGetir() {
    List<IzinGecmisi> liste = new java.util.ArrayList<>();
    String sql = "SELECT * FROM personel_izin_gecmisi ORDER BY izin_baslangic DESC";

    try (Connection conn = DBConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            IzinGecmisi g = new IzinGecmisi();
            g.setId(rs.getInt("id"));
            g.setPersonelId(rs.getInt("personel_id"));
            g.setIzinTarihi(rs.getDate("izin_baslangic")); 
            g.setGunSayisi(rs.getInt("gun_sayisi"));
            g.setAciklama(rs.getString("aciklama"));
            
            liste.add(g);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return liste;
}
    public List<IzinGecmisi> tumIzinGecmisiDetayliGetir() {

    List<IzinGecmisi> liste = new ArrayList<>();

    String sql =
        "SELECT P.Ad, P.Soyad, P.Sube, " +
        "G.izin_baslangic, G.gun_sayisi, G.aciklama " +
        "FROM personel_izin_gecmisi G " +
        "INNER JOIN Personel P ON G.personel_id = P.PersonelID " +
        "ORDER BY G.izin_baslangic DESC";

    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {

            IzinGecmisi g = new IzinGecmisi();

            g.setAd(rs.getString("Ad"));
            g.setSoyad(rs.getString("Soyad"));
            g.setSube(rs.getString("Sube"));

            g.setIzinTarihi(rs.getDate("izin_baslangic"));
            g.setGunSayisi(rs.getInt("gun_sayisi"));
            g.setAciklama(rs.getString("aciklama"));

            liste.add(g);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return liste;
}
    public List<IzinGecmisi> izinGecmisiAra(String sube, String aranan) {

    List<IzinGecmisi> liste = new ArrayList<>();

    String sql =
        "SELECT p.Ad, p.Soyad, p.Sube, " +
        "g.izin_baslangic, g.gun_sayisi, g.aciklama " +
        "FROM personel_izin_gecmisi g " +
        "INNER JOIN Personel p ON g.personel_id = p.PersonelID " +
        "WHERE (? = 'Tümü' OR p.Sube = ?) " +
        "AND (p.Ad LIKE ? OR p.Soyad LIKE ?) " +
        "ORDER BY g.izin_baslangic DESC";

    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setString(1, sube);
        ps.setString(2, sube);
        ps.setString(3, "%" + aranan + "%");
        ps.setString(4, "%" + aranan + "%");

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            IzinGecmisi g = new IzinGecmisi();

            g.setAd(rs.getString("Ad"));
            g.setSoyad(rs.getString("Soyad"));
            g.setSube(rs.getString("Sube"));
            g.setIzinTarihi(rs.getDate("izin_baslangic"));
            g.setGunSayisi(rs.getInt("gun_sayisi"));
            g.setAciklama(rs.getString("aciklama"));

            liste.add(g);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return liste;
}
public boolean izinIadeEt(int personelId, int iadeGunSayisi, String aciklama) {
    boolean sonuc = izinDusu(personelId, -iadeGunSayisi);
    
    if (sonuc) {
        try {
            izinGecmisiEkle(personelId, -iadeGunSayisi, "İzin İadesi: " + aciklama);
        } catch (Exception e) {
            System.out.println("Geçmiş kaydı ekleme uyarısı: " + e.getMessage());
        }
    }
    return sonuc;
}
public List<String> aylikIzinOzetGetir(int personelId) {
    List<String> ozetListe = new ArrayList<>();
    
    String sql = "SELECT YEAR(izin_baslangic) AS Yil, MONTH(izin_baslangic) AS Ay, SUM(gun_sayisi) AS ToplamGun " +
                 "FROM personel_izin_gecmisi " +
                 "WHERE personel_id = ? " +
                 "GROUP BY YEAR(izin_baslangic), MONTH(izin_baslangic) " +
                 "ORDER BY Yil DESC, Ay DESC";

    try (Connection conn = DBConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        
        stmt.setInt(1, personelId);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            int yil = rs.getInt("Yil");
            int ay = rs.getInt("Ay");
            int toplamGun = rs.getInt("ToplamGun");
            String satir = yil + " - " + ay + ". Ay Toplam Kullanılan İzin: " + toplamGun + " gün";
            ozetListe.add(satir);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return ozetListe;
}
public boolean topluPersonelEkle(java.util.List<Object[]> personelListesi) {

    String sqlPersonel =
            "INSERT INTO Personel " +
            "(TCNo, Ad, Soyad, Sube, Gorev, IseGirisTarihi) " +
            "VALUES (?, ?, ?, ?, ?, ?)";

    String sqlIzin =
            "INSERT INTO PersonelIzin " +
            "(PersonelID, Izin2018Oncesi, Izin2019, Izin2020, " +
            "Izin2021, Izin2022, Izin2023, Izin2024, Izin2025, Izin2026, " +
            "HakEdilenIzin, KullanilanIzin, KalanIzin) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    java.sql.Connection conn = null;
    java.sql.PreparedStatement pstmtPersonel = null;
    java.sql.PreparedStatement pstmtIzin = null;
    java.sql.ResultSet generatedKeys = null;

    try {

        conn = database.DBConnection.getConnection();
        conn.setAutoCommit(false);

        pstmtPersonel = conn.prepareStatement(
                sqlPersonel,
                java.sql.Statement.RETURN_GENERATED_KEYS
        );

        pstmtIzin = conn.prepareStatement(sqlIzin);

        for (Object[] p : personelListesi) {

            String ad = (p.length > 1 && p[1] != null)
                    ? String.valueOf(p[1]).trim()
                    : "";

            String soyad = (p.length > 2 && p[2] != null)
                    ? String.valueOf(p[2]).trim()
                    : "";

            String tcNo = (p.length > 3 && p[3] != null)
                    ? String.valueOf(p[3]).trim()
                    : "";

            String sube = (p.length > 5 && p[5] != null)
                    ? String.valueOf(p[5]).trim()
                    : "Merkez";

            String iseGirisTarihi = (p.length > 6 && p[6] != null)
                    ? String.valueOf(p[6]).trim()
                    : "";

            String gorev = (p.length > 7 && p[7] != null)
                    ? String.valueOf(p[7]).trim()
                    : "Personel";
            int izin2018Oncesi = (p.length > 8)
                    ? parseSafeInt(p[8]) : 0;

            int izin2019 = (p.length > 9)
                    ? parseSafeInt(p[9]) : 0;

            int izin2020 = (p.length > 10)
                    ? parseSafeInt(p[10]) : 0;

            int izin2021 = (p.length > 11)
                    ? parseSafeInt(p[11]) : 0;

            int izin2022 = (p.length > 12)
                    ? parseSafeInt(p[12]) : 0;

            int izin2023 = (p.length > 13)
                    ? parseSafeInt(p[13]) : 0;

            int izin2024 = (p.length > 14)
                    ? parseSafeInt(p[14]) : 0;

            int izin2025 = (p.length > 15)
                    ? parseSafeInt(p[15]) : 0;

            int izin2026 = (p.length > 16)
                    ? parseSafeInt(p[16]) : 0;

            int hakEdilen = (p.length > 17)
                    ? parseSafeInt(p[17]) : 0;

            int kullanilan = (p.length > 18)
                    ? parseSafeInt(p[18]) : 0;

            int kalan = (p.length > 19)
                    ? parseSafeInt(p[19])
                    : (hakEdilen - kullanilan);
            if (ad.isEmpty() && soyad.isEmpty()) {
                continue;
            }

            if (ad.equalsIgnoreCase("ADI")
                    || tcNo.equalsIgnoreCase("T.C. KİMLİK NO")) {
                continue;
            }

            java.sql.Date sqlTarih =
                    formatTarihForSql(iseGirisTarihi);
            if (tcNo.length() > 11) {
                tcNo = tcNo.substring(0, 11);
            }

            if (ad.length() > 50) {
                ad = ad.substring(0, 50);
            }

            if (soyad.length() > 50) {
                soyad = soyad.substring(0, 50);
            }

            if (sube.length() > 100) {
                sube = sube.substring(0, 100);
            }

            if (gorev.length() > 100) {
                gorev = gorev.substring(0, 100);
            }
            pstmtPersonel.setString(
                    1,
                    tcNo.isEmpty() ? null : tcNo
            );
            pstmtPersonel.setString(2, ad);
            pstmtPersonel.setString(3, soyad);
            pstmtPersonel.setString(4, sube);
            pstmtPersonel.setString(5, gorev);

            if (sqlTarih != null) {

                pstmtPersonel.setDate(6, sqlTarih);
            } else {
                pstmtPersonel.setNull(
                        6,
                        java.sql.Types.DATE
                );
            }

            pstmtPersonel.executeUpdate();

            generatedKeys =
                    pstmtPersonel.getGeneratedKeys();

            if (generatedKeys.next()) {

                int yeniPersonelID =
                        generatedKeys.getInt(1);
                pstmtIzin.setInt(1, yeniPersonelID);

                pstmtIzin.setInt(2, izin2018Oncesi);
                pstmtIzin.setInt(3, izin2019);
                pstmtIzin.setInt(4, izin2020);
                pstmtIzin.setInt(5, izin2021);
                pstmtIzin.setInt(6, izin2022);
                pstmtIzin.setInt(7, izin2023);
                pstmtIzin.setInt(8, izin2024);
                pstmtIzin.setInt(9, izin2025);
                pstmtIzin.setInt(10, izin2026);

                pstmtIzin.setInt(11, hakEdilen);
                pstmtIzin.setInt(12, kullanilan);
                pstmtIzin.setInt(13, kalan);

                pstmtIzin.addBatch();
            }

            if (generatedKeys != null) {
                generatedKeys.close();
                generatedKeys = null;
            }
        }


        pstmtIzin.executeBatch();
        conn.commit();

        return true;


    } catch (java.sql.SQLException e) {

        System.err.println(
                "SQL HATA DETAYI: " + e.getMessage()
        );
        e.printStackTrace();
        if (conn != null) {
            try {
                conn.rollback();
            } catch (java.sql.SQLException ex) {
                ex.printStackTrace();
            }
        }

        return false;
    } finally {
        try {
            if (generatedKeys != null) {
                generatedKeys.close();
            }
            if (pstmtPersonel != null) {
                pstmtPersonel.close();
            }
            if (pstmtIzin != null) {
                pstmtIzin.close();
            }
            if (conn != null) {
                conn.setAutoCommit(true);
                conn.close();
            }
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }
}
 public boolean personelEkle(Personel p) {
    String sqlPersonel = "INSERT INTO Personel (Ad, Soyad, TCNo, Sube, Gorev, IseGirisTarihi) VALUES (?, ?, ?, ?, ?, ?)";
    String sqlIzin = "INSERT INTO PersonelIzin (PersonelID, HakEdilenIzin, KullanilanIzin, KalanIzin) VALUES (?, ?, ?, ?)";

    Connection con = null;
    try {
        con = DBConnection.getConnection();
        con.setAutoCommit(false);

        int yeniPersonelId = -1;
        try (PreparedStatement psPersonel = con.prepareStatement(sqlPersonel, Statement.RETURN_GENERATED_KEYS)) {
            psPersonel.setString(1, p.getAd());             
            psPersonel.setString(2, p.getSoyad());          
            psPersonel.setString(3, p.getTcNo());           
            psPersonel.setString(4, p.getSube());           
            psPersonel.setString(5, p.getGorev());          
            psPersonel.setString(6, p.getIseGirisTarihi()); 
            psPersonel.executeUpdate();
            try (ResultSet rs = psPersonel.getGeneratedKeys()) {
                if (rs.next()) {
                    yeniPersonelId = rs.getInt(1);
                }
            }
        }

        if (yeniPersonelId != -1) {
            try (PreparedStatement psIzin = con.prepareStatement(sqlIzin)) {
                psIzin.setInt(1, yeniPersonelId);
                psIzin.setInt(2, p.getHakEdilenIzin());
                psIzin.setInt(3, 0);
                psIzin.setInt(4, p.getHakEdilenIzin());

                psIzin.executeUpdate();
            }
        }
        con.commit();
        return true;
    } catch (Exception e) {
        if (con != null) {
            try { con.rollback(); } catch (SQLException ex) { ex.printStackTrace(); }
        }
        e.printStackTrace();
        return false;
    } finally {
        if (con != null) {
            try {
                con.setAutoCommit(true);
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
    public boolean personelSil(int personelId) {
        String sqlGecmisSil = "DELETE FROM personel_izin_gecmisi WHERE personel_id = ?";
        String sqlIzinSil = "DELETE FROM PersonelIzin WHERE PersonelID = ?";
        String sqlPersonelSil = "DELETE FROM Personel WHERE PersonelID = ?";
        
        Connection conn = null;
        try {
            conn = DBConnection.getConnection();
            conn.setAutoCommit(false); 

            try (PreparedStatement ps = conn.prepareStatement(sqlGecmisSil)) {
                ps.setInt(1, personelId);
                ps.executeUpdate();
            }

            try (PreparedStatement ps = conn.prepareStatement(sqlIzinSil)) {
                ps.setInt(1, personelId);
                ps.executeUpdate();
            }
            boolean silindi = false;
            try (PreparedStatement ps = conn.prepareStatement(sqlPersonelSil)) {
                ps.setInt(1, personelId);
                silindi = ps.executeUpdate() > 0;
            }

            conn.commit();
            return silindi;

        } catch (SQLException e) {
            e.printStackTrace();
            if (conn != null) {
                try { conn.rollback(); } catch (SQLException ex) {}
            }
            return false;
        } finally {
            if (conn != null) {
                try { conn.setAutoCommit(true); conn.close(); } catch (SQLException e) {}
            }
        }
    }
        public boolean yillikIzinleriYenile() {
        String sqlSelect = "SELECT P.PersonelID, DATEDIFF(YEAR, P.IseGirisTarihi, GETDATE()) AS KidemYili " +
                       "FROM Personel P WHERE P.IseGirisTarihi IS NOT NULL";
                       
        String sqlUpdate = "UPDATE PersonelIzin SET HakEdilenIzin = HakEdilenIzin + ?, KalanIzin = KalanIzin + ? WHERE PersonelID = ?";

        Connection conn = null;
        try {
        conn = DBConnection.getConnection();
        conn.setAutoCommit(false);

        try (PreparedStatement psSelect = conn.prepareStatement(sqlSelect);
             ResultSet rs = psSelect.executeQuery();
             PreparedStatement psUpdate = conn.prepareStatement(sqlUpdate)) {

            while (rs.next()) {
                int pId = rs.getInt("PersonelID");
                int kidemYili = rs.getInt("KidemYili");
                int eklenecekIzin = 0;

                if (kidemYili >= 1 && kidemYili <= 5) {
                    eklenecekIzin = 18;
                } else if (kidemYili > 5 && kidemYili < 15) {
                    eklenecekIzin = 23;
                } else if (kidemYili >= 15) {
                    eklenecekIzin = 28;
                }

                if (eklenecekIzin > 0) {
                    psUpdate.setInt(1, eklenecekIzin);
                    psUpdate.setInt(2, eklenecekIzin);
                    psUpdate.setInt(3, pId);
                    psUpdate.addBatch();
                }
            }
            psUpdate.executeBatch();
        }

        conn.commit();
        return true;

    } catch (SQLException e) {
        e.printStackTrace();
        if (conn != null) {
            try { conn.rollback(); } catch (SQLException ex) {}
        }
        return false;
    } finally {
        if (conn != null) {
            try { conn.setAutoCommit(true); conn.close(); } catch (SQLException e) {}
        }
    }
}
     public boolean personelSilByTc(String tcNo) {
     String sqlIzin = "DELETE FROM PersonelIzin WHERE PersonelID IN (SELECT PersonelID FROM Personel WHERE TCNo = ?)";
     String sqlPersonel = "DELETE FROM Personel WHERE TCNo = ?";
    
     Connection con = null;
        try {
        con = DBConnection.getConnection();
        con.setAutoCommit(false); // Güvenli silme işlemi

        try (PreparedStatement ps1 = con.prepareStatement(sqlIzin)) {
            ps1.setString(1, tcNo);
            ps1.executeUpdate();
        }

        try (PreparedStatement ps2 = con.prepareStatement(sqlPersonel)) {
            ps2.setString(1, tcNo);
            ps2.executeUpdate();
        }

        con.commit();
        return true;
    } catch (Exception e) {
        if (con != null) {
            try { con.rollback(); } catch (SQLException ex) { ex.printStackTrace(); }
        }
        e.printStackTrace();
        return false;
    } finally {
        if (con != null) {
            try { con.setAutoCommit(true); con.close(); } catch (SQLException e) {}
        }
    }
}
    public boolean personelHucreGuncelleByTc(String tcNo, String sqlKolonAdi, String yeniDeger) {
        String sql = "UPDATE Personel SET " + sqlKolonAdi + " = ? WHERE TCNo = ?";
        try (Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
        if (sqlKolonAdi.equalsIgnoreCase("IseGirisTarihi") && (yeniDeger == null || yeniDeger.trim().isEmpty())) {
            ps.setNull(1, java.sql.Types.VARCHAR);
        } else {
            ps.setString(1, yeniDeger);
        }
        ps.setString(2, tcNo);
        return ps.executeUpdate() > 0;
    } catch (Exception e) {
        System.err.println("TC ile Güncelleme Hatası (" + sqlKolonAdi + "): " + e.getMessage());
        return false;
    }
}
public boolean personelHucreGuncelleByAdSoyad(String ad, String soyad, String sqlKolonAdi, String yeniDeger) {
    String sql = "UPDATE Personel SET " + sqlKolonAdi + " = ? WHERE Ad = ? AND Soyad = ?";
    try (Connection con = DBConnection.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {

        if (sqlKolonAdi.equalsIgnoreCase("IseGirisTarihi") && (yeniDeger == null || yeniDeger.trim().isEmpty())) {
            ps.setNull(1, java.sql.Types.VARCHAR);
        } else {
            ps.setString(1, yeniDeger);
        }
        ps.setString(2, ad);
        ps.setString(3, soyad);

        return ps.executeUpdate() > 0;
    } catch (Exception e) {
        System.err.println("Ad-Soyad ile Güncelleme Hatası (" + sqlKolonAdi + "): " + e.getMessage());
        return false;
    }
}
public void otomatikYillikIzinGuncelle() {
    String sqlSelect =
        "SELECT P.PersonelID, P.IseGirisTarihi, " +
        "I.HakEdilenIzin, I.KullanilanIzin, I.KalanIzin, " +
        "I.SonIzinYenilemeTarihi " +
        "FROM Personel P " +
        "INNER JOIN PersonelIzin I " +
        "ON P.PersonelID = I.PersonelID " +
        "WHERE P.IseGirisTarihi IS NOT NULL";
    Connection conn = null;
    try {
        conn = DBConnection.getConnection();
        conn.setAutoCommit(false);

        try (PreparedStatement ps =
                     conn.prepareStatement(sqlSelect);
             ResultSet rs = ps.executeQuery()) {

            java.time.LocalDate bugun =
                    java.time.LocalDate.now();
            while (rs.next()) {
                int personelId =
                        rs.getInt("PersonelID");
                java.sql.Date sqlTarih =
                        rs.getDate("IseGirisTarihi");
                if (sqlTarih == null) {
                    continue;
                }

                java.time.LocalDate iseGiris =
                        sqlTarih.toLocalDate();
                int kidemYili =
                        java.time.Period
                                .between(iseGiris, bugun)
                                .getYears();

                
                if (kidemYili < 1) {
                    continue;
                }
                java.time.LocalDate buYilDonumu;
                try {
                    buYilDonumu =
                        iseGiris.withYear(bugun.getYear());
                } catch (java.time.DateTimeException e) {
                    buYilDonumu =
                        java.time.LocalDate.of(
                            bugun.getYear(),
                            2,
                            28
                        );
                }

                if (bugun.isBefore(buYilDonumu)) {
                    continue;
                }

                java.sql.Date sqlSonYenileme =
                        rs.getDate("SonIzinYenilemeTarihi");

                java.time.LocalDate sonYenileme = null;

                if (sqlSonYenileme != null) {

                    sonYenileme =
                            sqlSonYenileme.toLocalDate();
                }
                if (sonYenileme != null &&
                    sonYenileme.getYear() == bugun.getYear()) {
                    continue;
                }

                int yeniIzin;

                if (kidemYili <= 5) {

                    yeniIzin = 18;

                } else if (kidemYili < 15) {

                    yeniIzin = 23;

                } else {

                    yeniIzin = 28;
                }

                int yil = bugun.getYear();

                String kolon;

                switch (yil) {

                    case 2019:
                        kolon = "Izin2019";
                        break;

                    case 2020:
                        kolon = "Izin2020";
                        break;

                    case 2021:
                        kolon = "Izin2021";
                        break;

                    case 2022:
                        kolon = "Izin2022";
                        break;

                    case 2023:
                        kolon = "Izin2023";
                        break;

                    case 2024:
                        kolon = "Izin2024";
                        break;

                    case 2025:
                        kolon = "Izin2025";
                        break;

                    case 2026:
                        kolon = "Izin2026";
                        break;

                    default:
                        System.out.println(
                            "Bu yıl için izin sütunu yok: " + yil
                        );
                        continue;
                }

                int mevcutHak =
                        rs.getInt("HakEdilenIzin");

                int mevcutKalan =
                        rs.getInt("KalanIzin");

                int yeniHak =
                        mevcutHak + yeniIzin;

                int yeniKalan =
                        mevcutKalan + yeniIzin;

                String sqlUpdate =
                    "UPDATE PersonelIzin SET " +
                    kolon + " = " + kolon + " + ?, " +
                    "HakEdilenIzin = ?, " +
                    "KalanIzin = ?, " +
                    "SonIzinYenilemeTarihi = ? " +
                    "WHERE PersonelID = ?";

                try (PreparedStatement psUpdate =
                             conn.prepareStatement(sqlUpdate)) {

                    psUpdate.setInt(1, yeniIzin);
                    psUpdate.setInt(2, yeniHak);
                    psUpdate.setInt(3, yeniKalan);
                    psUpdate.setDate(
                        4,
                        java.sql.Date.valueOf(bugun)
                    );
                    psUpdate.setInt(5, personelId);

                    psUpdate.executeUpdate();
                }

                System.out.println(
                    "Personel ID: " + personelId +
                    " | Kıdem: " + kidemYili +
                    " yıl" +
                    " | " + yil +
                    " yılına eklenen izin: " +
                    yeniIzin + " gün"
                );
            }
        }

        conn.commit();

        System.out.println(
            "Otomatik yıllık izin güncellemesi tamamlandı."
        );

    } catch (SQLException e) {

        e.printStackTrace();

        if (conn != null) {

            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    } finally {

        if (conn != null) {

            try {
                conn.setAutoCommit(true);
                conn.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
            public boolean personelIzinGuncelle(int personelId, int hakEdilen, int kullanilan) {
                int kalan = hakEdilen - kullanilan;
                String sql = "UPDATE PersonelIzin SET HakEdilenIzin = ?, KullanilanIzin = ?, KalanIzin = ? WHERE PersonelID = ?";
                try (Connection con = DBConnection.getConnection();
                        PreparedStatement ps = con.prepareStatement(sql)) {
                    ps.setInt(1, hakEdilen);
                    ps.setInt(2, kullanilan);
                    ps.setInt(3, kalan);
                    ps.setInt(4, personelId);
                    int etkilenen = ps.executeUpdate();
                    
                    if (etkilenen == 0) {
                    String insertSql = "INSERT INTO PersonelIzin (PersonelID, HakEdilenIzin, KullanilanIzin, KalanIzin) VALUES (?, ?, ?, ?)";
                    try (PreparedStatement insertPs = con.prepareStatement(insertSql)) {
                        insertPs.setInt(1, personelId);
                        insertPs.setInt(2, hakEdilen);
                        insertPs.setInt(3, kullanilan);
                        insertPs.setInt(4, kalan);
                        return insertPs.executeUpdate() > 0;
                    }
                    }
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
            }
            public boolean personelIzinGuncelleByTcOrAd(String tcNo, String ad, String soyad, int hakEdilen, int kullanilan, int kalan) {
                String idBulSql = "";
                boolean tcIleAra = (tcNo != null && !tcNo.trim().isEmpty());
                if (tcIleAra) {
                    idBulSql = "SELECT PersonelID FROM Personel WHERE TCNo = ?";
                } else {
                    idBulSql = "SELECT PersonelID FROM Personel WHERE Ad = ? AND Soyad = ?";
                }
                try (Connection con = DBConnection.getConnection();
                        PreparedStatement psId = con.prepareStatement(idBulSql)) {
                    if (tcIleAra) {
                        psId.setString(1, tcNo.trim());
                    } else {
                        psId.setString(1, ad.trim());
                        psId.setString(2, soyad.trim());
                    }
                    ResultSet rs = psId.executeQuery();
                    if (rs.next()) {
                        int personelId = rs.getInt("PersonelID");

            
            String updateSql = "UPDATE PersonelIzin SET HakEdilenIzin = ?, KullanilanIzin = ?, KalanIzin = ? WHERE PersonelID = ?";
            try (PreparedStatement psUpdate = con.prepareStatement(updateSql)) {
                psUpdate.setInt(1, hakEdilen);
                psUpdate.setInt(2, kullanilan);
                psUpdate.setInt(3, kalan);
                psUpdate.setInt(4, personelId);

                int rows = psUpdate.executeUpdate();
                if (rows > 0) {
                    return true; 
                }

               
                String insertSql = "INSERT INTO PersonelIzin (PersonelID, HakEdilenIzin, KullanilanIzin, KalanIzin) VALUES (?, ?, ?, ?)";
                try (PreparedStatement psInsert = con.prepareStatement(insertSql)) {
                    psInsert.setInt(1, personelId);
                    psInsert.setInt(2, hakEdilen);
                    psInsert.setInt(3, kullanilan);
                    psInsert.setInt(4, kalan);
                    return psInsert.executeUpdate() > 0;
                }
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return false;
}
public void excelImportVeSifirdanEkle(String csvDosyaYolu) {
    String sqlPersonel = "INSERT INTO Personel (Ad, Soyad, TCNo, Sube, Gorev, IseGirisTarihi) VALUES (?, ?, ?, ?, ?, ?)";
    
    String sqlIzin = "INSERT INTO PersonelIzin " +
            "(PersonelID, Izin2018Oncesi, Izin2019, Izin2020, Izin2021, Izin2022, Izin2023, Izin2024, Izin2025, Izin2026, HakEdilenIzin, KullanilanIzin, KalanIzin) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    int eklenenSayac = 0;

    try (java.io.BufferedReader br = new java.io.BufferedReader(
            new java.io.InputStreamReader(new java.io.FileInputStream(csvDosyaYolu), "UTF-8"))) {

        String satir;
        int satirNo = 0;

        try (java.sql.Connection con = database.DBConnection.getConnection()) {
            con.setAutoCommit(false);

            while ((satir = br.readLine()) != null) {
                if (satir.trim().isEmpty()) continue;
                satirNo++;

             
                if (satirNo == 1 || satir.toUpperCase().contains("SIRA NO") || satir.toUpperCase().contains("T.C")) {
                    continue;
                }

                String[] veriler = satir.split(";(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);

                for (int i = 0; i < veriler.length; i++) {
                    veriler[i] = veriler[i].replaceAll("^\"|\"$", "").trim();
                }

              
                String ad          = (veriler.length > 1) ? veriler[1] : "";
                String soyad       = (veriler.length > 2) ? veriler[2] : "";
                String tcNo        = (veriler.length > 3) ? veriler[3] : "";
                String sube        = (veriler.length > 5) ? veriler[5] : "";
                String iseGirisRaw = (veriler.length > 6) ? veriler[6] : "";
                String gorev       = (veriler.length > 7) ? veriler[7] : "";

                tcNo = tcNo.replaceAll("[^0-9]", "");
                if (tcNo.length() > 11) tcNo = tcNo.substring(0, 11);

                int iz18 = parseSafeInt(veriler, 8);
                int iz19 = parseSafeInt(veriler, 9);
                int iz20 = parseSafeInt(veriler, 10);
                int iz21 = parseSafeInt(veriler, 11);
                int iz22 = parseSafeInt(veriler, 12);
                int iz23 = parseSafeInt(veriler, 13);
                int iz24 = parseSafeInt(veriler, 14);
                int iz25 = parseSafeInt(veriler, 15);
                int iz26 = parseSafeInt(veriler, 16);

                int hakEdilen  = parseSafeInt(veriler, 17);
                int kullanilan = parseSafeInt(veriler, 18);
                int kalan      = parseSafeInt(veriler, 19);

                String iseGirisTarihi = null;
                if (iseGirisRaw.contains(".")) {
                    String[] p = iseGirisRaw.split("\\.");
                    if (p.length == 3) {
                        try {
                            iseGirisTarihi = String.format("%04d-%02d-%02d", 
                                Integer.parseInt(p[2].trim()), 
                                Integer.parseInt(p[1].trim()), 
                                Integer.parseInt(p[0].trim()));
                        } catch (Exception ignored) {}
                    }
                } else if (iseGirisRaw.contains("-")) {
                    iseGirisTarihi = iseGirisRaw;
                }

                int yeniPersonelId = -1;

                try (java.sql.PreparedStatement psP = con.prepareStatement(sqlPersonel, java.sql.Statement.RETURN_GENERATED_KEYS)) {
                    psP.setString(1, ad);                           
                    psP.setString(2, soyad);                        
                    psP.setString(3, tcNo.isEmpty() ? null : tcNo); 
                    psP.setString(4, sube);                         
                    psP.setString(5, gorev);                        

                    if (iseGirisTarihi != null && !iseGirisTarihi.isEmpty()) {
                        psP.setString(6, iseGirisTarihi);           
                    } else {
                        psP.setNull(6, java.sql.Types.DATE);
                    }

                    psP.executeUpdate();

                    try (java.sql.ResultSet rs = psP.getGeneratedKeys()) {
                        if (rs.next()) {
                            yeniPersonelId = rs.getInt(1);
                        }
                    }
                }

                
                if (yeniPersonelId != -1) {
                    try (java.sql.PreparedStatement psI = con.prepareStatement(sqlIzin)) {
                        psI.setInt(1, yeniPersonelId);
                        psI.setInt(2, iz18);
                        psI.setInt(3, iz19);
                        psI.setInt(4, iz20);
                        psI.setInt(5, iz21);
                        psI.setInt(6, iz22);
                        psI.setInt(7, iz23);
                        psI.setInt(8, iz24);
                        psI.setInt(9, iz25);
                        psI.setInt(10, iz26);
                        psI.setInt(11, hakEdilen);
                        psI.setInt(12, kullanilan);
                        psI.setInt(13, kalan);

                        psI.executeUpdate();
                    }
                    eklenenSayac++;
                }
            }

            con.commit();
            javax.swing.JOptionPane.showMessageDialog(null, "BAŞARILI!\n" + eklenenSayac + " personel eksiksiz yüklendi.");

        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, "SQL Hatası: " + e.getMessage());
            e.printStackTrace();
        }

    } catch (Exception e) {
        javax.swing.JOptionPane.showMessageDialog(null, "Dosya Hatası: " + e.getMessage());
        e.printStackTrace();
    }
}
private int parseSafeInt(String[] veriler, int index) {
    if (index < veriler.length && !veriler[index].isEmpty()) {
        try {
            return Integer.parseInt(veriler[index].replaceAll("[^0-9]", ""));
        } catch (Exception e) {
            return 0;
        }
    }
    return 0;
}
private java.util.List<String> parseCsvSatir(String line) {
    java.util.List<String> result = new java.util.ArrayList<>();
    boolean inQuotes = false;
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < line.length(); i++) {
        char c = line.charAt(i);
        if (c == '"') {
            inQuotes = !inQuotes; 
        } else if ((c == ';' || c == ',') && !inQuotes) {
            result.add(sb.toString()); 
            sb.setLength(0);
        } else {
            sb.append(c);
        }
    }
    result.add(sb.toString()); 
    return result;
}

private int parseSafeInt(Object obj) {
    if (obj == null) return 0;
    try {
        
        String str = String.valueOf(obj).replaceAll("[^0-9]", "");
        return str.isEmpty() ? 0 : Integer.parseInt(str);
    } catch (Exception e) {
        return 0;
    }
}
private java.sql.Date formatTarihForSql(String rawDate) {
    if (rawDate == null || rawDate.trim().isEmpty()) {
        return null;
    }
    
    String cleanDate = rawDate.trim().replace("/", ".").replace("-", ".");
    String[] formats = {"dd.MM.yyyy", "yyyy.MM.dd", "d.M.yyyy", "yyyy.M.d"};

    for (String format : formats) {
        try {
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(format);
            sdf.setLenient(false);
            java.util.Date parsedDate = sdf.parse(cleanDate);
            return new java.sql.Date(parsedDate.getTime()); // Doğrudan SQL Date nesnesi döner
        } catch (Exception ignored) {}
    }
    
    return null;
}
public List<Object[]> yillikIzinHaklariniGetir(int personelId) {

    List<Object[]> liste = new ArrayList<>();

    String sql =
        "SELECT Izin2021, Izin2022, Izin2023, " +
        "Izin2024, Izin2025, Izin2026 " +
        "FROM PersonelIzin " +
        "WHERE PersonelID = ?";

    try (Connection con = DBConnection.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setInt(1, personelId);

        try (ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {

                liste.add(new Object[]{2021, rs.getInt("Izin2021")});
                liste.add(new Object[]{2022, rs.getInt("Izin2022")});
                liste.add(new Object[]{2023, rs.getInt("Izin2023")});
                liste.add(new Object[]{2024, rs.getInt("Izin2024")});
                liste.add(new Object[]{2025, rs.getInt("Izin2025")});
                liste.add(new Object[]{2026, rs.getInt("Izin2026")});
            }
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return liste;
}
}




