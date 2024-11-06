package com.tecmilenio.tema13;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener, GoogleMap.OnMapLongClickListener {

    TextView etLati, etLong;
    GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        etLati = (TextView) findViewById(R.id.etLati);
        etLong = (TextView) findViewById(R.id.etLong);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        map = googleMap;
        this.map.setOnMapClickListener(this);
        this.map.setOnMapLongClickListener(this);

        setValues(19.8077463, -99.4077038);

        LatLng mexico = new LatLng(19.8077463, -99.4077038);
        map.addMarker(new MarkerOptions().position(mexico).title("Mexico"));
        map.moveCamera(CameraUpdateFactory.newLatLng(mexico));
    }

    @Override
    public void onMapClick(@NonNull LatLng latLng) {
        //System.out.println("sara onMapClick: "+ latLng.latitude);
        //System.out.println("sara onMapClick: "+ latLng.longitude);

        map.clear();
        LatLng mexico = new LatLng(latLng.latitude, latLng.longitude);
        map.addMarker(new MarkerOptions().position(mexico).title("Mexico"));
        map.moveCamera(CameraUpdateFactory.newLatLng(mexico));

        setValues(latLng.latitude, latLng.longitude);
    }

    @Override
    public void onMapLongClick(@NonNull LatLng latLng) {
        //System.out.println("sara onMapLongClick: "+ latLng.latitude);
        //System.out.println("sara onMapLongClick: "+ latLng.longitude);

        map.clear();
        LatLng mexico = new LatLng(latLng.latitude, latLng.longitude);
        map.addMarker(new MarkerOptions().position(mexico).title("Mexico"));
        map.moveCamera(CameraUpdateFactory.newLatLng(mexico));

        setValues(latLng.latitude, latLng.longitude);
    }

    public void setValues (double lat , double longi ){
        etLong.setText("Longitud :  " + longi);
        etLati.setText("Latitud  :  " + lat);
    }
}