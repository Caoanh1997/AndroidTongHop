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

import com.example.caoan.androidtonghop.Model.Player;
import com.example.caoan.androidtonghop.R;

import java.util.ArrayList;
import java.util.List;

public class PlayerListViewAdapter extends ArrayAdapter<Player> {
    private List<Player> playerList;
    public PlayerListViewAdapter(@NonNull Context context, @NonNull List<Player> objects) {
        super(context, 0, objects);
        playerList = new ArrayList<>(objects);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        return super.getView(position, convertView, parent);
        ViewHolder viewHolder;
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.player_autocomplete,parent,false);

            viewHolder = new ViewHolder();
            viewHolder.ivavatar = convertView.findViewById(R.id.ivavatar);
            viewHolder.tvname = convertView.findViewById(R.id.tvname);
            viewHolder.tvscore = convertView.findViewById(R.id.tvscore);
            viewHolder.tvclub = convertView.findViewById(R.id.tvclub);

            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Player player = getItem(position);
        if(player != null){
            viewHolder.ivavatar.setImageResource(player.getAvatar());
            viewHolder.tvname.setText(player.getName());
            viewHolder.tvscore.setText(String.valueOf(player.getScore()));
            viewHolder.tvclub.setText(player.getClub());
        }
        return convertView;
    }

    //dung class ViewHolder de giam thieu so lan goi findViewbyId()
    class ViewHolder{
        private ImageView ivavatar;
        private TextView tvname, tvscore, tvclub;
    }
    private Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            FilterResults results = new FilterResults();
            List<Player> suggestions = new ArrayList<>();

            if(charSequence == null || charSequence.length()==0 || charSequence.toString().equals("All")){
                suggestions.addAll(playerList);
            }else {
//                System.out.println("Filter");
                String s = charSequence.toString().toLowerCase().trim();
                for(Player player : playerList){
                    if(player.getPosition().toLowerCase().equals(s)){
                        suggestions.add(player);
                    }

                }
            }
            results.values = suggestions;
            results.count = suggestions.size();
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
            return ((Player) resultValue).getName();
        }
    };

    @NonNull
    @Override
    public Filter getFilter() {
        return filter;
    }
}
