package com.example.menuprojekt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Checkable;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.zip.Inflater;

public class MenuChackableActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_chackable);
        textView = (TextView)findViewById(R.id.text3);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.chackable_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.isChecked())
            item.setChecked(false);
        else
            item.setChecked(true);

        int id = item.getItemId();
        if(id == R.id.action1){
            textView.setText("Action 1");
        }else if(id == R.id.action2){
            textView.setText("Action2");
        }else if(id == R.id.action3_sub1){
            textView.setText("Action 3 in Sub 1");
        }else if(id == R.id.action3_sub2){
            textView.setText("Action 3 in Sub 2");
        }

        return true;
    }
}
