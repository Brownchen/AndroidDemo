package com.example.brown.broadcasttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by brown on 2016/9/2.
 */
public class MybroadcastReceiver extends BroadcastReceiver {
    public void onReceive (Context context, Intent intent){
        Toast.makeText(context, "received in MyBroadCastReceiver", Toast.LENGTH_SHORT).show();
    }
}
