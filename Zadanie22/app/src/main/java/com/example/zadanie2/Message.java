package com.example.zadanie2;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Message extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
    }

    public void onSendMessage(View view){
        EditText messageView = (EditText) findViewById(R.id.wiadomosc);
        EditText telefon = (EditText)findViewById(R.id.telefon);
        String messageText = messageView.getText().toString();
        String nrTel = telefon.getText().toString();
        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("sms:"+nrTel));
        intent.putExtra("sms_body",messageText);
        startActivity(intent);
    }
}
