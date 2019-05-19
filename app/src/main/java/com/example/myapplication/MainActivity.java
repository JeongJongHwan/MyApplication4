package com.example.myapplication;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getFragmentManager();
        MapFragment mapFragment = (MapFragment)fragmentManager.findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(final GoogleMap map) {

        LatLng POINT = new LatLng(35.945282, 126.6821529);

        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(POINT);
        markerOptions.title("군산");
        markerOptions.snippet("국립군산대학교");
        map.addMarker(markerOptions);

        map.moveCamera(CameraUpdateFactory.newLatLng(POINT));
        map.animateCamera(CameraUpdateFactory.zoomTo(15));
    }



}