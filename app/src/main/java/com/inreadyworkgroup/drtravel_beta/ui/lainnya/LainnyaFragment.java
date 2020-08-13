package com.inreadyworkgroup.drtravel_beta.ui.lainnya;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.inreadyworkgroup.drtravel_beta.R;

public class LainnyaFragment extends Fragment {
    TextView toolbar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_lainnya, container, false);

        final String nama,email;

        TextView tv_nama = root.findViewById(R.id.tv_nama_akun);
        TextView tv_email = root.findViewById(R.id.tv_email_akun);

        nama = tv_nama.getText().toString();
        email = tv_email.getText().toString();

        toolbar = root.findViewById(R.id.tv_header);
        toolbar.setText("Akun");

        Button btnKeluar = (Button) root.findViewById(R.id.btn_keluar_akun);
        btnKeluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });

        ImageView img_edit = root.findViewById(R.id.edit_profil_akun);
        img_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ke_edit = new Intent(getContext(), EditProfileActivity.class);
                ke_edit.putExtra("nama", nama);
                ke_edit.putExtra("email", email);
                startActivity(ke_edit);
            }
        });

        TextView tvundang = root.findViewById(R.id.tv_undang_teman);
        TextView tvbantuan = root.findViewById(R.id.tv_bantuan);
        TextView tvinfo = root.findViewById(R.id.tv_info);

        tvundang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent undang = new Intent(getActivity(), UndangTemanActivity.class);
                startActivity(undang);
            }
        });

        tvbantuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://www.drtravel.id";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        tvinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), InfoAppActivity.class));
            }
        });


        return root;
    }
}