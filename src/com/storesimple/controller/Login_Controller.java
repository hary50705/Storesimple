package com.storesimple.controller;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.storesimple.ForgotpasswordActivity;
import com.storesimple.FunctionActivity;
import com.storesimple.MainActivity;
import com.storesimple.R;
import com.storesimple.layout.Login_Layout;
import com.storesimple.module.StringVolleyPOST;
import com.storesimple.module.Tag;

public class Login_Controller {
	private Context context;
	private Login_Layout LoginLayout;
	private EditText accountInput;
	private EditText passwordInput;
	private Button loginBtn;
	private Button forgotpasswordBtn;
	private ProgressDialog processdialog;
	
	public Login_Controller(Context context,Login_Layout layout){
		this.context=context;
		LoginLayout=layout;
		init();
	}
	
	protected void init(){
		accountInput=LoginLayout.getAccountInput();
		passwordInput=LoginLayout.getPasswordInput();
		loginBtn=LoginLayout.getLoginBtn();
		forgotpasswordBtn=LoginLayout.getForgotpasswordBtn();
		
		setButton();
	}
	
	private void  setButton(){
		loginBtn.setOnClickListener(new OnClickListener() {//登入
			
			public void onClick(View v) {
				String account=accountInput.getText().toString();
				String password=passwordInput.getText().toString();
				if(!account.equals("") && !password.equals("")){
					Login(account,password);
				}else{
					Toast.makeText(context,R.string.Inputnotfinish,Toast.LENGTH_SHORT).show();
				}
			}
		});
		
		forgotpasswordBtn.setOnClickListener(new OnClickListener() {//忘記密碼
			
			public void onClick(View v) {
				Intent intent=new Intent();
				intent.setClass(context, ForgotpasswordActivity.class);
				context.startActivity(intent);
				((MainActivity)context).finish();
			}
		});
	}
	
	private void Login(String account,String password){
		
		processdialog=ProgressDialog.show(context,null,"Loading...",true,false);
		
		MainActivity.RQ.add(new StringVolleyPOST(Tag.GETLOGINDATA_URL+"Account="+account+"&password="+password
		    ,new StringVolleyPOST.OnStringResponse() {
			
			public void OnString(int state, StringVolleyPOST SV, String data) {
				SV.clean();
				processdialog.dismiss();
				if(state==StringVolleyPOST.STATE_OK){
					Log.e("Login",data);
					try {
						JSONArray logindataArray=new JSONArray(data);
						JSONObject logindata=logindataArray.getJSONObject(0);
						String status=logindata.getString("Status");//登入回傳狀態
						
						if(status.equals("ok")){//登入成功
							String categoryID=logindata.getString("CategoryID");//店家類別ID
							String storeID=logindata.getString("StoreID");//店家ID
							
							Bundle bundle=new Bundle();
							bundle.putString("CategoryID",categoryID);
							bundle.putString("StoreID",storeID);
							
							Intent intent=new Intent();
							intent.putExtras(bundle);
							intent.setClass(context,FunctionActivity.class);
							
							context.startActivity(intent);
							((MainActivity)context).finish();
							
						}else if(status.equals("fail")){//登入失敗
							Toast.makeText(context,logindata.getString("Message"),Toast.LENGTH_SHORT).show();
						}
						
					} catch (JSONException e) {
						e.printStackTrace();
					}
					
				}else if(state==StringVolleyPOST.STATE_ERROR){
					Log.e("InstantRank","網頁回傳資料失敗");
				}	
			}
		}
		,null).getSR());
	}
}
