package com.drcorp.drtravel.ui.home;

import com.drcorp.drtravel.R;

import java.util.ArrayList;

public class DataSubMenu {

    private static int[] gambarSubMenu = {
            R.drawable.ic_qr,
            R.drawable.ic_kuliner,
            R.drawable.ic_hotel,
            R.drawable.ic_masjid
    };

    private static String[] judulKSubMenu = {
            "AR 3D",
            "Kuliner",
            "Penginapan",
            "Masjid"
    };

    public static ArrayList<ViewModelSubMenu> getListData() {
        ArrayList<ViewModelSubMenu> list = new ArrayList<>();
        for (int position = 0; position < gambarSubMenu.length; position++) {
            ViewModelSubMenu model = new ViewModelSubMenu();
            model.setGambarSub(gambarSubMenu[position]);
            model.setTextSub(judulKSubMenu[position]);
            list.add(model);
        }
        return list;
    }
}
