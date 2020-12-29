package com.inreadyworkgroup.drtravel_beta.ui.detailwisata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.inreadyworkgroup.drtravel_beta.R;
import com.inreadyworkgroup.drtravel_beta.ui.home.ViewModelWisata;
import com.inreadyworkgroup.drtravel_beta.ui.home.cardmenu.adaptermenu.AdapterMenuAtas;
import com.inreadyworkgroup.drtravel_beta.ui.home.cardmenu.datamenu.DataMenuAtas;
import com.inreadyworkgroup.drtravel_beta.ui.home.cardmenu.datamenu.Datamenubawah;

import java.util.ArrayList;

public class DetailWisataActivity extends AppCompatActivity {
    ImageView btnBack,imgDetailAtas;
    TextView tvJudulDetail,tvAsalDetail,tvIsiDetail,tvToolbar;
    RecyclerView rvGalleri;
    private ArrayList<ViewModelGaleri> listData = new ArrayList<ViewModelGaleri>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_wisata);

        btnBack = findViewById(R.id.btn_back);
        imgDetailAtas = findViewById(R.id.img_detail_wisata);
        tvJudulDetail = findViewById(R.id.tv_judul_detail_wisata);
        tvAsalDetail = findViewById(R.id.tv_subjudul_detail_wisata);
        tvIsiDetail = findViewById(R.id.tv_isi_detail_wisata);
        tvToolbar = findViewById(R.id.tv_kembali);

        rvGalleri = findViewById(R.id.rv_galeri_wisata_detail);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        getIncomingIntent();

        rvGalleri.setHasFixedSize(true);

        rvGalleri.setLayoutManager(new GridLayoutManager(this, 3));
        AdapterGaleri adapterGaleri = new AdapterGaleri(this, listData);
        rvGalleri.setAdapter(adapterGaleri);
    }

    private void getIncomingIntent(){
        if(getIntent().hasExtra("JudulFoodMasjid") && getIntent().hasExtra("GambarFoodMasjid") && getIntent().hasExtra("AsalFoodMasjid") && getIntent().hasExtra("DetailFoodMasjid") && getIntent().hasExtra("toolbar")) {
            String judul_detail = getIntent().getStringExtra("JudulFoodMasjid");
            String asal_detail = getIntent().getStringExtra("AsalFoodMasjid");
            String detail = getIntent().getStringExtra("DetailFoodMasjid");
            String kategori = getIntent().getStringExtra("toolbar");
            int image_detail = getIntent().getIntExtra("GambarFoodMasjid", 0);

            setDetail(judul_detail, image_detail, asal_detail, detail, kategori);
        }
    }

    private void setDetail(String judul_detail, int image_detail, String asal_detail, String isi_detail, String kategori){
        tvJudulDetail.setText(judul_detail);
        tvAsalDetail.setText(asal_detail);
        tvIsiDetail.setText(isi_detail);
        tvToolbar.setText(kategori);

        if (judul_detail.equals("Pantai Losari")){
            listData.addAll(DataGaleri.getListDataGaleriPanlos());
        }
        else if (judul_detail.equals("Benteng Rotterdam")){
            listData.addAll(DataGaleri.getListDataGaleriBenteng());
        }
        else if (judul_detail.equals("Paduppa Resort")){
            listData.addAll(DataGaleri.getListDataGaleriPaduppa());
        }
        else if (judul_detail.equals("Permata Indah")){
            listData.addAll(DataGaleri.getListDataGaleriPermata());
        }
        if (judul_detail.equals("Pondok Lembah Biru")){
            listData.addAll(DataGaleri.getListDataGaleriPondok());
        }
        else if (judul_detail.equals("Hotel Pantai Gapura")){
            listData.addAll(DataGaleri.getListDataGaleriGapura());
        }

        Glide.with(this)
                .asBitmap()
                .load(image_detail)
                .into(imgDetailAtas);
    }
}