package com.example.zadanie4wstep;


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
public class Fragment1 extends Fragment implements RadioGroup.OnCheckedChangeListener {
    private AppCompatActivity A1;
    private OnWyborOpcjiListener sluchaczF1;

    public Fragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setRetainInstance(true);
        return inflater.inflate(R.layout.fragment_fragment1, container, false);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            A1 = (AppCompatActivity)context;
            sluchaczF1 = (OnWyborOpcjiListener)context;
        }catch (ClassCastException e){
            throw new ClassCastException(A1.toString()+" musi implementować OnWyborOpcjiListener");
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (group.getCheckedRadioButtonId()){
            case R.id.radioButton1:
                sluchaczF1.onWyborOpcji(1);
                break;
            case R.id.radioButton2:
                sluchaczF1.onWyborOpcji(2);
                break;
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        ((RadioGroup)getActivity().findViewById(R.id.opcje)).setOnCheckedChangeListener(this);
    }
}

