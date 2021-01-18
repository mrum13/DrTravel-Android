package com.drcorp.drtravel.ui.wisata;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.drcorp.drtravel.R;
import com.drcorp.drtravel.models.Wisata;
import com.drcorp.drtravel.storage.DbHelper;
import com.drcorp.drtravel.ui.detailwisata.DetailWisataActivity;

import java.util.List;

public class AdapterWisataBanyak extends RecyclerView.Adapter<AdapterWisataBanyak.ViewHolder> {
    Context context;
    List<Wisata> list;

    public AdapterWisataBanyak(Context context, List<Wisata> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public AdapterWisataBanyak.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_grid,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterWisataBanyak.ViewHolder holder, int position) {
        Wisata wisata = list.get(position);

        holder.tvWisata.setText(wisata.getNama_tempat());

        Glide.with(context).load( wisata.getGambar()).into(holder.imgWisata);

//        holder.bind(position);
//        holder.cbSelect.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (list.get(position).isChecked()) {
//                    holder.cbSelect.setChecked(false);
//                    list.get(position).setChecked(false);
//
//                }
//                else {
//                    holder.cbSelect.setChecked(true);
//                    list.get(position).setChecked(true);
//                }
//            }
//        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent kedetail = new Intent(context, DetailWisataActivity.class);
                kedetail.putExtra("JudulFoodMasjid", wisata.getNama_tempat());
                kedetail.putExtra("toolbar", "Wisata Menarik");

                context.startActivity(kedetail);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imgWisata;
        TextView tvWisata;
//        CheckBox cbSelect;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvWisata = itemView.findViewById(R.id.tv_item_wisata);
            imgWisata = itemView.findViewById(R.id.img_item_wisata);
//            cbSelect = itemView.findViewById(R.id.cb_favorit);
        }

//        void bind(int position) {
////            cbSelect.set(String.valueOf(items.get(position).getPosition()));
//
//            if (list.get(position).isChecked()) {
//                cbSelect.setChecked(true);
//            }
//            else {
//                cbSelect.setChecked(false);
//            }
//        }

        @Override
        public void onClick(View view) {

        }
    }
}
