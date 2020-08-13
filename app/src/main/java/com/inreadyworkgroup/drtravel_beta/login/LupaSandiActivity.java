package com.inreadyworkgroup.drtravel_beta.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.inreadyworkgroup.drtravel_beta.R;

public class LupaSandiActivity extends AppCompatActivity {
    Button btnProses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lupa_sandi);

        btnProses = findViewById(R.id.btn_proses);

        btnProses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent lanjut = new Intent(LupaSandiActivity.this, LupaSandiActivity2.class);
                startActivity(lanjut);
            }
        });
    }
}