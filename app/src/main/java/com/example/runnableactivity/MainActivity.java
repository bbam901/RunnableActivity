package com.example.runnableactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    Thread wr;
    boolean running = true;
    String TAG2 = "THREAD";
    String TAG1 = "THREAD";
    Thread w;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        w = new WorkerThread();
        running = true;

        w.start();
        Log.v(TAG1,"Now i am in Onstart");
        wr = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                for(i=0;i<20 && running;i++){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Log.v(TAG2,"Runnable time="+i);
                }

            }
        });
        wr.start();
        Log.v(TAG2,"Now i am in Onstart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        running = false;
        Log.v(TAG1,"Now i am in Onstop");
        Log.v(TAG2,"Now i am in Onstop");
    }

    @Override
    protected void onPause() {
        super.onPause();
        running = false;
        Log.v(TAG1,"Now i am in Onpause");
        Log.v(TAG2,"Now i am in Onpause");
    }


    class WorkerThread extends Thread{
        @Override
        public void run() {
            int i = 0 ;
            for(i=0;i<20 && running;i++){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Log.v(TAG1,"Thread times="+i);
            }
        }
    }
}