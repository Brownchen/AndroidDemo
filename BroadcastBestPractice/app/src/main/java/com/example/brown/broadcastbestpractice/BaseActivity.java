package com.example.brown.broadcastbestpractice;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by brown on 2016/9/4.
 */
public class BaseActivity extends Activity {

    protected void oncreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);
    }

    protected void onDestroy(){
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }
}
