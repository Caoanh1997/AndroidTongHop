package com.example.caoan.androidtonghop;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class LevelList extends AppCompatActivity {
    private ImageView iv;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_list);
        iv = findViewById(R.id.iv);

        int delay = 1000;
        int period = 5000;
        Timer timer = new Timer();

        final Handler messageHandle = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if(msg.what==0){
                    if(i<4){
                        i++;
                        iv.setImageLevel(i);
                    }else {
                        i=0;
                        iv.setImageLevel(i);
                    }
                }
            }
        };
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                messageHandle.sendEmptyMessage(0);
            }
        },delay,period);
    }
}
