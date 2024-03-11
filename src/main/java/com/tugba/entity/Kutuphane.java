package com.tugba.entity;

import java.util.*;

public class Kutuphane {
    private List<Uye> uyeler;
    private List<Kitap> kitaplar;

    public Kutuphane() {
        this.uyeler = new ArrayList<>();
        this.kitaplar = new ArrayList<>();
    }

    public Kutuphane(List<Uye> uyeler, List<Kitap> kitaplar) {
        this.uyeler = uyeler;
        this.kitaplar = kitaplar;
    }

    public void yeniUyeEklemeIslemi() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Yeni Üye Bilgilerini Giriniz:");
        System.out.print("Ad: ");
        String ad = scanner.nextLine();

        System.out.print("Soyad: ");
        String soyad = scanner.nextLine();

        System.out.print("Telefon: ");
        String telefon = scanner.nextLine();

        System.out.print("Adres: ");
        String adres = scanner.nextLine();

        System.out.print("Yaş: ");
        int yas = scanner.nextInt();

        System.out.print("Uye Olma Tarihi ");
        int uyeOlmaTarihi = scanner.nextInt();

        Uye yeniUye = new Uye(ad, soyad, telefon, adres, yas, uyeOlmaTarihi);
        uyeler.add(yeniUye);


        System.out.println("Yeni üye başarıyla eklendi. Yeni üyenin ID Numarası: " + yeniUye.getUyeId());
    }

    public void uyeSilmeIslemi() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Silinmesini istediğiniz Uyenin Uye ID numarasını yazınız.");
        int uyeID = scanner.nextInt();
        boolean uyeMevcutMu = false;
        Iterator<Uye> iterator = uyeler.iterator();
        while (iterator.hasNext()) {
            Uye siradakiUye = iterator.next();
            if (Objects.equals(siradakiUye.getUyeId(), String.valueOf(uyeID))) {
                uyeMevcutMu = true;
                System.out.println(uyeID + "Girilen ID numarasına göre bulunan kütüphane üyesi bilgileri aşağıdaki gibidir.");
                System.out.println("Üye Adı: " + siradakiUye.getUyeAd());
                System.out.println("Üye Soyad: " + siradakiUye.getUyeSoyad());
                System.out.println("Üye Telefon: " + siradakiUye.getUyeTelefon());
                System.out.println("Üye Olma Tarihi: " + siradakiUye.getUyeOlmaTarihi());
                System.out.println("Bu üyeyi sistemden silmek istiyor musunuz? E/H");
                String kontrol = scanner.nextLine();
                if (kontrol.equalsIgnoreCase("E")) {
                    iterator.remove();
                    System.out.println(uyeID + " Üye ID'li " + siradakiUye.getUyeAd() + " " + siradakiUye.getUyeSoyad() + " Adlı üye sistemden başarılı ile silinmiştir. ");
                } else {
                    System.out.println("Üye Silinmedi.");
                }
                break;
            }
        }
        if (!uyeMevcutMu) {
            System.out.println(uyeID + " Bu girilen ID'ye sahip bir üye bulunamadı. Tekrar Deneyin.");
            uyeSilmeIslemi();
        }
    }


    public Uye uyeBul(String uyeId) {
        for (Uye siradakiUye : uyeler) {
            if (siradakiUye.getUyeId().equals(uyeId)) {
                System.out.println(uyeId + " ID numarasına sahip üye bulundu.");
                System.out.println("Üye Adı: " + siradakiUye.getUyeAd());
                System.out.println("Üye Soyadı: " + siradakiUye.getUyeSoyad());
                System.out.println("Üye Telefon: " + siradakiUye.getUyeTelefon());
                System.out.println("Üye Olma Tarihi: " + siradakiUye.getUyeOlmaTarihi());
                return siradakiUye; // Bulunan üyeyi döndür
            }
        }

        System.out.println(uyeId + " ID numarasına sahip üye bulunamadı.");
        return null; // Üye bulunamadıysa null döndür
    }

    public void uyeleriListele() {
        System.out.println("Üyeler:");
        for (Uye uye : uyeler) {
            System.out.println("Ad: " + uye.getUyeAd() + ", Soyad: " + uye.getUyeSoyad() + ", Üye Numarası: " + uye.getUyeId() + ", Üye Telefon: " + uye.getUyeTelefon() + ", Üye Olma Tarihi: " + uye.getUyeOlmaTarihi());
        }
    }

    public void uyeninOduncAldigiKitaplariListele() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Lütfen Üye ID bilgisini giriniz: ");
        String uyeId = scanner.nextLine();
        Uye uye = uyeBul(uyeId);

        if (uye == null) {
            System.out.println("Belirtilen Üye ID'sine sahip üye bulunamadı.");
            return;
        }

        System.out.println("***** Üyenin Ödünç Aldığı Kitapların Listesi *****");
        List<Kitap> oduncAlinanKitaplar = uye.oduncAlinanKitaplarinListesi();
        if (oduncAlinanKitaplar.isEmpty()) {
            System.out.println("Üye hiçbir kitap ödünç almamış.");
            return;
        }

        System.out.println("Üyenin Ödünç Aldığı Kitaplar:");
        for (Kitap kitap : oduncAlinanKitaplar) {
            System.out.println("Kitap Başlık: " + kitap.getBaslik());
            System.out.println("ISBN: " + kitap.getISBN());
            System.out.println("Yazar: " + kitap.getYazarAdi());
            System.out.println("Kitabın Güncel Durumu: " + kitap.getDurum());
            System.out.println("--------------------------");
        }
    }

    public void yeniKitapEkle() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Yeni Kitap Bilgilerini Giriniz:");

        System.out.print("ISBN: ");
        int isbn = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Başlık: ");
        String baslik = scanner.nextLine();

        System.out.print("Yazar: ");
        String yazar = scanner.nextLine();

        System.out.print("Yayın Yılı: ");
        int yayinYili = scanner.nextInt();

        System.out.print("Sayfa Sayısı: ");
        int sayfaSayisi = scanner.nextInt();

        scanner.nextLine(); // nextint den sonra hata vermemesi için

        System.out.print("Yayın Evi: ");
        String yayinEvi = scanner.nextLine();

        System.out.println("Eklenecek Kitabın Türünü Belirtiniz.");
        System.out.println("""
                1 - Tarih
                2 - Cizgi Roman         
                3 - Bilim         
                4 - Sanat           
                5 - Roman          """);
        int secim = scanner.nextInt();
        switch (secim) {
            case 1:
                KitapTarih kitapTarih = new KitapTarih(isbn, "Tarih", baslik, yazar, yayinYili, sayfaSayisi, yayinEvi, Durum.ODUNC_ALINABILIR);
                kitaplar.add(kitapTarih);
                System.out.println("Kitap başarılı bir şekilde Tarih Türlerine eklendi");
                break;
            case 2:
                KitapCizgiRoman cizgiRoman = new KitapCizgiRoman(isbn, "Cizgi Roman", baslik, yazar, yayinYili, sayfaSayisi, yayinEvi, Durum.ODUNC_ALINABILIR);
                kitaplar.add(cizgiRoman);
                System.out.println("Kitap başarılı bir şekilde Cizgi Roman Türlerine eklendi");
                break;

            case 3:
                KitapBilim kitapBilim = new KitapBilim(isbn, "Bilim", baslik, yazar, yayinYili, sayfaSayisi, yayinEvi, Durum.ODUNC_ALINABILIR);
                kitaplar.add(kitapBilim);
                System.out.println("Kitap başarılı bir şekilde Bilim Türlerine eklendi");
                break;

            case 4:
                KitapSanat kitapSanat = new KitapSanat(isbn, "Sanat", baslik, yazar, yayinYili, sayfaSayisi, yayinEvi, Durum.ODUNC_ALINABILIR);
                kitaplar.add(kitapSanat);
                System.out.println("Kitap başarılı bir şekilde Sanat Türlerine eklendi");
                break;

            case 5:
                KitapRoman kitapRoman = new KitapRoman(isbn, "Roman", baslik, yazar, yayinYili, sayfaSayisi, yayinEvi, Durum.ODUNC_ALINABILIR);
                kitaplar.add(kitapRoman);
                System.out.println("Kitap başarılı bir şekilde Roman Türlerine eklendi");
                break;
            default:
                System.out.println("Hatalı bir seçim oldu.");
                break;

        }

    }

    public void tumKitaplariListele() {
        System.out.println("Kütüphanedeki Kitaplar:");
        for (Kitap kitap : kitaplar) {
            System.out.println(" Kitap Türü: " + kitap.getKitapTur() + " --> ISBN: " + kitap.getISBN() + ", Başlık: " + kitap.getBaslik() + ", Yazar: " + kitap.getYazarAdi() + ", Yayın Yılı: " + kitap.getYayinYili() + ", Durum: " + kitap.getDurum());

        }
    }

    public void kitapMevcutDurumGuncelle() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Kitap ISBN: ");
        int isbn = scanner.nextInt();
        for (Kitap kitap : kitaplar) {
            if (kitap.getISBN() == isbn) {
                kitap.setDurum(Durum.MEVCUT_DEGIL);
                System.out.println(kitap.getBaslik()+" adlı kitabın durumu başarıyla " + kitap.getDurum() + " olarak güncellendi.");
                return;
            }
        }

        System.out.println("Girdiğiniz ISBN numarasına sahip bir kitap bulunamadı.");
    }

    public void kitapOduncAl() {
        Scanner scanner = new Scanner(System.in);

        try {
            // Üye ID'sini al
            System.out.print("Üye ID: ");
            String uyeId = scanner.nextLine();

            // Kitap ISBN numarasını al
            System.out.print("Kitap ISBN: ");
            String isbnInput = scanner.nextLine();

            // Girdileri kontrol et ve integer'a dönüştür
            int isbn = Integer.parseInt(isbnInput);

            // Üye ve kitabı bul
            Uye uye = null;
            Kitap kitap = null;
            boolean uyeBulundu = false;
            boolean kitapBulundu = false;

            // Üye arama
            for (Uye uyeIds : uyeler) {
                if (uyeIds.getUyeId().equals(uyeId)) {
                    uye = uyeIds;
                    uyeBulundu = true;
                    break;
                }
            }

            if (!uyeBulundu) {
                System.out.println("Böyle bir üye bulunamadığı için kitap kiralanamaz.");
                return;
            }

            for (Kitap kitapIsnb : kitaplar) {
                if (kitapIsnb.getISBN() == isbn) {
                    kitap = kitapIsnb;
                    kitapBulundu = true;
                    break;
                }
            }

            if (!kitapBulundu) {
                System.out.println("Böyle bir kitap bulunamadığı için kitap kiralanamaz.");
                return;
            }

            // Kitabın durumunu kontrol et (Odunc_Alinabilir olma durumunu) ve ödünç al kısmı
            if (kitap.getDurum().equals(Durum.ODUNC_ALINABILIR)) {
                uye.kitapOduncAl(kitap);
                kitap.setDurum(Durum.ODUNCTE);
                System.out.println(kitap.getBaslik() + " adlı kitap " + uye.getUyeAd() + " " + uye.getUyeSoyad() + " adlı ve " + uye.getUyeId() + " numaralı üyeye ödünç verildi.");

            } else {
                System.out.println("Kitap ödünç alınamıyor. Kitap Durumu: " + kitap.getDurum());
            }
        } catch (NumberFormatException e) {
            System.out.println("Geçersiz giriş. Lütfen geçerli bir tamsayı girin.");
        } catch (Exception e) {
            System.out.println("Beklenmeyen bir hata oldu");
            throw new RuntimeException(e);
        }
    }

    public void kitapIadeEt() {
        Scanner scanner = new Scanner(System.in);
        // Üye ID'sini al
        System.out.print("Üye ID: ");
        String uyeId = scanner.nextLine();

        // Kitap ISBN numarasını al
        System.out.print("Kitap ISBN: ");
        String isbnInput = scanner.nextLine();

        // Girdileri kontrol et ve dönüştür
        int isbn = Integer.parseInt(isbnInput);

        // Üye ve kitabı bul
        Uye uye = null;
        Kitap kitap = null;
        boolean uyeBulundu = false;
        boolean kitapBulundu = false;

        // Üye arama
        for (Uye uyeIds : uyeler) {
            if (uyeIds.getUyeId().equals(uyeId)) {
                uye = uyeIds;
                uyeBulundu = true;
                break;
            }
        }

        if (!uyeBulundu) {
            System.out.println("Böyle bir üye bulunamadığı için kitap iade edilemez.");
            return;
        }

        // Kitap arama
        for (Kitap kitapIsnb : kitaplar) {
            if (kitapIsnb.getISBN() == isbn) {
                kitap = kitapIsnb;
                kitapBulundu = true;
                break;
            }
        }

        if (!kitapBulundu) {
            System.out.println("Böyle bir kitap bulunamadığı için kitap iade edilemez.");
            return;
        }

        if (uye.getOdunAlinanKitaplarListesi() == null || !uye.getOdunAlinanKitaplarListesi().contains(kitap)) {
            System.out.println(kitap.getBaslik() + " Adlı bu kitap bu üyede mevcut değil.");
            return;
        }

        kitap.setDurum(Durum.ODUNC_ALINABILIR);
        uye.kitapIadeEt(kitap);
        System.out.println(kitap.getBaslik() + " adlı kitap iade edildi.");
    }


    public void kitapDurumunuGoruntule() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Kitap ISBN: ");
        int isbn = scanner.nextInt();

        for (Kitap kitap : kitaplar) {
            if (kitap.getISBN() == isbn) {
                System.out.println("Kitap Durumu: " + kitap.getDurum());
                return;
            }
        }

        // Eğer kitap bulunamazsa:
        System.out.println("Girdiğiniz ISBN numarasına sahip bir kitap bulunamadı.");
    }

    public void kitapBul() {
        Scanner scanner = new Scanner(System.in);
        try {
            int isbn = scanner.nextInt();
            System.out.print("Bulmak istediğiniz kitabın ISBN bilgisini giriniz: ");
            for (Kitap kitapBilgileri : kitaplar) {
                if (kitapBilgileri.getISBN() == isbn) {
                    System.out.println(" Aradığınız Kitap Bilgileri: " +
                            "ISBN: " + kitapBilgileri.getISBN() +
                            "Kitap Adı: " + kitapBilgileri.getBaslik() +
                            "Kitap Yazarı: " + kitapBilgileri.getYazarAdi() +
                            "Kitap Türü: " + kitapBilgileri.getKitapTur() +
                            "Kitap Durumu: " + kitapBilgileri.getDurum()
                    );

                }
            }
        } catch (Exception e) {
            System.out.println("Böyle bir kitap bulunamadı.");
            throw new RuntimeException(e);
        }
    }

}