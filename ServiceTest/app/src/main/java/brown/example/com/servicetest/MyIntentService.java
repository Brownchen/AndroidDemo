package brown.example.com.servicetest;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/**
 * Created by brown on 2016/10/11.
 */

public class MyIntentService extends IntentService {

    public MyIntentService(){
        super("MyIntentService");
    }

    protected void onHandleIntent(Intent intent){
        Log.d("MyIntentService","Thread id is " + Thread.currentThread().getId());
    }

    public void onDestroy(){
        super.onDestroy();
        Log.d("MyIntentService","onDestroy");
    }
}
