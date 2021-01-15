package com.inreadyworkgroup.drtravel_beta.ui.lainnya;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Patterns;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.inreadyworkgroup.drtravel_beta.R;
import com.inreadyworkgroup.drtravel_beta.api.RetrofitClient;
import com.inreadyworkgroup.drtravel_beta.models.LoginResponse;
import com.inreadyworkgroup.drtravel_beta.models.User;
import com.inreadyworkgroup.drtravel_beta.storage.SharedPrefManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditProfileActivity extends AppCompatActivity {
    private EditText et_nama_edit, et_email_edit;
    String nama,email;
    private ImageView btnBack;
    private TextView dialogOk,tvKembali;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        et_nama_edit = findViewById(R.id.et_editnama_profile);
        et_email_edit = findViewById(R.id.et_editemail_profile);

        tvKembali = findViewById(R.id.tv_kembali);
        btnBack = findViewById(R.id.btn_back);
        tvKembali.setText("Ubah Akun");

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        getIncomingIntent();
//
        Button btn_simpan = findViewById(R.id.btn_simpan_akun);
        btn_simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateProfile();
            }
        });
    }

    private void showDialog(){
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
                EditProfileActivity.this.finish();
            }
        });

        dialog.show();
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

    private void updateProfile() {
        String email = et_email_edit.getText().toString().trim();
        String name = et_nama_edit.getText().toString().trim();

        if (email.isEmpty()) {
            et_email_edit.setError("Email is required");
            et_email_edit.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            et_email_edit.setError("Enter a valid email");
            et_email_edit.requestFocus();
            return;
        }

        if (name.isEmpty()) {
            et_nama_edit.setError("Name required");
            et_nama_edit.requestFocus();
            return;
        }

        User user = SharedPrefManager.getInstance(EditProfileActivity.this).getUser();
        id = user.getId();
        Call<LoginResponse> call = RetrofitClient.getInstance().getApi().updateUser(id,email,name);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (!response.body().isError()) {
                    SharedPrefManager.getInstance(EditProfileActivity.this).saveUser(response.body().getUser());
                    showDialog();
                }

            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

            }
        });
    }
}