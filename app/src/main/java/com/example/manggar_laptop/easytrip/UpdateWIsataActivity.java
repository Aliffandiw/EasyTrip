package com.example.manggar_laptop.easytrip;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.manggar_laptop.easytrip.model.wisata;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UpdateWIsataActivity extends AppCompatActivity {
    EditText TxtNamaWisataUpdate,TxtLokasiUpdate,TxtTiketUpdate;
    Button BtnUpdate, BtnKembaliUpdate;
    DatabaseReference databaseWisataMalang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_wisata);

            Intent i = getIntent();
            final String idWisata = i.getStringExtra("idWisata");
            final String namaWisata= i.getStringExtra("namaWisata");
            final String lokasi = i.getStringExtra("lokasi");
            final String tiket = i.getStringExtra("tiket");

            TxtNamaWisataUpdate = (EditText) findViewById(R.id.txtNamaWisataUpdate);
            TxtLokasiUpdate = (EditText) findViewById(R.id.txtLokasiUpdate);
            TxtTiketUpdate = (EditText) findViewById(R.id.txtTiketUpdate);

            TxtNamaWisataUpdate.setText(namaWisata);
            TxtLokasiUpdate.setText(lokasi);
            TxtTiketUpdate.setText(tiket);

            BtnUpdate = (Button) findViewById(R.id.btnUpdate);
            BtnKembaliUpdate = (Button) findViewById(R.id.btnKembaliUpdate);

            BtnKembaliUpdate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent a = new Intent(getApplicationContext(),WisataActivity.class);
                    startActivity(a);
                }
            });

        BtnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseWisataMalang = FirebaseDatabase.getInstance().getReference("wisata").child(idWisata);
                wisata wisataMu = new wisata(idWisata,TxtNamaWisataUpdate.getText().toString(),TxtLokasiUpdate.getText().toString(),TxtTiketUpdate.getText().toString());
                databaseWisataMalang.setValue(wisataMu);
                Toast.makeText(UpdateWIsataActivity.this,"Wisata berhasil di update.", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(),WisataActivity.class);
                startActivity(i);
            }
        });
    }
}
