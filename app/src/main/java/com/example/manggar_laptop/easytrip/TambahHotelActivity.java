package com.example.manggar_laptop.easytrip;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.manggar_laptop.easytrip.model.hotel;
import com.example.manggar_laptop.easytrip.model.wisata;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TambahHotelActivity extends AppCompatActivity {
    EditText TxtNamaHotel,TxtHarga,TxtAlamat;
    Button BtnTambah, BtnKembali;
    DatabaseReference databaseHotelMalang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_hotel);

        databaseHotelMalang = FirebaseDatabase.getInstance().getReference("hotel");

        TxtNamaHotel = (EditText) findViewById(R.id.txtNamaHotel);
        TxtHarga= (EditText) findViewById(R.id.txtHarga1);
        TxtAlamat= (EditText) findViewById(R.id.txtAlamat1);
        BtnTambah = (Button) findViewById(R.id.btnTambah);

        BtnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveMenu();
                Intent i = new Intent(getApplicationContext(),HotelActivity.class);
                startActivity(i);
            }
        });
        BtnKembali = (Button) findViewById(R.id.btnKembali);
        BtnKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),HomeActivity.class);
                startActivity(i);
            }
        });
    }
    public void saveMenu(){
        if (!TextUtils.isEmpty(TxtNamaHotel.toString()) && !TextUtils.isEmpty(TxtHarga.toString()) && !TextUtils.isEmpty(TxtAlamat.toString())){
            String idHotel = databaseHotelMalang.push().getKey();
            hotel hotelku= new hotel (idHotel,TxtNamaHotel.getText().toString(),TxtHarga.getText().toString(),TxtAlamat.getText().toString());
            databaseHotelMalang.child(idHotel).setValue(hotelku);
            Toast.makeText(this, "Menu Berhasil Ditambahkan",Toast.LENGTH_SHORT).show();
            Intent i = new Intent(getApplication(),HotelActivity.class);
            startActivity(i);
        }else{
            Toast.makeText(this, "Menu Gagal Ditambahkan",Toast.LENGTH_SHORT).show();
        }
    }
}