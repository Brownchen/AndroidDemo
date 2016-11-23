package edu.whut.chenmin.job2;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by brown on 2016/11/23.
 */

public class BindMusicPlayerService extends Service {

    private MediaPlayer mediaPlayer;

    int[] MP3List = {R.raw.m1,R.raw.m2,R.raw.m3};

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
    }
}
