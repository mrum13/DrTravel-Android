package com.drcorp.drtravel.models;

import java.util.List;

public class PenginapanResponseAtas {
    private boolean error;
    private List<ViewModelMenuAtas> penginapan;

    public PenginapanResponseAtas(boolean error, List<ViewModelMenuAtas> penginapan) {
        this.error = error;
        this.penginapan = penginapan;
    }

    public boolean isError() {
        return error;
    }

    public List<ViewModelMenuAtas> getPenginapan() {
        return penginapan;
    }
}
