package com.example.recyclercards;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

public class SeeMapActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Button button_yo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_map);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        final SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
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

    float radius2zoom(int radiusKM) {
        float radiusMI = (float) (radiusKM * 0.621371);
        return Math.round(14-Math.log(radiusMI)/Math.log(2));
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng NE = new LatLng(41.261602213,-8.39546205127);
        LatLng SW = new LatLng(41.0299552058,-8.83148194873);
        LatLngBounds campaignArea = new LatLngBounds(SW,NE);
        mMap.moveCamera(CameraUpdateFactory.newLatLngBounds(campaignArea,0));
        mMap.moveCamera(CameraUpdateFactory.zoomTo(radius2zoom(10)));

        button_yo = (Button) findViewById(R.id.button_yo);
        button_yo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                LatLngBounds newBounds = mMap.getProjection().getVisibleRegion().latLngBounds;
                Log.d("new bounds",""+newBounds);
            }
        });
    }
}
