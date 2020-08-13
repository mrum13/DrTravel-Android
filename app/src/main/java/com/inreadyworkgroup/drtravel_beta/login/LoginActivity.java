package com.inreadyworkgroup.drtravel_beta.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.inreadyworkgroup.drtravel_beta.MainActivity;
import com.inreadyworkgroup.drtravel_beta.R;

import java.nio.channels.InterruptedByTimeoutException;

public class LoginActivity extends AppCompatActivity {
    Button btnMasuk,btnRegis;
    TextView tvLupaPass;
    EditText etEmail,etPass;
    String username,pass;
    Boolean O,P,o,p;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail = findViewById(R.id.et_username);
        etPass = findViewById(R.id.et_pass);
        btnMasuk = findViewById(R.id.btn_masuk);
        btnRegis = findViewById(R.id.btn_regis);
        tvLupaPass = findViewById(R.id.tv_lupa_kata_sandi);

        username = etEmail.getText().toString();
        pass = etPass.getText().toString();

        tvLupaPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent keLupa = new Intent(LoginActivity.this, LupaSandiActivity.class);
                startActivity(keLupa);
            }
        });

        btnMasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent keDashboard = new Intent(LoginActivity.this, MainActivity.class);

                o=(username!=null);
                p=(pass!=null);

                assert username != null;
                O=(username.equals(""));
                assert pass != null;
                P=(pass.equals(""));

                if (O && P){
                    etEmail.setError("Email tidak boleh kosong");
                    etPass.setError("Kata sandi tidak boleh kosong");
                }
                else if (O) {
                    etEmail.setError("Email tidak boleh kosong");
                    etPass.setError(null);
                }
                else if (P){
                    etPass.setError("Kata sandi tidak boleh kosong");
                    etEmail.setError(null);
                }
                else {
                    etEmail.setError(null);
                    etPass.setError(null);
                    startActivity(keDashboard);
                    finish();
                }

                //                startActivity(keDashboard);
//                finish();
            }
        });

        btnRegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent keRegis = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(keRegis);
            }
        });
    }
}