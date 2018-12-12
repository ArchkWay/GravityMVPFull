package com.example.archek.gravitymvp.mvp.mockmap;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.archek.gravitymvp.R;
import com.example.archek.gravitymvp.mvp.GravityActivity;
import com.example.archek.gravitymvp.net.Mock;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import static java.lang.Double.valueOf;

public class PointMapActivity extends AppCompatActivity implements OnMapReadyCallback {
    /*ger coordinated and launch map with corespond marker*/
    private static final String EXTRA_LATITUDE = "latitude";
    private static final String EXTRA_LONGITUDE = "longitude";
    private static final String EXTRA_NAME = "name";

    public static Intent makeIntent(GravityActivity context, Mock mock) {
        return new Intent(context, PointMapActivity.class)
                .putExtra(PointMapActivity.EXTRA_LATITUDE, mock.getLatitude())
                .putExtra(PointMapActivity.EXTRA_LONGITUDE, mock.getLongitude())
                .putExtra(PointMapActivity.EXTRA_NAME, mock.getName());
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_point_map);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        assert mapFragment != null;
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        googleMap.setMapType( GoogleMap.MAP_TYPE_NORMAL );
        Intent intent = getIntent();
        String latitude = intent.getStringExtra(EXTRA_LATITUDE);
        String longitude = intent.getStringExtra(EXTRA_LONGITUDE);
        String name = intent.getStringExtra(EXTRA_NAME);
        LatLng point = new LatLng(valueOf(latitude), valueOf(longitude));
        googleMap.addMarker(new MarkerOptions().position(point).title(name));
        googleMap.moveCamera( CameraUpdateFactory.newLatLng( point ) );
    }
}
