package com.example.caoan.androidtonghop;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class TestViewFlipper extends AppCompatActivity {

    private ViewFlipper viewFlipper;
    private Button btprevious,btnext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_view_flipper);

        viewFlipper = findViewById(R.id.vf);
        btprevious = findViewById(R.id.btprevious);
        btnext = findViewById(R.id.btnext);


        btprevious.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                viewFlipper.showPrevious();
                choose();
            }
        });
        btnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewFlipper.showNext();
                choose();
            }
        });
    }
    public void choose(){
        switch (viewFlipper.getCurrentView().getId()){
            case R.id.iv1:
                Toast.makeText(getApplicationContext(),"Image 1",Toast.LENGTH_SHORT).show();
                break;
            case R.id.iv2:
                Toast.makeText(getApplicationContext(),"Image 2",Toast.LENGTH_SHORT).show();
                break;
            case R.id.iv3:
                Toast.makeText(getApplicationContext(),"Image 3",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
