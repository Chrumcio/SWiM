package com.example.zadanie2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class Grid1 extends AppCompatActivity implements  AdapterView.OnItemSelectedListener {
    private String[] lista = {"Pozycja 1", "Pozycja 2", "Pozycja 3"};
    private String[] p = {"1", "2", "3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid1);

        GridView gridView = (GridView)findViewById(R.id.gridview1);
        gridView.setAdapter(new myAdapter(this));

        Spinner opcje = (Spinner)findViewById(R.id.spinner1);
        if(opcje != null) {
            opcje.setOnItemSelectedListener(this);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,lista);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            opcje.setAdapter(adapter);
        }

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplicationContext(),"Wybrałeś: "+p[position],Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
