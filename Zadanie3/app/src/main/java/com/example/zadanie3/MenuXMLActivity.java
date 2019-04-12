package com.example.zadanie3;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MenuXMLActivity extends AppCompatActivity {

    TextView text1,text2;
    String t1,t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_xml);
        text1 = (TextView)findViewById(R.id.text1);
        text2 = (TextView)findViewById(R.id.text2);
        t1 = text1.getText().toString();
        t2 = text2.getText().toString();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.refresh,menu);
        inflater.inflate(R.menu.stop,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.pozycja1:
                if(text1.getCurrentTextColor() != Color.GREEN) {
                    text1.setTextColor(Color.GREEN);
                    text2.setTextColor(Color.RED);
                }else{
                    text1.setTextColor(Color.BLACK);
                    text2.setTextColor(Color.BLACK);
                }
                return true;
            case R.id.pozycja2:
                if(text1.getText().toString() != "Wybrano pozycja 2") {
                    text1.setText("Wybrano pozycja 2");
                    text2.setText("Wybrano pozycja 2");
                    text1.setTextSize(30);
                    text2.setTextSize(30);
                }else{
                    text1.setText(t1);
                    text2.setText(t2);
                    text1.setTextSize(20);
                    text2.setTextSize(20);
                }
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
