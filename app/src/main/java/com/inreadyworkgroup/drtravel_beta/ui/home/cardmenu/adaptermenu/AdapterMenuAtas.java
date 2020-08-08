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
import com.inreadyworkgroup.drtravel_beta.R;
import com.inreadyworkgroup.drtravel_beta.ui.detailfoodmasjid.DetailFoodMasjidActivity;
import com.inreadyworkgroup.drtravel_beta.ui.detailwisata.DetailWisataActivity;
import com.inreadyworkgroup.drtravel_beta.ui.home.AdapterSubMenu;
import com.inreadyworkgroup.drtravel_beta.ui.home.ViewModelSubMenu;
import com.inreadyworkgroup.drtravel_beta.ui.home.cardmenu.viewmodelmenu.ViewModelMenuAtas;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class AdapterMenuAtas extends RecyclerView.Adapter<AdapterMenuAtas.ViewHolder> {
    Context context;
    ArrayList<ViewModelMenuAtas> list;
    String kategori;

    public AdapterMenuAtas(Context context, ArrayList<ViewModelMenuAtas> list, String kategori) {
        this.context = context;
        this.list = list;
        this.kategori = kategori;
    }


    @NonNull
    @Override
    public AdapterMenuAtas.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_menu_atas,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final AdapterMenuAtas.ViewHolder holder, int position) {
        final ViewModelMenuAtas data = list.get(position);

        holder.tvAtas.setText(data.getTvMenuAtas());
        Glide.with(context).load(data.getGambarMenuAtas()).into(holder.gambarAtas);

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

                kedetail.putExtra("JudulFoodMasjid", data.getTvMenuAtas());
                kedetail.putExtra("GambarFoodMasjid", data.getGambarMenuAtas());
                kedetail.putExtra("AsalFoodMasjid", data.getAsalMenuAtas());
                kedetail.putExtra("DetailFoodMasjid", data.getDetailMenuAtas());
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
        ImageView gambarAtas;
        TextView tvAtas;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            gambarAtas = itemView.findViewById(R.id.img_menu_atas);
            tvAtas = itemView.findViewById(R.id.tv_menu_atas);
        }
    }
}
