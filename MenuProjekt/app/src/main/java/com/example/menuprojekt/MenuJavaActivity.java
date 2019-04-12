package com.example.menuprojekt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;

public class MenuJavaActivity extends AppCompatActivity {

    public static final int PIERWSZY_ELEMENT = 1;
    public static final int DRUGI_ELEMENT = 2;
    public static final int TRZECI_ELEMENT = 3;
    public static final int CZWARTY_ELEMENT = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_java);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        menu.add(0,PIERWSZY_ELEMENT,0,"Jeden");
        menu.add(1,DRUGI_ELEMENT,0,"");
        menu.add(2,TRZECI_ELEMENT,0,"Trzy");
        menu.addSubMenu(2,CZWARTY_ELEMENT,0,"Cztery").add(0,PIERWSZY_ELEMENT,0,"JEDEN");
        return true;
    }
}
