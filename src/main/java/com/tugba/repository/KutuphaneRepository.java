package com.tugba.repository;

import com.tugba.entity.Kutuphane;
import com.tugba.utility.DataBase;

public class KutuphaneRepository implements IKutuphaneRepository{

    @Override
    public void save(Kutuphane kutuphane) {
        DataBase.kutuphaneListesi.add(kutuphane);
    }
}
