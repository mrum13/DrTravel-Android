package com.inreadyworkgroup.drtravel_beta.ui.home.pencarian;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.inreadyworkgroup.drtravel_beta.R;

public class PencarianActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pencarian);

        ImageView ic_hapus = findViewById(R.id.clear_text_cari);
        final EditText et_cari = findViewById(R.id.et_cari_wisata);

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
            return false;
        }
    };
}