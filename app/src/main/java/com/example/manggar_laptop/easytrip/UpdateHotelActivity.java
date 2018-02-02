package com.example.manggar_laptop.easytrip;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.manggar_laptop.easytrip.model.hotel;
import com.example.manggar_laptop.easytrip.model.wisata;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UpdateHotelActivity extends AppCompatActivity {

    EditText TxtNamaHotelUpdate,TxtAlamatUpdate,TxtHargaUpdate;
    Button BtnUpdate, BtnKembaliUpdate;
    DatabaseReference databaseHotelMalang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_hotel);

        Intent i = getIntent();
        final String idHotel = i.getStringExtra("idHotel");
        final String namaHotel= i.getStringExtra("namaHotel");
        final String alamat = i.getStringExtra("alamat");
        final String harga = i.getStringExtra("harga");

        TxtNamaHotelUpdate = (EditText) findViewById(R.id.txtNamaHotelUpdate);
        TxtAlamatUpdate = (EditText) findViewById(R.id.txtAlamatUpdate);
        TxtHargaUpdate = (EditText) findViewById(R.id.txtHargaUpdate);

        TxtNamaHotelUpdate.setText(namaHotel);
        TxtAlamatUpdate.setText(alamat);
        TxtHargaUpdate.setText(harga);

        BtnUpdate = (Button) findViewById(R.id.btnUpdateHotel);
        BtnKembaliUpdate = (Button) findViewById(R.id.btnKembaliUpdateHotel);

        BtnKembaliUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(getApplicationContext(),HotelActivity.class);
                startActivity(a);
            }
        });

    BtnUpdate.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            databaseHotelMalang = FirebaseDatabase.getInstance().getReference("hotel").child(idHotel);
            hotel hotelMu = new hotel(idHotel,TxtNamaHotelUpdate.getText().toString(),TxtAlamatUpdate.getText().toString(),TxtHargaUpdate.getText().toString());
            databaseHotelMalang.setValue(hotelMu);
            Toast.makeText(UpdateHotelActivity.this,"Hotel berhasil di update.", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(getApplicationContext(),HotelActivity.class);
            startActivity(i);
        }
    });
}
}