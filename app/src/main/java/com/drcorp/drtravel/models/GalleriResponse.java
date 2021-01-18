package com.drcorp.drtravel.models;

import java.util.List;

public class GalleriResponse {
    private boolean error;
    private List<ViewModelGaleri> galleri;

    public GalleriResponse(boolean error, List<ViewModelGaleri> galleri) {
        this.error = error;
        this.galleri = galleri;
    }

    public boolean isError() {
        return error;
    }

    public List<ViewModelGaleri> getGalleri() {
        return galleri;
    }
}
