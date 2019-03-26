package com.example.zadanie2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ObliczeniaActivity extends AppCompatActivity {
    EditText editText;

    @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_obliczenia);
        editText = (EditText)findViewById(R.id.edittext);
    }

    public void sendHome(View view){
        Intent intent = new Intent();
        String message = editText.getText().toString();
        intent.putExtra("Data",message);
        setResult(RESULT_OK,intent);
        finish();
    }
}
