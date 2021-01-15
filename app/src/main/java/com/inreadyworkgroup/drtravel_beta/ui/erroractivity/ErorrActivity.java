package com.inreadyworkgroup.drtravel_beta.ui.erroractivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.inreadyworkgroup.drtravel_beta.R;

public class ErorrActivity extends AppCompatActivity {
    private Button btnRefresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_erorr);

        inisialisasiObjek();
        btnRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void inisialisasiObjek() {
        btnRefresh = findViewById(R.id.btn_refresh);
    }
}