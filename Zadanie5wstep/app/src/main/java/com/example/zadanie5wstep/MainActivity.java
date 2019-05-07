package com.example.zadanie5wstep;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onResume() {
        super.onResume();
        final SensorManager sm = (SensorManager)getSystemService(SENSOR_SERVICE);
        boolean enabled = !sm.getSensorList(Sensor.TYPE_LIGHT).isEmpty();
        TextView tv = (TextView)findViewById(R.id.text1);
        tv.setText(getString(R.string.light_status) + " " + getString(enabled ? R.string.txt_avail : R.string.txt_unvail));
        tv.setTextColor(enabled ? Color.GREEN : Color.RED);
        findViewById(R.id.natezenie_swiatla).setEnabled(enabled);

        enabled = !sm.getSensorList(Sensor.TYPE_ACCELEROMETER).isEmpty();
        tv = (TextView)findViewById(R.id.text2);
        tv.setText(getString(R.string.accel_status) + " " + getString(enabled ? R.string.txt_avail : R.string.txt_unvail));
        tv.setTextColor(enabled ? Color.GREEN : Color.RED);
        findViewById(R.id.przyspieszenie).setEnabled(enabled);

        final LocationManager lm = (LocationManager)getSystemService(LOCATION_SERVICE);
        enabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
        tv = (TextView)findViewById(R.id.text3);
        tv.setText(getString(R.string.gps_status) + " " + getString(enabled ? R.string.txt_avail : R.string.txt_unvail));
        tv.setTextColor(enabled ? Color.GREEN : Color.RED);
        findViewById(R.id.lokalizacja).setEnabled(enabled);

    }

    public final void startAktywnosc(final View v){
        Intent in;
        if(v.getId() == R.id.lokalizacja)
            in = new Intent(this,GPS.class);
        else{
            in = new Intent(this,ASensor.class);
            if(v.getId() == R.id.natezenie_swiatla)
                in.putExtra("sensorType",Sensor.TYPE_LIGHT);
            else if(v.getId() == R.id.przyspieszenie)
                in.putExtra("sensorType",Sensor.TYPE_ACCELEROMETER);
        }
        startActivity(in);
    }
}
