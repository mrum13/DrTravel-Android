package com.inreadyworkgroup.drtravel_beta.ui.penanda;

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

import java.util.ArrayList;

public class AdapterFavorit extends RecyclerView.Adapter<AdapterFavorit.ViewHolder> {
    Context context;
    ArrayList<ViewModelFavorit> list;

    public AdapterFavorit(Context context, ArrayList<ViewModelFavorit> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public AdapterFavorit.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_wisata,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterFavorit.ViewHolder holder, int position) {
        final ViewModelFavorit DA = list.get(position);

        holder.txt.setText(DA.getJudulWisata());

        Glide.with(context).load( DA.getGambarWisata()).into(holder.img);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
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
        private ImageView img;
        private TextView txt;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img=itemView.findViewById(R.id.gambar_wisata);
            txt=itemView.findViewById(R.id.tv_namaTempat);
        }
    }
}
