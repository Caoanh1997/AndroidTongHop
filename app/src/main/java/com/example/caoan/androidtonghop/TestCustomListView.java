package com.example.caoan.androidtonghop;

import android.content.DialogInterface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.example.caoan.androidtonghop.Adapter.PlayerListViewAdapter;
import com.example.caoan.androidtonghop.Model.Player;

import java.util.ArrayList;
import java.util.List;

public class TestCustomListView extends AppCompatActivity {

    private ListView listView;
    private List<Player> playerList;
    private List<Country> countryList;
    private EditText etname,etstar,etclub;
    private ViewFlipper viewFlipper;
    private Button btprevious,btnext,btadd;
    private ImageView iv1,iv2,iv3;
    private String name="";
    private String club="";
    private String star="";
    private int image;
    private PlayerListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_custom_list_view);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        listView = findViewById(R.id.lv);
        fillPlayerlist();

        adapter = new PlayerListViewAdapter(this,playerList);
        listView.setAdapter(adapter);
        //adapter.notifyDataSetChanged();
        registerForContextMenu(listView);

//        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
//        listView.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
//            @Override
//            public void onItemCheckedStateChanged(ActionMode actionMode, int i, long l, boolean b) {
//
//            }
//
//            @Override
//            public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
//                getMenuInflater().inflate(R.menu.multiple_choice,menu);
//                return false;
//            }
//
//            @Override
//            public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
//                return false;
//            }
//
//            @Override
//            public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
//                return false;
//            }
//
//            @Override
//            public void onDestroyActionMode(ActionMode actionMode) {
//
//            }
//        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(getApplicationContext(),"Position: "+i,Toast.LENGTH_SHORT).show();
                 listView.setTag(i);
                return false;
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
//        fillCountrylist();
//        CountryCustomSpinnerAdapter adapter = new CountryCustomSpinnerAdapter(this,countryList);
//        listView.setAdapter(adapter);

    }

//    public void fillCountrylist(){
//        countryList = new ArrayList<>();
//
//        countryList.add(new Country("England",R.drawable.england));
//        countryList.add(new Country("Spain",R.drawable.spain));
//        countryList.add(new Country("Sween",R.drawable.sween));
//        countryList.add(new Country("Italia",R.drawable.italia));
//        countryList.add(new Country("Russia",R.drawable.russia));
//        countryList.add(new Country("France",R.drawable.france));
//    }

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


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        //super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.contextmenu,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
//        return super.onContextItemSelected(item);
        switch (item.getItemId()){
            case R.id.edit:
                //Toast.makeText(getApplicationContext(),"Press edit",Toast.LENGTH_SHORT).show();
                final int position = (int) listView.getTag();
                //Toast.makeText(getApplicationContext(),"Position: "+position,Toast.LENGTH_SHORT).show();
                final Player player = playerList.get(position);
                final AlertDialog.Builder builder = new AlertDialog.Builder(this);
                View dialogView = getLayoutInflater().inflate(R.layout.edit_player_dialog,null);
                builder.setView(dialogView);
                ImageView ivavatar = dialogView.findViewById(R.id.ivavatar);
                ivavatar.setImageResource(player.getAvatar());
                TextView tvname = dialogView.findViewById(R.id.tvname);
                tvname.setText(player.getName());
                final EditText etscore = dialogView.findViewById(R.id.etscore);
                etscore.setText(String.valueOf(player.getScore()));
                final EditText etclub = dialogView.findViewById(R.id.etclub);
                etclub.setText(player.getClub());
                Button btsave = dialogView.findViewById(R.id.btsave);
                Button btcancel = dialogView.findViewById(R.id.btcancel);
                builder.setTitle("Edit Player");
                final AlertDialog alertDialog = builder.create();
                alertDialog.show();
                btsave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String str = String.valueOf(etscore.getText());
                        String club = String.valueOf(etclub.getText());
                        if (club.equals("")){
                            AlertDialog.Builder builder1 = new AlertDialog.Builder(TestCustomListView.this);
                            builder1.setTitle("Thong bao");
                            builder1.setMessage("Chua dien day du thong tin");
                            builder1.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.dismiss();
                                }
                            });
                            AlertDialog alertDialog1 = builder1.create();
                            alertDialog1.show();
                        }else {
                            try {
                                Float score = Float.valueOf(str);
                                playerList.get(position).setScore(score);
                                playerList.get(position).setClub(club);
                                alertDialog.dismiss();
                                listView.invalidateViews();
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                        }
                    }
                });
                btcancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        alertDialog.dismiss();
                    }
                });
                return true;
            case R.id.delete:
                //Toast.makeText(getApplicationContext(),"Press delete",Toast.LENGTH_SHORT).show();
                final int delete = (int) listView.getTag();
                AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
                builder1.setIcon(R.drawable.help);
                builder1.setTitle("Delete Player");
                builder1.setMessage("Are you sure to delete this player?");
                builder1.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        playerList.remove(delete);
                        dialogInterface.dismiss();
                        listView.invalidateViews();
                    }
                });
                builder1.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog alertDialog1 = builder1.create();
                alertDialog1.show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu,menu);

        MenuItem menuItem = menu.findItem(R.id.find);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //TestCustomListView.this.adapter.getFilter().filter(newText);
                //adapter.notifyDataSetChanged();
                //listView.invalidateViews();
                System.out.println(newText);
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add:
                //Toast.makeText(getApplicationContext(),"Choose add",Toast.LENGTH_SHORT).show();
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                View dialogView = getLayoutInflater().inflate(R.layout.add_player_layout,null);
                builder.setTitle("Add Player");
                builder.setView(dialogView);
                builder.setCancelable(true);

                final AlertDialog alertDialog = builder.create();
                alertDialog.show();

                etname = dialogView.findViewById(R.id.etname);
                etclub = dialogView.findViewById(R.id.etclub);
                etstar = dialogView.findViewById(R.id.etstar);
                viewFlipper = dialogView.findViewById(R.id.vf);
                btprevious = dialogView.findViewById(R.id.btprevious);
                btnext = dialogView.findViewById(R.id.btnext);
                btadd = dialogView.findViewById(R.id.btadd);
                iv1 = dialogView.findViewById(R.id.iv1);
                iv2 = dialogView.findViewById(R.id.iv2);
                iv3 = dialogView.findViewById(R.id.iv3);

                btnext.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        viewFlipper.showNext();
                        switch (viewFlipper.getCurrentView().getId()){
                            case R.id.iv1:
                                //Toast.makeText(getApplicationContext(),"Image 1",Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.iv2:
                                //Toast.makeText(getApplicationContext(),"Image 2",Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.iv3:
                                //Toast.makeText(getApplicationContext(),"Image 3",Toast.LENGTH_SHORT).show();
                                break;
                            default:
                                break;
                        }
                    }
                });
                btprevious.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        viewFlipper.showPrevious();
                        switch (viewFlipper.getCurrentView().getId()){
                            case R.id.iv1:
                                //Toast.makeText(getApplicationContext(),"Image 1",Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.iv2:
                                //Toast.makeText(getApplicationContext(),"Image 2",Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.iv3:
                                //Toast.makeText(getApplicationContext(),"Image 3",Toast.LENGTH_SHORT).show();
                                break;
                            default:
                                break;
                        }
                    }
                });
                btadd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        name = String.valueOf(etname.getText());
                        club = String.valueOf(etclub.getText());
                        star = String.valueOf(etstar.getText());

                        ImageView imageView = new ImageView(TestCustomListView.this);
                        imageView.setImageResource(R.drawable.ronaldo);

                        switch (viewFlipper.getCurrentView().getId()){
                            case R.id.iv1:
                                //Toast.makeText(getApplicationContext(),"Image 1",Toast.LENGTH_SHORT).show();
                                image  = R.drawable.ronaldo;
                                break;
                            case R.id.iv2:
                                //Toast.makeText(getApplicationContext(),"Image 2",Toast.LENGTH_SHORT).show();
                                image = R.drawable.messi;
                                break;
                            case R.id.iv3:
                                //Toast.makeText(getApplicationContext(),"Image 3",Toast.LENGTH_SHORT).show();
                                image = R.drawable.neymar;
                                break;
                            default:
                                image = getResources().getIdentifier("drawable","ronaldo",getPackageName());
                        }
                        if(name ==null || name.length()==0 || club == null || club.length()==0 || star == null ||star.length()==0){
                            Toast.makeText(getApplicationContext(),"Object Null",Toast.LENGTH_SHORT).show();
                        }else {
                            Float score = Float.valueOf(star);
                            Player player =new Player(name,score,image,club,"FC");

                            //Player player = new Player("Ronaldo",10,R.drawable.ronaldo,"Juventus","FC");
                            //Toast.makeText(getApplicationContext(),player.toString(),Toast.LENGTH_SHORT).show();
                            playerList.add(0,player);
                            adapter.notifyDataSetChanged();
                            alertDialog.dismiss();
                            //listView.invalidateViews();
                        }

                    }
                });
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
