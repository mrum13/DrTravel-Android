package com.inreadyworkgroup.drtravel_beta.models;

import java.util.List;

public class GalleriResponsePenginapan {
    private boolean error;
    private List<ViewModelGalleriPenginapan> galleri;

    public GalleriResponsePenginapan(boolean error, List<ViewModelGalleriPenginapan> galleri) {
        this.error = error;
        this.galleri = galleri;
    }

    public boolean isError() {
        return error;
    }

    public List<ViewModelGalleriPenginapan> getGalleri() {
        return galleri;
    }
}
