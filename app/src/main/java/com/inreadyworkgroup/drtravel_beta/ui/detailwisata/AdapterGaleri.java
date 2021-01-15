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
import com.inreadyworkgroup.drtravel_beta.models.ViewModelGaleri;
import com.inreadyworkgroup.drtravel_beta.models.ViewModelMenuBawah;

import java.util.ArrayList;
import java.util.List;

public class AdapterGaleri extends RecyclerView.Adapter<AdapterGaleri.ViewHolder> {
    List<ViewModelGaleri> list;
    RecyclerOnItemClickListener mItemClickListener;

    public AdapterGaleri(List<ViewModelGaleri> list, RecyclerOnItemClickListener mItemClickListener) {
        this.list = list;
        this.mItemClickListener = mItemClickListener;
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

        Glide.with(holder.itemView.getContext()).load(DA.getGambar()).into(holder.imgGaleri);
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
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mItemClickListener.onItemClick(getAdapterPosition());
                }
            });
        }
    }
}
