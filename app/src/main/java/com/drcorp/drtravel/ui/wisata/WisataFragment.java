package com.drcorp.drtravel.ui.wisata;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.drcorp.drtravel.R;
import com.drcorp.drtravel.api.RetrofitClient;
import com.drcorp.drtravel.models.Wisata;
import com.drcorp.drtravel.models.WisataResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WisataFragment extends Fragment {
    private RecyclerView rvGrid;
    private List<Wisata> listWisata;
    TextView toolbar;

    ShimmerFrameLayout shimmer1,shimmer2;
    View view1,view2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_wisata, container, false);

        toolbar = root.findViewById(R.id.tv_header);
        toolbar.setText("Wisata Menarik");

        view1=(View)root.findViewById(R.id.view1);
        view2=(View)root.findViewById(R.id.view2);

        shimmer1= (ShimmerFrameLayout) root.findViewById(R.id.shimmer_wisata1);
        shimmer1.startShimmer(); //start Shimmer animation of shimmer

        shimmer2= (ShimmerFrameLayout) root.findViewById(R.id.shimmer_wisata2);
        shimmer2.startShimmer(); //start Shimmer animation of shimmer

        rvGrid = (RecyclerView)root.findViewById(R.id.rv_list_wisata);
        rvGrid.setHasFixedSize(true);

//        listWisata.addAll(DataWisataBanyak.getListData());

        rvGrid.setLayoutManager(new GridLayoutManager(getContext(), 2));
        Call<WisataResponse> call = RetrofitClient.getInstance().getApi().getAllWisata();
        call.enqueue(new Callback<WisataResponse>() {
            @Override
            public void onResponse(Call<WisataResponse> call, Response<WisataResponse> response) {

                listWisata = response.body().getWisata();
                AdapterWisataBanyak adapter = new AdapterWisataBanyak(getActivity(), listWisata);
                shimmer1.stopShimmer();
                view1.setVisibility(View.GONE);
                shimmer2.stopShimmer();
                view2.setVisibility(View.GONE);
                rvGrid.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<WisataResponse> call, Throwable t) {

            }
        });

        return root;
    }
}