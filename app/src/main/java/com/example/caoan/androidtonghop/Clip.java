package com.example.caoan.androidtonghop;

import android.graphics.drawable.ClipDrawable;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class Clip extends AppCompatActivity {
    private ImageView iv;
    private Button bt;
    int levelInt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clip);
        iv = findViewById(R.id.iv);

        bt = findViewById(R.id.bt);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Handler handler = new Handler(){
                    @Override
                    public void handleMessage(Message msg) {
                        super.handleMessage(msg);
                        if(msg.what==0){
                            ClipDrawable drawable = (ClipDrawable) iv.getBackground();
                            drawable.setLevel(drawable.getLevel()+100);
                        }
                    }
                };
                new Timer().scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {
                        handler.sendEmptyMessage(0);
                    }
                },1000,1000);
            }
        });

    }
}
