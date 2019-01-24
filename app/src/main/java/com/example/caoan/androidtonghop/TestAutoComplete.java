package com.example.caoan.androidtonghop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;

import com.example.caoan.androidtonghop.Adapter.CountryAutoCompleteAdapter;

import java.util.ArrayList;
import java.util.List;

public class TestAutoComplete extends AppCompatActivity {
    private AutoCompleteTextView autoCompleteTextView,customAutoComplete;
    private MultiAutoCompleteTextView multiAutoCompleteTextView;
    private List<Country> countryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_auto_complete);

        autoCompleteTextView = findViewById(R.id.autocomplete);
        multiAutoCompleteTextView = findViewById(R.id.multiautocomplete);
        customAutoComplete = findViewById(R.id.customautocomplete);

        String[] arr = getResources().getStringArray(R.array.countries);
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,arr);
        autoCompleteTextView.setAdapter(adapter);
        autoCompleteTextView.setThreshold(1);
        multiAutoCompleteTextView.setAdapter(adapter);
        multiAutoCompleteTextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
        multiAutoCompleteTextView.setThreshold(1);

        fillCountrylist();
        CountryAutoCompleteAdapter countryAutoCompleteAdapter = new CountryAutoCompleteAdapter(this,countryList);
        customAutoComplete.setAdapter(countryAutoCompleteAdapter);
        customAutoComplete.setThreshold(1);
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
