package com.example.zadanie2;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import static android.R.layout.simple_list_item_1;

public class Lista1 extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private String[] napisy = {"Film1","Film2","Film3","Film4","Film5","Film6","Film7","Film8","Film9"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista1);

        ListView lista1 = (ListView)findViewById(R.id.listview1);
        lista1.setOnItemClickListener(this);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, simple_list_item_1, napisy);
        lista1.setAdapter(adapter2);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //Chujostwo Switch(position) nie dziala!
        String n = Integer.toString(position+1);
        Toast.makeText(getApplicationContext(),n,Toast.LENGTH_SHORT).show();
    }
}
