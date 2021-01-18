package com.drcorp.drtravel.ui.home;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.drcorp.drtravel.R;
import com.drcorp.drtravel.api.RetrofitClient;
import com.drcorp.drtravel.models.Wisata;
import com.drcorp.drtravel.models.WisataResponse;
import com.drcorp.drtravel.ui.home.pencarian.PencarianActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {
    private RecyclerView rvWisata;
    private RecyclerView rvSubmenu;
    private List<Wisata> listWisata;

    private ArrayList<ViewModelSubMenu> listSubMenu = new ArrayList<ViewModelSubMenu>();
    private LinearLayoutManager linearLayout,linearLayoutsubmenu;
    private EditText et_search;

    ShimmerFrameLayout shimmer1;
    View view1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        et_search = root.findViewById(R.id.et_tabSearch);
        view1=(View)root.findViewById(R.id.view1);

        shimmer1= (ShimmerFrameLayout) root.findViewById(R.id.shimmer_view_container1);
        shimmer1.startShimmer(); //start Shimmer animation of shimmer

        rvWisata = (RecyclerView)root.findViewById(R.id.rv_wisata_menarik);
        rvWisata.setHasFixedSize(true);
        rvSubmenu = (RecyclerView)root.findViewById(R.id.rv_subMenu);
        rvSubmenu.setHasFixedSize(true);

        listSubMenu.addAll(DataSubMenu.getListData());

        linearLayout = new LinearLayoutManager(getActivity());
        linearLayoutsubmenu = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);

        rvSubmenu.setLayoutManager(linearLayoutsubmenu);
        rvWisata.setLayoutManager(linearLayout);

        AdapterSubMenu adapterSubMenu = new AdapterSubMenu(getContext(), listSubMenu);
        rvSubmenu.setAdapter(adapterSubMenu);

        Call<WisataResponse> call = RetrofitClient.getInstance().getApi().getPopulerWisata();
        call.enqueue(new Callback<WisataResponse>() {
            @Override
            public void onResponse(Call<WisataResponse> call, Response<WisataResponse> response) {

                listWisata = response.body().getWisata();
                AdapterWisata adapter = new AdapterWisata(getActivity(), listWisata);
                shimmer1.stopShimmer();
                view1.setVisibility(View.GONE);
                rvWisata.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<WisataResponse> call, Throwable t) {
            }
        });


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