package com.example.zadanie2;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;

public class myAdapter extends BaseAdapter {
    private Context ctx;

    public Integer[] id_obrazkow = {
            R.drawable.img1, R.drawable.img2, R.drawable.img3,
            R.drawable.img2, R.drawable.img3, R.drawable.img1,
            R.drawable.img3, R.drawable.img1, R.drawable.img2};

    public myAdapter(Context c){
        this.ctx = c;
    }

    @Override
    public int getCount() {
        return id_obrazkow.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView mV;
        if(convertView == null){
            mV = new ImageView(ctx);
            mV.setLayoutParams(new GridView.LayoutParams(200,200));
            mV.setScaleType(ImageView.ScaleType.CENTER_CROP);
            mV.setPadding(8,8,8,8);
        }else {
            mV = (ImageView) convertView;
        }
        mV.setImageResource(id_obrazkow[position]);
        return mV;
    }
}
