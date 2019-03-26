package com.example.zadanie2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Lista2 extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private String[] napisy = {"Film1","Film2","Film3","Film4","Film5","Film6","Film7","Film8","Film9"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista2);

        ListView lista2 = (ListView) findViewById(R.id.listview2);
        lista2.setOnItemClickListener(this);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, napisy);
        lista2.setAdapter(adapter2);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String napis = "";
        ListView lista2 = (ListView)findViewById(R.id.listview2);
        SparseBooleanArray zaznaczone = lista2.getCheckedItemPositions();
        for (int i = 0; i < zaznaczone.size(); i++){
            if(zaznaczone.valueAt(i)){
                int indeks = zaznaczone.keyAt(i);
                napis += (" " + String.valueOf(indeks+1));
            }
        }
        Toast.makeText(getApplicationContext(),"Wybrałeś:"+napis,Toast.LENGTH_SHORT).show();
    }
}
