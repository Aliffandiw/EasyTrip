package com.example.manggar_laptop.easytrip;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;

public class UserDetailWisataActivity extends AppCompatActivity {

    TextView TxtNamaWIsata, TxtLokasi, TxtTiket;
    Button BtnMap;
    DatabaseReference databaseWisata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail_wisata);

        TxtNamaWIsata = (TextView) findViewById(R.id.txtNamaWisata);
        TxtLokasi = (TextView) findViewById(R.id.txtLokasi);
        TxtTiket = (TextView) findViewById(R.id.txtTiket);

        //BtnUpdate = (Button) findViewById(R.id.btnUpdate2);
        //BtnDelete = (Button) findViewById(R.id.btnDelete2);

        BtnMap = (Button) findViewById(R.id.btnMap6);

        Intent i = getIntent();
        final String idWisata = i.getStringExtra("idWisata");
        final String namaWisata = i.getStringExtra("namaWisata");
        final String lokasi = i.getStringExtra("lokasi");
        final String tiket = i.getStringExtra("tiket");

        TxtNamaWIsata.setText(namaWisata);
        TxtLokasi.setText(lokasi);
        TxtTiket.setText(tiket);

        BtnMap.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(UserDetailWisataActivity.this, "Tombol Maps",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(),MapsActivity.class);
                startActivity(i);
            }});
    }
}
