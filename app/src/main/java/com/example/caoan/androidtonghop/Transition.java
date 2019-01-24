package com.example.caoan.androidtonghop;

import android.graphics.drawable.TransitionDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Transition extends AppCompatActivity {
    private ImageView iv;
    private Button bt1,bt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition);

        iv = findViewById(R.id.iv);
        bt1 = findViewById(R.id.bt1);
        bt2 = findViewById(R.id.bt2);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TransitionDrawable transitionDrawable = (TransitionDrawable) iv.getDrawable();
                transitionDrawable.startTransition(500);
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TransitionDrawable transitionDrawable = (TransitionDrawable) iv.getDrawable();
                transitionDrawable.reverseTransition(500);
            }
        });


    }
}
