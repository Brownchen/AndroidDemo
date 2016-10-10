package brown.example.com.servicetest;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by brown on 2016/10/10.
 */

public class MyService extends Service {

    private DownloadBinder mBinder = new DownloadBinder();

    class DownloadBinder extends Binder{

        public void startDownload(){
            Log.d("MyService","startDownload executed");
        }

        public int getProgress(){
            Log.d("MyService","getProgress executed");
            return 0;
        }
    }

    public IBinder onBind(Intent intent){
        return mBinder;
    }

    public void onCreate(){
        super.onCreate();
        Log.d("MyService","onCreate executed");
    }

    public int onStartCommand(Intent intent ,int flags,int startId){
        Log.d("MyService","onStartCommand executed");
        return super.onStartCommand(intent,flags,startId);

    }

    public void onDestroy(){
        super.onDestroy();
        Log.d("MyService","onDestroy executed");
    }
}
