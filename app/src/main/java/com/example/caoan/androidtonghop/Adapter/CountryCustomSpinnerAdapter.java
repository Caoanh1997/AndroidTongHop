package com.example.caoan.androidtonghop.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.caoan.androidtonghop.Country;
import com.example.caoan.androidtonghop.R;

import java.util.List;

public class CountryCustomSpinnerAdapter extends ArrayAdapter<Country> {

    private List<Country> countryList;
    public CountryCustomSpinnerAdapter(@NonNull Context context, @NonNull List<Country> countries) {
        super(context, 0, countries);
        countryList = countries;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        return super.getView(position, convertView, parent);
        return initView(position,convertView,parent);
    }
    class ViewHolder{
        private ImageView iv;
        private TextView tv;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //return super.getDropDownView(position, convertView, parent);
        return initView(position,convertView,parent);
    }

    public View initView(int position, View convertView, ViewGroup parent){
        ViewHolder viewHolder;
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.custom_spinner_item,parent,false);

            viewHolder = new ViewHolder();
            viewHolder.iv = convertView.findViewById(R.id.ivnational);
            viewHolder.tv = convertView.findViewById(R.id.tvnational);

            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Country country = (Country) getItem(position);
        if(country != null){
            viewHolder.iv.setImageResource(country.getFlagImage());
            viewHolder.tv.setText(country.getName());
        }
        return convertView;
    }
}
