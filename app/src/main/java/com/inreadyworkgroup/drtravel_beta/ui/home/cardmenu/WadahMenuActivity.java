package com.inreadyworkgroup.drtravel_beta.ui.home.cardmenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.inreadyworkgroup.drtravel_beta.R;
import com.inreadyworkgroup.drtravel_beta.api.RetrofitClient;
import com.inreadyworkgroup.drtravel_beta.models.KulinerResponseAtas;
import com.inreadyworkgroup.drtravel_beta.models.KulinerResponseBawah;
import com.inreadyworkgroup.drtravel_beta.models.MasjidResponseAtas;
import com.inreadyworkgroup.drtravel_beta.models.MasjidResponseBawah;
import com.inreadyworkgroup.drtravel_beta.models.PenginapanResponseBawah;
import com.inreadyworkgroup.drtravel_beta.models.PenginapanResponseAtas;
import com.inreadyworkgroup.drtravel_beta.ui.home.cardmenu.adaptermenu.AdapterMenuAtas;
import com.inreadyworkgroup.drtravel_beta.ui.home.cardmenu.adaptermenu.AdapterMenuBawah;
import com.inreadyworkgroup.drtravel_beta.models.ViewModelMenuAtas;
import com.inreadyworkgroup.drtravel_beta.models.ViewModelMenuBawah;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WadahMenuActivity extends AppCompatActivity {
    private RecyclerView rvMenuAtas,rvMenuBawah;
    private List<ViewModelMenuAtas> list;
    private List<ViewModelMenuBawah> listBawah;
    private String title = "Judul";
    private String tvAtas, tvBawah,datalist,kategori;
    private AdapterMenuAtas adapterMenuAtas;
    private AdapterMenuBawah adapterMenuBawah;
    private TextView tvToolbar,tvMenuAtas,tvMenuBawah;
    ImageView btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        if(getIntent().hasExtra("judultoolbar") && getIntent().hasExtra("tvAtas") && getIntent().hasExtra("tvBawah") && getIntent().hasExtra("data")){
            title = getIntent().getStringExtra("judultoolbar");
            tvAtas = getIntent().getStringExtra("tvAtas");
            tvBawah = getIntent().getStringExtra("tvBawah");
            datalist = getIntent().getStringExtra("data");
        }

        tvToolbar = findViewById(R.id.tv_kembali);
        tvMenuAtas = findViewById(R.id.tv_menu_atas);
        tvMenuBawah = findViewById(R.id.tv_menu_bawah);
        btnBack = findViewById(R.id.btn_back);
        tvToolbar.setText(title);
        tvMenuAtas.setText(tvAtas);
        tvMenuBawah.setText(tvBawah);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        rvMenuAtas = findViewById(R.id.rv_menu_atas);
        rvMenuAtas.setHasFixedSize(true);
        rvMenuAtas.setLayoutManager(new LinearLayoutManager(WadahMenuActivity.this,LinearLayoutManager.HORIZONTAL,false));

        rvMenuBawah = findViewById(R.id.rv_menu_bawah);
        rvMenuBawah.setHasFixedSize(true);

        if (datalist.equals("Kuliner")){
            kategori = "Kuliner";
            favKuliner();
            semuaKuliner();
        }
        else if (datalist.equals("Penginapan")){
            kategori = "Penginapan";
            favPenginapan();
            semuaPenginapan();
        }
        else if (datalist.equals("Masjid")){
            kategori = "Masjid";
            favMasjid();
            semuaMasjid();
        }
    }

    private void setAdapterAtas(){
        rvMenuAtas.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        adapterMenuAtas = new AdapterMenuAtas(list, kategori);
        rvMenuAtas.setAdapter(adapterMenuAtas);
    }

    private void setAdapterBawah(){
        rvMenuBawah.setLayoutManager(new GridLayoutManager(this,2));
        adapterMenuBawah = new AdapterMenuBawah(listBawah, kategori);
        rvMenuBawah.setAdapter(adapterMenuBawah);
    }

    private void semuaKuliner(){
        Call<KulinerResponseBawah> call = RetrofitClient.getInstance().getApi().getAllKuliner();
        call.enqueue(new Callback<KulinerResponseBawah>() {
            @Override
            public void onResponse(Call<KulinerResponseBawah> call, Response<KulinerResponseBawah> response) {
                listBawah = response.body().getKuliner();
                setAdapterBawah();
            }

            @Override
            public void onFailure(Call<KulinerResponseBawah> call, Throwable t) {
            }
        });
    }

    private void favKuliner(){
        Call<KulinerResponseAtas> call = RetrofitClient.getInstance().getApi().getPopulerKuliner();
        call.enqueue(new Callback<KulinerResponseAtas>() {
            @Override
            public void onResponse(Call<KulinerResponseAtas> call, Response<KulinerResponseAtas> response) {
                list = response.body().getKuliner();
                setAdapterAtas();
            }

            @Override
            public void onFailure(Call<KulinerResponseAtas> call, Throwable t) {
            }
        });
    }

    private void semuaPenginapan(){
        Call<PenginapanResponseBawah> call = RetrofitClient.getInstance().getApi().getAllPenginapan();
        call.enqueue(new Callback<PenginapanResponseBawah>() {
            @Override
            public void onResponse(Call<PenginapanResponseBawah> call, Response<PenginapanResponseBawah> response) {
                listBawah = response.body().getPenginapan();
                setAdapterBawah();
            }

            @Override
            public void onFailure(Call<PenginapanResponseBawah> call, Throwable t) {
            }
        });
    }

    private void favPenginapan(){
        Call<PenginapanResponseAtas> call = RetrofitClient.getInstance().getApi().getPopulerPenginapan();
        call.enqueue(new Callback<PenginapanResponseAtas>() {
            @Override
            public void onResponse(Call<PenginapanResponseAtas> call, Response<PenginapanResponseAtas> response) {
                list = response.body().getPenginapan();
                setAdapterAtas();
            }

            @Override
            public void onFailure(Call<PenginapanResponseAtas> call, Throwable t) {
            }
        });
    }

    private void semuaMasjid(){
        Call<MasjidResponseBawah> call = RetrofitClient.getInstance().getApi().getAllMasjid();
        call.enqueue(new Callback<MasjidResponseBawah>() {
            @Override
            public void onResponse(Call<MasjidResponseBawah> call, Response<MasjidResponseBawah> response) {
                listBawah = response.body().getMasjid();
                setAdapterBawah();
            }

            @Override
            public void onFailure(Call<MasjidResponseBawah> call, Throwable t) {
            }
        });
    }

    private void favMasjid(){
        Call<MasjidResponseAtas> call = RetrofitClient.getInstance().getApi().getPopulerMasjid();
        call.enqueue(new Callback<MasjidResponseAtas>() {
            @Override
            public void onResponse(Call<MasjidResponseAtas> call, Response<MasjidResponseAtas> response) {
                list = response.body().getMasjid();
                setAdapterAtas();
            }

            @Override
            public void onFailure(Call<MasjidResponseAtas> call, Throwable t) {
            }
        });
    }
}