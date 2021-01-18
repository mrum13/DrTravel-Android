package com.drcorp.drtravel.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.drcorp.drtravel.R;
import com.drcorp.drtravel.api.RetrofitClient;
import com.drcorp.drtravel.models.DefaultResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LupaSandiActivity extends AppCompatActivity {
    private Button btnProses;
    private EditText etEmailLupa;
    private String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lupa_sandi);

        btnProses = findViewById(R.id.btn_proses);
        etEmailLupa = findViewById(R.id.et_email_lupa);

        btnProses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email=etEmailLupa.getText().toString().trim();

                if(email.isEmpty()){
                    etEmailLupa.setError("Email is required");
                    etEmailLupa.requestFocus();
                    return;
                }

                if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    etEmailLupa.setError("Enter a valid email");
                    etEmailLupa.requestFocus();
                    return;
                }

                Call<DefaultResponse> call= RetrofitClient.getInstance().getApi().forgetPass(email);
                call.enqueue(new Callback<DefaultResponse>() {
                    @Override
                    public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                        if(response.code()==201){
                            DefaultResponse dr = response.body();
                            Toast.makeText(LupaSandiActivity.this, "Email sedang diproses",Toast.LENGTH_LONG).show();
                            Intent lanjut = new Intent(LupaSandiActivity.this, LupaSandiActivity2.class);
                            startActivity(lanjut);
                        }
                        else if (response.code()==422){
                            Toast.makeText(LupaSandiActivity.this,"Pengguna tidak ada",Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<DefaultResponse> call, Throwable t) {
                        Toast.makeText(LupaSandiActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}