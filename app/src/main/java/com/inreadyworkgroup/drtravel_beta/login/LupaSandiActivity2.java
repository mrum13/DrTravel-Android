package com.inreadyworkgroup.drtravel_beta.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.inreadyworkgroup.drtravel_beta.R;

public class LupaSandiActivity2 extends AppCompatActivity {
    Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lupa_sandi2);

        btnOk = findViewById(R.id.btn_ok);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent keLogin = new Intent(LupaSandiActivity2.this, LoginActivity.class);
                startActivity(keLogin);
                finish();
            }
        });
    }
}