package com.example.zadanie2;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Lista3 extends AppCompatActivity {
    //private String[] ltxt1 = {"Pozycja nr 1","Pozycja nr 2","Pozycja nr 3","Pozycja nr 4","Pozycja nr 5"};
   // private String[] ltxt2 = {"Tekst 1","Tekst 2","Tekst 3","Tekst 4","Tekst 5"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista3);
        myAdapter2 adapter2 = new myAdapter2(this);
        ListView lista3 = (ListView)findViewById(R.id.listview3);
        lista3.setAdapter(adapter2);

        SharedPreferences sp = getSharedPreferences("dane_apki",MODE_PRIVATE);
        SharedPreferences.Editor spe = sp.edit();
        int nru = sp.getInt("nr_uruchomienia",0);
        nru++;
        Toast.makeText(getApplicationContext(),"Uruchomienie nr "+nru,Toast.LENGTH_SHORT).show();
        spe.putInt("nr_uruchomienia",nru);
        spe.commit();
    }
}

