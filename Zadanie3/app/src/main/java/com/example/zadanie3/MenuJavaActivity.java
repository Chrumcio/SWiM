package com.example.zadanie3;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MenuJavaActivity extends AppCompatActivity {
    public static final int PIERWSZY_ELEMENT = 1;
    public static final int DRUGI_ELEMENT = 2;
    public static final int TRZECI_ELEMENT = 3;
    public static final int CZWARTY_ELEMENT = 4;
    public static final int PIATY_ELEMENT = 5;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_java);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        menu.add(0,PIERWSZY_ELEMENT,0,"Jeden");
        menu.add(1,DRUGI_ELEMENT,0,"Dwa");
        SubMenu subMenu = menu.addSubMenu("Trzy");
        subMenu.add(2,CZWARTY_ELEMENT,0,"Cztery");
        subMenu.add(3,PIATY_ELEMENT,0,"Piec");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        TextView text1 = (TextView)findViewById(R.id.jtext1);
        TextView text2 = (TextView)findViewById(R.id.jtext2);
        ImageView imageView = (ImageView)findViewById(R.id.imageview);
        switch (item.getItemId()){
            case PIERWSZY_ELEMENT:
                imageView.setImageResource(R.drawable.bee);
                return true;
            case DRUGI_ELEMENT:
                imageView.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        Toast.makeText(MenuJavaActivity.this,"Bee image",Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });
                return true;
            case CZWARTY_ELEMENT:
                text1.setBackgroundColor(Color.YELLOW);
                text2.setBackgroundColor(Color.CYAN);
                return true;
            case PIATY_ELEMENT:
                text1.setTextSize(30);
                text1.animate().rotation(text1.getRotation()-360).start();
                text2.setTextSize(30);
                text2.animate().rotation(text2.getRotation()+360).start();
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
