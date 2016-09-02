package com.example.brown.broadcasttest;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity{

    private IntentFilter intentFilter;

//    private NetworkChangeReceiver networkChangeReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        intentFilter = new IntentFilter();
//        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
//        networkChangeReceiver = new NetworkChangeReceiver();
//        registerReceiver(networkChangeReceiver,intentFilter);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("com.example.broadcasttest.MY_BROADCAST");
                sendBroadcast(intent);
            }
        });
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
