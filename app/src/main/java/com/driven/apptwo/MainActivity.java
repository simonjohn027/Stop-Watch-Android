package com.driven.apptwo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private  int second = 0;
    private  boolean running;
    private  boolean wasRunning;

    //Get called as the app is being created, either from Launcher or when device config has changed
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        runTimer();
        if(savedInstanceState != null){
            second = savedInstanceState.getInt("second");
            running = savedInstanceState.getBoolean("running");
        }
    }

    //Get called as the app assume (again) the focus
    @Override
    public void onResume(){
        super.onResume();
        if(wasRunning)running = true;

    }


    //Only called when there is a change in device configurations
    @Override
    public void onSaveInstanceState(Bundle appInstanceState){
        super.onSaveInstanceState(appInstanceState);
        appInstanceState.putInt("second",second);
        appInstanceState.putBoolean("running",running);

    }

    //Called when the app change the visibility focus such that it's not visible to the user
    @Override
    public  void onPause(){
        super.onPause();
        wasRunning = running;
        running = false;
    }



    public  void onClickStart(View view){
      running = true;
    }

    public  void onClickStop(View view){
        running = false;
    }

    public  void  onClickReset(View view){
        running = false;
        second = 0;
    }


    //Handle the times, as this will block the main android thread, it need it own thread
    //Handler is the one responsible to takecare of that new thread, under Runnable obj,
    //Handler post, get the stopwatch start immediately, while the  postDelay update the watch
    private void runTimer(){
        final TextView clock = (TextView) findViewById(R.id.clock);
        final Handler handler = new Handler();

        handler.post(
                new Runnable() {
            @Override
            public void run() {
                int hours = second/3600;
                int minutes = (second%3600)/60;
                int secs = second%60;

                String time = String.format(Locale.getDefault(), "%d:%02d:%02d",hours,minutes,secs);
                clock.setText(time);
                if(running){
                    second ++;
                }
                handler.postDelayed(this, 1000);
            }
        });
    }

}


