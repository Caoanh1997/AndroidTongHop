package com.example.caoan.androidtonghop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import com.example.caoan.androidtonghop.Adapter.PlayerGridViewAdapter;
import com.example.caoan.androidtonghop.Model.Player;

import java.util.ArrayList;
import java.util.List;

public class TestGridView extends AppCompatActivity {
    private GridView gridView;
    private String[] arr = {"England","France","Sween","Spain","Russia","Italia"};
    private PlayerGridViewAdapter playerGridViewAdapter;
    private List<Player> playerList;
    private Animation animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_grid_view);
        gridView = findViewById(R.id.gv);

//        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,arr);
//        gridView.setAdapter(adapter);
        fillPlayerlist();
        playerGridViewAdapter = new PlayerGridViewAdapter(this,playerList);
        gridView.setAdapter(playerGridViewAdapter);

        //animation = new AnimationUtils().loadAnimation(getApplicationContext(),R.anim.slide_up);
        //gridView.startAnimation(animation);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),"Choose "+((Player)adapterView.getItemAtPosition(i)).getName(),Toast.LENGTH_SHORT).show();
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
}
