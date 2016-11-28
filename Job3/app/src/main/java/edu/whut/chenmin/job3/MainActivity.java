package edu.whut.chenmin.job3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static edu.whut.chenmin.job3.MusicLoader.musicList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Map<String,Object>> mData= new ArrayList<Map<String,Object>>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initList();
        MusicAdapter adapter = new MusicAdapter(MainActivity.this,R.layout.iconlist,musicList);
        ListView listview = (ListView) findViewById(R.id.list_view);
        listview.setAdapter(adapter);
    }

    private void initList() {
        MusicLoader musicLoader = MusicLoader.instance(this.getContentResolver());
        final List<MusicLoader.MusicInfo> my_list = musicLoader.getMusicList();
        int lengh = my_list.size();
        for (int i = 0; i < lengh; i++) {
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("image", R.mipmap.ic_launcher);
            item.put("title", my_list.get(i).getTitle().substring(0, my_list.get(i).getTitle().lastIndexOf('.')));
            item.put("text", my_list.get(i).getArtist());
            item.put("url", my_list.get(i).getUrl());
            mData.add(item);
        }
    }
}
