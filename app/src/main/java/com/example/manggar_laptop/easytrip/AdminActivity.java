package com.example.manggar_laptop.easytrip;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

public class AdminActivity extends AppCompatActivity {

    Button BtnWisata,BtnHotel, BtnLogout;
    DatabaseReference databasePasien;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        firebaseAuth = FirebaseAuth.getInstance();

        if (firebaseAuth.getCurrentUser() == null){
            finish();
            startActivity(new Intent(getApplicationContext(),LoginActivity.class));
        }

        BtnWisata = (Button) findViewById(R.id.btnWisata);
        BtnWisata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),WisataActivity.class);
                startActivity(i);
            }
        });

        BtnHotel = (Button) findViewById(R.id.btnHotel);
        BtnHotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),HotelActivity.class);
                startActivity(i);
            }
        });

        BtnLogout= (Button) findViewById(R.id.btnLogout);
        BtnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.signOut();
                finish();
                startActivity(new Intent(getApplicationContext(),HomeActivity.class));
            }
        });
    }
}