package edu.whut.chenmin.job3;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by brown on 2016/11/28.
 */

public class MusicAdapter extends ArrayAdapter<MusicLoader.MusicInfo> {

    private int resourceId;

    public MusicAdapter(Context context, int resource, List<MusicLoader.MusicInfo> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MusicLoader.MusicInfo musicInfo = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId,null);
        ImageView musicImage = (ImageView) view.findViewById(R.id.songs_image);
        TextView musicTitle = (TextView) view.findViewById(R.id.songs_name);
        TextView musicSinger = (TextView) view.findViewById(R.id.songs_singer);
        musicImage.setImageResource(R.mipmap.ic_launcher);
        musicTitle.setText(musicInfo.getTitle());
        musicSinger.setText(musicInfo.getArtist());
        return view;
    }
}
