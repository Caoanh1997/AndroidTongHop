package com.example.caoan.androidtonghop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class FirstActivity extends AppCompatActivity {
    private Button bt1,bt2,bt3,bt4,bt5,bt6,bt7,bt8,bt9,bt10,bt11,bt12,bt13,bt14,bt15,bt16,bt17,bt18,bt19,bt20,bt21,bt22,bt23;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        bt1 = findViewById(R.id.btmainactivity);
        bt2 = findViewById(R.id.btdatetime);
        bt3 = findViewById(R.id.btgameyourmemory);
        bt4 = findViewById(R.id.bttransition);
        bt5 = findViewById(R.id.btprogressbar);
        bt6 = findViewById(R.id.btlevellist);
        bt7 = findViewById(R.id.btclip);
        bt8 = findViewById(R.id.btseekbar);
        bt9 = findViewById(R.id.btmultilanguage);
        bt10 = findViewById(R.id.btautocomplete);
        bt11 = findViewById(R.id.btcustomautocomplete);
        bt12 = findViewById(R.id.btbasiclistview);
        bt13 = findViewById(R.id.btcustomlistview);
        bt14 = findViewById(R.id.btbasicspinner);
        bt15 = findViewById(R.id.btcustomcspinner);
        bt16 = findViewById(R.id.btdemoSpandLv);
        bt17 = findViewById(R.id.btgridview);
        bt18 = findViewById(R.id.bthandler);
        bt19 = findViewById(R.id.btviewflipper);
        bt20 = findViewById(R.id.bttabhost);
        bt21 = findViewById(R.id.btactionbar);
        bt22 = findViewById(R.id.bttoolbar);
        bt23 = findViewById(R.id.btanimation);

        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FirstActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FirstActivity.this, DateTime.class);
                startActivity(intent);
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FirstActivity.this, GameYourMemory.class);
                startActivity(intent);
            }
        });
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FirstActivity.this, Transition.class);
                startActivity(intent);
            }
        });
        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FirstActivity.this, TestProgressBar.class);
                startActivity(intent);
            }
        });
        bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FirstActivity.this, LevelList.class);
                startActivity(intent);
            }
        });
        bt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FirstActivity.this, Clip.class);
                startActivity(intent);
            }
        });
        bt8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FirstActivity.this, TestSeekBar.class);
                startActivity(intent);
            }
        });
        bt9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FirstActivity.this, MultiLanguage.class);
                startActivity(intent);
            }
        });
        bt10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FirstActivity.this, TestAutoComplete.class);
                startActivity(intent);
            }
        });
        bt11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FirstActivity.this, TestCustomAutoComplete.class);
                startActivity(intent);
            }
        });
        bt12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FirstActivity.this, TestBasicListView.class);
                startActivity(intent);
            }
        });
        bt13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FirstActivity.this, TestCustomListView.class);
                startActivity(intent);
            }
        });
        bt14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FirstActivity.this, TestBasicSpinner.class);
                startActivity(intent);
            }
        });
        bt15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FirstActivity.this, TestCustomSpinner.class);
                startActivity(intent);
            }
        });
        bt16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FirstActivity.this, DemoSpinnerAndListView.class);
                startActivity(intent);
            }
        });
        bt17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FirstActivity.this, TestGridView.class);
                startActivity(intent);
            }
        });
        bt18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FirstActivity.this, TestHandler.class);
                startActivity(intent);
            }
        });
        bt19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FirstActivity.this, TestViewFlipper.class);
                startActivity(intent);
            }
        });
        bt20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FirstActivity.this, TestTabHost.class);
                startActivity(intent);
            }
        });
        bt21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FirstActivity.this, TestActionBar.class);
                startActivity(intent);
            }
        });
        bt22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FirstActivity.this, TestToolBar.class);
                startActivity(intent);
            }
        });
        bt23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FirstActivity.this, TestAnimation.class);
                //overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
                overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_to_left);
                startActivity(intent);
            }
        });
    }
}
