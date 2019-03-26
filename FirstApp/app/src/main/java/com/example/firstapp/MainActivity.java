package com.example.firstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void uruchomDwa(View view){
        Intent intent = new Intent(this,Formularz.class);
        startActivity(intent);
    }

    public void uruchomTrzy(View view){
        Intent intent = new Intent(this,Main2Activity.class);
        startActivity(intent);
    }

    public void uruchomCztery(View view){
        Intent intent = new Intent(this,Main3Activity.class);
        startActivity(intent);
    }

    public void tekstAlternatywny(View view){
        Toast.makeText(getApplicationContext(),"Przykładowy Obraz",Toast.LENGTH_SHORT).show();
    }
}
