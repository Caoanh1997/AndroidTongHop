package com.example.caoan.androidtonghop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class TestSeekBar extends AppCompatActivity {

    private SeekBar seekBar;
    private TextView textView;
    private Button bt1,bt2;
    int temp = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_seek_bar);

        seekBar = findViewById(R.id.sb);
        textView = findViewById(R.id.tv);
        bt1 = findViewById(R.id.bt1);
        bt2 = findViewById(R.id.bt2);

        textView.setText("Progress "+seekBar.getProgress()+"/"+seekBar.getMax());

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                seekBar.setProgress(i);
                textView.setText("Progress "+seekBar.getProgress()+"/"+seekBar.getMax());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getApplicationContext(),"Dang truot", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getApplicationContext(),"Het truot", Toast.LENGTH_SHORT).show();
            }
        });

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(seekBar.getProgress()-temp<0){
                    seekBar.setProgress(0);
                }else {
                    seekBar.setProgress(seekBar.getProgress()-temp);
                }
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(seekBar.getProgress()+temp>100){
                    seekBar.setProgress(100);
                }else {
                    seekBar.setProgress(seekBar.getProgress()+temp);
                }
            }
        });
    }
}
