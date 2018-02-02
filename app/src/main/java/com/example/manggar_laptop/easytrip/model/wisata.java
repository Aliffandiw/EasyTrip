package com.example.manggar_laptop.easytrip.model;

/**
 * Created by MANGGAR-LAPTOP on 1/14/2018.
 */

public class wisata {
    String id_wisata,nama_wisata,tiket,lokasi;
    public wisata() {
    }

    public wisata(String id_wisata, String nama_wisata, String tiket, String lokasi) {
        this.id_wisata = id_wisata;
        this.nama_wisata = nama_wisata;
        this.tiket = tiket;
        this.lokasi = lokasi;
}

    public String getId_wisata() {
        return id_wisata;
    }

    public void setId_wisata(String id_wisata) {
        this.id_wisata = id_wisata;
    }

    public String getNama_wisata() {return nama_wisata;}

    public void setNama_wisata(String nama_wisata) {
        this.nama_wisata = nama_wisata;
    }

    public String getTiket() {
        return tiket;
    }

    public void setTiket(String tiket) {
        this.tiket = tiket;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }


}
