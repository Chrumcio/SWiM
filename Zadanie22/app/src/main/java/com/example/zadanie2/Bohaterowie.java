package com.example.zadanie2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Bohaterowie extends AppCompatActivity {
    List<Hero>heroList;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bohaterowie);

        heroList = new ArrayList<>();
        heroList.add(new Hero(R.drawable.batman,"Batman","Justice League"));
        heroList.add(new Hero(R.drawable.kapitanameryka,"Kapitan Ameryka","Avengers"));
        heroList.add(new Hero(R.drawable.doktorstrange,"Doktor Strange","Avengers"));
        listView = (ListView)findViewById(R.id.listview);
        MyCustomListAdapter adapter = new MyCustomListAdapter(this,R.layout.my_list_item,heroList);
        listView.setAdapter(adapter);
    }
}
