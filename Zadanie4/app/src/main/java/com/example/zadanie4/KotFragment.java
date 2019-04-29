package com.example.zadanie4;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class KotFragment extends Fragment {
    public static final List<Kot>listKot = new ArrayList<>();

    public KotFragment() {
        // Required empty public constructor
    }

    public List<Kot>getListKot(){
        return this.listKot;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_kot,container,false);
        final FragmentTransaction transaction = getFragmentManager().beginTransaction();
        Button b = (Button)view.findViewById(R.id.kot_create);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText rasa = (EditText)view.findViewById(R.id.rasa_kota);
                EditText wiek = (EditText)view.findViewById(R.id.wiek_kota);
                EditText imie = (EditText)view.findViewById(R.id.imie_kota);
                String r,w,i;
                r = "rasa = "+rasa.getText().toString();
                i = " imie = "+imie.getText().toString();
                w = " wiek = "+wiek.getText().toString();
                listKot.add(new Kot(r,w,i));
                rasa.setText("");
                wiek.setText("");
                imie.setText("");
            }
        });
        setRetainInstance(true);
        return view;
    }
}
