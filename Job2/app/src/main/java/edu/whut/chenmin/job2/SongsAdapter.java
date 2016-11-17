package edu.whut.chenmin.job2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by brown on 2016/11/17.
 */

public class SongsAdapter extends ArrayAdapter<Songs> {

    private int resourceId;
    public SongsAdapter (Context context, int textViewResourceId, List<Songs> objects){
        super(context,textViewResourceId,objects);
        resourceId = textViewResourceId;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        Songs songs = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId,null);
        ImageView songsImage = (ImageView) view.findViewById(R.id.songs_image);
        TextView songsName = (TextView) view.findViewById(R.id.songs_name);
        TextView songsSinger = (TextView) view.findViewById(R.id.songs_singer);
        songsImage.setImageResource(songs.getImageId());
        songsName.setText(songs.getName());
        songsSinger.setText(songs.getSinger());
        return view;
    }
}
