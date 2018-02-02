package com.example.manggar_laptop.easytrip;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;

public class UserDetailHotelActivity extends AppCompatActivity {
    TextView TxtNamaHotel, TxtAlamat, TxtHarga;
    Button BtnMap;
    DatabaseReference databaseHotel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail_hotel);

        TxtNamaHotel = (TextView) findViewById(R.id.txtNamaHotel);
        TxtAlamat = (TextView) findViewById(R.id.txtAlamat);
        TxtHarga = (TextView) findViewById(R.id.txtHarga);

        //BtnUpdate = (Button) findViewById(R.id.btnUpdate3);
       BtnMap = (Button) findViewById(R.id.btnMap3);

        Intent i = getIntent();
        final String idHotel = i.getStringExtra("idHotel");
        final String namaHotel = i.getStringExtra("namaHotel");
        final String alamat = i.getStringExtra("alamat");
        final String harga = i.getStringExtra("harga");

        TxtNamaHotel.setText(namaHotel);
        TxtAlamat.setText(alamat);
        TxtHarga.setText(harga);

        BtnMap.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(UserDetailHotelActivity.this, "Tombol Maps",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(),MapsActivity.class);
                startActivity(i);
            }});
    }
}
