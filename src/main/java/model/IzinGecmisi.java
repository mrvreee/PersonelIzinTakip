/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.sql.Date;

public class IzinGecmisi {
    private int id;
    private int personelId;
    private Date izinTarihi;
    private int gunSayisi;
    private String aciklama;
    private String ad;
private String soyad;
private String sube;

    public IzinGecmisi() {}

    public IzinGecmisi(int personelId, Date izinTarihi, int gunSayisi, String aciklama) {
        this.personelId = personelId;
        this.izinTarihi = izinTarihi;
        this.gunSayisi = gunSayisi;
        this.aciklama = aciklama;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getPersonelId() { return personelId; }
    public void setPersonelId(int personelId) { this.personelId = personelId; }

    public Date getIzinTarihi() { return izinTarihi; }
    public void setIzinTarihi(Date izinTarihi) { this.izinTarihi = izinTarihi; }

    public int getGunSayisi() { return gunSayisi; }
    public void setGunSayisi(int gunSayisi) { this.gunSayisi = gunSayisi; }

    public String getAciklama() { return aciklama; }
    public void setAciklama(String aciklama) { this.aciklama = aciklama; }
    public String getAd() {
    return ad;
}

public void setAd(String ad) {
    this.ad = ad;
}

public String getSoyad() {
    return soyad;
}

public void setSoyad(String soyad) {
    this.soyad = soyad;
}

public String getSube() {
    return sube;
}

public void setSube(String sube) {
    this.sube = sube;
}
}

/**
 *
 * @author mrveg
 */