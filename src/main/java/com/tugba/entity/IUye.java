package com.tugba.entity;

import java.util.List;

public interface IUye {

    List<Kitap> oduncAlinanKitaplarinListesi();
    void kitapOduncAl(Kitap kitap);
    void kitapIadeEt(Kitap kitap);

    

}
