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
import android.widget.Toast;

import com.inreadyworkgroup.drtravel_beta.R;
import com.inreadyworkgroup.drtravel_beta.api.RetrofitClient;
import com.inreadyworkgroup.drtravel_beta.models.Wisata;
import com.inreadyworkgroup.drtravel_beta.models.WisataResponse;
import com.inreadyworkgroup.drtravel_beta.ui.home.DataSubMenu;
import com.inreadyworkgroup.drtravel_beta.ui.home.ViewModelSubMenu;
import com.inreadyworkgroup.drtravel_beta.ui.home.ViewModelWisata;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WisataFragment extends Fragment {
    private RecyclerView rvGrid;
    private List<Wisata> listWisata;
    TextView toolbar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_wisata, container, false);

        toolbar = root.findViewById(R.id.tv_header);
        toolbar.setText("Wisata Menarik");

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
                rvGrid.setAdapter(adapter);

//                if (listWisata==null){
//                    System.out.println("data tidak ada");
//                }
//                else {
//                }

            }

            @Override
            public void onFailure(Call<WisataResponse> call, Throwable t) {

            }
        });

        return root;
    }
}