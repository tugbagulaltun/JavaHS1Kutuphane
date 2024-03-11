package com.tugba.repository;

import com.tugba.entity.Kitap;
import com.tugba.utility.DataBase;

import java.util.ArrayList;

public interface IKitapRepository {

    public void save(Kitap kitap);
    public void delete(int index);
    public ArrayList<Kitap> findAll();
}
