package edu.whut.chenmin.job2;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by brown on 2016/11/23.
 */

public class BindMusicPlayerService extends Service {

    private MediaPlayer mediaPlayer;

    int[] MP3List = {R.raw.m1, R.raw.m2, R.raw.m3};

    private IBinder binder = new MyBinder();

    class MyBinder extends Binder {
        BindMusicPlayerService getService() {
//            Log.v("BindMusicPlayerService", "in  BindMusicPlayerService getService()");
            return BindMusicPlayerService.this;
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
        }
    }

    public void play(){
        Log.v("BindMusicPlayerService", "in  play()");
//		if (mediaPlayer == null) {
//        mediaPlayer = MediaPlayer.create(this,MP3List[num]);
//        mediaPlayer.setLooping(false);
//		}
        if (!mediaPlayer.isPlaying()) {
            mediaPlayer.start();
        }

    }

    public void replay(){
        Log.v("BindMusicPlayerService", "in  replay()");
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(this,MP3List[0]);
            mediaPlayer.setLooping(false);
        }
        if (!mediaPlayer.isPlaying()) {
            mediaPlayer.start();
        }

    }

    public void puase(){
        Log.v("BindMusicPlayerService", "in puase()");
        if(mediaPlayer.isPlaying()&&mediaPlayer!=null){
            mediaPlayer.pause();
        }
    }

    public void stop(){
        Log.v("BindMusicPlayerService", "in stop()");
        if(mediaPlayer!=null){
            mediaPlayer.stop();
//            try {
//                mediaPlayer.prepare();
//            } catch (IllegalStateException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            } catch (IOException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
        }
    }
}
