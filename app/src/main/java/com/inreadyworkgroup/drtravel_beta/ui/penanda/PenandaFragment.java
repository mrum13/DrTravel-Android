package com.inreadyworkgroup.drtravel_beta.ui.penanda;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.inreadyworkgroup.drtravel_beta.R;
import com.inreadyworkgroup.drtravel_beta.ui.home.ViewModelWisata;
import com.inreadyworkgroup.drtravel_beta.ui.wisata.AdapterWisataBanyak;
import com.inreadyworkgroup.drtravel_beta.ui.wisata.DataWisataBanyak;
import com.inreadyworkgroup.drtravel_beta.ui.wisata.ViewModelWisataBanyak;

import java.util.ArrayList;

public class PenandaFragment extends Fragment {
    private RecyclerView rvFavorit;
    private ArrayList<ViewModelFavorit> listFavorit = new ArrayList<ViewModelFavorit>();
    TextView toolbar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_penanda, container, false);

        toolbar = root.findViewById(R.id.tv_header);
        toolbar.setText("Wisata Favorit");

        rvFavorit = root.findViewById(R.id.rv_favorit);
        rvFavorit.setHasFixedSize(true);

        listFavorit.addAll(DataFavorit.getListData());

        rvFavorit.setLayoutManager(new LinearLayoutManager(getActivity()));
        AdapterFavorit adapterFavorit = new AdapterFavorit(getContext(), listFavorit);
        rvFavorit.setAdapter(adapterFavorit);

        return root;
    }
}