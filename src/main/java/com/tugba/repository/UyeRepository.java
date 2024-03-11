package com.tugba.repository;

import com.tugba.entity.Uye;
import com.tugba.utility.DataBase;

import java.util.ArrayList;

public class UyeRepository implements IUyeRepository{
    @Override
    public void save(Uye uye) {DataBase.uyeListesi.add(uye);}
    @Override
    public void delete(int index) {DataBase.uyeListesi.remove(index);}
    @Override
    public ArrayList<Uye> findAll() {return DataBase.uyeListesi;}
}
