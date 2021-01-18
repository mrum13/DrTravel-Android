package com.drcorp.drtravel.ui.detailwisata;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.drcorp.drtravel.R;
import com.drcorp.drtravel.models.ViewModelGaleri;

import java.util.List;

public class ViewPagerAdapter extends PagerAdapter {
    private LayoutInflater layoutInflater;
    private Context context;
    private List<ViewModelGaleri> list;
    private int pos;

    public ViewPagerAdapter(Context context, List<ViewModelGaleri> list, int pos) {
        this.context = context;
        this.list = list;
        this.pos = pos;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item, container, false);

        ImageView imageView;

        imageView = view.findViewById(R.id.image);
        Glide.with(context).load(list.get(position).getGambar()).into(imageView);

        container.addView(view,0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
