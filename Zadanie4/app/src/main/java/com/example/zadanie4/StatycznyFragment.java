package com.example.zadanie4;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class StatycznyFragment extends Fragment implements RadioGroup.OnCheckedChangeListener {
    private AppCompatActivity A1;
    private OnWyborOpcjiListener listener;

    public StatycznyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setRetainInstance(true);
        return inflater.inflate(R.layout.fragment_statyczny, container, false);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            A1 = (AppCompatActivity)context;
            listener =(OnWyborOpcjiListener)context;
        }catch (ClassCastException e){
            throw new ClassCastException(A1.toString()+"Musi implementować OnWyborOpcjiListener");
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (group.getCheckedRadioButtonId()){
            case R.id.button_pies:
               listener.onWyborOpcji(1);
               group.clearCheck();
                break;
            case R.id.button_kot:
                listener.onWyborOpcji(2);
                group.clearCheck();
                break;
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        ((RadioGroup)getActivity().findViewById(R.id.opcje)).setOnCheckedChangeListener(this);
    }
}
