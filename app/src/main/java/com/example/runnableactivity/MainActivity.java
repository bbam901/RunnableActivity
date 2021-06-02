package com.example.runnableactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    WorkerThread wt;
    WorkerRunnable wr;
    boolean running = true;

    String TAG = "THREAD";

    class WorkerThread extends Thread {
        public void run() {
            int i = 0;
            for (i = 0 ; i < 20 && running; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {

                }
                Log.v(TAG, "Thread time " + i);
            }
        }
    }

    class WorkerRunnable extends Thread {
        public void run() {
            int i = 0;
            for(i = 0; i < 20 && running; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
                Log.v(TAG, "Runnable time = " + i);
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(TAG, "Now I am in onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        running = true;

        wt = new WorkerThread();
        wt.start();

        wr = new WorkerRunnable();
        wr.run();
        Log.v(TAG, "Now I am in onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        running = true;
        Log.v(TAG, "Now I am in onStop");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(TAG, "Now I am in onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(TAG, "Now I am in onResume");
    }
}