package com.inreadyworkgroup.drtravel_beta.ui.detailwisata;

import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.inreadyworkgroup.drtravel_beta.R;

public class DetailGaleri extends AppCompatActivity {
    ImageView imgGallery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_galeri);

        imgGallery = findViewById(R.id.img_galleri);
    }
}