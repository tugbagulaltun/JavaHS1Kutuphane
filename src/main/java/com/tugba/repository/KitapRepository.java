package com.tugba.repository;

import com.tugba.entity.Kitap;
import com.tugba.utility.DataBase;

import java.util.ArrayList;

public class KitapRepository implements IKitapRepository{

    @Override
    public void save(Kitap kitap) {
        DataBase.kitapListesi.add(kitap);
    }

    @Override
    public void delete(int index) {
        DataBase.kitapListesi.remove(index);
    }

    @Override
    public ArrayList<Kitap> findAll() {
        return DataBase.kitapListesi;
    }
}
