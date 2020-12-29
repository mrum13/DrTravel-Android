package com.inreadyworkgroup.drtravel_beta.ui.home.pencarian;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.inreadyworkgroup.drtravel_beta.MainActivity;
import com.inreadyworkgroup.drtravel_beta.R;
import com.inreadyworkgroup.drtravel_beta.api.RetrofitClient;
import com.inreadyworkgroup.drtravel_beta.login.LoginActivity;
import com.inreadyworkgroup.drtravel_beta.models.LoginResponse;
import com.inreadyworkgroup.drtravel_beta.models.Wisata;
import com.inreadyworkgroup.drtravel_beta.models.WisataResponse;
import com.inreadyworkgroup.drtravel_beta.storage.SharedPrefManager;
import com.inreadyworkgroup.drtravel_beta.ui.home.AdapterWisata;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PencarianActivity extends AppCompatActivity {
    private RecyclerView rvResultWisata;
    private List<Wisata> listWisataResult;
    private LinearLayoutManager linearLayout;
    private String wisata;
    private EditText et_cari;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pencarian);

        ImageView ic_hapus = findViewById(R.id.clear_text_cari);
        et_cari = findViewById(R.id.et_cari_wisata);

        et_cari.setOnEditorActionListener(editorListener);

        ic_hapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_cari.setText("");
            }
        });

    }

    private TextView.OnEditorActionListener editorListener = new TextView.OnEditorActionListener() {
        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            switch (actionId) {
                case EditorInfo.IME_ACTION_SEND:
                    Toast.makeText(PencarianActivity.this, "Mencari", Toast.LENGTH_SHORT).show();
                    break;
            }

            wisata = et_cari.getText().toString().trim();

            rvResultWisata = (RecyclerView)findViewById(R.id.rv_cari);
            rvResultWisata.setHasFixedSize(true);
            linearLayout = new LinearLayoutManager(PencarianActivity.this);
            rvResultWisata.setLayoutManager(linearLayout);

            Call<WisataResponse> call = RetrofitClient.getInstance().getApi().searchWisata(wisata);
            call.enqueue(new Callback<WisataResponse>() {
                @Override
                public void onResponse(Call<WisataResponse> call, Response<WisataResponse> response) {

                    WisataResponse wisata =response.body();

                    if (!wisata.isError()){
                        listWisataResult = response.body().getWisata();
                        if (!listWisataResult.isEmpty()){
                            AdapterWisata adapter = new AdapterWisata(PencarianActivity.this, listWisataResult);
                            rvResultWisata.setAdapter(adapter);
                        }
                        else {
                            Toast.makeText(PencarianActivity.this, "Data tidak ditemukan",Toast.LENGTH_LONG).show();
                        }


                    }
                    else {
                        Toast.makeText(PencarianActivity.this, "Data tidak ditemukan",Toast.LENGTH_LONG).show();
                    }


                }

                @Override
                public void onFailure(Call<WisataResponse> call, Throwable t) {

                }
            });
            return false;
        }
    };
}