package edu.whut.chenmin.job2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener,View.OnClickListener {

    private List<Songs> songsList = new ArrayList<Songs>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initSongs();
        SongsAdapter songsAdapter = new SongsAdapter(MainActivity.this,R.layout.songs_item,songsList);
        ListView listView = (ListView) findViewById(R.id.list_view);
        Button pause = (Button) findViewById(R.id.pause);
        Button play = (Button) findViewById(R.id.play);
        Button stop = (Button) findViewById(R.id.stop);
        pause.setOnClickListener(this);
        play.setOnClickListener(this);
        stop.setOnClickListener(this);

        listView.setAdapter(songsAdapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.pause:

        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//        i = (Integer) view.getTag();
        Intent intent = new Intent(MainActivity.this,LyricsActivity.class);
        intent.putExtra("id", i);
        startActivity(intent);
//        switch (view.getId()){
//            case R.id.songs_image:
//        }
    }

    private void initSongs(){
        Songs m1 = new Songs(R.drawable.c1,"俾面派对","Beyond");
        songsList.add(m1);
        Songs m2 = new Songs(R.drawable.c2,"富士山下","陈奕迅");
        songsList.add(m2);
        Songs m3 = new Songs(R.drawable.c3,"无心睡眠","张国荣");
        songsList.add(m3);
    }
}
