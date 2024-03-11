package com.tugba.entity;

import com.tugba.entity.IUye;
import com.tugba.entity.Kitap;

import java.util.ArrayList;
import java.util.List;

public class Uye implements IUye {
    private String uyeId;
    private String uyeAd;
    private String uyeSoyad;
    private String uyeTelefon;
    private String uyeAdres;
    private int uyeYas;
    private int uyeOlmaTarihi;
    private List<Kitap> oduncAlinanKitaplarListesi;

    public Uye(String uyeAd, String uyeSoyad, String uyeTelefon, String uyeAdres, int uyeYas, int uyeOlmaTarihi) {
        this.uyeId = uyeOlmaTarihi + uyeAd.toLowerCase() + uyeSoyad.charAt(0) + uyeSoyad.length();
        this.uyeAd = uyeAd;
        this.uyeSoyad = uyeSoyad;
        this.uyeTelefon = uyeTelefon;
        this.uyeAdres = uyeAdres;
        this.uyeYas = uyeYas;
        this.uyeOlmaTarihi = uyeOlmaTarihi;
        this.oduncAlinanKitaplarListesi = new ArrayList<>();
    }

    public Uye() {
    }

    @Override
    public String toString() {
        return "UYE BILGILERI -> {" +
                "Uye ID: " + uyeId +
                ", Uye Ad: " + uyeAd + '\'' +
                ", Uye Soyad: '" + uyeSoyad + '\'' +
                ", Uye Telefon: '" + uyeTelefon + '\'' +
                ", Uye Adres: '" + uyeAdres + '\'' +
                ", Uye Yas: " + uyeYas +
                ", Uye Kayıt Tarihi: " + uyeOlmaTarihi +
                '}';
    }

    public String getUyeId() {
        return uyeId;
    }

    public String getUyeAd() {
        return uyeAd;
    }

    public String getUyeSoyad() {
        return uyeSoyad;
    }

    public String getUyeTelefon() {
        return uyeTelefon;
    }

    public String getUyeAdres() {
        return uyeAdres;
    }

    public int getUyeYas() {
        return uyeYas;
    }

    public int getUyeOlmaTarihi() {
        return uyeOlmaTarihi;
    }

    public List<Kitap> getOdunAlinanKitaplarListesi() {
        return oduncAlinanKitaplarListesi;
    }


    @Override
    public List<Kitap> oduncAlinanKitaplarinListesi() {
        return oduncAlinanKitaplarListesi;
    }

    @Override
    public void kitapOduncAl(Kitap kitap) {
    getOdunAlinanKitaplarListesi().add(kitap);
    }

    @Override
    public void kitapIadeEt(Kitap kitap) {
        getOdunAlinanKitaplarListesi().remove(kitap);
    }
}
