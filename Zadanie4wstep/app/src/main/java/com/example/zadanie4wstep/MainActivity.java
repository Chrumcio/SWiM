package com.example.zadanie4wstep;

import android.app.Fragment;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements OnWyborOpcjiListener{

    private Fragment11 f11;
    private Fragment12 f12;
    private FragmentTransaction trasakcja;
    private static final String TAG_F11 = "Fragment11";
    private static final String TAG_F12 = "Fragment12";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            f11 = new Fragment11();
            f12 = new Fragment12();
            trasakcja = getSupportFragmentManager().beginTransaction();
            trasakcja.add(R.id.kontener, f11,TAG_F11);
            trasakcja.detach(f11);
            trasakcja.add(R.id.kontener, f12,TAG_F12);
            trasakcja.detach(f12);
            trasakcja.commit();

        }else{
            f11 = (Fragment11)getSupportFragmentManager().findFragmentByTag(TAG_F11);
            f12 = (Fragment12)getSupportFragmentManager().findFragmentByTag(TAG_F12);
        }
    }

    @Override
    public void onWyborOpcji(int opcja) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (opcja){
            case 1:
                transaction.detach(f12);
                transaction.attach(f11);
                break;
            case 2:
                transaction.detach(f11);
                transaction.attach(f12);
                break;
        }
        transaction.commit();
    }

    public void uruchomDwa(View view){
        Intent intent = new Intent(this,Aktywnosc2.class);
        startActivity(intent);
    }
}
