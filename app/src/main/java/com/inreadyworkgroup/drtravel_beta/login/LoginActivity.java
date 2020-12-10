package com.inreadyworkgroup.drtravel_beta.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.inreadyworkgroup.drtravel_beta.MainActivity;
import com.inreadyworkgroup.drtravel_beta.R;
import com.inreadyworkgroup.drtravel_beta.api.RetrofitClient;
import com.inreadyworkgroup.drtravel_beta.models.LoginResponse;
import com.inreadyworkgroup.drtravel_beta.storage.SharedPrefManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tvLupaPass;
    private EditText etEmail,etPass;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail = findViewById(R.id.et_username);
        etPass = findViewById(R.id.et_pass);
        tvLupaPass = findViewById(R.id.tv_lupa_kata_sandi);

        tvLupaPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent keLupa = new Intent(LoginActivity.this, LupaSandiActivity.class);
                startActivity(keLupa);
            }
        });

        findViewById(R.id.btn_masuk).setOnClickListener(this);
        findViewById(R.id.btn_regis).setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(SharedPrefManager.getInstance(this).isLoggedIn()) {
            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
    }

    private void userRegis() {
        Intent keRegis = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(keRegis);
    }

    private void usersLogin() {
        String email = etEmail.getText().toString().trim();
        String password = etPass.getText().toString().trim();

        if(email.isEmpty()){
            etEmail.setError("Email is required");
            etEmail.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            etEmail.setError("Enter a valid email");
            etEmail.requestFocus();
            return;
        }

        if(password.isEmpty()){
            etPass.setError("Password required");
            etPass.requestFocus();
            return;
        }

        if(password.length()<6){
            etPass.setError("Password should be atleast 6 character long");
            etPass.requestFocus();
            return;
        }

        Call<LoginResponse> call =RetrofitClient.getInstance().getApi().userLogin(email,password);

        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                LoginResponse loginResponse =response.body();

                if (!loginResponse.isError()){
                    SharedPrefManager.getInstance(LoginActivity.this).saveUser(loginResponse.getUser());
                    Intent keHome = new Intent(LoginActivity.this, MainActivity.class);
                    keHome.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(keHome);
                }
                else {
                    Toast.makeText(LoginActivity.this, loginResponse.getMessage(),Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Gagal Koneksi",Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_masuk:
                usersLogin();
                break;
            case R.id.btn_regis:
                userRegis();
                break;
        }
    }
}