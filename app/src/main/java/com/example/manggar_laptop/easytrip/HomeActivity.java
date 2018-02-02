package com.example.manggar_laptop.easytrip;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_dasboard);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        //inisialisai tombol pada dasboard
        Button btnwisata = (Button) findViewById(R.id.btnWisata);
        Button btnhotel = (Button) findViewById(R.id.btnHotel);
        Button btnlogin = (Button) findViewById(R.id.btnLogin);
        Button btnfeedback = (Button) findViewById(R.id.btnFeedback);
        Button btnshare = (Button) findViewById(R.id.btnSetting);
        Button btnabout = (Button) findViewById(R.id.btnAbout);

        //start aksi tombol
        btnwisata.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(HomeActivity.this, "Tombol Wisata",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(),UserWIsataActivity.class);
                startActivity(i);
            }});

        btnhotel.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(HomeActivity.this, "Tombol Hotel",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(),UserHotelActivity.class);
                startActivity(i);
            }});
        btnlogin.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(HomeActivity.this, "Tombol Login",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(i);
            }});
        btnabout.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(HomeActivity.this, "Tombol About",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(),AboutActivity.class);
                startActivity(i);
            }});
        btnfeedback.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(HomeActivity.this, "Tombol Maps",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(),MapsActivity.class);
                startActivity(i);
            }});

        btnshare.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(HomeActivity.this, "Tombol Share",Toast.LENGTH_SHORT).show();
                Intent sharingIntent;
                sharingIntent =   new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,   "Download Aplikasi Travel Apps");
                String shareMessage = "Klik Link Untuk Download Aplikasi \n http://www.mediafire.com/download/jq1ks6e46bvm6el/EasyTrip.apk";
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT,   shareMessage);
                startActivity(Intent.createChooser(sharingIntent,   "Share Via"));
            }});
    }
}
