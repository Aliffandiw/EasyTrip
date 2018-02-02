package com.example.manggar_laptop.easytrip;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.manggar_laptop.easytrip.adapter.HotelAdapter;
import com.example.manggar_laptop.easytrip.adapter.WisataAdapter;
import com.example.manggar_laptop.easytrip.model.hotel;
import com.example.manggar_laptop.easytrip.model.wisata;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class HotelActivity extends AppCompatActivity {
    Button BtnTambahHotel;
    private HotelAdapter mAdapter;
    private List<hotel> mDaftarHotel= new ArrayList<>();
    DatabaseReference databaseHotel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel);

        final RecyclerView recyclerMenu = (RecyclerView) findViewById(R.id.rvHotel);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerMenu.setLayoutManager(mLayoutManager);
//        recyclerMenu.setItemAnimator(new DefaultItemAnimator());
//        recyclerMenu.setAdapter(mAdapter);
//        mAdapter.notifyDataSetChanged();

        databaseHotel = FirebaseDatabase.getInstance().getReference();
        databaseHotel.child("hotel").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                mDaftarHotel= new ArrayList<>();
                for (DataSnapshot noteDataSnapshot : dataSnapshot.getChildren()) {
                    hotel Hotel= noteDataSnapshot.getValue(hotel.class);
                    Hotel.setId_hotel(noteDataSnapshot.getKey());
                    mDaftarHotel.add(Hotel);
                }
                mAdapter = new HotelAdapter(HotelActivity.this,mDaftarHotel);
                recyclerMenu.setAdapter(mAdapter);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println(databaseError.getDetails()+" "+databaseError.getMessage());
            }
        });

        BtnTambahHotel = (Button) findViewById(R.id.btnTambahHotel);
        BtnTambahHotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),TambahHotelActivity.class);
                startActivity(i);
            }
        });
    }
}
