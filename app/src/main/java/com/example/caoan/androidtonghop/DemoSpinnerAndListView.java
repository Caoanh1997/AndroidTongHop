package com.example.caoan.androidtonghop;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.caoan.androidtonghop.Adapter.CountryAutoCompleteAdapter;
import com.example.caoan.androidtonghop.Adapter.PlayerListViewAdapter;
import com.example.caoan.androidtonghop.Model.Player;

import java.io.FilterReader;
import java.util.ArrayList;
import java.util.List;

public class DemoSpinnerAndListView extends AppCompatActivity {

    private Spinner spinner;
    private ListView listView;
    private List<Player> playerList;
    private EditText editText;
    private TextView textView;
    private Button button;
    //private CountryAutoCompleteAdapter countryAutoCompleteAdapter;
    private PlayerListViewAdapter playerListViewAdapter;
    private String[] arr = {"All","FC","MC","DC","GK"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_spinner_and_list_view);

        spinner = findViewById(R.id.spinner);
        listView = findViewById(R.id.lv);
        editText = findViewById(R.id.et);
        textView = findViewById(R.id.tv);
        button = findViewById(R.id.bt);

        button.setEnabled(false);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerListViewAdapter.notifyDataSetChanged();;
                listView.invalidateViews();
                //Toast.makeText(getApplicationContext(),"size: "+listView.getCount(),Toast.LENGTH_SHORT).show();
                button.setText("There are "+listView.getCount()+" player");
            }
        });

        fillPlayerlist();

        textView.setVisibility(View.GONE);
        editText.setVisibility(View.GONE);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                DemoSpinnerAndListView.this.playerListViewAdapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        playerListViewAdapter = new PlayerListViewAdapter(this,playerList);
        listView.setAdapter(playerListViewAdapter);

        final ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,arr);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(getApplicationContext(),"Choose: "+adapterView.getItemAtPosition(i),Toast.LENGTH_SHORT).show();
                DemoSpinnerAndListView.this.playerListViewAdapter.getFilter().filter((CharSequence) adapterView.getItemAtPosition(i));
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        button.performClick();
                    }
                },100);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),"index: "+i,Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void fillPlayerlist(){
        playerList = new ArrayList<>();

        playerList.add(new Player("Ronaldo",10,R.drawable.ronaldo,"Juventus","FC"));
        playerList.add(new Player("Messi",10,R.drawable.messi,"Barcelona","MC"));
        playerList.add(new Player("Rooney",9,R.drawable.rooney,"Everton","FC"));
        playerList.add(new Player("Neymar",9,R.drawable.neymar,"PSG","DC"));
        playerList.add(new Player("Mbappe", (float) 8.5,R.drawable.mbappe,"PSG","MC"));
        playerList.add(new Player("Aguero", (float) 9.5,R.drawable.aguero,"Manchester City","FC"));
        playerList.add(new Player("Aubameyang",9,R.drawable.aubameyang,"Arsernal","FC"));
        playerList.add(new Player("Antoine griezmann", (float) 9.5,R.drawable.antoinegriezmann,"Atletico Madrid","MC"));
        playerList.add(new Player("Degea", (float) 9.5,R.drawable.degea,"Manchester United","GK"));
        playerList.add(new Player("Kevin der bruyne",9,R.drawable.kevindebruyne,"Manchester City","MC"));
    }
    public int Size(String position){
        int i=0;
        for(Player player : playerList){
            if(player.getPosition()==position){
                i++;
            }
        }
        return i;
    }
}
