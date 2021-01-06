package com.inreadyworkgroup.drtravel_beta.ui.wisata;

import com.inreadyworkgroup.drtravel_beta.R;

import java.util.ArrayList;

public class DataWisataBanyak {
    private static int[] gambarWisata = {
            R.drawable.gambar_panlos,
            R.drawable.gambar_benteng
    };

    private static String[] judulWisata = {
            "Pantai Losari",
            "Benteng Rotterdam"
    };

    private static String[] asalWisata = {
            "Makassar, Sulawesi Selatan",
            "Makassar, Sulawesi Selatan"
    };

    private static String[] detailWisata = {
            "Pantai Losari tentu sudah tidak asing lagi, terutama bagi warga Makassar dan sekitarnya. Pantai yang berlokasi di sebelah barat kota Makassar ini sudah menjadi ikon dari Makassar dan merupakan salah satu tempat wisata di Makassar yang paling populer. Pantai Losari tidak hanya menjadi ikon tempat kota Makassar, melainkan juga menjadi destinasi wisata favorit bagi keluarga di makassar dan sekitarnya. Selain itu, Pantai Losari Makassar juga menyuguhkan panorama alam yang menakjubkan. Kemudian, bagi kamu yang ingin berswafoto, pihak pengelola tempat wisata ini juga telah menyediakan berbagai spot foto yang unik.\n" +
                    "\n" +
                    "Kemudian di tempat ini juga memiliki Masjib bernama Amirul Mukminin, masjid ini sepintas tampak seperti mengapung diatas perairan Pantai Losari Makassar. Masjid tersebut juga kerap dijadikan sebagai spot foto dalam mengabadikan momen liburan keluarga. Kemegahan Masjib Amirul Mukminin menjadi salah satu daya tarik yang dimiliki tempat wisata ini.\n",
            "Fort Rotterdam atau Benteng Ujung Pandang (Jum Pandang) adalah sebuah benteng peninggalan Kerajaan Gowa-Tallo. Letak benteng ini berada di pinggir pantai sebelah barat Kota Makassar, Sulawesi Selatan.\n" +
                    "Benteng ini dibangun pada tahun 1545 oleh Raja Gowa ke-9 yang bernama I manrigau Daeng Bonto Karaeng Lakiung . Awalnya benteng ini berbahan dasar tanah liat, namun pada masa pemerintahan Raja Gowa ke-14 Sultan Alauddin konstruksi benteng ini diganti menjadi batu padas yang bersumber dari Pegunungan Karst yang ada di daerah Maros. Benteng Ujung Pandang ini berbentuk seperti seekor penyu yang hendak merangkak turun ke lautan. Dari segi bentuknya sangat jelas filosofi Kerajaan Gowa, bahwa penyu dapat hidup di darat maupun di laut. Begitu pun dengan Kerajaan Gowa yang berjaya di daratan maupun di lautan.[1]\n" +
                    "Nama asli benteng ini adalah Benteng Ujung Pandang, biasa juga orang Gowa-Makassar menyebut benteng ini dengan sebutan Benteng Panyyua yang merupakan markas pasukan katak Kerajaan Gowa. Kerajaan Gowa-Tallo akhirnya menandatangani perjanjian Bungayya yang salah satu pasalnya mewajibkan Kerajaan Gowa untuk menyerahkan benteng ini kepada Belanda. Pada saat Belanda menempati benteng ini, nama Benteng Ujung Pandang diubah menjadi Fort Rotterdam. Cornelis Speelman sengaja memilih nama Fort Rotterdam untuk mengenang daerah kelahirannya di Belanda. Benteng ini kemudian digunakan oleh Belanda sebagai pusat penampungan rempah-rempah di Indonesia bagian timur.\n"
    };

    public static ArrayList<ViewModelWisataBanyak> getListData() {
        ArrayList<ViewModelWisataBanyak> list = new ArrayList<>();
        for (int position = 0; position < gambarWisata.length; position++) {
            ViewModelWisataBanyak model = new ViewModelWisataBanyak();
            model.setGambarWisata(gambarWisata[position]);
            model.setJudulWisata(judulWisata[position]);
            model.setAsalWisata(asalWisata[position]);
            model.setDetailWisata(detailWisata[position]);
            list.add(model);
        }
        return list;
    }
}
