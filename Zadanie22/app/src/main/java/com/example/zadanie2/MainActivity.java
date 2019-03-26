package com.example.zadanie2;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> listView, View v,int position,long id){
                if(position == 0){
                    Intent intent = new Intent(MainActivity.this,CarCategoryActivity.class);
                    startActivity(intent);
                }else if(position == 1){
                    Intent intent = new Intent(MainActivity.this,Kontrolki.class);
                    startActivity(intent);
                }else if(position == 2){
                    Intent intent = new Intent(MainActivity.this,Bohaterowie.class);
                    startActivity(intent);
                }else if(position == 3){
                    Intent intent = new Intent(MainActivity.this,Message.class);
                    startActivity(intent);
                }else if(position == 4){
                    Intent intent = new Intent(MainActivity.this,ReadAndWrite.class);
                    startActivity(intent);
                }else if(position == 5){
                    Intent intent = new Intent(MainActivity.this,ActivityForResults.class);
                    startActivity(intent);
                }
            }
        };
        ListView listView = (ListView)findViewById(R.id.list_options);
        listView.setOnItemClickListener(itemClickListener);
    }
}
