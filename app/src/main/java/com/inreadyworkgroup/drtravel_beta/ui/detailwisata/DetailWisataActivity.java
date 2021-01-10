package com.inreadyworkgroup.drtravel_beta.ui.detailwisata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.inreadyworkgroup.drtravel_beta.R;
import com.inreadyworkgroup.drtravel_beta.api.RetrofitClient;
import com.inreadyworkgroup.drtravel_beta.models.GalleriResponse;
import com.inreadyworkgroup.drtravel_beta.models.GalleriResponsePenginapan;
import com.inreadyworkgroup.drtravel_beta.models.PenginapanResponseBawah;
import com.inreadyworkgroup.drtravel_beta.models.ViewModelGaleri;
import com.inreadyworkgroup.drtravel_beta.models.ViewModelGalleriPenginapan;
import com.inreadyworkgroup.drtravel_beta.models.ViewModelMenuBawah;
import com.inreadyworkgroup.drtravel_beta.models.Wisata;
import com.inreadyworkgroup.drtravel_beta.models.WisataResponse;

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
    private ViewModelMenuBawah[] detailPenginapan;
    private List<ViewModelMenuBawah> listPenginapan;
    private ViewModelGaleri[] detailGalleri;
    private List<ViewModelGaleri> listGalleri;
    private List<ViewModelGalleriPenginapan> listGalleriPenginapan;
    private String wisata;
    ShimmerFrameLayout shimmerDetail;
    View viewDetail;
    AdapterGaleri adapterGaleri;

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
        viewDetail=(View)findViewById(R.id.view_detail);

        shimmerDetail= (ShimmerFrameLayout)findViewById(R.id.shimmer_detail);
        shimmerDetail.startShimmer(); //start Shimmer animation of shimmer

        rvGalleri = findViewById(R.id.rv_galeri_wisata_detail);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        getIncomingIntent();

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
//        tvJudulDetail.setText(nama_wisata);

        if (kategori.equals("Penginapan")) {
            dataPenginapanBawah();
            galleriPenginapan();
        } else  {
            dataWisata();
            galleriWisata();
        }
    }

    private void dataWisata(){
        Call<WisataResponse> call = RetrofitClient.getInstance().getApi().detailWisata(wisata);
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
                    shimmerDetail.stopShimmer();
                    viewDetail.setVisibility(View.GONE);
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

    private void dataPenginapanBawah(){
        Call<PenginapanResponseBawah> call = RetrofitClient.getInstance().getApi().detailPenginapanBawah(wisata);
        call.enqueue(new Callback<PenginapanResponseBawah>() {
            @Override
            public void onResponse(Call<PenginapanResponseBawah> call, Response<PenginapanResponseBawah> response) {
                PenginapanResponseBawah penginapanResponseBawah =response.body();
                if (!penginapanResponseBawah.isError()){
                    listPenginapan = response.body().getPenginapan();
                    detailPenginapan = listPenginapan.toArray(new ViewModelMenuBawah[0]);
                    tvJudulDetail.setText(detailPenginapan[0].getTvMenuBawah());
                    tvAsalDetail.setText(detailPenginapan[0].getAsalMenuBawah());
                    tvIsiDetail.setText(detailPenginapan[0].getDetailMenuBawah());
                    RequestOptions options = new RequestOptions()
                            .centerCrop()
                            .placeholder(R.mipmap.ic_launcher_round)
                            .error(R.mipmap.ic_launcher_round);
                    shimmerDetail.stopShimmer();
                    viewDetail.setVisibility(View.GONE);
                    Glide.with(DetailWisataActivity.this).load(detailPenginapan[0].getGambarMenuBawah()).apply(options).into(imgDetailAtas);

                }
                else {
                    Toast.makeText(DetailWisataActivity.this, "Data tidak ditemukan", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<PenginapanResponseBawah> call, Throwable t) {

            }
        });
    }

    private void galleriWisata(){
        Call<GalleriResponse> call = RetrofitClient.getInstance().getApi().galleriWisata(wisata);
        call.enqueue(new Callback<GalleriResponse>() {
            @Override
            public void onResponse(Call<GalleriResponse> call, Response<GalleriResponse> response) {
                GalleriResponse galleriResponse =response.body();

                if (!galleriResponse.isError()){
                    listGalleri = response.body().getGalleri();
                    if (!listWisata.isEmpty()){
//                        AdapterWisata adapter = new AdapterWisata(PencarianActivity.this, listWisataResult);
//                            shimmerPencarian.stopShimmer();
//                            viewPencarian.setVisibility(View.GONE);
//                        rvResultWisata.setAdapter(adapter);
                        showGalleri();
                    }
                    else {
                        Toast.makeText(DetailWisataActivity.this, "Data tidak ditemukan",Toast.LENGTH_LONG).show();
                    }
                }
                else {
                    Toast.makeText(DetailWisataActivity.this, "Data tidak ditemukan",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<GalleriResponse> call, Throwable t) {

            }
        });
    }

    private void galleriPenginapan(){
        Call<GalleriResponse> call = RetrofitClient.getInstance().getApi().galleriPenginapan(wisata);
        call.enqueue(new Callback<GalleriResponse>() {
            @Override
            public void onResponse(Call<GalleriResponse> call, Response<GalleriResponse> response) {
                GalleriResponse galleriResponse =response.body();
                if (!galleriResponse.isError()){
                    listGalleri = response.body().getGalleri();
                    if (!listGalleri.isEmpty()){
//                        AdapterWisata adapter = new AdapterWisata(PencarianActivity.this, listWisataResult);
//                            shimmerPencarian.stopShimmer();
//                            viewPencarian.setVisibility(View.GONE);
//                        rvResultWisata.setAdapter(adapter);
                        showGalleri();
                    }
                    else {
                        Toast.makeText(DetailWisataActivity.this, "Data tidak ditemukan",Toast.LENGTH_LONG).show();
                    }
                }
                else {
                    Toast.makeText(DetailWisataActivity.this, "Data tidak ditemukan",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<GalleriResponse> call, Throwable t) {

            }
        });
    }

    private void showGalleri(){
        rvGalleri.setHasFixedSize(true);
        rvGalleri.setLayoutManager(new GridLayoutManager(this, 3));
        adapterGaleri = new AdapterGaleri(listGalleri);
        rvGalleri.setAdapter(adapterGaleri);
    }
}