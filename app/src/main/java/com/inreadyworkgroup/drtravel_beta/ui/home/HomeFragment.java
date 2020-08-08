package com.inreadyworkgroup.drtravel_beta.ui.home;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.inreadyworkgroup.drtravel_beta.R;
import com.inreadyworkgroup.drtravel_beta.ui.home.pencarian.PencarianActivity;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private RecyclerView rvWisata;
    private RecyclerView rvSubmenu;
    private ArrayList<ViewModelWisata> listData = new ArrayList<ViewModelWisata>();
    private ArrayList<ViewModelSubMenu> listSubMenu = new ArrayList<ViewModelSubMenu>();
    private LinearLayoutManager linearLayout,linearLayoutsubmenu;
    private EditText et_search;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        et_search = root.findViewById(R.id.et_tabSearch);

        rvWisata = (RecyclerView)root.findViewById(R.id.rv_wisata_menarik);
        rvWisata.setHasFixedSize(true);
        rvSubmenu = (RecyclerView)root.findViewById(R.id.rv_subMenu);
        rvSubmenu.setHasFixedSize(true);

        listSubMenu.addAll(DataSubMenu.getListData());
        listData.addAll(DataWisata.getListData());

        linearLayout = new LinearLayoutManager(getActivity());
        linearLayoutsubmenu = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);

        rvSubmenu.setLayoutManager(linearLayoutsubmenu);
        rvWisata.setLayoutManager(linearLayout);

        AdapterWisata adapterWisata = new AdapterWisata(getContext(), listData);
        AdapterSubMenu adapterSubMenu = new AdapterSubMenu(getContext(), listSubMenu);
        rvSubmenu.setAdapter(adapterSubMenu);
        rvWisata.setAdapter(adapterWisata);


        et_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent keSearch = new Intent(getActivity(), PencarianActivity.class);
                startActivity(keSearch);
            }
        });

        return root;
    }
}