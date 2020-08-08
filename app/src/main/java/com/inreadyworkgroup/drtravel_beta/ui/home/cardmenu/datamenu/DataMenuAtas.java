package com.inreadyworkgroup.drtravel_beta.ui.home.cardmenu.datamenu;

import com.inreadyworkgroup.drtravel_beta.R;
import com.inreadyworkgroup.drtravel_beta.ui.home.cardmenu.viewmodelmenu.ViewModelMenuAtas;

import java.util.ArrayList;

public class DataMenuAtas {
    private static int[] gambarKuliner = {
            R.drawable.coto_makassar,
            R.drawable.pisang_epe,
            R.drawable.pisang_ijo
    };

    private static String[] judulKuliner = {
            "Coto Makassar",
            "Pisang Epe",
            "Pisang Ijo"
    };

    private static String[] asalKuliner = {
            "Makassar, Sulawesi Selatan",
            "Makassar, Sulawesi Selatan",
            "Makassar, Sulawesi Selatan"
    };

    private static String[] detailKuliner = {
            "Coto makassar atau coto mangkasara adalah makanan tradisional Makassar, Sulawesi Selatan. Makanan ini terbuat dari jeroan sapi yang direbus dalam waktu yang lama. Rebusan jeroan bercampur daging sapi ini kemudian diiris-iris lalu dibumbui dengan bumbu yang diracik secara khusus. Coto dihidangkan dalam mangkuk dan dinikmati dengan ketupat dan buras, yakni sejenis ketupat yang dibungkus daun pisang.",
            "Pisang Epe Mantap",
            "Pisang ijo Mantap"
    };

    private static int[] gambarPenginapan  = {
            R.drawable.wisata_atas
    };

    private static String[] judulPenginapan = {
            "Paduppa Resort",
    };

    private static String[] asalPenginapan = {
            "Bulukumba, Sulawesi Selatan"
    };

    private static String[] detailPenginapan = {
            "Bagus pengantin baru liburan kesini",
    };

    private static int[] gambarMasjid = {
            R.drawable.masjid_atas,
    };

    private static String[] judulMasjid = {
            "Masjid 99 Kubah",
    };

    private static String[] asalmasjid = {
            "Makassar, Sulawesi Selatan",
    };

    private static String[] detailmasjid = {
            "Masjid yang berada di pantai losari",
    };

    public static ArrayList<ViewModelMenuAtas> getListDataKuliner() {
        ArrayList<ViewModelMenuAtas> list = new ArrayList<>();
        for (int position = 0; position < gambarKuliner.length; position++) {
            ViewModelMenuAtas model = new ViewModelMenuAtas();
            model.setGambarMenuAtas(gambarKuliner[position]);
            model.setTvMenuAtas(judulKuliner[position]);
            model.setAsalMenuAtas(asalKuliner[position]);
            model.setDetailMenuAtas(detailKuliner[position]);
            list.add(model);
        }
        return list;
    }

    public static ArrayList<ViewModelMenuAtas> getListDataPenginapan() {
        ArrayList<ViewModelMenuAtas> list = new ArrayList<>();
        for (int position = 0; position < gambarPenginapan.length; position++) {
            ViewModelMenuAtas model = new ViewModelMenuAtas();
            model.setGambarMenuAtas(gambarPenginapan[position]);
            model.setTvMenuAtas(judulPenginapan[position]);
            model.setAsalMenuAtas(asalPenginapan[position]);
            model.setDetailMenuAtas(detailPenginapan[position]);
            list.add(model);
        }
        return list;
    }

    public static ArrayList<ViewModelMenuAtas> getListDataMasjid() {
        ArrayList<ViewModelMenuAtas> list = new ArrayList<>();
        for (int position = 0; position < gambarMasjid.length; position++) {
            ViewModelMenuAtas model = new ViewModelMenuAtas();
            model.setGambarMenuAtas(gambarMasjid[position]);
            model.setTvMenuAtas(judulMasjid[position]);
            model.setAsalMenuAtas(asalmasjid[position]);
            model.setDetailMenuAtas(detailmasjid[position]);
            list.add(model);
        }
        return list;
    }
}
