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
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.inreadyworkgroup.drtravel_beta.R;
import com.inreadyworkgroup.drtravel_beta.api.RetrofitClient;
import com.inreadyworkgroup.drtravel_beta.models.Wisata;
import com.inreadyworkgroup.drtravel_beta.models.WisataResponse;
import com.inreadyworkgroup.drtravel_beta.ui.home.AdapterWisata;
import com.inreadyworkgroup.drtravel_beta.ui.home.ViewModelWisata;
import com.inreadyworkgroup.drtravel_beta.ui.home.cardmenu.adaptermenu.AdapterMenuAtas;
import com.inreadyworkgroup.drtravel_beta.ui.home.cardmenu.datamenu.DataMenuAtas;
import com.inreadyworkgroup.drtravel_beta.ui.home.cardmenu.datamenu.Datamenubawah;
import com.inreadyworkgroup.drtravel_beta.ui.home.pencarian.PencarianActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailWisataActivity extends AppCompatActivity {
    ImageView btnBack,imgDetailAtas;
    TextView tvJudulDetail,tvAsalDetail,tvIsiDetail,tvToolbar;
    RecyclerView rvGalleri;
    private ArrayList<ViewModelGaleri> listData = new ArrayList<ViewModelGaleri>();
    private Wisata[] detailWisata;
    private List<Wisata> listWisata;
    private String wisata;
    private int i;

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
        if(getIntent().hasExtra("JudulFoodMasjid") && getIntent().hasExtra("toolbar")) {
            wisata = getIntent().getStringExtra("JudulFoodMasjid");
            String kategori = getIntent().getStringExtra("toolbar");
//            int image_detail = getIntent().getIntExtra("GambarFoodMasjid", 0);

            setDetail(wisata,kategori);
        }
    }

    private void setDetail(String nama_wisata, String kategori){
        tvToolbar.setText(kategori);

        Call<WisataResponse> call = RetrofitClient.getInstance().getApi().detailWisata(nama_wisata);
        call.enqueue(new Callback<WisataResponse>() {
            @Override
            public void onResponse(Call<WisataResponse> call, Response<WisataResponse> response) {
                WisataResponse wisataResponse =response.body();
                if (!wisataResponse.isError()){
                    listWisata = response.body().getWisata();
                    detailWisata = listWisata.toArray(new Wisata[0]);
                    tvJudulDetail.setText(detailWisata[0].getNama_tempat());
                    tvAsalDetail.setText(detailWisata[0].getLokasi_tempat());
                    tvIsiDetail.setText(detailWisata[0].getDeskripsi());
                    RequestOptions options = new RequestOptions()
                            .centerCrop()
                            .placeholder(R.mipmap.ic_launcher_round)
                            .error(R.mipmap.ic_launcher_round);

                    Glide.with(DetailWisataActivity.this).load(detailWisata[0].getGambar()).apply(options).into(imgDetailAtas);

                }
                else {
                    Toast.makeText(DetailWisataActivity.this, "Data tidak ditemukan",Toast.LENGTH_LONG).show();
                }


            }

            @Override
            public void onFailure(Call<WisataResponse> call, Throwable t) {

            }
        });
    }
}