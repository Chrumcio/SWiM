package com.example.zadanie4wstep;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Aktywnosc2 extends AppCompatActivity implements ActionBar.TabListener{
    Fragment11 f11;
    Fragment12 f12;
    FragmentTransaction transakcja;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aktywnosc2);
        f11 = new Fragment11();
        f12 = new Fragment12();
        transakcja = getSupportFragmentManager().beginTransaction();
        transakcja.add(R.id.kontener2,f11);
        transakcja.detach(f11);
        transakcja.add(R.id.kontener2,f12);
        transakcja.detach(f12);
        transakcja.commit();
        actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        ActionBar.Tab tab;
        tab = actionBar.newTab();
        tab.setText("Jakiś tekst");
        tab.setTabListener((ActionBar.TabListener) this);
        actionBar.addTab(tab);

        ActionBar.Tab tab1;
        tab1 = actionBar.newTab();
        tab1.setText("Jakis tekst 1");
        tab1.setTabListener((ActionBar.TabListener) this);
        actionBar.addTab(tab1);
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        int position = tab.getPosition();
        switch (position){
            case 0:
                fragmentTransaction.attach(f11);
                break;
            case 1:
                fragmentTransaction.attach(f12);
                break;
        }
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        int position = tab.getPosition();
        switch (position){
            case 0:
                fragmentTransaction.detach(f11);
                break;
            case 1:
                fragmentTransaction.detach(f12);
                break;
        }
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        int position = tab.getPosition();
    }
}
