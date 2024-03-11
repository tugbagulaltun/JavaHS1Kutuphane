package com.tugba.entity;

import java.util.Date;
import java.util.logging.LogManager;

public abstract class Kitap {
    private int ISBN;
    private String baslik;
    private String yazarAdi;
    private int yayinYili;
    private int sayfaSayisi;
    private String yayinEvi;
    private String kitapTur;
    private Durum durum;



    public Kitap(int ISBN, String kitapTur, String baslik, String yazarAdi, int yayinYili, int sayfaSayisi, String yayinEvi, Durum durum) {
        this.ISBN = ISBN;
        this.kitapTur= kitapTur;
        this.baslik = baslik;
        this.yazarAdi = yazarAdi;
        this.yayinYili = yayinYili;
        this.sayfaSayisi = sayfaSayisi;
        this.yayinEvi = yayinEvi;
        this.durum = durum;
    }

    public Kitap() {

    }

    @Override
    public String toString() {
        return "KITAP BILGILERI -> {" +
                "  ISBN: " + ISBN +
                "  Kitap Tur: " + kitapTur +
                ", Kitap Başlık: '" + baslik + '\'' +
                ", Kitap Yazar Adı: '" + yazarAdi + '\'' +
                ", Kitap Yayın Yılı: " + yayinYili +
                ", Kitap Sayfa Sayısı: " + sayfaSayisi +
                ", Kitap Yayın Evi: '" + yayinEvi + '\'' +
                ", Kitap Durumu: '" + durum + '\'' +
                '}';
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getBaslik() {
        return baslik;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    public String getYazarAdi() {
        return yazarAdi;
    }

    public void setYazarAdi(String yazarAdi) {
        this.yazarAdi = yazarAdi;
    }

    public int getYayinYili() {
        return yayinYili;
    }

    public void setYayinYili(int yayinYili) {
        this.yayinYili = yayinYili;
    }
    public Durum getDurum() {
        return durum;
    }

    public void setDurum(Durum durum) {
        this.durum = durum;
    }

    public int getSayfaSayisi() {
        return sayfaSayisi;
    }

    public void setSayfaSayisi(int sayfaSayisi) {
        this.sayfaSayisi = sayfaSayisi;
    }
    public String getYayinEvi() {
        return yayinEvi;
    }

    public void setYayinEvi(String yayinEvi) {
        this.yayinEvi = yayinEvi;
    }
    public String getKitapTur() {
        return kitapTur;
    }

    public void setKitapTur(String kitapTur) {
        this.kitapTur = kitapTur;
    }
}
