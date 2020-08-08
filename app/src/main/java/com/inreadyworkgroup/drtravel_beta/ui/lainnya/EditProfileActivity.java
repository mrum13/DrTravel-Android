package com.inreadyworkgroup.drtravel_beta.ui.lainnya;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.app.Dialog;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.inreadyworkgroup.drtravel_beta.R;

public class EditProfileActivity extends AppCompatActivity {
    private EditText et_nama_edit, et_email_edit;
    String nama,email;
    TextView dialogOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        et_nama_edit = findViewById(R.id.et_editnama_profile);
        et_email_edit = findViewById(R.id.et_editemail_profile);

        et_nama_edit.setOnEditorActionListener(editorListener);
        et_email_edit.setOnEditorActionListener(editorListener);

        getIncomingIntent();

        Button btn_simpan = findViewById(R.id.btn_simpan_akun);
        btn_simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(EditProfileActivity.this);

                //Memasang Title / Judul pada Custom Dialog
                dialog.setTitle("Update berhasil");

                //Memasang Desain Layout untuk Custom Dialog
                dialog.setContentView(R.layout.dialog_simpan_profile);

                //Memasang Listener / Aksi saat tombol OK di Klik
                TextView DialogButton = dialog.findViewById(R.id.tv_simpan);
                DialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });
    }

    private TextView.OnEditorActionListener editorListener = new TextView.OnEditorActionListener() {
        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            switch (actionId) {
                case EditorInfo.IME_ACTION_NEXT:
                    nama = et_nama_edit.getText().toString();
                    if(nama == "") {
                        et_nama_edit.setError("Nama harus diisi !");
                    } else {
                        et_nama_edit.setBackgroundColor(getResources().getColor(R.color.colorWhilte));
                    }
                    break;
                case EditorInfo.IME_ACTION_SEND:
                    email = et_email_edit.getText().toString();
                    if(email == "") {
                        et_email_edit.setError("Email harus diisi !");
                    } else {
                        et_email_edit.setBackgroundColor(getResources().getColor(R.color.colorWhilte));
                    }
                    break;
            }

            return false;
        }
    };

    private void getIncomingIntent(){
        if(getIntent().hasExtra("nama") && getIntent().hasExtra("email")) {
            String nama = getIntent().getStringExtra("nama");
            String email = getIntent().getStringExtra("email");

            setDetail(nama, email);
        }
    }

    private void setDetail(String nama, String email){
        et_nama_edit.setText(nama);
        et_email_edit.setText(email);
    }
}