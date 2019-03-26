package com.example.zadanie2;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class CarActivity extends AppCompatActivity {
    public static final String EXTRA_CARNO = "carNo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car);

        int carNo = (Integer)getIntent().getExtras().get(EXTRA_CARNO);
        Car car = Car.cars[carNo];

        ImageView photo = (ImageView)findViewById(R.id.photo);
        photo.setImageResource(car.getImageResourceId());
        photo.setContentDescription(car.getBrand());

        TextView brand = (TextView)findViewById(R.id.brand);
        brand.setText(car.getBrand());

        TextView description = (TextView)findViewById(R.id.description);
        description.setText(car.getDescription());
    }
}
