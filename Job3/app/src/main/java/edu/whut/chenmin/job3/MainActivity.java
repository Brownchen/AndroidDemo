package edu.whut.chenmin.job3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static edu.whut.chenmin.job3.MusicLoader.musicList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    ArrayList<Map<String,Object>> mData= new ArrayList<Map<String,Object>>();
    public TextView Title;
    public TextView singer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initList();
        MusicAdapter adapter = new MusicAdapter(MainActivity.this,R.layout.iconlist,musicList);
        ListView listview = (ListView) findViewById(R.id.list_view);
        //TextView Title = (TextView) findViewById(R.id.songs_name);
        //TextView singer = (TextView) findViewById(R.id.songs_singer);
//        Title.setText("不可撤销");
//        singer.setText("不可撤销");
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(this);


    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        Intent intent = new Intent(MainActivity.this,LyricActivity.class);
        //用Bundle携带数据
        Bundle bundle=new Bundle();
        //传递name参数为tinyphp
        bundle.putString("title", musicList.get(i).getTitle());
        bundle.putString("text", musicList.get(i).getArtist());
        intent.putExtras(bundle);

        startActivity(intent);
    }

    private void initList() {
        MusicLoader musicLoader = MusicLoader.instance(this.getContentResolver());
        final List<MusicLoader.MusicInfo> my_list = musicLoader.getMusicList();
        int lengh = my_list.size();
        for (int i = 0; i < lengh; i++) {
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("image", R.mipmap.ic_launcher);
            item.put("title", my_list.get(i).getTitle());
            item.put("text", my_list.get(i).getArtist());
            item.put("url", my_list.get(i).getUrl());
            mData.add(item);
        }
    }
}
