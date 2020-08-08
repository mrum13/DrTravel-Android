package com.inreadyworkgroup.drtravel_beta.ui.home.cardmenu.adaptermenu;

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
import com.bumptech.glide.request.RequestOptions;
import com.inreadyworkgroup.drtravel_beta.R;
import com.inreadyworkgroup.drtravel_beta.ui.detailfoodmasjid.DetailFoodMasjidActivity;
import com.inreadyworkgroup.drtravel_beta.ui.detailwisata.DetailWisataActivity;
import com.inreadyworkgroup.drtravel_beta.ui.home.cardmenu.viewmodelmenu.ViewModelMenuBawah;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;

public class AdapterMenuBawah extends RecyclerView.Adapter<AdapterMenuBawah.ViewHolder> {
    Context context;
    ArrayList<ViewModelMenuBawah> list;
    String kategori;

    public AdapterMenuBawah(Context context, ArrayList<ViewModelMenuBawah> list, String kategori) {
        this.context = context;
        this.list = list;
        this.kategori = kategori;
    }

    @NonNull
    @Override
    public AdapterMenuBawah.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_menu_bawah, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterMenuBawah.ViewHolder holder, int position) {
        final ViewModelMenuBawah data = list.get(position);

        Glide.with(holder.itemView.getContext())
                .load(data.getGambarMenuBawah())
                .apply(new RequestOptions())
                .into(holder.gambarMenu);
        holder.tvMenu.setText(data.getTvMenuBawah());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent kedetail = null;
                if (kategori.equals("Kuliner")){
                    kedetail = new Intent(context, DetailFoodMasjidActivity.class);
                }
                else if (kategori.equals("Masjid")){
                    kedetail = new Intent(context, DetailFoodMasjidActivity.class);
                }
                else if (kategori.equals("Penginapan")){
                    kedetail = new Intent(context, DetailWisataActivity.class);
                }

                kedetail.putExtra("JudulFoodMasjid", data.getTvMenuBawah());
                kedetail.putExtra("GambarFoodMasjid", data.getGambarMenuBawah());
                kedetail.putExtra("AsalFoodMasjid", data.getAsalMenuBawah());
                kedetail.putExtra("DetailFoodMasjid", data.getDetailMenuBawah());
                kedetail.putExtra("toolbar", kategori);

                context.startActivity(kedetail);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView gambarMenu;
        TextView tvMenu;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            gambarMenu = itemView.findViewById(R.id.img_card_menu_bawah);
            tvMenu = itemView.findViewById(R.id.tv_card_menu_bawah);
        }
    }
}
