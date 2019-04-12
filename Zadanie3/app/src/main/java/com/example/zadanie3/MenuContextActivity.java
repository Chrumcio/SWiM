package com.example.zadanie3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MenuContextActivity extends AppCompatActivity {

    ImageView img1,img2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_context);

        Button contextMenuButton = (Button)findViewById(R.id.buttoncontextmenu);
        registerForContextMenu(contextMenuButton);

        img1 = (ImageView)findViewById(R.id.imagecon1);
        img2 = (ImageView)findViewById(R.id.imagecon2);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Choose your option");
        menu.setHeaderIcon(R.drawable.obraz1);
        getMenuInflater().inflate(R.menu.menu_context,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_option1:
                Toast.makeText(this,"Pumpkin",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item_option2:
                img1.animate().rotation(img1.getRotation()-1080).start();
                return true;
            case R.id.item_option3:
                img1.animate().rotation(img1.getRotation()+1080).start();
                return true;
            case R.id.item_option4:
                img1.animate().rotation(img1.getRotation()-180).start();
                return true;
            case R.id.item_option5:
                Toast.makeText(this,"Cello",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item_option6:
                img2.setImageResource(R.drawable.lion);
                return true;
            case R.id.item_option7:
                img2.setImageResource(R.drawable.watch);
                return true;
            case R.id.item_option8:
                img2.setImageResource(R.drawable.ic_poz1);
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}
