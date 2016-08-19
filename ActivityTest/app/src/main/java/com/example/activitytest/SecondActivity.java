package com.example.activitytest;

//import java.security;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

public class SecondActivity extends BaseActivity {

	public static void actionStart(Context context,String data1,String data2){
		Intent intent = new Intent(context,SecondActivity.class);
		intent.putExtra("param1",data1);
		intent.putExtra("param2",data2);
		context.startActivity(intent);
	}

	public SecondActivity() {
		// TODO Auto-generated constructor stub
	}
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		Log.d("SecondActivity", "Task id is " + getTaskId());
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.second_layout);
//		Intent intent = getIntent();
//		String data = intent.getStringExtra("extra_data");
//		Log.d("SecondActivity", data);
		Button button2 = (Button) findViewById(R.id.button_2);
		button2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
//					Intent intent = new Intent();
//					intent.putExtra("data_return", "Hello FirstActivity");
//					setResult(RESULT_OK,intent);
//					finish();
				Intent intent  = new Intent(SecondActivity.this,ThirdActivity.class);
				startActivity(intent);
			}
		});
	}
	
	protected void onDestroy(){
		super.onDestroy();
		Log.d("SecondActivity", "onDestroy");
	}
}
