package com.example.zadanie4;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class DaneKotowFragment extends Fragment {
    TextView textView;
    List<Kot>listKot;

    public DaneKotowFragment() {
        // Required empty public constructor
    }

    public void setListKot(List<Kot>listKot){
        this.listKot = listKot;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_dane_kotow, container, false);
        final FragmentTransaction transaction = getFragmentManager().beginTransaction();
        textView = (TextView) view.findViewById(R.id.infokoty);
        textView.setTextSize(14);
        for(int i=0;i<listKot.size();i++){
            textView.append(listKot.get(i).toString()+"\n");
        }
        setRetainInstance(true);
        return view;
    }

}
