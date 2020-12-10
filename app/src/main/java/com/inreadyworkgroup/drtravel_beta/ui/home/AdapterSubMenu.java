package com.inreadyworkgroup.drtravel_beta.ui.home;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.inreadyworkgroup.drtravel_beta.ui.augmentedreality.ARActivity;
import com.inreadyworkgroup.drtravel_beta.ui.home.cardmenu.datamenu.DataMenuAtas;

import com.bumptech.glide.Glide;
import com.inreadyworkgroup.drtravel_beta.R;
import com.inreadyworkgroup.drtravel_beta.ui.home.cardmenu.WadahMenuActivity;

import java.util.ArrayList;

public class AdapterSubMenu extends RecyclerView.Adapter<AdapterSubMenu.ViewHolder> {
    Context context;
    ArrayList<ViewModelSubMenu> listSubmenu;

    public AdapterSubMenu(Context context, ArrayList<ViewModelSubMenu> listSubmenu) {
        this.context = context;
        this.listSubmenu = listSubmenu;
    }

    @NonNull
    @Override
    public AdapterSubMenu.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_submenu,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterSubMenu.ViewHolder holder, final int position) {
        final ViewModelSubMenu list = listSubmenu.get(position);

        holder.txt.setText(list.getTextSub());
        Glide.with(context).load(list.getGambarSub()).into(holder.img);

        holder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (position) {
                    case 0:
                        Intent kear = new Intent(context, ARActivity.class);
                        context.startActivity(kear);
                        break;
                    case 1:
                        Intent kefood = new Intent(context, WadahMenuActivity.class);
                        kefood.putExtra("judultoolbar", "Kuliner");
                        kefood.putExtra("tvAtas", "Kuliner Populer Khas Daerah");
                        kefood.putExtra("tvBawah", "Kuliner Daerah Lainnya");
                        kefood.putExtra("data", "Kuliner");
                        context.startActivity(kefood);
                        break;
                    case 2:
                        Intent kePenginapan = new Intent(context, WadahMenuActivity.class);
                        kePenginapan.putExtra("judultoolbar", "Penginapan");
                        kePenginapan.putExtra("tvAtas", "Penginapan Dengan Nuansa Pemandangan Eksotis");
                        kePenginapan.putExtra("tvBawah", "Penginapan Lainnya");
                        kePenginapan.putExtra("data", "Penginapan");
                        context.startActivity(kePenginapan);
                        break;
                    case 3:
                        Intent keMasjid = new Intent(context, WadahMenuActivity.class);
                        keMasjid.putExtra("judultoolbar", "Masjid");
                        keMasjid.putExtra("tvAtas", "Cari Masjid Di Sekitar Anda ");
                        keMasjid.putExtra("tvBawah", "Masjid Lainnya");
                        keMasjid.putExtra("data", "Masjid");
                        context.startActivity(keMasjid);
                        break;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return listSubmenu.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView txt;
        private CardView cv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            this.img=itemView.findViewById(R.id.image_subMenu);
            this.txt=itemView.findViewById(R.id.tv_subMenu);
            this.cv=itemView.findViewById(R.id.card_AR);
        }
    }
}
