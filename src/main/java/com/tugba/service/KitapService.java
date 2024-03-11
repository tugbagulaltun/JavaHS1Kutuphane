package com.tugba.service;

import com.tugba.entity.Kitap;
import com.tugba.repository.IKitapRepository;
import com.tugba.repository.KitapRepository;

import java.util.ArrayList;

public class KitapService {
    private IKitapRepository kitapRepository;
    public KitapService(){
        kitapRepository = new KitapRepository();
    }
    public void save(Kitap book) {
        kitapRepository.save(book);
    }
    public void delete(int index) {kitapRepository.delete(index);}
    public ArrayList<Kitap> findAll() {
        return kitapRepository.findAll();
    }
}
