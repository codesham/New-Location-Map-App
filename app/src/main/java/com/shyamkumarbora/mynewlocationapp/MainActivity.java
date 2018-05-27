package com.shyamkumarbora.mynewlocationapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    private Button mMapButton,mSatelliteButton,mHybridButton;
    private GoogleMap mGoogleMap;
    Boolean mMapReady = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMapButton = findViewById(R.id.btnMap);
        mSatelliteButton = findViewById(R.id.btnSatellite);
        mHybridButton = findViewById(R.id.btnHybrid);
        mMapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mMapReady){
                    mGoogleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                }
            }
        });
        mSatelliteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mGoogleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
            }
        });
        mHybridButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mGoogleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
            }
        });
        MapFragment mMapFragment = (MapFragment)getFragmentManager().findFragmentById(R.id.map);
        mMapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mGoogleMap = googleMap;
        mMapReady = true;
        LatLng mGuwahati  = new LatLng(26.1445,91.7362);
        CameraPosition mCameraPosition = CameraPosition.builder()
                .target(mGuwahati).zoom(14).build();
        mGoogleMap.moveCamera(CameraUpdateFactory.newCameraPosition(mCameraPosition));
    }
}
