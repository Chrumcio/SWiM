package com.example.zadanie4;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class PiesFragment extends Fragment {
    public static final List<Pies>listPies=new ArrayList<>();

    public PiesFragment() {
        // Required empty public constructor
    }

    public List<Pies>getListPies(){
        return this.listPies;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_pies,container,false);
        final FragmentTransaction transaction = getFragmentManager().beginTransaction();
        Button b = (Button)view.findViewById(R.id.pies_create);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText rasa = (EditText)view.findViewById(R.id.rasa_psa);
                EditText wiek = (EditText)view.findViewById(R.id.wiek_psa);
                EditText imie = (EditText)view.findViewById(R.id.imie_psa);
                String r,w,i;
                r = "rasa = "+rasa.getText().toString();
                i = " imie = "+imie.getText().toString();
                w = " wiek = "+wiek.getText().toString();
                listPies.add(new Pies(r,w,i));
                rasa.setText("");
                wiek.setText("");
                imie.setText("");
            }
        });
        setRetainInstance(true);
        return view;
    }



}
