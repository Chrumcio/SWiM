package com.example.menuprojekt;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.example_menu,menu);
        return true;
    }

    public void uruchomJeden(View view){
        Intent intent = new Intent(this,MenuJavaActivity.class);
        startActivity(intent);
    }

    public void uruchomDwa(View view){
        Intent intent = new Intent(this,MenuChackableActivity.class);
        startActivity(intent);
    }
}