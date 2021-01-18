package com.drcorp.drtravel.models;

import java.util.List;

public class KulinerResponseAtas {
    private boolean error;
    private List<ViewModelMenuAtas> kuliner;

    public KulinerResponseAtas(boolean error, List<ViewModelMenuAtas> kuliner) {
        this.error = error;
        this.kuliner = kuliner;
    }

    public boolean isError() {
        return error;
    }

    public List<ViewModelMenuAtas> getKuliner() {
        return kuliner;
    }
}
