package com.ucup.katalog_peralatan_dapur;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ucup.katalog_peralatan_dapur.Model.Katalog;

import java.util.List;

public class GaleriActivity extends AppCompatActivity {

    List<Katalog> katalogs;
    int indeksTampil = 0;
    String jenisKatalog;
    Button btnPertama,btnTerakhir,btnSebelumnya,btnBerikutnya;
    TextView txJenis,txRas ,txAsal,txDeskripsi,txJudul;
    ImageView ivFotoKatalog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_ras);
        Intent intent = getIntent();
        jenisKatalog = intent.getStringExtra(MainActivity.JENIS_GALERI_KEY);
        katalogs = DataProvider.getKatalogByTipe(this,jenisKatalog);
        inisialisasiView();
        tampilkanProfil();
    }

    private void inisialisasiView() {
        btnPertama = findViewById(R.id.btnPertama);
        btnSebelumnya = findViewById(R.id.btnSebelumnya);
        btnBerikutnya = findViewById(R.id.btnBerikutnya);
        btnTerakhir = findViewById(R.id.btnTerakhir);

        btnPertama.setOnClickListener(view -> KatalogPertama());
        btnTerakhir.setOnClickListener(view -> katalogTerakhir());
        btnSebelumnya.setOnClickListener(view -> katalogSebelumnya());
        btnBerikutnya.setOnClickListener(view -> katalogBerikutnya());

        txJenis = findViewById(R.id.txJenis);
        txRas = findViewById(R.id.txRas);
        txAsal = findViewById(R.id.txAsal);
        txDeskripsi = findViewById(R.id.txDeskripsi);
        ivFotoKatalog = findViewById(R.id.gambarKatalog);

        txJudul = findViewById(R.id.txJudul);
        txJudul.setText("Berbagai Macam jenis peralatan dapur "+jenisKatalog);
    }


    private void tampilkanProfil() {
        Katalog k = katalogs.get(indeksTampil);
        Log.d("Elektronik","Menampilkan Elektronik "+k.getJenis());
        txJenis.setText(k.getJenis());
        txRas.setText(k.getRas());
        txAsal.setText(k.getAsal());
        txDeskripsi.setText(k.getDeskripsi());
        ivFotoKatalog.setImageDrawable(this.getDrawable(k.getDrawableRes()));
    }

    private void KatalogPertama() {
        int posAwal = 0;
        if (indeksTampil == posAwal) {
            Toast.makeText(this,"Sudah di posisi pertama",Toast.LENGTH_SHORT).show();
            return;
        } else {
            indeksTampil = posAwal;
            tampilkanProfil();
        }
    }

    private void katalogTerakhir() {
        int posAkhir = katalogs.size() - 1;
        if (indeksTampil == posAkhir) {
            Toast.makeText(this,"Sudah di posisi terakhir",Toast.LENGTH_SHORT).show();
            return;
        } else {
            indeksTampil = posAkhir;
            tampilkanProfil();
        }
    }

    private void katalogSebelumnya() {
        if (indeksTampil == katalogs.size() - 1) {
            Toast.makeText(this,"Sudah di posisi terakhir",Toast.LENGTH_SHORT).show();
            return;
        } else {
            indeksTampil++;
            tampilkanProfil();
        }
    }

    private void katalogBerikutnya() {
        if (indeksTampil == 0) {
            Toast.makeText(this,"Sudah di posisi pertama",Toast.LENGTH_SHORT).show();
            return;
        } else {
            indeksTampil--;
            tampilkanProfil();
        }
    }
}