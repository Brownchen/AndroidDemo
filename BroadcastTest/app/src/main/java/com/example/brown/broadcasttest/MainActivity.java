package com.example.brown.broadcasttest;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity{

    private IntentFilter intentFilter;

//    private NetworkChangeReceiver networkChangeReceiver;

    private LocalReceiver localReceiver;

    private LocalBroadcastManager localBroadcastManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        localBroadcastManager = LocalBroadcastManager.getInstance(this);


        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("com.example.broadcasttest.LOCAL_BROADCAST");
                localBroadcastManager.registerReceiver(localReceiver,intentFilter);
            }
        });
        intentFilter = new IntentFilter();
        intentFilter.addAction("com.example.broadcasttest.LOCAL_BROADCAST");
        localReceiver = new LocalReceiver();
        localBroadcastManager.registerReceiver(localReceiver,intentFilter);
    }

    protected void onDestroy(){
        super.onDestroy();
        localBroadcastManager.unregisterReceiver(localReceiver);
    }


    class LocalReceiver extends BroadcastReceiver{
        public void onReceive(Context context,Intent intent){
            Toast.makeText(context, "receiver local broadcast", Toast.LENGTH_SHORT).show();
        }
    }

//    protected void onDestory(){
//        super.onDestroy();
//        unregisterReceiver(networkChangeReceiver);
//    }
//
//    class NetworkChangeReceiver extends BroadcastReceiver{
//        public void onReceive(Context context, Intent intent){
////            Toast.makeText(context, "network changes", Toast.LENGTH_SHORT).show();
//            ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
//            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
//            if (networkInfo != null && networkInfo.isAvailable()){
//                Toast.makeText(context, "network is available", Toast.LENGTH_SHORT).show();
//            }else {
//                Toast.makeText(context, "network is unavailable", Toast.LENGTH_SHORT).show();
//            }
//        }
//    }
}
