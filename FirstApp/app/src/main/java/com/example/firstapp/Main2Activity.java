package com.example.firstapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        View mojeOkno2 = (View)findViewById(R.id.longClick);
        mojeOkno2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                finish();
                return false;
            }
        });

        Switch switch1 = (Switch) findViewById(R.id.switch1);
        final TextView textView = (TextView)findViewById(R.id.colortext);
        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(getApplicationContext(),"ON",Toast.LENGTH_SHORT).show();
                    textView.setText("Zmiana tekstu, przycisk ON");
                }
                else{
                    Toast.makeText(getApplicationContext(),"OFF",Toast.LENGTH_SHORT).show();
                    textView.setText("Zmiana tekstu, przycisk OFF");
                }
            }
        });
    }

    protected void onStop(){
        super.onStop();
        Toast.makeText(getApplicationContext(),"Aktywnosc 2 - zatrzymana",Toast.LENGTH_SHORT).show();
    }
}
