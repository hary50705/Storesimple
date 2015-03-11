package com.storesimple;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.KeyEvent;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.storesimple.controller.Login_Controller;
import com.storesimple.layout.Login_Layout;
/*登入畫面Activity*/
public class MainActivity extends Activity {
	private Login_Controller LoginContro;
	public static RequestQueue RQ;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		RQ = Volley.newRequestQueue(this);
		Login_Layout LoginLayout=new Login_Layout(this);
		setContentView(LoginLayout);
		LoginContro=new Login_Controller(this,LoginLayout);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if(keyCode == KeyEvent.KEYCODE_BACK){
			AlertDialog.Builder builder=new Builder(this);
			builder.setTitle("離開APP");
			builder.setMessage("確認要離開此APP?");
			builder.setNegativeButton("確認",new OnClickListener() {
				
				public void onClick(DialogInterface dialog, int which) {
					System.exit(0);
					dialog.dismiss();
				}
			});
			
			builder.setPositiveButton("取消",new OnClickListener() {
				
				public void onClick(DialogInterface dialog, int which) {
					dialog.dismiss();
				}
			});
			builder.create().show();
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

}
