package com.example.zadanie5wstep;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class GPS extends Activity implements LocationListener {
    private LocationManager mLocMgr = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gps);
        mLocMgr = (LocationManager)getSystemService(LOCATION_SERVICE);
        TextView txt_data = (TextView)findViewById(R.id.txt_status);
        txt_data.setText("Czekam na dane GPS...");
    }

    public void onResume(){
        super.onResume();
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED)
            mLocMgr.requestLocationUpdates(LocationManager.GPS_PROVIDER,1000,10,this);
        else
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},0);
    }

    public void onPause(){
        super.onPause();
        if (ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED)
            mLocMgr.removeUpdates(this);
    }

    @Override
    public void onLocationChanged(Location location) {
        TextView txt_data = (TextView)findViewById(R.id.txt_data);
        StringBuilder sb = new StringBuilder();
        sb.append("Altitude: ");
        sb.append(location.getAltitude());
        sb.append("m\nBearing: ");
        sb.append(location.getBearing());
        sb.append("\u00B0\nLatitude: ");
        sb.append(location.getLatitude());
        sb.append("\nLongitude: ");
        sb.append(location.getLongitude());
        sb.append("\nSpeed: ");
        sb.append(location.getSpeed());
        sb.append("m/s");
        txt_data.setText(sb);

        txt_data = (TextView)findViewById(R.id.txt_status);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Accuracy: ");
        sb2.append(location.getAccuracy());
        sb2.append("m");
        txt_data.setText(sb2);
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {
        if(LocationManager.GPS_PROVIDER.contentEquals(provider))
            finish();
    }
}
