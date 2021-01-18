package com.drcorp.drtravel.models;

import java.util.List;

public class MasjidResponseBawah {
    private boolean error;
    private List<ViewModelMenuBawah> masjid;

    public MasjidResponseBawah(boolean error, List<ViewModelMenuBawah> masjid) {
        this.error = error;
        this.masjid = masjid;
    }

    public boolean isError() {
        return error;
    }

    public List<ViewModelMenuBawah> getMasjid() {
        return masjid;
    }
}
