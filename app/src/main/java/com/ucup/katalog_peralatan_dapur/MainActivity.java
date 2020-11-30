package com.ucup.katalog_peralatan_dapur;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton btnElektronik,btnNonelektronik;
    public static final String JENIS_GALERI_KEY = "JENIS_GALERI";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inisialisasiView();

    }

    private void inisialisasiView() {
        btnElektronik = findViewById(R.id.btn_buka_Elektronik);
        btnNonelektronik = findViewById(R.id.btn_buka_Non_Elektronik);
        btnElektronik.setOnClickListener(view -> bukaGaleri("Elektronik"));
        btnNonelektronik.setOnClickListener(view -> bukaGaleri("Non_Elektronik"));
    }

    private void bukaGaleri(String jenisKatalog) {
        Log.d("MAIN","Buka activity Elektronik");
        Intent intent = new Intent(this, GaleriActivity.class);
        intent.putExtra(JENIS_GALERI_KEY, jenisKatalog);
        startActivity(intent);
    }

}