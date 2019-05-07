package com.example.zadanie5wstep;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ASensor extends Activity implements SensorEventListener {
    private SensorManager mSrMgr = null;
    private int mSensorType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asensor);
        mSrMgr = (SensorManager)getSystemService(SENSOR_SERVICE);
        mSensorType = getIntent().getIntExtra("sensorType",Sensor.TYPE_LIGHT);
        if(mSensorType == Sensor.TYPE_LIGHT)
            setTitle(R.string.light_status);
        else if (mSensorType == Sensor.TYPE_ACCELEROMETER)
            setTitle(R.string.accel_status);
    }

    public void onResume(){
        super.onResume();
        final Sensor sens = mSrMgr.getSensorList(mSensorType).get(0);
        mSrMgr.registerListener(this,sens,SensorManager.SENSOR_DELAY_NORMAL);
    }

    public void onPause(){
        super.onPause();
        mSrMgr.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        TextView tv = (TextView) findViewById(R.id.txt_data);
        StringBuilder sb = new StringBuilder();
        if(mSensorType == Sensor.TYPE_LIGHT){
            sb.append("Ambient light level: ");
            sb.append(event.values[0]);
            sb.append(" lux");
        }else if(mSensorType == Sensor.TYPE_ACCELEROMETER){
            sb.append("X acceleration: ");
            sb.append(String.format("%7.4f",event.values[0]));
            sb.append("m/s\u00B2\nY acceleration: ");
            sb.append(String.format("%7.4f",event.values[1]));
            sb.append("m/s\u00B2\nZ acceleration: ");
            sb.append(String.format("%7.4f",event.values[2]));
            sb.append("m/s\u00B2");
        }
        tv.setText(sb);

        tv = (TextView)findViewById(R.id.txt_status);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("\nAccuracy: ");
        sb2.append(event.accuracy == 3 ? "High" : (event.accuracy == 2 ? "Medium" : "Low"));
        tv.setText(sb2);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
