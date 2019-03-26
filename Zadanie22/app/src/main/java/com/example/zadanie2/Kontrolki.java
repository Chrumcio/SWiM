package com.example.zadanie2;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import org.w3c.dom.Text;

public class Kontrolki extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    private static SeekBar seekBar;
    private static TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kontrolki);

        final ToggleButton toggleButton = (ToggleButton)findViewById(R.id.togglebutton);
        final RelativeLayout relativeLayout = (RelativeLayout)findViewById(R.id.layout);
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(getApplicationContext(),"Toggle: "+toggleButton.getTextOn(),Toast.LENGTH_SHORT).show();
                }
            }
        });

        SeekBar seekBar = (SeekBar)findViewById(R.id.seekbar);
        final TextView textView = (TextView)findViewById(R.id.texview);
        textView.setText("Covered: "+seekBar.getProgress()+" / "+seekBar.getMax());
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int val;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                val = progress;
                textView.setText("Covered: "+progress+" / "+seekBar.getMax());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getApplicationContext(),"SeekBar in StartTracking",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                textView.setText("Covered: "+val+" / "+seekBar.getMax());
                Toast.makeText(getApplicationContext(),"SeekBar in StopTracking",Toast.LENGTH_SHORT).show();
            }
        });
        Switch switchbutton = (Switch)findViewById(R.id.switchbutton);
        switchbutton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    relativeLayout.setBackgroundColor(Color.GREEN);
                }else{
                    relativeLayout.setBackgroundColor(Color.WHITE);
                }
            }
        });

        Spinner spinner = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.spinner,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        SharedPreferences sp = getSharedPreferences("dane",MODE_PRIVATE);
        SharedPreferences.Editor spe = sp.edit();
        String pamietane = sp.getString("Calosc","");
        pamietane+=" "+text;
        Toast.makeText(getApplicationContext(),"Wybrano dotychczas: "+pamietane,Toast.LENGTH_SHORT).show();
        spe.putString("Calosc",pamietane);
        spe.commit();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
