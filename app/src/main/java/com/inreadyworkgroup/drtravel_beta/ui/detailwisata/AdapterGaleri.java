package com.inreadyworkgroup.drtravel_beta.ui.detailwisata;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.inreadyworkgroup.drtravel_beta.R;

import java.util.ArrayList;

public class AdapterGaleri extends RecyclerView.Adapter<AdapterGaleri.ViewHolder> {
    Context context;
    ArrayList<ViewModelGaleri> list;

    public AdapterGaleri(Context context, ArrayList<ViewModelGaleri> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public AdapterGaleri.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_galeri,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull AdapterGaleri.ViewHolder holder, int position) {
        final ViewModelGaleri DA = list.get(position);

        Glide.with(context).load(DA.getGambarGaleri()).into(holder.imgGaleri);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgGaleri;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgGaleri = itemView.findViewById(R.id.imgGaleri);
        }
    }
}
