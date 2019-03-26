package com.example.zadanie2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void mojClickHandlerList1(View view){
        Intent intent = new Intent(this,Lista1.class);
        startActivity(intent);
    }

    public void mojClickHandlerList2(View view){
        Intent intent = new Intent(this,Lista2.class);
        startActivity(intent);
    }

    public void mojClickHandlerList3(View view){
        Intent intent = new Intent(this,Grid1.class);
        startActivity(intent);
    }

    public void mojClickHandlerList4(View view){
        Intent intent = new Intent(this,Lista3.class);
        startActivity(intent);
    }
}
