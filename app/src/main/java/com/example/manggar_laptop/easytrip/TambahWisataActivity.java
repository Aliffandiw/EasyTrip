package com.example.manggar_laptop.easytrip;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.manggar_laptop.easytrip.model.wisata;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TambahWisataActivity extends AppCompatActivity {
    EditText TxtNamaWisata,TxtTiket,TxtLokasi;
    Button BtnTambah, BtnKembali;
    DatabaseReference databaseWisataMalang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_wisata);

        databaseWisataMalang = FirebaseDatabase.getInstance().getReference("wisata");

        TxtNamaWisata = (EditText) findViewById(R.id.txtNamaWisata);
        TxtTiket= (EditText) findViewById(R.id.txtTiket);
        TxtLokasi= (EditText) findViewById(R.id.txtLokasi);
        BtnTambah = (Button) findViewById(R.id.btnTambah);

        BtnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveMenu();
                Intent i = new Intent(getApplicationContext(),WisataActivity.class);
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
        if (!TextUtils.isEmpty(TxtNamaWisata.toString()) && !TextUtils.isEmpty(TxtTiket.toString()) && !TextUtils.isEmpty(TxtLokasi.toString())){
            String idWisata = databaseWisataMalang.push().getKey();
            wisata wisataku= new wisata (idWisata,TxtNamaWisata.getText().toString(),TxtTiket.getText().toString(),TxtLokasi.getText().toString());
            databaseWisataMalang.child(idWisata).setValue(wisataku);
            Toast.makeText(this, "Menu Berhasil Ditambahkan",Toast.LENGTH_SHORT).show();
            Intent i = new Intent(getApplication(),WisataActivity.class);
            startActivity(i);
        }else{
            Toast.makeText(this, "Menu Gagal Ditambahkan",Toast.LENGTH_SHORT).show();
        }
    }
}
