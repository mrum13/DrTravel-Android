package com.drcorp.drtravel.models;

import java.util.List;

public class KulinerResponseBawah {
    private boolean error;
    private List<ViewModelMenuBawah> kuliner;

    public KulinerResponseBawah(boolean error, List<ViewModelMenuBawah> kuliner) {
        this.error = error;
        this.kuliner = kuliner;
    }

    public boolean isError() {
        return error;
    }

    public List<ViewModelMenuBawah> getKuliner() {
        return kuliner;
    }
}
