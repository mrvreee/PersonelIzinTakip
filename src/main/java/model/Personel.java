/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Personel {

    private int personelID;
    private String ad;
    private String soyad;
    private String tcNo;
    private String sube;
    private String gorev;
    private String iseGirisTarihi;
    private int hakEdilenIzin;
    private int kullanilanIzin;
    private int kalanIzin;

    // 1. Boş Constructor
    public Personel() {
    }

    // 2. Parametreli Constructor (Veritabanından Nesne Oluştururken Çok Kolaylık Sağlar)
    public Personel(int personelID, String ad, String soyad, String tcNo, String sube, String gorev, String iseGirisTarihi, int hakEdilenIzin, int kullanilanIzin, int kalanIzin) {
        this.personelID = personelID;
        this.ad = ad;
        this.soyad = soyad;
        this.tcNo = tcNo;
        this.sube = sube;
        this.gorev = gorev;
        this.iseGirisTarihi = iseGirisTarihi;
        this.hakEdilenIzin = hakEdilenIzin;
        this.kullanilanIzin = kullanilanIzin;
        this.kalanIzin = kalanIzin;
    }

    // --- GETTER & SETTER METOTLARI ---
    public int getPersonelId() {
        return personelID;
    }

    public void setPersonelID(int personelID) {
        this.personelID = personelID;
    }

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

    public String getTcNo() {
        return tcNo;
    }

    public void setTcNo(String tcNo) {
        this.tcNo = tcNo;
    }

    public String getSube() {
        return sube;
    }

    public void setSube(String sube) {
        this.sube = sube;
    }

    public String getGorev() {
        return gorev;
    }

    public void setGorev(String gorev) {
        this.gorev = gorev;
    }

    public String getIseGirisTarihi() {
        return iseGirisTarihi;
    }

    public void setIseGirisTarihi(String iseGirisTarihi) {
        this.iseGirisTarihi = iseGirisTarihi;
    }

    public int getHakEdilenIzin() {
        return hakEdilenIzin;
    }

    public void setHakEdilenIzin(int hakEdilenIzin) {
        this.hakEdilenIzin = hakEdilenIzin;
    }

    public int getKullanilanIzin() {
        return kullanilanIzin;
    }

    public void setKullanilanIzin(int kullanilanIzin) {
        this.kullanilanIzin = kullanilanIzin;
    }

    public int getKalanIzin() {
        return kalanIzin;
    }

    public void setKalanIzin(int kalanIzin) {
        this.kalanIzin = kalanIzin;
    }

    
    @Override
    public String toString() {
    return ad + " " + soyad;
    }
}

