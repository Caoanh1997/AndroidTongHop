package com.example.caoan.androidtonghop;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button bt,btdialog,btAlertDialog,btcustomdialog,bt1,bt2,bt3;
    private EditText edtUserName, edtPassword;
    private Button btnLogin, btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt = findViewById(R.id.bt);
        btdialog = findViewById(R.id.btdialog);
        btAlertDialog = findViewById(R.id.btalertdialog);
        btcustomdialog = findViewById(R.id.btcustomdialog);

        registerForContextMenu(bt);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btdialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setTitle("Nhap Title");
                dialog.setContentView(R.layout.dialog);
                dialog.show();
            }
        });
        btAlertDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Dang xuat");
                builder.setMessage("Ban co muon dang xuat?");
                builder.setPositiveButton("Co", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(),"Co dang xuat",Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("Khong", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                builder.setIcon(R.drawable.action);
                builder.setCancelable(true);
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
        /*btcustomdialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                LayoutInflater layoutInflater = getLayoutInflater();
                View dialogView  = layoutInflater.inflate(R.layout.login_dialog,null);
                builder.setView(dialogView);
                builder.setCancelable(true);
                builder.setTitle("Dang nhap");
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
                edtUserName = alertDialog.findViewById(R.id.edtUsername);
                edtPassword = alertDialog.findViewById(R.id.edtPassword);
                btnLogin = alertDialog.findViewById(R.id.btnLogin);
                btnCancel = alertDialog.findViewById(R.id.btnCancel);

                btnLogin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        System.out.println(String.valueOf(edtUserName.getText()));
                    }
                });
                btnCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getApplicationContext(),"Cancle",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });*/
        btcustomdialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                LayoutInflater inflater = getLayoutInflater();
                //View dialogView = inflater.inflate(R.layout.character_dialog,null); cai nay van dung
                View dialogView = LayoutInflater.from(MainActivity.this).inflate(R.layout.character_dialog,null);
                builder.setTitle("Chon nhan vat");
                builder.setView(dialogView);
                //builder.setView(R.layout.character_dialog);
                builder.setCancelable(true);
                AlertDialog alertDialog = builder.create();
                alertDialog.show();

                bt1 = dialogView.findViewById(R.id.bt1);
                bt2 = dialogView.findViewById(R.id.bt2);
                bt3 = dialogView.findViewById(R.id.bt3);

                bt1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getApplicationContext(),"chon "+bt1.getBackground(),Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        return super.onOptionsItemSelected(item);
        switch (item.getItemId()){
            case R.id.add:
                Toast.makeText(getApplicationContext(),"Press Add",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.help:
                Toast.makeText(getApplicationContext(),"Press Help",Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        //super.onCreateContextMenu(menu, v, menuInfo);
        //getMenuInflater().inflate(R.menu.contextmenu,menu);
        //menu.setHeaderIcon(getResources().getIdentifier("action","drawable",getPackageName()));
        menu.setHeaderIcon(R.drawable.action);
        menu.setHeaderTitle("Select action");
        menu.add(0,v.getId(),0,"Edit");
        menu.add(0,v.getId(),0,"Delete");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        //return super.onContextItemSelected(item);
        switch (item.getItemId()){
            case R.id.edit:
                Toast.makeText(getApplicationContext(),"Press Edit",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.delete:
                Toast.makeText(getApplicationContext(),"Press Delete",Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}
