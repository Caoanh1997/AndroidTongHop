package com.example.caoan.androidtonghop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Space;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.caoan.androidtonghop.Adapter.CountryCustomSpinnerAdapter;

import java.util.ArrayList;
import java.util.List;

public class TestCustomSpinner extends AppCompatActivity {
    private List<Country> countryList;
    private Spinner customspinner;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_custom_spinner);
        customspinner = findViewById(R.id.customspinner);
        textView = findViewById(R.id.tv);

        fillCountrylist();
        CountryCustomSpinnerAdapter adapter = new CountryCustomSpinnerAdapter(this,countryList);
        customspinner.setAdapter(adapter);
        customspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Country country = (Country) adapterView.getItemAtPosition(i);
                textView.setText(country.getName());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
    public void fillCountrylist(){
        countryList = new ArrayList<>();

        countryList.add(new Country("England",R.drawable.england));
        countryList.add(new Country("Spain",R.drawable.spain));
        countryList.add(new Country("Sween",R.drawable.sween));
        countryList.add(new Country("Italia",R.drawable.italia));
        countryList.add(new Country("Russia",R.drawable.russia));
        countryList.add(new Country("France",R.drawable.france));
    }
}
