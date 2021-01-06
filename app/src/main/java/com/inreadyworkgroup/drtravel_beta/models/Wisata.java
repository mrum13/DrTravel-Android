package com.inreadyworkgroup.drtravel_beta.models;

public class Wisata {
    private String nama_tempat, lokasi_tempat, deskripsi,gambar;
    private boolean isChecked;

    public Wisata(String nama_tempat, String lokasi_tempat, String deskripsi, String gambar) {

        this.nama_tempat = nama_tempat;
        this.lokasi_tempat = lokasi_tempat;
        this.deskripsi = deskripsi;
        this.gambar = gambar;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public String getNama_tempat() {
        return nama_tempat;
    }

    public String getLokasi_tempat() {
        return lokasi_tempat;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public String getGambar() {
        return gambar;
    }

}
