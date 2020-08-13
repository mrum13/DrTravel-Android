package com.inreadyworkgroup.drtravel_beta.ui.lainnya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.inreadyworkgroup.drtravel_beta.R;

public class UndangTemanActivity extends AppCompatActivity {
    TextView toolbarAjak;
    Button btnAjak,btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_undang_teman);

        toolbarAjak = findViewById(R.id.tv_kembali);
        btnAjak = findViewById(R.id.btn_ajakteman);


        toolbarAjak.setText("Undang Teman");
        btnAjak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = "Here is Dr Travel App";
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, "Share via"));
            }
        });
    }
}