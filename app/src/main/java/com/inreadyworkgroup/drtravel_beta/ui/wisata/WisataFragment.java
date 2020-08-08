package com.inreadyworkgroup.drtravel_beta.ui.wisata;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.inreadyworkgroup.drtravel_beta.R;
import com.inreadyworkgroup.drtravel_beta.ui.home.DataSubMenu;
import com.inreadyworkgroup.drtravel_beta.ui.home.ViewModelSubMenu;
import com.inreadyworkgroup.drtravel_beta.ui.home.ViewModelWisata;

import java.util.ArrayList;

public class WisataFragment extends Fragment {
    private RecyclerView rvGrid;
    private ArrayList<ViewModelWisataBanyak> listWisata = new ArrayList<ViewModelWisataBanyak>();
    TextView toolbar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_wisata, container, false);

        toolbar = root.findViewById(R.id.tv_header);
        toolbar.setText("Wisata Menarik");

        rvGrid = (RecyclerView)root.findViewById(R.id.rv_list_wisata);
        rvGrid.setHasFixedSize(true);

        listWisata.addAll(DataWisataBanyak.getListData());

        rvGrid.setLayoutManager(new GridLayoutManager(getContext(), 2));
        AdapterWisataBanyak adapterWisataBanyak = new AdapterWisataBanyak(getContext(), listWisata);
        rvGrid.setAdapter(adapterWisataBanyak);

        return root;
    }
}