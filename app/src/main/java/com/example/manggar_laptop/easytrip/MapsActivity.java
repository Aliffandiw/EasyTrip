package com.example.manggar_laptop.easytrip;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng malang = new LatLng(-7.946636, 112.615271);
        mMap.addMarker(new MarkerOptions().position(malang).title("Office of EasyTrip Kota Malang "));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(malang));

        //
        LatLng HawaiWaterPark = new LatLng( -7.923292, 112.658205);
        mMap.addMarker(new MarkerOptions().position(HawaiWaterPark).title("Hawai Water Park"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(HawaiWaterPark));

        LatLng Alun2Malang = new LatLng( -7.982610, 112.630852);
        mMap.addMarker(new MarkerOptions().position(Alun2Malang).title("Alun-Alun Kota Malang"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Alun2Malang));

        //HOTEL

        LatLng HotelSavana = new LatLng( -7.9621142, 112.6339703);
        mMap.addMarker(new MarkerOptions().position(HotelSavana).title("Hotel Savana Kota Malang"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(HotelSavana));

        LatLng HotelEveryday = new LatLng( -7.9494602, 112.614577);
        mMap.addMarker(new MarkerOptions().position(HotelEveryday).title("EveryDay Smart Hotel Kota Malang"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(HotelEveryday));

        LatLng HotelSahidMontana = new LatLng( -7.976965, 112.6300262);
        mMap.addMarker(new MarkerOptions().position(HotelSahidMontana).title("Hotel Sahid Montana Kota Malang"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(HotelSahidMontana));
    }
}
