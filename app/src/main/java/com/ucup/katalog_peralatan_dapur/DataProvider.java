package com.ucup.katalog_peralatan_dapur;

import android.content.Context;

import com.ucup.katalog_peralatan_dapur.Model.Katalog;
import com.ucup.katalog_peralatan_dapur.Model.Elektronik;

import java.util.ArrayList;
import java.util.List;

import com.ucup.katalog_peralatan_dapur.Model.Non_Elektronik;


public class DataProvider {
    private static List <Katalog> katalogs = new ArrayList<>();

    private static List<Elektronik> initDataelektronik(Context ctx) {
        List<Elektronik> elektroniks = new ArrayList<>();
        elektroniks.add(new Elektronik("Blender", "245.000",
                "Sebuah wadah dilengkapi pisau berputar yang digunakan untuk mengaduk, mencampur, menggiling, atau melunakkan bahan makanan", R.drawable.e1));
        elektroniks.add(new Elektronik("Dispenser", "300.000",
                "Sebuah mesin yang digunakan untuk mendinginkan, dan meyimpan air dengan ukuran kulkas", R.drawable.e2));
        elektroniks.add(new Elektronik("Kulkas", "2.800.000",
                "Sebuah mesin yang untuk menolong pengawetan makanan, dan menggunakan pompa panas pengubah fase beroperasi dalam sebuah putaran refrigeration", R.drawable.e3));
        elektroniks.add(new Elektronik("mesin cuci", "2.500.000",
                "Sebuah mesin yang dirancang untuk membersihkan pakaian, dantekstil rumah tangga lainnya seperti handuk dan sprei", R.drawable.e4));
        elektroniks.add(new Elektronik("microwave", "1.800.000",
                "Sebuah mesin yang menggunakan listrik dan radiasi gelombang, mikro untuk memasak atau memanaskan makanan ", R.drawable.e5));
        elektroniks.add(new Elektronik("mixer", "1.000.000",
                "Sebuah mesin mekanis yang digunakan untuk mencampur bahan adonan, yang biasanya digunakan untuk pembuatan kue", R.drawable.e6));
        elektroniks.add(new Elektronik("pemanggang roti", "1.500.000",
                "Sebuah mesin yangdigunakan untuk, membuat roti panggang", R.drawable.e7));
        return elektroniks;
    }

    private static List <Non_Elektronik> initDatanonelektronik(Context ctx) {
        List<Non_Elektronik> non_elektroniks = new ArrayList<>();
        non_elektroniks.add(new Non_Elektronik("gelas kaca", ".100.000",
                "merupakan peralatan dapur yang terbuat dari bahan kaca yang umumnya berat", R.drawable.non1));
        non_elektroniks.add(new Non_Elektronik("kompor gas", "2.000.000 ",
                "merupakan peralatan dapur yang terbuat dari besi baja yang tipis dan ringan", R.drawable.non2));
        non_elektroniks.add(new Non_Elektronik("panci", "150.000",
                "merupakan peralatan dapur yang terbuat dari logam,besi,aluminium, dan berbentuk silinder atau mengecil pada bagian bawahnya ", R.drawable.non3));
        non_elektroniks.add(new Non_Elektronik("parutan", "40.000",
                "merupakan peralatan dapur yang yang terbuat dari besi ,aluminium, yang digunakan untuk memarut makanan menjadi potongan halus", R.drawable.non4));
        non_elektroniks.add(new Non_Elektronik("piring ", "800.000",
                "merupakan peralatan dapur yang terbuat dari kaca,besi,kawat, yang digunakan untuk menaruh makanan", R.drawable.non5));
        non_elektroniks.add(new Non_Elektronik("pisau", "100.000",
                "merupakan peralatan dappur yang terbuat dari besi,baja,aluminium, yang digunakan untuk memotong bahan - bahan makanan ", R.drawable.non6));
        non_elektroniks.add(new Non_Elektronik("wajan", "500.000",
                "merupakan peralatan dapur yang terbuat dari stainless stell, yang digunakan untuk memasak atau menggoreng bahan makanan yang menggunakan minyak", R.drawable.non7));
        return non_elektroniks;
    }

    private static void initAllKatalogs(Context ctx) {
        katalogs.addAll(initDataelektronik(ctx));
        katalogs.addAll(initDatanonelektronik(ctx));
    }

    public static List<Katalog> getAllKatalog(Context ctx) {
        if (katalogs.size() == 0) {
            initAllKatalogs(ctx);
        }
        return  katalogs;
    }

    public static List<Katalog> getKatalogByTipe(Context ctx, String jenis) {
        List<Katalog> katalogsByType = new ArrayList<>();
        if (katalogs.size() == 0) {
            initAllKatalogs(ctx);
        }
        for (Katalog h : katalogs) {
            if (h.getJenis().equals(jenis)) {
                katalogsByType.add(h);
            }
        }
        return katalogsByType;
    }

}
