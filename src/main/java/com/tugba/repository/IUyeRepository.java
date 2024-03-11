package com.tugba.repository;



import com.tugba.entity.Uye;

import java.util.ArrayList;

public interface IUyeRepository {
    public void save(Uye uye);
    public void delete(int index);
    public ArrayList<Uye> findAll();
}
