package com.inreadyworkgroup.drtravel_beta.ui.home.cardmenu.datamenu;

import com.inreadyworkgroup.drtravel_beta.R;
import com.inreadyworkgroup.drtravel_beta.ui.home.cardmenu.viewmodelmenu.ViewModelMenuAtas;
import com.inreadyworkgroup.drtravel_beta.ui.home.cardmenu.viewmodelmenu.ViewModelMenuBawah;

import java.util.ArrayList;

public class Datamenubawah {
    private static int[] gambarKuliner = {
            R.drawable.palekko,
            R.drawable.kapurung,
            R.drawable.konro,
            R.drawable.sop_sodara
    };

    private static String[] judulKuliner = {
            "Palekko",
            "Kapurung",
            "konro",
            "Sop Sodara"
    };

    private static String[] asalKuliner = {
            "Pinrang, Sulawesi Selatan",
            "Palopo, Sulawesi Selatan",
            "Makassar, Sulawesi Selatan",
            "Pangkep, Sulawesi Selatan"
    };

    private static String[] detailKuliner = {
            "Nasu Palekko adalah salah satu kuliner khas suku Bugis yang terbuat dari Daging Bebek yang dipotong-potong kecil seperti dicincang, atau disebut Daging Bebek Cincang. Dimana dalam proses pembuatannya, daging bebek yang sudah disembelih dan dikuliti serta dicincang lalu dicuci bersih. Kemudian diberi cuka atau jeruk nipis untuk menghilangkan bau amis-nya.",
            "Namanya Kapurung, sebuah makanan berkuah dengan rasa sedikit asam namun sangat menyegarkan. Kuliner ini merupakan makanan khas tradisional dari Palopo, khususnya masyarakat Desa Luwu.\n" +
                    "Cara membuatnya cukup mudah, yang perlu disiapkan adalah sagu asli atau tepung sagu yang nantinya akan dilarutkan menggunakan air panas.\n",
            "Sup Konro adalah masakan sup iga sapi khas Indonesia yang berasal dari tradisi Bugis dan Makassar. Sup ini biasanya dibuat dengan bahan iga sapi atau daging sapi. Masakan berkuah warna coklat kehitaman ini biasa dimakan dengan burasa dan ketupat yang dipotong-potong terlebih dahulu.",
            "Sop saudara merupakan masakan khas dari Sulawesi Selatan berupa hidangan berkuah dengan bahan dasar daging sapi yang biasanya disajikan bersama bahan pelengkap seperti bihun, perkedel kentang, jeroan sapi (misalnya, paru goreng), dan telur rebus. Masakan ini umum dikonsumsi bersama dengan nasi putih dan ikan bolu (bandeng) bakar."
    };

    private static int[] gambarPenginapan  = {
            R.drawable.wisata_atas,
            R.drawable.permata_indah,
            R.drawable.pondok_lembah_biru,
            R.drawable.hotel_pantai_gapura
    };

    private static String[] judulPenginapan = {
            "Paduppa Resort",
            "Permata Indah",
            "Pondok Lembah Biru",
            "Hotel Pantai Gapura"
    };

    private static String[] asalPenginapan = {
            "Bulukumba, Sulawesi Selatan",
            "Malino, Sulawesi Selatan",
            "Malino, Sulawesi Selatan",
            "Makassar, Sulawesi Selatan"
    };

    private static String[] detailPenginapan = {
            "Bagus pengantin baru liburan di sini",
            "Kolam renangnya mantap bro",
            "Satu lagi tempat wisata di Malino yang patut anda kunjungi yakni Lembah Biru Malino. Keindahan tempat ini tak perlu kalian ragukan lagi, secara tempat ini telah banyak dikunjungi oleh para wisatawan. Pemandangan alamnya yang asri serta udaranya sejuk membuat pengunjung merasa betah untuk berlama-lama. Hanya saja cuaca disana begitu dingin, membuat kita enggan untuk mandi.\n" +
                    "Di Lembah Biru Malino terdapat fasilitas kolam renang, tapi anda jangan langsung terjun dan mandi begitu saja soalnya airnya sangat dingin. Mungkin perlu adaptasi agar bisa menyesuaikan kondisi dinginnya. Yang sudah terbiasa dengan dinginnya tak mengapa kalian langsung menikmati mandi di kolam renang Lembah Biru Malino.\n" +
                    "Tempat ini sangat cocok buat keluarga, selain memiliki fasilitas kolam renang yang airnya berasal dari pegunungan, juga pemandangan disekitarnya dihinggapi banyak pepohonan-pepohonan sehingga kesejukan alam sekitarnya begitu terasa. Sangat disayangkan jika kalian tidak menyempatkan diri untuk singgah ditempat ini.\n",
            "Pantai Gapura Hotel Makassar adalah tempat yang disarankan untuk Anda yang ingin menikmati keindahan dari matahari yang terbenam. Selain tempat untuk berlibur, Pantai Gapura Hotel Makassar adalah tempat yang banyak dipilih sebagai tempat untuk berbisnis. Pantai Gapura Hotel Makassar akan memberi pengetahuan tentang sejarah singkat Fort Rotterdam. Dengan desain yang menarik menggunakan kayu, akan menciptakan suasana yang sangat nyaman dan tak terlupakan bagi Anda."
    };

    private static int[] gambarMasjid = {
            R.drawable.masjid_raya_mks,
            R.drawable.masjid_agung_gowa,
            R.drawable.masjid_datotiro,
            R.drawable.masjid_terapung
    };

    private static String[] judulMasjid = {
            "Masjid Raya Makassar",
            "Masjid Agung Gowa",
            "Masjid Dato Tiro",
            "Masjid Terapung"
    };

    private static String[] asalMasjid = {
            "Makassar, Sulawesi Selatan",
            "Gowa, Sulawesi Selatan",
            "Bulukumba, Sulawesi Selatan",
            "Makassar, Sulawesi Selatan"
    };

    private static String[] detailMasjid = {
            "Masjid Raya Makassar merupakan sebuah masjid yang terletak di Makassar, Indonesia. Masjid ini dibangun pada tahun 1948 dan selesai pada tahun 1949. Masjid ini mengalami renovasi dari tahun 1999 hingga tahun 2005. Pertama kali dirancang oleh arsitek Muhammad Soebardjo setelah memenangi sayembara yang digelar panitia pembangunan masjid raya. Masjid ini dapat menampung hingga 10.000 jamaah.\n" +
                    "Mesjid dua lantai di Jl. Bulusaraung ini menggunakan bahan bangunan sekitar 80 persen dari bahan baku lokal, memiliki dua menara setinggi 66,66 meter, daya tampung 10.000 jamaah dan fasilitas berupa perpustakaan, kantor Majelis Ulama Indonesia (MUI) Sulawesi Selatan.\n",
            "Salah satu rumah ibadah yang sudah mulai difungsikan yakni Masjid Agung Syekh Yusuf, yang merupakan masjid kebanggaan masyarakat Kabupaten Gowa.",
            "Bulukumba memiliki berbagai wisata alam pantai yang begitu memukau. Disana juga terdapat berbagai wisata lainnya yang menarik para wisatawan lokal maupun mancanegara. Bulukumba juga memiliki sebuah bangunan Masjid yang begitu megah. Masjid tersebut bernama masjid Islamic Center Dato Tiro Bulukumba. Masjid tersebut sudah ada sejak tahun 2014 kemarin. Nama masjid tersebut diambil sebagai penghormatan besar terhadap salah satu tokoh penyebar Islam di kawasan Bulukumba. Atas jasanya yang begitu mulia dalam menyebarkan agama serta ajaran islam, nama beliau diabadikan dalam sebuah bangunan tempat beribadah umat muslim Bulukumba dan untuk masyarakat Sulawesi Selatan umumnya.",
            "Masjid Terapung"
    };

    public static ArrayList<ViewModelMenuBawah> getListDataKuliner() {
        ArrayList<ViewModelMenuBawah> list = new ArrayList<>();
        for (int position = 0; position < gambarKuliner.length; position++) {
            ViewModelMenuBawah model = new ViewModelMenuBawah();
            model.setGambarMenuBawah(gambarKuliner[position]);
            model.setTvMenuBawah(judulKuliner[position]);
            model.setAsalMenuBawah(asalKuliner[position]);
            model.setDetailMenuBawah(detailKuliner[position]);
            list.add(model);
        }
        return list;
    }

    public static ArrayList<ViewModelMenuBawah> getListDataPenginapan() {
        ArrayList<ViewModelMenuBawah> list = new ArrayList<>();
        for (int position = 0; position < gambarPenginapan.length; position++) {
            ViewModelMenuBawah model = new ViewModelMenuBawah();
            model.setGambarMenuBawah(gambarPenginapan[position]);
            model.setTvMenuBawah(judulPenginapan[position]);
            model.setAsalMenuBawah(asalPenginapan[position]);
            model.setDetailMenuBawah(detailPenginapan[position]);
            list.add(model);
        }
        return list;
    }

    public static ArrayList<ViewModelMenuBawah> getListDataMasjid() {
        ArrayList<ViewModelMenuBawah> list = new ArrayList<>();
        for (int position = 0; position < gambarMasjid.length; position++) {
            ViewModelMenuBawah model = new ViewModelMenuBawah();
            model.setGambarMenuBawah(gambarMasjid[position]);
            model.setTvMenuBawah(judulMasjid[position]);
            model.setAsalMenuBawah(asalMasjid[position]);
            model.setDetailMenuBawah(detailMasjid[position]);
            list.add(model);
        }
        return list;
    }
}
