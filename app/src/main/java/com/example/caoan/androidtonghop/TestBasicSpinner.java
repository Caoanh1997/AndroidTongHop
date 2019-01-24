package com.example.caoan.androidtonghop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.caoan.androidtonghop.Adapter.CountryCustomSpinnerAdapter;

import java.util.ArrayList;
import java.util.List;

public class TestBasicSpinner extends AppCompatActivity {
    private Spinner spinner;
    private TextView textView;
    private String[] arr = {"-- Select a national --","England","France","Sween","Spain","Russia","Italia"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_basic_spinner);
        spinner = findViewById(R.id.spinner);
        textView = findViewById(R.id.tv);

        //final String[] arr = getResources().getStringArray(R.array.countries);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,arr);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i != 0){
                    textView.setText(arr[i]);
                }else {
                    textView.setText("Choose national");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
}
