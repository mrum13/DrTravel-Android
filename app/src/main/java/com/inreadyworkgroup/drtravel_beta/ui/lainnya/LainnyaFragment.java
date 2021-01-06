package com.inreadyworkgroup.drtravel_beta.ui.lainnya;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.inreadyworkgroup.drtravel_beta.R;
import com.inreadyworkgroup.drtravel_beta.login.LoginActivity;
import com.inreadyworkgroup.drtravel_beta.models.User;
import com.inreadyworkgroup.drtravel_beta.storage.SharedPrefManager;

public class LainnyaFragment extends Fragment {
    TextView toolbar,tv_nama,tv_email;
    TextView tvidUser;
    int id_user;
    User user;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_lainnya, container, false);

        final String nama,email;

        tv_nama = root.findViewById(R.id.tv_nama_akun);
        tv_email = root.findViewById(R.id.tv_email_akun);
        tvidUser = root.findViewById(R.id.tv_id_akun);

        toolbar = root.findViewById(R.id.tv_header);
        toolbar.setText("Akun");

        //nama dan email berdasarkan data login
        user = SharedPrefManager.getInstance(getActivity()).getUser();
        tv_nama.setText(user.getName());
        tv_email.setText(user.getEmail());
        id_user = user.getId();
        tvidUser.setText(Integer.toString(id_user));

        nama = user.getName();
        email = user.getEmail();

        Button btnKeluar = (Button) root.findViewById(R.id.btn_keluar_akun);
        btnKeluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                getActivity().finish();
                SharedPrefManager.getInstance(getActivity()).clear();
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
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
                Intent keinfo = new Intent(getContext(),InfoAppActivity.class);
                startActivity(keinfo);
            }
        });


        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        user = SharedPrefManager.getInstance(getActivity()).getUser();
        tv_nama.setText(user.getName());
        tv_email.setText(user.getEmail());
    }
}