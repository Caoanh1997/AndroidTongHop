package com.example.caoan.androidtonghop.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.caoan.androidtonghop.Country;
import com.example.caoan.androidtonghop.R;

import java.util.ArrayList;
import java.util.List;

public class CountryAutoCompleteAdapter extends ArrayAdapter<Country> {

    private List<Country> countryList;
    //private Context mContext;
    //private int itemLayout;

//    public CountryAutoCompleteAdapter(@NonNull Context context, int resource, List<Country> countries) {
//        super(context, resource,countries);
//        countryList = countries;
//        mContext = context;
//        itemLayout = resource;
//    }
    public CountryAutoCompleteAdapter(@NonNull Context context, @NonNull List<Country> countries) {
        super(context, 0, countries);
        countryList = new ArrayList<>(countries);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        return super.getView(position, convertView, parent);

        if (convertView==null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.custom_autocomplete_country,parent,false);
        }

        TextView tv = convertView.findViewById(R.id.tv);
        ImageView iv = convertView.findViewById(R.id.iv);

        Country country = getItem(position);
        if(country !=null){
            tv.setText(country.getName());
            iv.setImageResource(country.getFlagImage());
        }
        return convertView;
    }

    @NonNull
    @Override
    public Filter getFilter() {
        return filter;
    }


    private Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            FilterResults results = new FilterResults();
            List<Country> suggestion = new ArrayList<>();
            if(charSequence == null || charSequence.length()==0){
                System.out.println("filter fail");
                suggestion.addAll(countryList);
                System.out.println(suggestion.size());
            }else {
//                System.out.println("filter");
                String s = charSequence.toString().toLowerCase().trim();
                System.out.println(s);
                for(Country country : countryList){
//                    if(country.getName().toLowerCase().contains(s)){
//                        suggestion.add(country);
//                    }
                    if(country.getName().toLowerCase().startsWith(s)){
                        suggestion.add(country);
                        //System.out.println(country.toString());
                    }
                }
                System.out.println(suggestion.size());
            }
            results.values = suggestion;
            results.count = suggestion.size();
//            System.out.println("size result: "+results.count);

            return results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            clear();
            addAll((List) filterResults.values);
            notifyDataSetChanged();
        }

        @Override
        public CharSequence convertResultToString(Object resultValue) {
//            return super.convertResultToString(resultValue);
            return ((Country) resultValue).getName();
        }
    };


}
