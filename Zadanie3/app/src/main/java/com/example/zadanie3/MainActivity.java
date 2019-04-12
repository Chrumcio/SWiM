package com.example.zadanie3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void uruchomJeden(View view){
        Intent intent = new Intent(this,MenuXMLActivity.class);
        startActivity(intent);
    }

    public void uruchomDwa(View view){
        Intent intent = new Intent(this,SubmenuActivity.class);
        startActivity(intent);
    }

    public void uruchomTrzy(View view){
        Intent intent = new Intent(this,MenuJavaActivity.class);
        startActivity(intent);
    }

    public void uruchomCztery(View view){
        Intent intent = new Intent(this,MenuContextActivity.class);
        startActivity(intent);
    }

    public void uruchomPiec(View view){
        Intent intent = new Intent(this,ContextModeActivity.class);
        startActivity(intent);

    }

    public void uruchomSzesc(View view){
        Intent intent = new Intent(this,MenuChackableActivity.class);
        startActivity(intent);
    }
}

