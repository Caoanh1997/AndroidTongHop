package com.example.caoan.androidtonghop;

import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

public class TestActionBar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_action_bar);
        ActionBar actionBar = getSupportActionBar();
        //actionBar.setTitle("Le Cao Anh");
        //actionBar.hide();
        /*actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setLogo(R.drawable.action);
        actionBar.setDisplayUseLogoEnabled(true);*/

        //Lay chieu cao cua action bar
        TypedArray styledAttributes = getTheme().obtainStyledAttributes(new int[] {50});
        int actionBarSize = (int) styledAttributes.getDimension(0,0);
        styledAttributes.recycle();

        //Tao drawable moi co kich thuoc tuy chon
        /*Drawable drawable = getResources().getDrawable(R.drawable.action);
        Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
        Drawable newdrawable = new BitmapDrawable(getResources(),Bitmap.createScaledBitmap(bitmap,50,50,true));*/

        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setLogo(R.drawable.action);
        actionBar.setDisplayUseLogoEnabled(true);

        //hien mui ten back
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        /*Drawable drawable1 = getResources().getDrawable(R.drawable.ic_launcher);
        Bitmap bitmap1 = ((BitmapDrawable) drawable1).getBitmap();
        Drawable newdrawable1 = new BitmapDrawable(getResources(),Bitmap.createScaledBitmap(bitmap1,50,50,true));
        getSupportActionBar().setHomeAsUpIndicator(newdrawable1);*/
        //getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_action_find);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
