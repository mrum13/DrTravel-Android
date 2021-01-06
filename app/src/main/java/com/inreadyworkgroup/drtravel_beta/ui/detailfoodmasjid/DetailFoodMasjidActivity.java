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
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.inreadyworkgroup.drtravel_beta.R;
import com.inreadyworkgroup.drtravel_beta.api.RetrofitClient;
import com.inreadyworkgroup.drtravel_beta.models.KulinerResponseAtas;
import com.inreadyworkgroup.drtravel_beta.models.KulinerResponseBawah;
import com.inreadyworkgroup.drtravel_beta.models.MasjidResponseBawah;
import com.inreadyworkgroup.drtravel_beta.models.PenginapanResponseBawah;
import com.inreadyworkgroup.drtravel_beta.models.ViewModelMenuAtas;
import com.inreadyworkgroup.drtravel_beta.models.ViewModelMenuBawah;
import com.inreadyworkgroup.drtravel_beta.models.Wisata;
import com.inreadyworkgroup.drtravel_beta.models.WisataResponse;
import com.inreadyworkgroup.drtravel_beta.ui.detailwisata.DetailWisataActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailFoodMasjidActivity extends AppCompatActivity {
    private ImageView gambarDetail,kembali;
    private TextView tvJudulDetail,tvAsalDetail,tvDetail,toolbarTa;
    private String aksesMaps;
    private Button btn_cari;
    private String judul_detail;
    private String kategori;
    private ViewModelMenuBawah[] detailFoodMasjid;
    private List<ViewModelMenuBawah> listFoodMasjid;
    private ViewModelMenuAtas[] detailFoodMasjidFav;
    private List<ViewModelMenuAtas> listFoodMasjidFav;

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
        if(getIntent().hasExtra("JudulFoodMasjid") && getIntent().hasExtra("toolbar")) {
            judul_detail = getIntent().getStringExtra("JudulFoodMasjid");
            kategori = getIntent().getStringExtra("toolbar");

            setDetail(judul_detail,kategori);
        }
    }

    private void setDetail(String judul_detailfoodmasjid, String kategori) {
        tvJudulDetail.setText(judul_detailfoodmasjid);
        toolbarTa.setText(kategori);

        aksesMaps = judul_detail;

        if (kategori.equals("Kuliner")) {
            btn_cari.setText("Cari Makanan");
            dataFoodBawah();
        } else if (kategori.equals("Masjid")) {
            btn_cari.setText("Lokasi Masjid");
            dataMasjidBawah();
        }

        btn_cari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + aksesMaps);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });
    }

    //detail food bawah
    private void dataFoodBawah(){
        Call<KulinerResponseBawah> call = RetrofitClient.getInstance().getApi().detailKulinerBawah(judul_detail);
        call.enqueue(new Callback<KulinerResponseBawah>() {
            @Override
            public void onResponse(Call<KulinerResponseBawah> call, Response<KulinerResponseBawah> response) {
                KulinerResponseBawah kulinerResponseBawah =response.body();
                if (!kulinerResponseBawah.isError()){
                    listFoodMasjid = response.body().getKuliner();
                    detailFoodMasjid = listFoodMasjid.toArray(new ViewModelMenuBawah[0]);
                    tvJudulDetail.setText(detailFoodMasjid[0].getTvMenuBawah());
                    tvAsalDetail.setText(detailFoodMasjid[0].getAsalMenuBawah());
                    tvDetail.setText(detailFoodMasjid[0].getDetailMenuBawah());
                    RequestOptions options = new RequestOptions()
                            .centerCrop()
                            .placeholder(R.mipmap.ic_launcher_round)
                            .error(R.mipmap.ic_launcher_round);
//                    shimmerDetail.stopShimmer();
//                    viewDetail.setVisibility(View.GONE);
                    Glide.with(DetailFoodMasjidActivity.this).load(detailFoodMasjid[0].getGambarMenuBawah()).apply(options).into(gambarDetail);

                }
                else {
                    Toast.makeText(DetailFoodMasjidActivity.this, "Data tidak ditemukan",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<KulinerResponseBawah> call, Throwable t) {
            }
        });
    }

    //detail masjid bawah
    private void dataMasjidBawah(){
        Call<MasjidResponseBawah> call = RetrofitClient.getInstance().getApi().detailMasjidBawah(judul_detail);
        call.enqueue(new Callback<MasjidResponseBawah>() {
            @Override
            public void onResponse(Call<MasjidResponseBawah> call, Response<MasjidResponseBawah> response) {
                MasjidResponseBawah masjidResponseBawah =response.body();
                if (!masjidResponseBawah.isError()){
                    listFoodMasjid = response.body().getMasjid();
                    detailFoodMasjid = listFoodMasjid.toArray(new ViewModelMenuBawah[0]);
                    tvJudulDetail.setText(detailFoodMasjid[0].getTvMenuBawah());
                    tvAsalDetail.setText(detailFoodMasjid[0].getAsalMenuBawah());
                    tvDetail.setText(detailFoodMasjid[0].getDetailMenuBawah());
                    RequestOptions options = new RequestOptions()
                            .centerCrop()
                            .placeholder(R.mipmap.ic_launcher_round)
                            .error(R.mipmap.ic_launcher_round);
//                    shimmerDetail.stopShimmer();
//                    viewDetail.setVisibility(View.GONE);
                    Glide.with(DetailFoodMasjidActivity.this).load(detailFoodMasjid[0].getGambarMenuBawah()).apply(options).into(gambarDetail);

                }
                else {
                    Toast.makeText(DetailFoodMasjidActivity.this, "Data tidak ditemukan",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<MasjidResponseBawah> call, Throwable t) {
            }
        });
    }

    //datafoodAtas
//    private void dataFoodAtas(){
//        Call<KulinerResponseAtas> call = RetrofitClient.getInstance().getApi().detailKulinerAtas(judul_detail);
//        call.enqueue(new Callback<KulinerResponseAtas>() {
//            @Override
//            public void onResponse(Call<KulinerResponseAtas> call, Response<KulinerResponseAtas> response) {
//                KulinerResponseAtas kulinerResponseAtas =response.body();
//                if (!kulinerResponseAtas.isError()){
//                    listFoodMasjidFav = response.body().getKuliner();
//                    detailFoodMasjidFav = listFoodMasjidFav.toArray(new ViewModelMenuAtas[0]);
//                    tvJudulDetail.setText(detailFoodMasjidFav[0].getTvMenuAtas());
//                    tvAsalDetail.setText(detailFoodMasjidFav[0].getAsalMenuAtas());
//                    tvDetail.setText(detailFoodMasjidFav[0].getDetailMenuAtas());
//                    RequestOptions options = new RequestOptions()
//                            .centerCrop()
//                            .placeholder(R.mipmap.ic_launcher_round)
//                            .error(R.mipmap.ic_launcher_round);
////                    shimmerDetail.stopShimmer();
////                    viewDetail.setVisibility(View.GONE);
//                    Glide.with(DetailFoodMasjidActivity.this).load(detailFoodMasjidFav[0].getGambarMenuAtas()).apply(options).into(gambarDetail);
//
//                }
//                else {
//                    Toast.makeText(DetailFoodMasjidActivity.this, "Data tidak ditemukan",Toast.LENGTH_LONG).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<KulinerResponseAtas> call, Throwable t) {
//            }
//        });
//    }
}