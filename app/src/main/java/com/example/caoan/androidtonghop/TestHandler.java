package com.example.caoan.androidtonghop;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class TestHandler extends AppCompatActivity implements View.OnClickListener {

    private Button button;
    private ProgressBar progressBar;
    private TextView textView;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_handler);

        button = findViewById(R.id.btstart);
        button.setOnClickListener(this);
        progressBar = findViewById(R.id.progressbar);
        textView = findViewById(R.id.tv);

        listenHandler();

    }



    private void count(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<=100;i++){
                    Message message = new Message();
                    message.what = 1;
                    message.arg1 = i;
                    handler.sendMessage(message);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                handler.sendEmptyMessage(2);
            }
        }).start();
    }
    private void listenHandler(){
        handler = new Handler(Looper.getMainLooper()){
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what){
                    case 1:
                        progressBar.setProgress(msg.arg1);
                        setText(textView,String.valueOf(msg.arg1)+"%");
                        break;
                    case 2:
                        Toast.makeText(getApplicationContext(),"Loading completed",Toast.LENGTH_SHORT).show();
                        break;
                   default:
                        break;
                }
            }
        };
    }
    private void setText(final TextView textView, final String str){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                textView.setText(str);
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btstart:
                count();
                //Toast.makeText(getApplicationContext(),"Choose Start",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
