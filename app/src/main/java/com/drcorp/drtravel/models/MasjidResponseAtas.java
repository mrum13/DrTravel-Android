package com.drcorp.drtravel.models;

import java.util.List;

public class MasjidResponseAtas {
    private boolean error;
    private List<ViewModelMenuAtas> masjid;

    public MasjidResponseAtas(boolean error, List<ViewModelMenuAtas> masjid) {
        this.error = error;
        this.masjid = masjid;
    }

    public boolean isError() {
        return error;
    }

    public List<ViewModelMenuAtas> getMasjid() {
        return masjid;
    }
}
