package com.inreadyworkgroup.drtravel_beta.ui.home.cardmenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.inreadyworkgroup.drtravel_beta.R;
import com.inreadyworkgroup.drtravel_beta.ui.home.cardmenu.adaptermenu.AdapterMenuAtas;
import com.inreadyworkgroup.drtravel_beta.ui.home.cardmenu.adaptermenu.AdapterMenuBawah;
import com.inreadyworkgroup.drtravel_beta.ui.home.cardmenu.datamenu.DataMenuAtas;
import com.inreadyworkgroup.drtravel_beta.ui.home.cardmenu.datamenu.Datamenubawah;
import com.inreadyworkgroup.drtravel_beta.ui.home.cardmenu.viewmodelmenu.ViewModelMenuAtas;
import com.inreadyworkgroup.drtravel_beta.ui.home.cardmenu.viewmodelmenu.ViewModelMenuBawah;

import java.util.ArrayList;

public class WadahMenuActivity extends AppCompatActivity {
    private RecyclerView rvMenuAtas,rvMenuBawah;
    private ArrayList<ViewModelMenuAtas> list = new ArrayList<>();
    private ArrayList<ViewModelMenuBawah> listBawah = new ArrayList<>();
    private String title = "Judul";
    private String tvAtas, tvBawah,datalist,kategori;
    TextView tvToolbar,tvMenuAtas,tvMenuBawah;
    ImageView btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        if(getIntent().hasExtra("judultoolbar") && getIntent().hasExtra("tvAtas") && getIntent().hasExtra("tvBawah") && getIntent().hasExtra("data")){
            title = getIntent().getStringExtra("judultoolbar");
            tvAtas = getIntent().getStringExtra("tvAtas");
            tvBawah = getIntent().getStringExtra("tvBawah");
            datalist = getIntent().getStringExtra("data");
        }


        tvToolbar = findViewById(R.id.tv_kembali);
        tvMenuAtas = findViewById(R.id.tv_menu_atas);
        tvMenuBawah = findViewById(R.id.tv_menu_bawah);
        btnBack = findViewById(R.id.btn_back);
        tvToolbar.setText(title);
        tvMenuAtas.setText(tvAtas);
        tvMenuBawah.setText(tvBawah);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        rvMenuAtas = findViewById(R.id.rv_menu_atas);
        rvMenuAtas.setHasFixedSize(true);

        rvMenuBawah = findViewById(R.id.rv_menu_bawah);
        rvMenuBawah.setHasFixedSize(true);

        if (datalist.equals("Kuliner")){
            list.addAll(DataMenuAtas.getListDataKuliner());
            listBawah.addAll(Datamenubawah.getListDataKuliner());
            kategori = "Kuliner";
        }
        else if (datalist.equals("Penginapan")){
            list.addAll(DataMenuAtas.getListDataPenginapan());
            listBawah.addAll(Datamenubawah.getListDataPenginapan());
            kategori = "Penginapan";
        }
        else if (datalist.equals("Masjid")){
            list.addAll(DataMenuAtas.getListDataMasjid());
            listBawah.addAll(Datamenubawah.getListDataMasjid());
            kategori = "Masjid";
        }

        rvMenuAtas.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        AdapterMenuAtas adapterMenuAtas = new AdapterMenuAtas(this, list, kategori);
        rvMenuAtas.setAdapter(adapterMenuAtas);

        rvMenuBawah.setLayoutManager(new GridLayoutManager(this,2));
        AdapterMenuBawah adapterMenuBawah = new AdapterMenuBawah(this, listBawah, kategori);
        rvMenuBawah.setAdapter(adapterMenuBawah);
    }
}