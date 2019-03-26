package com.example.firstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class Formularz extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formularz);
    }

    public void wypisz(View view){
        TextView tekst1 = (TextView)findViewById(R.id.output);
        RadioButton radio1 = (RadioButton)findViewById(R.id.radio1);
        RadioButton radio2 = (RadioButton)findViewById(R.id.radio2);
        EditText name = (EditText)findViewById(R.id.name);
        EditText surname = (EditText)findViewById(R.id.surname);
        Spinner day = (Spinner)findViewById(R.id.dzien);
        Spinner month = (Spinner)findViewById(R.id.miesiac);
        Spinner year = (Spinner)findViewById(R.id.rok);
        CheckBox nozna = (CheckBox)findViewById(R.id.check1);
        CheckBox siatka = (CheckBox)findViewById(R.id.check2);
        CheckBox kosz = (CheckBox)findViewById(R.id.check3);

        String mezczyzna = String.valueOf(radio1.getText());
        String kobieta = String.valueOf(radio2.getText());
        String tekst="Płeć: ";
        if(radio1.isChecked()){
            tekst+=mezczyzna+"\n";
        }else if(radio2.isChecked()){
            tekst+=kobieta+"\n";
        }
        tekst+="Imię:"+name.getText()+"\n";
        tekst+="Nazwisko:"+surname.getText()+"\n";
        tekst+="Data Urodzenia:\n"+day.getSelectedItem().toString()+" ";
        tekst+=month.getSelectedItem().toString()+" ";
        tekst+=year.getSelectedItem().toString()+"\n";
        tekst+="Zainteresowania:\n";
        if(nozna.isChecked()) {
            tekst +=nozna.getText().toString() + "\n";
        }
        if(siatka.isChecked()){
            tekst += siatka.getText().toString()+"\n";
        }
        if(kosz.isChecked()){
            tekst += kosz.getText().toString();
        }
        /*tekst1.setText(surname.getText()+" ");
        int dzien = Integer.parseInt(day.toString());
        String miesiac = month.toString();
        int rok = Integer.parseInt(year.toString());
        tekst1.setText(dzien+" "+miesiac+" "+rok+" ");
        tekst1.refreshDrawableState();*/
        tekst1.setText(tekst);
        tekst1.refreshDrawableState();
    }


}
