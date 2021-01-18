package com.drcorp.drtravel.models;

public class ViewModelGalleriPenginapan {
    String nama_tempat,gambar;

    public ViewModelGalleriPenginapan(String nama_tempat, String gambar) {
        this.nama_tempat = nama_tempat;
        this.gambar = gambar;
    }

    public String getNama_tempat() {
        return nama_tempat;
    }

    public String getGambar() {
        return gambar;
    }
}
