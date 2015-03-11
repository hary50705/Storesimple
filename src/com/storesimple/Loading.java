package com.storesimple;

import com.storesimple.layout.Loading_Layout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Loading extends Activity{
	private Runnable runable;
	private Handler handler;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Loading_Layout LoadingLayout=new Loading_Layout(this);
		setContentView(LoadingLayout);
		
		runable=new Runnable() {
			
			public void run() {
				Intent intent=new Intent();
				intent.setClass(Loading.this,MainActivity.class);
				startActivity(intent);
				overridePendingTransition(R.anim.loadingin,R.anim.loadingout);
				Loading.this.finish();
			}
		};
		handler=new Handler();
		handler.postDelayed(runable,500);
    }

	@Override
	protected void onDestroy() {
		super.onDestroy();
		if(handler!=null){
			handler.removeCallbacks(runable);
			handler=null;
		}
	}
}
