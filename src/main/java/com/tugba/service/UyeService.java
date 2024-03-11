package com.tugba.service;

import com.tugba.entity.Uye;
import com.tugba.repository.IUyeRepository;
import com.tugba.repository.UyeRepository;

import java.util.ArrayList;

public class UyeService {
    private IUyeRepository uyeRepository;

    public UyeService(){
        uyeRepository = new UyeRepository();
    }
    public void save(Uye uye) {
        uyeRepository.save(uye);
    }

    public void delete(int index) {
        uyeRepository.delete(index);

    }
    public ArrayList<Uye> findAll() {
        return uyeRepository.findAll();
    }
}
