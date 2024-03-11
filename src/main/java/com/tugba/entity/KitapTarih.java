package com.tugba.entity;

import java.util.Date;

public class KitapTarih extends Kitap{

    public KitapTarih(int ISBN, String kitapTur, String baslik, String yazarAdi, int yayinYili, int sayfaSayisi, String yayinEvi, Durum durum) {
        super(ISBN, kitapTur, baslik, yazarAdi, yayinYili, sayfaSayisi, yayinEvi, durum);}
}
