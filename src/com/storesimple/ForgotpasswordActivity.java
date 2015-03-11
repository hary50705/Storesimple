package com.storesimple;

import android.app.Activity;
import android.os.Bundle;

import com.storesimple.controller.Forgotpassword_Controller;
import com.storesimple.layout.Forgotpassword_Layout;
/*忘記密碼畫面Activity*/
public class ForgotpasswordActivity extends Activity {
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Forgotpassword_Layout ForgotpasswordLayout =new Forgotpassword_Layout(this);
		setContentView(ForgotpasswordLayout);
		Forgotpassword_Controller ForgotpasswordContro=new Forgotpassword_Controller(this,ForgotpasswordLayout);
	}
   
}
