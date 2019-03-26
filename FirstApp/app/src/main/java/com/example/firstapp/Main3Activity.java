package com.example.firstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }

    public void obliczBMI(View view) {
        TextView wynik = (TextView) findViewById(R.id.wynik);
        EditText t1 = (EditText) findViewById(R.id.kilogram);
        EditText t2 = (EditText) findViewById(R.id.wzrost);
        String s1 = t1.getText().toString();
        String s2 = t2.getText().toString();
        double waga = Double.parseDouble(s1);
        double wzrost = Double.parseDouble(s2);
        double bmi = waga / (Math.pow((wzrost / 100), 2));
        java.text.DecimalFormat df = new java.text.DecimalFormat();
        df.setMaximumFractionDigits(2);
        String w = df.format(bmi);
        if (bmi < 18.5) {
            wynik.setText("Niedowaga!\nTwoje BMI: " + w);
        } else if (bmi < 24.9) {
            wynik.setText("Norma!\nTwoje BMI: "+w);
        }else if(bmi<29.9){
            wynik.setText("Nadwaga!\nTwoje BMI: "+w);
        }else{
            wynik.setText("Otyłość!\nTwoje BMI: "+w);
        }
    }
}