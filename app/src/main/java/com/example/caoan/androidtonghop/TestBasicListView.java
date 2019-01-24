package com.example.caoan.androidtonghop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TestBasicListView extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_basic_list_view);

        listView = findViewById(R.id.lv);

        String[] arr = getResources().getStringArray(R.array.countries);

        listView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arr));
    }
}
