package com.example.zadanie3;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MenuChackableActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_chackable);

        textView = (TextView)findViewById(R.id.text3);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_chackable,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String text = null;
        if(item.isChecked())
            item.setChecked(false);
        else
            item.setChecked(true);

        int id = item.getItemId();
        if(id == R.id.action1){
            textView.setText("Wybrales akcje numer jeden");
        }else if(id == R.id.action2){
            textView.setTextSize(40);
        }else if(id == R.id.action3){
            Toast.makeText(getApplicationContext(),"Akcja3",Toast.LENGTH_SHORT).show();
        }else if(id == R.id.action3_sub1){
            textView.setTextColor(Color.CYAN);
            textView.setBackgroundColor(Color.WHITE);
        }else if(id == R.id.action3_sub2){
            textView.setBackgroundColor(Color.YELLOW);
            textView.setTextColor(Color.BLACK);
        }else if(id == R.id.action3_sub3){
            textView.animate().rotation(textView.getRotation()+1440).start();
            textView.setTextColor(Color.BLACK);
            textView.setBackgroundColor(Color.WHITE);
        }else if(id == R.id.action4){
            Toast.makeText(getApplicationContext(),"Akcja4",Toast.LENGTH_SHORT).show();
        }else if(id == R.id.action4_sub1){
           textView.setTextSize(25);
        }else if(id == R.id.action4_sub2){
            textView.setBackgroundColor(Color.CYAN);
        }else if(id == R.id.action4_sub3){
            textView.setTextColor(Color.RED);
        }
        return true;
    }
}
