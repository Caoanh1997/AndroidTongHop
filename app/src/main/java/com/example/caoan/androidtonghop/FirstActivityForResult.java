package com.example.caoan.androidtonghop;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.caoan.androidtonghop.Model.Player;

import java.io.Serializable;

public class FirstActivityForResult extends AppCompatActivity {

    private TextView tvtitle;
    private Button btchange;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_for_result);

        tvtitle = findViewById(R.id.tvtitle);
        btchange = findViewById(R.id.btchange);

        btchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FirstActivityForResult.this,SecondActivityForResult.class);
                startActivityForResult(intent,1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1){
            if(resultCode == Activity.RESULT_OK){
                String result = data.getStringExtra("result");
                tvtitle.setText(result);
            }
            if(resultCode == Activity.RESULT_CANCELED){
                //do thing....
            }
        }
    }
}
