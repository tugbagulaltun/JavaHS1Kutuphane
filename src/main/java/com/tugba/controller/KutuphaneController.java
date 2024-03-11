package com.tugba.controller;

import com.tugba.entity.Kutuphane;
import com.tugba.entity.Uye;
import java.util.Scanner;

public class KutuphaneController {
    public static void main(String[] args) {
        KutuphaneController kutuphaneController = new KutuphaneController();
        kutuphaneController.uygulama();
    }

    private void uygulama() {
        Kutuphane kutuphane = new Kutuphane();
        Scanner scanner = new Scanner(System.in);
        int secim;
        do {
            anaMenu();
            secim = secimYap(scanner);
            anaIslemler(secim, kutuphane, scanner);
        } while (secim != 3);
    }

    private int secimYap(Scanner scanner) {
        int secim;
        System.out.println("Lütfen seçim yapınız:");
        secim = Integer.parseInt(scanner.nextLine());
        return secim;
    }

    public void anaMenu() {
        System.out.println("""
                **********************************
                ****** KUTUPHANE OTOMASYONU ******
                **********************************
                
                1- ÜYE İşlemleri
                2- KITAP İşlemleri
                3- ÇIKIS""");
    }

    public void anaIslemler(int secim, Kutuphane kutuphane, Scanner scanner) {

        switch (secim) {
            case 1:
                uyeIslemleriMenusu();
                int uyeSecim = secimYap(scanner);
                uyeIslemleriSecimleri(uyeSecim, kutuphane, scanner);
                break;
            case 2:
                kitapIslemleriMenusu();
                int kitapSecim = secimYap(scanner);
                kitapIslemleriSecimleri(kitapSecim, kutuphane, scanner);
                break;
            case 3:
                System.out.println("Çıkış yapılıyor...");
                break;
            default:
                System.out.println("Hatalı seçim yaptınız.");
                break;
        }
    }

    public void uyeIslemleriMenusu() {
        System.out.println("""
                **********************************
                ****** ÜYE İSLEMLERİ MENÜSÜ ******
                **********************************
                
                1- Üye Ekle
                2- Üyeleri Listele
                3- Üye Bul
                4- Uyenin Odunc Aldığı Kitapların Listesi
                5- ANA MENÜ""");
    }

    public void uyeIslemleriSecimleri(int uyeSecim, Kutuphane kutuphane, Scanner scanner) {
        switch (uyeSecim) {
            case 1:
                kutuphane.yeniUyeEklemeIslemi();
                break;
            case 2:
                kutuphane.uyeleriListele();
                break;
            case 3:
                System.out.println("Lütfen Uye ID bilgisini giriniz.");
                String uyeId= scanner.nextLine();
                kutuphane.uyeBul(uyeId);
                break;
            case 4:
                kutuphane.uyeninOduncAldigiKitaplariListele();
                break;
                case 5:
                anaMenu();
                break;
            default:
                System.out.println("Hatalı seçim yaptınız.");
                break;
        }
    }

    public void kitapIslemleriMenusu() {
        System.out.println("""
                **********************************
                ***** KITAP ISLEMLERİ MENÜSÜ *****
                **********************************
                
                1- Kitap Ekle
                2- Kayıp Kitap Bildir
                3- Kitapları Listele
                4- Kitap Bul
                5- Kitap Durumunu Görüntüle
                6- Kitap Ödünç Al
                7- Kitap İade Et 
                8- ANA MENÜ""");
    }

    public void kitapIslemleriSecimleri(int kitapSecim, Kutuphane kutuphane, Scanner scanner) {
        switch (kitapSecim) {
            case 1:
                kutuphane.yeniKitapEkle();
                break;
            case 2:
                kutuphane.kitapMevcutDurumGuncelle();
                break;
            case 3:
                kutuphane.tumKitaplariListele();
                break;
            case 4:
                kutuphane.kitapBul();
                break;
            case 5:
                kutuphane.kitapDurumunuGoruntule();
                break;
            case 6:
                kutuphane.kitapOduncAl();
                break;
            case 7:
                kutuphane.kitapIadeEt();
                break;
            case 8:
                anaMenu();
                break;
            default:
                System.out.println("Hatalı seçim yaptınız.");
                break;
        }
    }
}
