package com.storesimple;

import com.IMAC.Response.IntentZXing;


import android.app.Activity;
import android.os.Bundle;

public class QRcodeScanActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		IntentZXing iZX = new IntentZXing(QRcodeScanActivity.this);
		iZX.OpenScanActivity(QRcodeActivity.class);
		finish();
	}
	
	
}
