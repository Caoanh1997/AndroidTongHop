package com.example.caoan.androidtonghop;

import android.app.AlertDialog;
import android.app.TabActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.example.caoan.androidtonghop.Model.Player;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class TestTabHost extends TabActivity implements View.OnClickListener {
    private TabHost tabHost;
    private EditText etname,etclub,etstar;
    private Button btprevious,btnext,btadd;
    private ViewFlipper viewFlipper;
    private ImageView iv1,iv2,iv3;
    private String name="";
    private String club="";
    private String star="";
    private int image;
    private ListView lv;
    private ArrayList<String> stringArrayList;
//    String s1 = "Add";
//    String s2 = "Edit";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        stringArrayList = new ArrayList<>();
//        stringArrayList.add(s1);
//        stringArrayList.add(s2);
//          setContentView(R.layout.activity_test_tab_host);
        /*tabHost = findViewById(android.R.id.tabhost);
        TabHost.TabSpec tabSpec1 = tabHost.newTabSpec("Tab1");
        tabSpec1.setIndicator("Tab 1",getDrawable(R.drawable.edit_tabhost));
        TabHost.TabSpec tabSpec2 = tabHost.newTabSpec("Tab2");
        tabSpec2.setIndicator("Tab 2",getDrawable(R.drawable.list));*/
        tabHost = getTabHost();
//        tabHost.setup();
        LayoutInflater.from(this).inflate(R.layout.activity_test_tab_host, tabHost.getTabContentView(),true);
//        tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator("Tab 1",getDrawable(R.drawable.tab_selector)).setContent(R.id.tv1));
//        tabHost.addTab(tabHost.newTabSpec("tab2").setIndicator("Tab 2",getDrawable(R.drawable.tab_selector)).setContent(R.id.tv2));

        ImageView imageView = new ImageView(this);
        imageView.setImageResource(R.drawable.edit_tabhost);
        View view = getLayoutInflater().inflate(R.layout.tab1_layout,null);
        ImageView imageView1 = new ImageView(this);
        imageView1.setImageResource(R.drawable.list);
        TabHost.TabSpec  tabSpec;
        tabSpec = tabHost.newTabSpec("tab1");
        tabSpec.setIndicator(view);
        //tabSpec.setContent(R.id.tv1);
        tabSpec.setContent(new TabHost.TabContentFactory() {
            @Override
            public View createTabContent(String s) {
                LinearLayout linearLayout = new LinearLayout(getBaseContext());
                linearLayout.setOrientation(LinearLayout.VERTICAL);
                Button bt1 = new Button(getBaseContext());
//                int i = 1;
//                bt1.setId(i);
                bt1.setWidth(200);
                bt1.setHeight(50);
                bt1.setGravity(Gravity.CENTER);
                bt1.setText("Add Player");
                bt1.setTextSize(25);
                linearLayout.addView(bt1);

                Button bt2 = new Button(getBaseContext());
                bt2.setWidth(200);
                bt2.setHeight(50);
                bt2.setGravity(Gravity.CENTER);
                bt2.setText("Edit Player");
                bt2.setTextSize(25);
                linearLayout.addView(bt2);

                bt1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //Toast.makeText(getApplicationContext(),"Add",Toast.LENGTH_SHORT).show();
                        Calendar calendar = Calendar.getInstance();
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss a");
                        //int h = calendar.get(Calendar.HOUR);
                        String s = simpleDateFormat.format(calendar.getTime());
                        s += ": Add";
                        stringArrayList.add(s);
                        tabHost.setCurrentTabByTag("tab2");
                    }
                });
                bt2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //Toast.makeText(getApplicationContext(),"Edit",Toast.LENGTH_SHORT).show();
                        Calendar calendar = Calendar.getInstance();
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss a");
                        //int h = calendar.get(Calendar.HOUR);
                        String s = simpleDateFormat.format(calendar.getTime());
                        s += ": Edit";
                        stringArrayList.add(s);
                    }
                });


                return linearLayout;
            }
        });
        tabHost.addTab(tabSpec);
        tabSpec = tabHost.newTabSpec("tab2");
        tabSpec.setIndicator(getLayoutInflater().inflate(R.layout.tab2_layout,null));
        lv = findViewById(R.id.lv);
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,stringArrayList);
        lv.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        lv.invalidateViews();
        tabSpec.setContent(R.id.lv);
        tabHost.addTab(tabSpec);
        tabHost.addTab(tabHost.newTabSpec("tab3").setIndicator("Tab 3",getDrawable(R.drawable.add)).setContent(R.id.progressbar));
        tabHost.addTab(tabHost.newTabSpec("tab4").setIndicator("Tab 4",getDrawable(R.drawable.add)).setContent(new Intent(this,DemoSpinnerAndListView.class)));


        /*tabHost = findViewById(android.R.id.tabhost);
        TabHost.TabSpec tabSpec;
        tabSpec = tabHost.newTabSpec("tab1");
        tabSpec.setIndicator("Tab 1",getResources().getDrawable(R.drawable.edit_tabhost));
        tabSpec.setContent(new Intent(this,DemoSpinnerAndListView.class));
        tabHost.addTab(tabSpec);
        tabSpec = tabHost.newTabSpec("tab2");
        tabSpec.setIndicator("Tab 2",getResources().getDrawable(R.drawable.list));
        tabSpec.setContent(new Intent(this,TestCustomListView.class));
        tabHost.addTab(tabSpec);*/

        tabHost.setCurrentTab(0);
        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String s) {
                //Toast.makeText(getApplicationContext(),"Tab ID: "+s,Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case 1:
                Toast.makeText(getApplicationContext(),"Add",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
