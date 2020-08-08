package com.inreadyworkgroup.drtravel_beta.ui.detailfoodmasjid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.inreadyworkgroup.drtravel_beta.R;

public class DetailFoodMasjidActivity extends AppCompatActivity {
    ImageView gambarDetail,kembali;
    TextView tvJudulDetail,tvAsalDetail,tvDetail,toolbarTa;
    String aksesMaps;
    Button btn_cari;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_food_masjid);

        gambarDetail = findViewById(R.id.img_detail_foodmasjid);
        tvJudulDetail = findViewById(R.id.tv_judul_detail_foodmasjid);
        tvAsalDetail = findViewById(R.id.tv_subjudul_detail_foodmasjid);
        tvDetail = findViewById(R.id.tv_isi_detail_foodmasjid);
        toolbarTa = findViewById(R.id.tv_kembali);
        btn_cari = findViewById(R.id.btn_cari_food_masjid);
        kembali = findViewById(R.id.btn_back);

        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        getIncomingIntent();
    }

    private void getIncomingIntent(){
        if(getIntent().hasExtra("JudulFoodMasjid") && getIntent().hasExtra("GambarFoodMasjid") && getIntent().hasExtra("AsalFoodMasjid") && getIntent().hasExtra("DetailFoodMasjid") && getIntent().hasExtra("toolbar")) {
            String judul_detail = getIntent().getStringExtra("JudulFoodMasjid");
            String asal_detail = getIntent().getStringExtra("AsalFoodMasjid");
            String detail = getIntent().getStringExtra("DetailFoodMasjid");
            String kategori = getIntent().getStringExtra("toolbar");
            int image_detail = getIntent().getIntExtra("GambarFoodMasjid", 1);

            setDetail(judul_detail, image_detail, asal_detail, detail, kategori);
        }
    }

    private void setDetail(String judul_detail, int image_detail, String asal_detail, String isi_detail, String kategori){
        tvJudulDetail.setText(judul_detail);
        tvAsalDetail.setText(asal_detail);
        tvDetail.setText(isi_detail);
        toolbarTa.setText(kategori);

        aksesMaps = judul_detail;

        if (kategori.equals("Kuliner")){
            btn_cari.setText("Cari Makanan");
        }
        else if (kategori.equals("Masjid")){
            btn_cari.setText("Lokasi Masjid");
        }

        btn_cari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri gmmIntentUri = Uri.parse("geo:0,0?q="+aksesMaps);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });



        Glide.with(this)
                .asBitmap()
                .load(image_detail)
                .into(gambarDetail);
    }
}