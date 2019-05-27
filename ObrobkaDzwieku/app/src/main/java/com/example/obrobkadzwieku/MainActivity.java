package com.example.obrobkadzwieku;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.media.AudioFormat;
import android.media.AudioRecord;
import android.media.MediaRecorder;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.concurrent.LinkedBlockingQueue;

public class MainActivity extends AppCompatActivity {
    Button startRecording,stopRecording,listOfRecords,clearList,saveRecording;
    AudioRecord audioRecord;
    int buffSize;
    final int MIN_BUFFER_SIZE_ALLOWING_16_HZ_ANALYSIS = (5500 * 4);
    boolean isRecording;
    final int REQUEST_PERMISSION_CODE = 1000;
    AudioGrabbingTask audioGrabbingTask;
    AudioProcessingTask audioProcessingTask;
    LinkedBlockingQueue<byte[]> audioBuffersQueue = new LinkedBlockingQueue<byte[]>();

    private int seconds = 0;
    private boolean running;
    private boolean wasRunning;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState != null) {
            seconds = savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("running");
            wasRunning = savedInstanceState.getBoolean("wasRunning");
        }
        runTimer();

        if(!checkPermissionFromDevice())
            requestPermission();

        startRecording = (Button)findViewById(R.id.startbutton);
        stopRecording = (Button)findViewById(R.id.stopbutton);
        saveRecording = (Button)findViewById(R.id.savebutton);
        listOfRecords = (Button)findViewById(R.id.listbutton);
        clearList = (Button)findViewById(R.id.clearbutton);
        int minPossibleBuffSize = AudioRecord.getMinBufferSize(44100,AudioFormat.CHANNEL_IN_MONO,AudioFormat.ENCODING_PCM_FLOAT);

        if(minPossibleBuffSize > MIN_BUFFER_SIZE_ALLOWING_16_HZ_ANALYSIS)
            buffSize = minPossibleBuffSize;
        else buffSize = MIN_BUFFER_SIZE_ALLOWING_16_HZ_ANALYSIS;

        audioRecord = new AudioRecord(MediaRecorder.AudioSource.MIC,
                44100,
                AudioFormat.CHANNEL_IN_MONO,
                AudioFormat.ENCODING_PCM_16BIT,
                8192);

        if (MainActivity.this.checkSelfPermission(Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED)
        {
            MainActivity.this.requestPermissions(new String[]{Manifest.permission.RECORD_AUDIO}, 1);
        }
        startRecording.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startRecording();
                isRecording = true;
                startRecording.setEnabled(false);
                stopRecording.setEnabled(true);
                clearList.setEnabled(false);
                listOfRecords.setEnabled(false);
            }
        });

        stopRecording.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopRecording();
                isRecording = false;
                stopRecording.setEnabled(false);
                startRecording.setEnabled(true);
                clearList.setEnabled(true);
                listOfRecords.setEnabled(true);
            }
        });

        saveRecording.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveRecording();
                onClickReset();
            }
        });

        listOfRecords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ListOfRecords.class);
                startActivity(intent);
            }
        });

        clearList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    //region AfterParty
    @Override
    public void onPause(){
        super.onPause();
        wasRunning = running;
        running = false;
    }

    @Override
    public void onResume(){
        super.onResume();
        if(wasRunning){
            running = true;
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("seconds", seconds);
        savedInstanceState.putBoolean("running", running);
        savedInstanceState.putBoolean("wasRunning", wasRunning);
    }

    public void onClickStart(){
        running = true;
    }

    public void onClickStop(){
        running = false;
    }

    public void onClickReset(){
        seconds = 0;
        running = false;
    }

    private void runTimer(){
        final TextView timeView = (TextView)findViewById(R.id.time_view);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds/3600;
                int minutes = (seconds%3600)/60;
                int secs = seconds%60;
                String time = String.format("%d:%02d:%02d",hours,minutes,secs);
                timeView.setText(time);
                if(running){
                    seconds++;
                }
                handler.postDelayed(this,1000);
            }
        });
    }
    //endregion

    public void startRecording(){
        isRecording = true;
        audioRecord.startRecording();
        Toast.makeText(MainActivity.this,"Recording started",Toast.LENGTH_SHORT).show();
        onClickStart();
        audioGrabbingTask = new AudioGrabbingTask(buffSize,audioRecord,audioBuffersQueue);
        new Thread(audioGrabbingTask).start();
        String fileName = "audio-"+System.currentTimeMillis()+".wav";
        createFileInExternalStorage(fileName);
        audioProcessingTask = new AudioProcessingTask(audioBuffersQueue,Environment.getExternalStorageDirectory().getAbsolutePath()+"/AudioGrabberDemo/"+fileName,buffSize,audioRecord);
        new Thread(audioProcessingTask).start();
    }

    public void stopRecording(){
        audioRecord.stop();
        Toast.makeText(MainActivity.this,"Recording stopped",Toast.LENGTH_SHORT).show();
        onClickStop();
        int time = seconds;
        Toast.makeText(MainActivity.this,"Recording time: "+time,Toast.LENGTH_SHORT).show();
        isRecording = false;
        audioGrabbingTask.stop();
    }

    public void saveRecording(){
        audioProcessingTask.stop();
    }

    public void createFileInExternalStorage(String name){
        File folder = new File(Environment.getExternalStorageDirectory(),"AudioGrabberDemo");
        if(!folder.exists())
            folder.mkdirs();
       /* File file = new File(folder.getAbsolutePath(),name+".wav");
        if(!file.exists())
            file.mkdir();*/
    }

    private void requestPermission() {
        ActivityCompat.requestPermissions(this,new String[]{
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.RECORD_AUDIO
        },REQUEST_PERMISSION_CODE);
    }

    private boolean checkPermissionFromDevice() {
        int write_external_storage_result = ContextCompat.checkSelfPermission(this,Manifest.permission.WRITE_EXTERNAL_STORAGE);
        int record_audio_result = ContextCompat.checkSelfPermission(this,Manifest.permission.RECORD_AUDIO);
        return write_external_storage_result == PackageManager.PERMISSION_GRANTED && record_audio_result == PackageManager.PERMISSION_GRANTED;
    }

}
