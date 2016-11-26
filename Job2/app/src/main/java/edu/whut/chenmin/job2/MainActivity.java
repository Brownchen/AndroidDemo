package edu.whut.chenmin.job2;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener,View.OnClickListener {

    private List<Songs> songsList = new ArrayList<Songs>();

    private BindMusicPlayerService bindMusicPlayerService;

    private ServiceConnection connection = new ServiceConnection(){

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.v("BindMusicButton", "in onServiceConnected(ComponentName name, IBinder service)");
            bindMusicPlayerService = ((BindMusicPlayerService.MyBinder)service).getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            bindMusicPlayerService = null;
            Log.v("BindMusicButton", "in onServiceDisconnected(ComponentName name) ");

        }};
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

//        Intent intent = new Intent(MainActivity.this,BindMusicPlayerService.class);
//        bindService(intent,connection,BIND_AUTO_CREATE);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.pause:
                bindMusicPlayerService.puase();
                break;
            case R.id.play:
                bindMusicPlayerService.play();
                break;
            case R.id.stop:
                bindMusicPlayerService.stop();
                break;

        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//        i = (Integer) view.getTag();
        Intent intent = new Intent(MainActivity.this,LyricsActivity.class);
        intent.putExtra("id", i);
        startActivity(intent);
        Intent serviceIntent = new Intent(MainActivity.this,BindMusicPlayerService.class);
        serviceIntent.putExtra("id",i);
        startService(serviceIntent);
        bindService(serviceIntent,connection,BIND_AUTO_CREATE);
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
