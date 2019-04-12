package com.example.zadanie3;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class SubmenuActivity extends AppCompatActivity {

    ViewFlipper viewFlipper;
    int [] images = {R.drawable.bee,R.drawable.cello,R.drawable.lion,R.drawable.pumpkin,R.drawable.watch};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submenu);
        viewFlipper = (ViewFlipper)findViewById(R.id.v_flipper);
        for(int image:images){
            flipperImage(image);
        }
    }

    public void flipperImage(int image){
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        viewFlipper.addView(imageView);

        viewFlipper.setInAnimation(this,android.R.anim.slide_in_left);
        viewFlipper.setOutAnimation(this,android.R.anim.slide_out_right);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.example_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.item1:
                viewFlipper.showNext();
                return true;
            case R.id.item2:
                viewFlipper.showPrevious();
                return true;
            case R.id.item3:
                Toast.makeText(this,"Wszedłeś do Submenu!",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.subitem1:
                viewFlipper.removeAllViews();
                return true;
            case R.id.subitem2:
                for(int image:images){
                    flipperImage(image);
                }
                viewFlipper.startFlipping();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
