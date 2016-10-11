package brown.example.com.servicebestpractice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by brown on 2016/10/11.
 */

public class AlarmReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent){
        Intent intent1 = new Intent(context,LongRunningService.class);
        context.startService(intent1);
    }
}
