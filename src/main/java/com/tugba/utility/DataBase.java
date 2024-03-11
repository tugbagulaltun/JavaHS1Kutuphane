package com.tugba.utility;

import com.tugba.entity.Kitap;
import com.tugba.entity.Kutuphane;
import com.tugba.entity.Uye;

import java.util.ArrayList;

public abstract class DataBase {
    public static ArrayList<Kitap> kitapListesi = new ArrayList<>();
    public static ArrayList<Uye> uyeListesi = new ArrayList<>();
    public static ArrayList<Kutuphane> kutuphaneListesi = new ArrayList<>();

}
