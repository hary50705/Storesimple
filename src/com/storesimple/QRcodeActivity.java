package com.storesimple;

import com.storesimple.controller.QRcode_Controller;
import com.storesimple.layout.QRcode_Layout;

import android.app.Activity;
import android.os.Bundle;

public class QRcodeActivity extends Activity{

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		QRcode_Layout QRcodeLayout=new QRcode_Layout(this); 
		setContentView(QRcodeLayout);
		QRcode_Controller QRcodeContro=new QRcode_Controller(this,QRcodeLayout);
	}
	
}
