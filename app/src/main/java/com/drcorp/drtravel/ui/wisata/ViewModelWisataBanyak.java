package com.drcorp.drtravel.ui.wisata;

public class ViewModelWisataBanyak {
    int gambarWisata;
    String judulWisata,asalWisata,detailWisata;

    public int getGambarWisata() {
        return gambarWisata;
    }

    public void setGambarWisata(int gambarWisata) {
        this.gambarWisata = gambarWisata;
    }

    public String getJudulWisata() {
        return judulWisata;
    }

    public void setJudulWisata(String judulWisata) {
        this.judulWisata = judulWisata;
    }

    public String getAsalWisata() {
        return asalWisata;
    }

    public void setAsalWisata(String asalWisata) {
        this.asalWisata = asalWisata;
    }

    public String getDetailWisata() {
        return detailWisata;
    }

    public void setDetailWisata(String detailWisata) {
        this.detailWisata = detailWisata;
    }

    public ViewModelWisataBanyak() {
        this.gambarWisata = gambarWisata;
        this.judulWisata = judulWisata;
        this.asalWisata = asalWisata;
        this.detailWisata = detailWisata;
    }
}
