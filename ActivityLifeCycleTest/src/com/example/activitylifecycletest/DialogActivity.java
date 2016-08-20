package com.example.activitylifecycletest;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class DialogActivity extends Activity {

	public DialogActivity() {
		// TODO Auto-generated constructor stub
	}
    protected void onCreate(Bundle savedInstanceState){
    	super.onCreate(savedInstanceState);
    	requestWindowFeature(Window.FEATURE_NO_TITLE);
    	setContentView(R.layout.dialog_layout);
    }
}
