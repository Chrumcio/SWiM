package com.example.obrobkadzwieku;

import android.media.AudioRecord;

import java.util.concurrent.LinkedBlockingQueue;

public class AudioGrabbingTask implements Runnable{

    private int buffSize;
    private AudioRecord audioRecord;
    private LinkedBlockingQueue<byte[]> buffQueue;
    private boolean isRunning = true;

    public AudioGrabbingTask(int buffSize, AudioRecord audioRecord, LinkedBlockingQueue<byte[]> buffQueue) {
        this.buffSize = buffSize;
        this.audioRecord = audioRecord;
        this.buffQueue = buffQueue;
    }

    @Override
    public void run() {
        while(isRunning){
            try {
                buffQueue.put(getNextBlock());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stop() {
        isRunning = false;
    }

    byte[] getNextBlock(){
        byte[] buffer = new byte[buffSize];
        int returnCode = audioRecord.read(buffer,0,buffer.length);
        if(returnCode>=0){
            return buffer;
        }else{
            return null;
        }
    }
}
