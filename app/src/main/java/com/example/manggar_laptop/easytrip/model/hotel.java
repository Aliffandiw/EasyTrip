package com.example.manggar_laptop.easytrip.model;

/**
 * Created by MANGGAR-LAPTOP on 1/14/2018.
 */

public class hotel {
    String id_hotel,nama_hotel,harga,alamat;
    public hotel() {
}
    public hotel(String id_hotel, String nama_hotel, String harga, String alamat) {
        this.id_hotel = id_hotel;
        this.nama_hotel = nama_hotel;
        this.harga = harga;
        this.alamat = alamat;
    }
    public String getId_hotel() {
        return id_hotel;
    }

    public void setId_hotel(String id_hotel) {
        this.id_hotel = id_hotel;
    }

    public String getNama_hotel() {return nama_hotel;}

    public void setNama_hotel(String nama_hotel) {
        this.nama_hotel = nama_hotel;
    }

    public String getharga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }


}
