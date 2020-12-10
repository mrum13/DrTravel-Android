package com.inreadyworkgroup.drtravel_beta.ui.wisata;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.inreadyworkgroup.drtravel_beta.R;
import com.inreadyworkgroup.drtravel_beta.ui.detailwisata.DetailWisataActivity;
import com.inreadyworkgroup.drtravel_beta.ui.home.AdapterWisata;
import com.inreadyworkgroup.drtravel_beta.ui.home.ViewModelWisata;

import java.util.ArrayList;

public class AdapterWisataBanyak extends RecyclerView.Adapter<AdapterWisataBanyak.ViewHolder> {
    Context context;
    ArrayList<ViewModelWisataBanyak> list;

    public AdapterWisataBanyak(Context context, ArrayList<ViewModelWisataBanyak> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public AdapterWisataBanyak.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_grid,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterWisataBanyak.ViewHolder holder, int position) {
        final ViewModelWisataBanyak DA = list.get(position);

        holder.tvWisata.setText(DA.getJudulWisata());

        Glide.with(context).load( DA.getGambarWisata()).into(holder.imgWisata);

        holder.imgWisata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent kedetail = new Intent(context, DetailWisataActivity.class);

                kedetail.putExtra("JudulFoodMasjid", DA.getJudulWisata());
                kedetail.putExtra("GambarFoodMasjid", DA.getGambarWisata());
                kedetail.putExtra("AsalFoodMasjid", DA.getAsalWisata());
                kedetail.putExtra("DetailFoodMasjid", DA.getDetailWisata());
                kedetail.putExtra("toolbar", "Wisata Menarik");

                context.startActivity(kedetail);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgWisata;
        TextView tvWisata;
        ImageView favBefore;
        ImageView favAfter;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvWisata = itemView.findViewById(R.id.tv_item_wisata);
            imgWisata = itemView.findViewById(R.id.img_item_wisata);
            favBefore = itemView.findViewById(R.id.img_favorit_before);
            favAfter = itemView.findViewById(R.id.img_favorit_after);
        }
    }
}
