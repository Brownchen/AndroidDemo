package edu.whut.chenmin.job2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

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
        listView.setAdapter(songsAdapter);
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
