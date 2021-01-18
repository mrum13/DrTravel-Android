package com.drcorp.drtravel.ui.detailwisata;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.Toast;

import com.drcorp.drtravel.R;
import com.drcorp.drtravel.api.RetrofitClient;
import com.drcorp.drtravel.models.GalleriResponse;
import com.drcorp.drtravel.models.ViewModelGaleri;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailGaleri extends AppCompatActivity {
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;
    private List<ViewModelGaleri> listGalleri;
    private int posisi;
    private String wisata,kategori;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_galeri);

        inisialisasiObjek();

        Intent mIntent = getIntent();
        posisi = mIntent.getIntExtra("position",0);
        wisata = mIntent.getStringExtra("wisata");
        kategori = mIntent.getStringExtra("ktgr");

        if (kategori.equals("Penginapan")){
            galeriPenginapan();
        }
        else {
            galeriWisata();
        }

    }

    private void inisialisasiObjek(){
        viewPager = findViewById(R.id.view_pager);
    }

    private void galeriPenginapan(){
        Call<GalleriResponse> call = RetrofitClient.getInstance().getApi().galleriPenginapan(wisata);
        System.out.println(wisata);
        call.enqueue(new Callback<GalleriResponse>() {
            @Override
            public void onResponse(Call<GalleriResponse> call, Response<GalleriResponse> response) {
                GalleriResponse galleriResponse =response.body();
                if (!galleriResponse.isError()){
                    listGalleri = response.body().getGalleri();
                    if (!listGalleri.isEmpty()){
                        viewPagerAdapter = new ViewPagerAdapter(DetailGaleri.this,listGalleri,posisi);
                        viewPager.setAdapter(viewPagerAdapter);
                        viewPager.setCurrentItem(posisi);
                        viewPager.setPadding(0, 0, 0, 0);
                    }
                    else {
                        Toast.makeText(DetailGaleri.this, "Data kosong",Toast.LENGTH_LONG).show();
                    }
                }
                else {
                    Toast.makeText(DetailGaleri.this, "Nama tempat"+wisata,Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<GalleriResponse> call, Throwable t) {

            }
        });
    }

    private void galeriWisata(){
        Call<GalleriResponse> call = RetrofitClient.getInstance().getApi().galleriWisata(wisata);
        call.enqueue(new Callback<GalleriResponse>() {
            @Override
            public void onResponse(Call<GalleriResponse> call, Response<GalleriResponse> response) {
                GalleriResponse galleriResponse =response.body();
                if (!galleriResponse.isError()){
                    listGalleri = response.body().getGalleri();
                    if (!listGalleri.isEmpty()){
                        viewPagerAdapter = new ViewPagerAdapter(DetailGaleri.this,listGalleri,posisi);
                        viewPager.setAdapter(viewPagerAdapter);
                        viewPager.setCurrentItem(posisi);
                        viewPager.setPadding(0, 0, 0, 0);
                    }
                    else {
                        Toast.makeText(DetailGaleri.this, "Data kosong",Toast.LENGTH_LONG).show();
                    }
                }
                else {
                    Toast.makeText(DetailGaleri.this, "Nama tempat"+wisata,Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<GalleriResponse> call, Throwable t) {

            }
        });
    }
}