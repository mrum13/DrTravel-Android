package com.inreadyworkgroup.drtravel_beta.models;

public class Wisata {
    private int status;
    private String nama_tempat, lokasi_tempat, deskripsi,gambar;
    private boolean isChecked;

    public Wisata(int status, String nama_tempat, String lokasi_tempat, String deskripsi, String gambar) {

        this.status = status;
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

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
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
