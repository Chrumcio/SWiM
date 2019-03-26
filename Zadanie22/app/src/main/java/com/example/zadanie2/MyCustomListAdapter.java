package com.example.zadanie2;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyCustomListAdapter extends ArrayAdapter<Hero> {
    private Context mCtx;
    private int resource;
    private List<Hero> heroList;

    public MyCustomListAdapter(Context mCtx, int resource, List<Hero>heroList){
        super(mCtx,resource,heroList);
        this.mCtx = mCtx;
        this.resource = resource;
        this.heroList = heroList;
    }

    @Nullable
    @Override
    public View getView(final int position, @Nullable View convertView, @Nullable ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(resource,null);
        TextView textViewName = view.findViewById(R.id.textViewName);
        TextView textViewTeam = view.findViewById(R.id.textViewTeam);
        ImageView imageView = view.findViewById(R.id.bohaterowie);
        Hero hero = heroList.get(position);
        textViewName.setText(hero.getName());
        textViewTeam.setText(hero.getTeam());
        imageView.setImageDrawable(mCtx.getResources().getDrawable(hero.getImage()));
        view.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeItem(position);
            }
        });
        return view;
    }

    private void removeItem(final int position){
        AlertDialog.Builder builder = new AlertDialog.Builder(mCtx);
        builder.setTitle("Are you sure you want to delete?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                heroList.remove(position);
                notifyDataSetChanged();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
