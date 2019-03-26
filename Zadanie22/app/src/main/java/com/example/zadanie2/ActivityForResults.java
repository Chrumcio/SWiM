package com.example.zadanie2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ActivityForResults extends AppCompatActivity {
    TextView textView;
    EditText editText1;
    EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_results);
        textView = (TextView)findViewById(R.id.wyniki);
    }

    public void openObliczeniaActivity(View view){
        Intent intent = new Intent(getApplicationContext(),ObliczeniaActivity.class);
        startActivityForResult(intent,1);
    }

    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode == 1 && resultCode==RESULT_OK){
            String message = data.getStringExtra("Data");
            textView.setText(message);
        }

    }
}
