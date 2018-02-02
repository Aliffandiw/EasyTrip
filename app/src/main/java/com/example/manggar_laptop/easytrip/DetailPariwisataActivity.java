package com.example.manggar_laptop.easytrip;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DetailPariwisataActivity extends AppCompatActivity {
    TextView TxtNamaWIsata, TxtLokasi, TxtTiket;
    Button BtnUpdate, BtnDelete;
    DatabaseReference databaseWisata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pariwisata);

        TxtNamaWIsata = (TextView) findViewById(R.id.txtNamaWisata);
        TxtLokasi = (TextView) findViewById(R.id.txtLokasi);
        TxtTiket = (TextView) findViewById(R.id.txtTiket);

        BtnUpdate = (Button) findViewById(R.id.btnUpdate2);
        BtnDelete = (Button) findViewById(R.id.btnDelete2);

        Intent i = getIntent();
        final String idWisata = i.getStringExtra("idWisata");
        final String namaWisata = i.getStringExtra("namaWisata");
        final String lokasi = i.getStringExtra("lokasi");
        final String tiket = i.getStringExtra("tiket");

        TxtNamaWIsata.setText(namaWisata);
        TxtLokasi.setText(lokasi);
        TxtTiket.setText(tiket);

        BtnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseWisata = FirebaseDatabase.getInstance().getReference("wisata").child(idWisata);
                databaseWisata.removeValue();
                Toast.makeText(DetailPariwisataActivity.this,"Wisata Telah dihapus", Toast.LENGTH_SHORT).show();
                Intent p = new Intent(getApplicationContext(),WisataActivity.class);
                startActivity(p);
            }
        });

        BtnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),UpdateWIsataActivity.class);
                i.putExtra("idWisata",idWisata);
                i.putExtra("namaWisata",namaWisata);
                i.putExtra("lokasi",lokasi);
                i.putExtra("tiket",tiket);
                startActivity(i);
            }
        });
    }
}

