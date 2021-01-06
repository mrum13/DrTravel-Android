package com.inreadyworkgroup.drtravel_beta.models;

import java.util.List;

public class PenginapanResponseBawah {
    private boolean error;
    private List<ViewModelMenuBawah> penginapan;

    public PenginapanResponseBawah(boolean error, List<ViewModelMenuBawah> penginapan) {
        this.error = error;
        this.penginapan = penginapan;
    }

    public boolean isError() {
        return error;
    }

    public List<ViewModelMenuBawah> getPenginapan() {
        return penginapan;
    }
}
