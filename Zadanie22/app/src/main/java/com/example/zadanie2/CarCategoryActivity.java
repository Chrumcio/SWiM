package com.example.zadanie2;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CarCategoryActivity extends ListActivity {

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        ListView listCars = getListView();
        ArrayAdapter<Car> listAdapter = new ArrayAdapter<Car>(this,android.R.layout.simple_list_item_1,Car.cars);
        listCars.setAdapter(listAdapter);
    }

    @Override
    public void onListItemClick(ListView listView, View itemView,int position,long id){
        Intent intent = new Intent(CarCategoryActivity.this,CarActivity.class);
        intent.putExtra(CarActivity.EXTRA_CARNO,(int)id);
        startActivity(intent);
    }
}
