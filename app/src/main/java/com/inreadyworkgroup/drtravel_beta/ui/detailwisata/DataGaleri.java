package com.inreadyworkgroup.drtravel_beta.ui.detailwisata;

import com.inreadyworkgroup.drtravel_beta.R;
import com.inreadyworkgroup.drtravel_beta.ui.home.cardmenu.viewmodelmenu.ViewModelMenuAtas;

import java.util.ArrayList;

public class DataGaleri {
    private static int[] gambarBenteng = {
            R.drawable.benteng1,
            R.drawable.benteng2,
            R.drawable.benteng3
    };

    private static int[] gambarPanlos = {
            R.drawable.panlos1,
            R.drawable.panlos2,
            R.drawable.panlos3
    };

    private static int[] gambarPaduppa = {
            R.drawable.paduppa1,
            R.drawable.paduppa2,
            R.drawable.paduppa3
    };

    private static int[] gambarPermata = {
            R.drawable.permata1,
            R.drawable.permata2,
            R.drawable.permata3
    };

    private static int[] gambarPondok = {
            R.drawable.pondok1,
            R.drawable.pondok2,
            R.drawable.pondok3
    };

    private static int[] gambarGapura = {
            R.drawable.gapura1,
            R.drawable.gapura2,
            R.drawable.gapura3
    };

    public static ArrayList<ViewModelGaleri> getListDataGaleriPanlos() {
        ArrayList<ViewModelGaleri> list = new ArrayList<>();
        for (int position = 0; position < gambarPanlos.length; position++) {
            ViewModelGaleri model = new ViewModelGaleri();
            model.setGambarGaleri(gambarPanlos[position]);
            list.add(model);
        }
        return list;
    }

    public static ArrayList<ViewModelGaleri> getListDataGaleriBenteng() {
        ArrayList<ViewModelGaleri> list = new ArrayList<>();
        for (int position = 0; position < gambarBenteng.length; position++) {
            ViewModelGaleri model = new ViewModelGaleri();
            model.setGambarGaleri(gambarBenteng[position]);
            list.add(model);
        }
        return list;
    }

    public static ArrayList<ViewModelGaleri> getListDataGaleriPaduppa() {
        ArrayList<ViewModelGaleri> list = new ArrayList<>();
        for (int position = 0; position < gambarPaduppa.length; position++) {
            ViewModelGaleri model = new ViewModelGaleri();
            model.setGambarGaleri(gambarPaduppa[position]);
            list.add(model);
        }
        return list;
    }

    public static ArrayList<ViewModelGaleri> getListDataGaleriPermata() {
        ArrayList<ViewModelGaleri> list = new ArrayList<>();
        for (int position = 0; position < gambarPermata.length; position++) {
            ViewModelGaleri model = new ViewModelGaleri();
            model.setGambarGaleri(gambarPermata[position]);
            list.add(model);
        }
        return list;
    }

    public static ArrayList<ViewModelGaleri> getListDataGaleriPondok() {
        ArrayList<ViewModelGaleri> list = new ArrayList<>();
        for (int position = 0; position < gambarPondok.length; position++) {
            ViewModelGaleri model = new ViewModelGaleri();
            model.setGambarGaleri(gambarPondok[position]);
            list.add(model);
        }
        return list;
    }

    public static ArrayList<ViewModelGaleri> getListDataGaleriGapura() {
        ArrayList<ViewModelGaleri> list = new ArrayList<>();
        for (int position = 0; position < gambarGapura.length; position++) {
            ViewModelGaleri model = new ViewModelGaleri();
            model.setGambarGaleri(gambarGapura[position]);
            list.add(model);
        }
        return list;
    }
}
