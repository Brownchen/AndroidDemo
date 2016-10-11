package brown.example.com.servicebestpractice;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.Log;

import java.util.Date;

/**
 * Created by brown on 2016/10/11.
 */

public class LongRunningService extends Service {

    public IBinder onBind(Intent intent){
        return null;
    }

    public int onStartCommand(Intent intent ,int flags, int startId){
        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.d("LongRunningService","executed at " + new Date().toString());
            }
        }).start();
        AlarmManager manager = (AlarmManager) getSystemService(ALARM_SERVICE);
        int minute = 60*1000;
        long triggerAtTime = SystemClock.elapsedRealtime() + minute;
        Intent intent1 = new Intent(this,AlarmReceiver.class);
        PendingIntent pi = PendingIntent.getBroadcast(this,0,intent,0);
        manager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,triggerAtTime,pi);
        return super.onStartCommand(intent,flags,startId);
    }
}
