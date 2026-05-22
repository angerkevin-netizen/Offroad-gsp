package com.exemple.offroad;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import org.osmdroid.config.Configuration;
import org.osmdroid.views.MapView;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.overlay.Marker;

public class MainActivity extends AppCompatActivity {
    private MapView map = null;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        Configuration.getInstance().setUserAgentValue(getPackageName());
        setContentView(R.layout.activity_main);
        
        map = findViewById(R.id.map);
        map.setMultiTouchControls(true);
        
        GeoPoint startPoint = new GeoPoint(48.8583, 2.2944); // Paris par défaut
        map.getController().setZoom(15.0);
        map.getController().setCenter(startPoint);
        
        Marker startMarker = new Marker(map);
        startMarker.setPosition(startPoint);
        startMarker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        startMarker.setTitle("Position");
        map.getOverlays().add(startMarker);
    }
    
    @Override
    public void onResume() {
        super.onResume();
        map.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        map.onPause();
    }
}
