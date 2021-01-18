package com.drcorp.drtravel.ui.home;

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
import com.drcorp.drtravel.R;
import com.drcorp.drtravel.models.Wisata;
import com.drcorp.drtravel.ui.detailwisata.DetailWisataActivity;

import java.util.List;

public class AdapterWisata extends RecyclerView.Adapter<AdapterWisata.viewHolder> {
    Context context;
    List<Wisata> listWisata;

    public AdapterWisata(Context context, List<Wisata> listWisata) {
        this.context = context;
        this.listWisata = listWisata;
    }

    @NonNull
    @Override
    public AdapterWisata.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_wisata,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterWisata.viewHolder holder, int position) {
        final Wisata DA = listWisata.get(position);

        holder.txt.setText(DA.getNama_tempat());

        RequestOptions options = new RequestOptions()
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher_round)
                .error(R.mipmap.ic_launcher_round);

        Glide.with(context).load( DA.getGambar()).apply(options).into(holder.img);
//        Glide.with(context).load( "https://www.pantaipedia.com/wp-content/uploads/2019/02/Pantai-Losari.jpg").apply(options).into(holder.img);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent kedetail = new Intent(context, DetailWisataActivity.class);

                kedetail.putExtra("JudulFoodMasjid", DA.getNama_tempat());
                kedetail.putExtra("toolbar", "Wisata Menarik");

                context.startActivity(kedetail);
            }
        });


    }

    @Override
    public int getItemCount() {
        return listWisata.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView txt;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            img=itemView.findViewById(R.id.gambar_wisata);
            txt=itemView.findViewById(R.id.tv_namaTempat);
        }
    }
}
