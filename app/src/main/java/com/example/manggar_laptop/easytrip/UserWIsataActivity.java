package com.example.manggar_laptop.easytrip;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.manggar_laptop.easytrip.adapter.WisataAdapter;
import com.example.manggar_laptop.easytrip.adapter.WisataUserAdapter;
import com.example.manggar_laptop.easytrip.model.wisata;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class UserWIsataActivity extends AppCompatActivity {

    private WisataUserAdapter mAdapter;
    private List<wisata> mDaftarWisata= new ArrayList<>();
    DatabaseReference databaseWisata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_wisata);

        final RecyclerView recyclerMenu = (RecyclerView) findViewById(R.id.rvWisata);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerMenu.setLayoutManager(mLayoutManager);
//        recyclerMenu.setItemAnimator(new DefaultItemAnimator());
//        recyclerMenu.setAdapter(mAdapter);
//        mAdapter.notifyDataSetChanged();

        databaseWisata = FirebaseDatabase.getInstance().getReference();
        databaseWisata.child("wisata").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                mDaftarWisata= new ArrayList<>();
                for (DataSnapshot noteDataSnapshot : dataSnapshot.getChildren()) {
                    wisata Wisata= noteDataSnapshot.getValue(wisata.class);
                    Wisata.setId_wisata(noteDataSnapshot.getKey());
                    mDaftarWisata.add(Wisata);
                }
                mAdapter = new WisataUserAdapter(UserWIsataActivity.this,mDaftarWisata);
                recyclerMenu.setAdapter(mAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println(databaseError.getDetails()+" "+databaseError.getMessage());
            }
        });
    }
}
