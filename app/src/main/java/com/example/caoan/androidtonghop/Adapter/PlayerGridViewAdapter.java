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
import android.widget.Toast;

import com.example.caoan.androidtonghop.Model.Player;
import com.example.caoan.androidtonghop.R;

import java.util.List;

public class PlayerGridViewAdapter extends ArrayAdapter<Player> {

    private List<Player> playerList;
    public PlayerGridViewAdapter(@NonNull Context context, @NonNull List<Player> objects) {
        super(context, 0, objects);
        playerList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        return super.getView(position, convertView, parent);
        ViewHolder viewHolder;
        if(convertView==null){
            viewHolder = new ViewHolder();

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.player_grid_view_items,parent,false);
            viewHolder.tvname = convertView.findViewById(R.id.tvname);
            viewHolder.tvclub = convertView.findViewById(R.id.tvclub);
            viewHolder.ivavatar = convertView.findViewById(R.id.ivavatar);

            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Player player = getItem(position);
        if(player != null){
            viewHolder.tvname.setText(player.getName());
            viewHolder.tvclub.setText(player.getClub());
            viewHolder.ivavatar.setImageResource(player.getAvatar());
        }
        return convertView;
    }
    class ViewHolder{
        TextView tvname,tvclub;
        ImageView ivavatar;
    }
}
