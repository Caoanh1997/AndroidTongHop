package com.example.caoan.androidtonghop;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.caoan.androidtonghop.Model.Player;

import java.io.Serializable;

public class SecondActivityForResult extends AppCompatActivity {
    private EditText ettitle;
    private Button btUpper, btLower;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_for_result);

        ettitle = findViewById(R.id.ettitle);
        btUpper = findViewById(R.id.btUpper);
        btLower = findViewById(R.id.btLower);

        btUpper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = String.valueOf(ettitle.getText());
                if(title.isEmpty()){
                    AlertDialog.Builder builder = new AlertDialog.Builder(SecondActivityForResult.this);
                    builder.setMessage("Ban phai nhap noi dung title");
                    builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }else {
                    Intent returnForResult = new Intent();
                    title = title.toUpperCase();
                    returnForResult.putExtra("result",title);
                    setResult(Activity.RESULT_OK,returnForResult);
                    finish();
                }
            }
        });
        btLower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = String.valueOf(ettitle.getText());
                if(title.isEmpty()){
                    AlertDialog.Builder builder = new AlertDialog.Builder(SecondActivityForResult.this);
                    builder.setMessage("Ban phai nhap noi dung title");
                    builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }else {
                    Intent returnForResult = new Intent();
                    title = title.toLowerCase();
                    returnForResult.putExtra("result",title);
                    setResult(Activity.RESULT_OK,returnForResult);
                    finish();
                }
            }
        });
    }
}
