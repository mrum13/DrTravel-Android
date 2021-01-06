package com.inreadyworkgroup.drtravel_beta.models;

public class ViewModelMenuBawah {
    private String tvMenuBawah,asalMenuBawah,detailMenuBawah,gambarMenuBawah;

    public ViewModelMenuBawah(String tvMenuBawah, String asalMenuBawah, String detailMenuBawah, String gambarMenuBawah) {
        this.tvMenuBawah = tvMenuBawah;
        this.asalMenuBawah = asalMenuBawah;
        this.detailMenuBawah = detailMenuBawah;
        this.gambarMenuBawah = gambarMenuBawah;
    }

    public String getTvMenuBawah() {
        return tvMenuBawah;
    }

    public String getAsalMenuBawah() {
        return asalMenuBawah;
    }

    public String getDetailMenuBawah() {
        return detailMenuBawah;
    }

    public String getGambarMenuBawah() {
        return gambarMenuBawah;
    }
}
