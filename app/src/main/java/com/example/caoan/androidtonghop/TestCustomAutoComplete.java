package com.example.caoan.androidtonghop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

import com.example.caoan.androidtonghop.Adapter.PlayerAutoCompleteAdapter;
import com.example.caoan.androidtonghop.Model.Player;

import java.util.ArrayList;
import java.util.List;

public class TestCustomAutoComplete extends AppCompatActivity {

    private List<Player> playerList;
    private MultiAutoCompleteTextView autoCompleteTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_custom_auto_complete);
        autoCompleteTextView = findViewById(R.id.playerautocomplete);

        fillplayerlist();

        PlayerAutoCompleteAdapter adapter = new PlayerAutoCompleteAdapter(this,playerList);
        autoCompleteTextView.setAdapter(adapter);
        autoCompleteTextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
    }

    public void fillplayerlist(){
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
}
