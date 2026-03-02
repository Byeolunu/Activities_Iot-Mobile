package com.example.app;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MapActivity extends AppCompatActivity implements com.google.android.gms.maps.OnMapReadyCallback {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        com.google.android.gms.maps.SupportMapFragment mapFragment = (com.google.android.gms.maps.SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(com.google.android.gms.maps.GoogleMap googleMap) {
        com.google.android.gms.maps.model.LatLng sydney = new com.google.android.gms.maps.model.LatLng(-33.8688, 151.2093);
        googleMap.addMarker(new com.google.android.gms.maps.model.MarkerOptions().position(sydney).title("Marker in Sydney"));
        googleMap.moveCamera(com.google.android.gms.maps.CameraUpdateFactory.newLatLngZoom(sydney, 10));
    }
}