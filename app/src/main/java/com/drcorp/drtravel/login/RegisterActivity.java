package com.drcorp.drtravel.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.drcorp.drtravel.R;
import com.drcorp.drtravel.models.DefaultResponse;
import com.drcorp.drtravel.api.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    EditText usernameRegis,emailRegis,passwordRegis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        usernameRegis = findViewById(R.id.et_username);
        emailRegis = findViewById(R.id.et_email);
        passwordRegis = findViewById(R.id.et_pass);

        findViewById(R.id.btn_daftar).setOnClickListener(this);
        findViewById(R.id.tv_login).setOnClickListener(this);
    }

    private void userSignUp(){
        String email=emailRegis.getText().toString().trim();
        String password=passwordRegis.getText().toString().trim();
        String name=usernameRegis.getText().toString().trim();

        if(email.isEmpty()){
            emailRegis.setError("Email is required");
            emailRegis.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            emailRegis.setError("Enter a valid email");
            emailRegis.requestFocus();
            return;
        }

        if(password.isEmpty()){
            passwordRegis.setError("Password required");
            passwordRegis.requestFocus();
            return;
        }

        if(password.length()<6){
            passwordRegis.setError("Password should be atleast 6 character long");
            passwordRegis.requestFocus();
            return;
        }

        if(name.isEmpty()){
            usernameRegis.setError("Name Required");
            usernameRegis.requestFocus();
            return;
        }

        Call<DefaultResponse> call= RetrofitClient
                .getInstance()
                .getApi()
                .createUser(email,password,name);

        call.enqueue(new Callback<DefaultResponse>() {
            @Override
            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                if(response.code()==201){
                    DefaultResponse dr = response.body();
                    Toast.makeText(RegisterActivity.this, dr.getMsg(),Toast.LENGTH_LONG).show();
                    startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                }
                else if (response.code()==422){
                    Toast.makeText(RegisterActivity.this,"Pengguna sudah ada",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<DefaultResponse> call, Throwable t) {
                Toast.makeText(RegisterActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btn_daftar:
                userSignUp();
                break;
            case R.id.tv_login:
                startActivity(new Intent(this, LoginActivity.class));
                break;
        }
    }
}