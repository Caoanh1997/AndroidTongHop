package com.example.caoan.androidtonghop;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.Random;

public class GameYourMemory extends AppCompatActivity {

    private ImageView iv1, iv2;
    private Button btAnswer, btAgain;
    private ImageButton btA1, btA2, btA3, btA4, btA5, btA6, btA7, btA8, btA9;
    private CheckBox cb;
    private String arr[] = {"galaxya5", "galaxys8", "samsunggalaxyj5", "oppo_f1s", "asuszenfone2lazer", "htcuultra",
            "lgg6", "iphone7plusblackselect2016", "asuszenfone3max"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_your_memory);

        iv1 = findViewById(R.id.iv1);
        iv2 = findViewById(R.id.iv2);
        btAnswer = findViewById(R.id.btAnswer);

        btAgain = findViewById(R.id.btAgain);
        btAgain.setVisibility(View.INVISIBLE);
        cb = findViewById(R.id.cb);

        cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cb.isChecked()){
                    btAnswer.setEnabled(false);
                }else {
                    btAnswer.setEnabled(true);
                }
            }
        });
        btAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(getIntent());
            }
        });

        int size = arr.length;

        Random random = new Random();
        int x = random.nextInt(size);
        String str = arr[x];

        final int resID = getResources().getIdentifier(str, "drawable", getPackageName());

        iv1.setImageResource(resID);

        btAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater = getLayoutInflater();
                View dialogAnswer = inflater.inflate(R.layout.answer_dialog, null);

                btA1 = dialogAnswer.findViewById(R.id.btA1);
                btA1.setImageResource(getResources().getIdentifier(arr[0], "drawable", getPackageName()));
                btA1.setTag(getResources().getIdentifier(arr[0], "drawable", getPackageName()));
                btA2 = dialogAnswer.findViewById(R.id.btA2);
                btA2.setImageResource(getResources().getIdentifier(arr[1], "drawable", getPackageName()));
                btA2.setTag(getResources().getIdentifier(arr[1], "drawable", getPackageName()));
                btA3 = dialogAnswer.findViewById(R.id.btA3);
                btA3.setImageResource(getResources().getIdentifier(arr[2], "drawable", getPackageName()));
                btA3.setTag(getResources().getIdentifier(arr[2], "drawable", getPackageName()));
                btA4 = dialogAnswer.findViewById(R.id.btA4);
                btA4.setImageResource(getResources().getIdentifier(arr[3], "drawable", getPackageName()));
                btA4.setTag(getResources().getIdentifier(arr[3], "drawable", getPackageName()));
                btA5 = dialogAnswer.findViewById(R.id.btA5);
                btA5.setImageResource(getResources().getIdentifier(arr[4], "drawable", getPackageName()));
                btA5.setTag(getResources().getIdentifier(arr[4], "drawable", getPackageName()));
                btA6 = dialogAnswer.findViewById(R.id.btA6);
                btA6.setImageResource(getResources().getIdentifier(arr[5], "drawable", getPackageName()));
                btA6.setTag(getResources().getIdentifier(arr[5], "drawable", getPackageName()));
                btA7 = dialogAnswer.findViewById(R.id.btA7);
                btA7.setImageResource(getResources().getIdentifier(arr[6], "drawable", getPackageName()));
                btA7.setTag(getResources().getIdentifier(arr[6], "drawable", getPackageName()));
                btA8 = dialogAnswer.findViewById(R.id.btA8);
                btA8.setImageResource(getResources().getIdentifier(arr[7], "drawable", getPackageName()));
                btA8.setTag(getResources().getIdentifier(arr[7], "drawable", getPackageName()));
                btA9 = dialogAnswer.findViewById(R.id.btA9);
                btA9.setImageResource(getResources().getIdentifier(arr[8], "drawable", getPackageName()));
                btA9.setTag(getResources().getIdentifier(arr[8], "drawable", getPackageName()));

                final AlertDialog.Builder builder = new AlertDialog.Builder(GameYourMemory.this);
                builder.setView(dialogAnswer);
                final AlertDialog alertDialog = builder.create();
                alertDialog.show();
                btA1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //Toast.makeText(getApplicationContext(), "chon "+ btA1.getBackground(),Toast.LENGTH_LONG).show();
                        alertDialog.dismiss();

                        iv2.setImageResource(getResources().getIdentifier(arr[0], "drawable", getPackageName()));
                        Integer integer = (Integer) btA1.getTag();
                        if (resID == integer) {
                            AlertDialog.Builder builder1 = new AlertDialog.Builder(GameYourMemory.this);
                            builder1.setMessage("Dung");
                            builder1.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.dismiss();
                                    finish();
                                    startActivity(getIntent());
                                }
                            });
                            AlertDialog alertDialog1 = builder1.create();
                            alertDialog1.show();
                        } else {
                            AlertDialog.Builder builder1 = new AlertDialog.Builder(GameYourMemory.this);
                            builder1.setMessage("Sai");
                            builder1.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.dismiss();
                                }
                            });
                            AlertDialog alertDialog1 = builder1.create();
                            alertDialog1.show();
                        }
                    }
                });
                btA2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //Toast.makeText(getApplicationContext(), "chon "+ btA1.getBackground(),Toast.LENGTH_LONG).show();
                        alertDialog.dismiss();

                        iv2.setImageResource(getResources().getIdentifier(arr[1], "drawable", getPackageName()));
                        Integer integer = (Integer) btA2.getTag();
                        if (resID == integer) {
                            AlertDialog.Builder builder1 = new AlertDialog.Builder(GameYourMemory.this);
                            builder1.setMessage("Dung");
                            builder1.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.dismiss();
                                    finish();
                                    startActivity(getIntent());
                                }
                            });
                            AlertDialog alertDialog1 = builder1.create();
                            alertDialog1.show();
                        } else {
                            AlertDialog.Builder builder1 = new AlertDialog.Builder(GameYourMemory.this);
                            builder1.setMessage("Sai");
                            builder1.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.dismiss();
                                }
                            });
                            AlertDialog alertDialog1 = builder1.create();
                            alertDialog1.show();
                        }
                    }
                });
                btA3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //Toast.makeText(getApplicationContext(), "chon "+ btA1.getBackground(),Toast.LENGTH_LONG).show();
                        alertDialog.dismiss();

                        iv2.setImageResource(getResources().getIdentifier(arr[2], "drawable", getPackageName()));
                        Integer integer = (Integer) btA3.getTag();
                        if (resID == integer) {
                            AlertDialog.Builder builder1 = new AlertDialog.Builder(GameYourMemory.this);
                            builder1.setMessage("Dung");
                            builder1.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.dismiss();
                                    finish();
                                    startActivity(getIntent());
                                }
                            });
                            AlertDialog alertDialog1 = builder1.create();
                            alertDialog1.show();
                        } else {
                            AlertDialog.Builder builder1 = new AlertDialog.Builder(GameYourMemory.this);
                            builder1.setMessage("Sai");
                            builder1.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.dismiss();
                                }
                            });
                            AlertDialog alertDialog1 = builder1.create();
                            alertDialog1.show();
                        }
                    }
                });
                btA4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //Toast.makeText(getApplicationContext(), "chon "+ btA1.getBackground(),Toast.LENGTH_LONG).show();
                        alertDialog.dismiss();

                        iv2.setImageResource(getResources().getIdentifier(arr[3], "drawable", getPackageName()));
                        Integer integer = (Integer) btA4.getTag();
                        if (resID == integer) {
                            AlertDialog.Builder builder1 = new AlertDialog.Builder(GameYourMemory.this);
                            builder1.setMessage("Dung");
                            builder1.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.dismiss();
                                    finish();
                                    startActivity(getIntent());
                                }
                            });
                            AlertDialog alertDialog1 = builder1.create();
                            alertDialog1.show();
                        } else {
                            AlertDialog.Builder builder1 = new AlertDialog.Builder(GameYourMemory.this);
                            builder1.setMessage("Sai");
                            builder1.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.dismiss();
                                }
                            });
                            AlertDialog alertDialog1 = builder1.create();
                            alertDialog1.show();
                        }
                    }
                });
                btA5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //Toast.makeText(getApplicationContext(), "chon "+ btA1.getBackground(),Toast.LENGTH_LONG).show();
                        alertDialog.dismiss();

                        iv2.setImageResource(getResources().getIdentifier(arr[4], "drawable", getPackageName()));
                        Integer integer = (Integer) btA5.getTag();
                        if (resID == integer) {
                            AlertDialog.Builder builder1 = new AlertDialog.Builder(GameYourMemory.this);
                            builder1.setMessage("Dung");
                            builder1.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.dismiss();
                                    finish();
                                    startActivity(getIntent());
                                }
                            });
                            AlertDialog alertDialog1 = builder1.create();
                            alertDialog1.show();
                        } else {
                            AlertDialog.Builder builder1 = new AlertDialog.Builder(GameYourMemory.this);
                            builder1.setMessage("Sai");
                            builder1.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.dismiss();
                                }
                            });
                            AlertDialog alertDialog1 = builder1.create();
                            alertDialog1.show();
                        }
                    }
                });
                btA6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //Toast.makeText(getApplicationContext(), "chon "+ btA1.getBackground(),Toast.LENGTH_LONG).show();
                        alertDialog.dismiss();

                        iv2.setImageResource(getResources().getIdentifier(arr[5], "drawable", getPackageName()));
                        Integer integer = (Integer) btA6.getTag();
                        if (resID == integer) {
                            AlertDialog.Builder builder1 = new AlertDialog.Builder(GameYourMemory.this);
                            builder1.setMessage("Dung");
                            builder1.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.dismiss();
                                    finish();
                                    startActivity(getIntent());
                                }
                            });
                            AlertDialog alertDialog1 = builder1.create();
                            alertDialog1.show();
                        } else {
                            AlertDialog.Builder builder1 = new AlertDialog.Builder(GameYourMemory.this);
                            builder1.setMessage("Sai");
                            builder1.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.dismiss();
                                }
                            });
                            AlertDialog alertDialog1 = builder1.create();
                            alertDialog1.show();
                        }
                    }
                });
                btA7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //Toast.makeText(getApplicationContext(), "chon "+ btA1.getBackground(),Toast.LENGTH_LONG).show();
                        alertDialog.dismiss();

                        iv2.setImageResource(getResources().getIdentifier(arr[6], "drawable", getPackageName()));
                        Integer integer = (Integer) btA7.getTag();
                        if (resID == integer) {
                            AlertDialog.Builder builder1 = new AlertDialog.Builder(GameYourMemory.this);
                            builder1.setMessage("Dung");
                            builder1.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.dismiss();
                                    finish();
                                    startActivity(getIntent());
                                }
                            });
                            AlertDialog alertDialog1 = builder1.create();
                            alertDialog1.show();
                        } else {
                            AlertDialog.Builder builder1 = new AlertDialog.Builder(GameYourMemory.this);
                            builder1.setMessage("Sai");
                            builder1.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.dismiss();
                                }
                            });
                            AlertDialog alertDialog1 = builder1.create();
                            alertDialog1.show();
                        }
                    }
                });
                btA8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //Toast.makeText(getApplicationContext(), "chon "+ btA1.getBackground(),Toast.LENGTH_LONG).show();
                        alertDialog.dismiss();

                        iv2.setImageResource(getResources().getIdentifier(arr[7], "drawable", getPackageName()));
                        Integer integer = (Integer) btA8.getTag();
                        if (resID == integer) {
                            AlertDialog.Builder builder1 = new AlertDialog.Builder(GameYourMemory.this);
                            builder1.setMessage("Dung");
                            builder1.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.dismiss();
                                    finish();
                                    startActivity(getIntent());
                                }
                            });
                            AlertDialog alertDialog1 = builder1.create();
                            alertDialog1.show();
                        } else {
                            AlertDialog.Builder builder1 = new AlertDialog.Builder(GameYourMemory.this);
                            builder1.setMessage("Sai");
                            builder1.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.dismiss();
                                }
                            });
                            AlertDialog alertDialog1 = builder1.create();
                            alertDialog1.show();
                        }
                    }
                });
                btA9.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //Toast.makeText(getApplicationContext(), "chon "+ btA1.getBackground(),Toast.LENGTH_LONG).show();
                        alertDialog.dismiss();

                        iv2.setImageResource(getResources().getIdentifier(arr[8], "drawable", getPackageName()));
                        Integer integer = (Integer) btA9.getTag();
                        if (resID == integer) {
                            AlertDialog.Builder builder1 = new AlertDialog.Builder(GameYourMemory.this);
                            builder1.setMessage("Dung");
                            builder1.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.dismiss();
                                    finish();
                                    startActivity(getIntent());
                                }
                            });
                            AlertDialog alertDialog1 = builder1.create();
                            alertDialog1.show();
                        } else {
                            AlertDialog.Builder builder1 = new AlertDialog.Builder(GameYourMemory.this);
                            builder1.setMessage("Sai");
                            builder1.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.dismiss();
                                }
                            });
                            AlertDialog alertDialog1 = builder1.create();
                            alertDialog1.show();
                        }
                    }
                });
            }
        });
    }

    public void Click(View view) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        return super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.refresh:
                finish();
                startActivity(getIntent());
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
