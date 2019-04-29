package com.example.zadanie4;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements OnWyborOpcjiListener{

    private TextView mTextMessage;
    private KotFragment kotFragment;
    private PiesFragment piesFragment;
    private DaneKotowFragment daneKotowFragment;
    private DanePsowFragment danePsowFragment;
    private FragmentTransaction transaction;
    private List<Kot>listKot;
    private List<Pies>listPies;
    private static final String KOT = "KOT";
    private static final String PIES = "PIES";
    private static final String DANEKOTOW = "DANEKOTOW";
    private static final String DANEPSOW = "DANEPSOW";
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    transaction.detach(kotFragment);
                    transaction.detach(piesFragment);
                    transaction.detach(danePsowFragment);
                    transaction.detach(daneKotowFragment);
                    transaction.commit();
                    return true;
                case R.id.menukoty:
                    listKot = kotFragment.getListKot();
                    daneKotowFragment.setListKot(listKot);
                    transaction.detach(kotFragment);
                    transaction.detach(piesFragment);
                    transaction.detach(danePsowFragment);
                    transaction.attach(daneKotowFragment);
                    transaction.commit();
                    return true;
                case R.id.menupsy:
                    listPies = piesFragment.getListPies();
                    danePsowFragment.setListPies(listPies);
                    transaction.detach(kotFragment);
                    transaction.detach(piesFragment);
                    transaction.detach(daneKotowFragment);
                    transaction.attach(danePsowFragment);
                    transaction.commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState == null){
            kotFragment = new KotFragment();
            piesFragment = new PiesFragment();
            daneKotowFragment = new DaneKotowFragment();
            danePsowFragment = new DanePsowFragment();
            transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.frame1,kotFragment,KOT);
            transaction.detach(kotFragment);
            transaction.add(R.id.frame1,piesFragment,PIES);
            transaction.detach(piesFragment);
            transaction.add(R.id.frame1,daneKotowFragment,DANEKOTOW);
            transaction.detach(daneKotowFragment);
            transaction.add(R.id.frame1,danePsowFragment,DANEPSOW);
            transaction.detach(danePsowFragment);
            transaction.commit();
        }else{
            kotFragment = (KotFragment)getSupportFragmentManager().findFragmentByTag(KOT);
            piesFragment = (PiesFragment)getSupportFragmentManager().findFragmentByTag(PIES);
            danePsowFragment = (DanePsowFragment)getSupportFragmentManager().findFragmentByTag(DANEPSOW);
            daneKotowFragment = (DaneKotowFragment)getSupportFragmentManager().findFragmentByTag(DANEKOTOW);
        }
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    public void onWyborOpcji(int opcja) {
        FragmentTransaction transaction =getSupportFragmentManager().beginTransaction();
        switch (opcja){
            case 1:
                transaction.detach(kotFragment);
                transaction.detach(danePsowFragment);
                transaction.detach(daneKotowFragment);
                transaction.attach(piesFragment);
                break;
            case 2:
                transaction.detach(piesFragment);
                transaction.detach(daneKotowFragment);
                transaction.detach(danePsowFragment);
                transaction.attach(kotFragment);
                break;
        }
        transaction.commit();
    }

}
