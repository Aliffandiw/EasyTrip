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

public class DetailHotelActivity extends AppCompatActivity {
    TextView TxtNamaHotel, TxtAlamat, TxtHarga;
    Button BtnUpdate, BtnDelete;
    DatabaseReference databaseHotel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_hotel);

        TxtNamaHotel = (TextView) findViewById(R.id.txtNamaHotel);
        TxtAlamat = (TextView) findViewById(R.id.txtAlamat);
        TxtHarga = (TextView) findViewById(R.id.txtHarga);

        BtnUpdate = (Button) findViewById(R.id.btnUpdate3);
        BtnDelete = (Button) findViewById(R.id.btnDelete3);

        Intent i = getIntent();
        final String idHotel = i.getStringExtra("idHotel");
        final String namaHotel = i.getStringExtra("namaHotel");
        final String alamat = i.getStringExtra("alamat");
        final String harga = i.getStringExtra("harga");

        TxtNamaHotel.setText(namaHotel);
        TxtAlamat.setText(alamat);
        TxtHarga.setText(harga);

        BtnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHotel = FirebaseDatabase.getInstance().getReference("hotel").child(idHotel);
                databaseHotel.removeValue();
                Toast.makeText(DetailHotelActivity.this,"Hotel Telah dihapus", Toast.LENGTH_SHORT).show();
                Intent p = new Intent(getApplicationContext(),HotelActivity.class);
                startActivity(p);
            }
        });

        BtnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),UpdateHotelActivity.class);
                i.putExtra("idHotel",idHotel);
                i.putExtra("namaHotel",namaHotel);
                i.putExtra("alamat",alamat);
                i.putExtra("harga",harga);
                startActivity(i);
            }
        });
    }
}
