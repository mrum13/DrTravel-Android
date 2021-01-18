package com.drcorp.drtravel.models;

import java.util.List;

public class WisataResponse {
    private boolean error;
    private List<Wisata> wisata;

    public WisataResponse(boolean error, List<Wisata> wisata) {
        this.error = error;
        this.wisata = wisata;
    }

    public boolean isError() {
        return error;
    }

    public List<Wisata> getWisata() {
        return wisata;
    }
}
