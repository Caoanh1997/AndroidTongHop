package com.example.caoan.androidtonghop.Adapter;

import android.content.Context;
import android.renderscript.ScriptIntrinsicYuvToRGB;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.caoan.androidtonghop.Model.Player;
import com.example.caoan.androidtonghop.R;

import java.util.ArrayList;
import java.util.List;

public class PlayerAutoCompleteAdapter extends ArrayAdapter {
    private List<Player> playerList;
    public PlayerAutoCompleteAdapter(@NonNull Context context, @NonNull List<Player> list) {
        super(context, 0, list);
        playerList = new ArrayList<>(list);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //return super.getView(position, convertView, parent);
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.player_autocomplete,parent,false);
        }
        ImageView ivavatar = convertView.findViewById(R.id.ivavatar);
        TextView tvname = convertView.findViewById(R.id.tvname);
        TextView tvscore = convertView.findViewById(R.id.tvscore);
        TextView tvclub = convertView.findViewById(R.id.tvclub);

        Player player = (Player) getItem(position);
        if(player != null){
            ivavatar.setImageResource(player.getAvatar());
            tvname.setText(player.getName());
            tvscore.setText(String.valueOf(player.getScore()));
            tvclub.setText(player.getClub());
        }
        return convertView;
    }

    private Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            FilterResults results = new FilterResults();
            List<Player> suggestion = new ArrayList<>();
            if(charSequence == null || charSequence.length()==0){
                suggestion.addAll(playerList);
            }else {
                String s = charSequence.toString().toLowerCase().trim();
                System.out.println(s);
                for (Player player : playerList){
                    if(player.getName().toLowerCase().contains(s)){
                        suggestion.add(player);
                    }
                }
            }
            results.values = suggestion;
            results.count = suggestion.size();
            return results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            clear();
            addAll((List)filterResults.values);
            notifyDataSetChanged();
        }

        @Override
        public CharSequence convertResultToString(Object resultValue) {
            return ((Player)resultValue).getName();
        }
    };

    @NonNull
    @Override
    public Filter getFilter() {
        return filter;
    }
}
