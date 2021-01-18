package com.drcorp.drtravel.models;

public class ViewModelMenuAtas {
    private String tvMenuAtas,asalMenuAtas,detailMenuAtas,gambarMenuAtas;

    public ViewModelMenuAtas(String tvMenuAtas, String asalMenuAtas, String detailMenuAtas, String gambarMenuAtas) {
        this.tvMenuAtas = tvMenuAtas;
        this.asalMenuAtas = asalMenuAtas;
        this.detailMenuAtas = detailMenuAtas;
        this.gambarMenuAtas = gambarMenuAtas;
    }

    public String getGambarMenuAtas() {
        return gambarMenuAtas;
    }

    public String getTvMenuAtas() {
        return tvMenuAtas;
    }

    public String getAsalMenuAtas() {
        return asalMenuAtas;
    }

    public String getDetailMenuAtas() {
        return detailMenuAtas;
    }
}
