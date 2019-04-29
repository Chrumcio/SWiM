package com.example.zadanie4;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class DanePsowFragment extends Fragment {
    TextView textView;
    List<Pies>listPies;


    public DanePsowFragment() {
        // Required empty public constructor
    }

    public void setListPies(List<Pies>listPies){
        this.listPies = listPies;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_dane_psow,container,false);
        final FragmentTransaction transaction = getFragmentManager().beginTransaction();
        textView = (TextView) view.findViewById(R.id.infopsy);
        textView.setTextSize(14);
        for(int i=0;i<listPies.size();i++){
            textView.append(listPies.get(i).toString()+"\n");
        }
        setRetainInstance(true);
        return view;
    }

}
