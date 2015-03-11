package com.storesimple.controller;



import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.storesimple.ForgotpasswordActivity;
import com.storesimple.MainActivity;
import com.storesimple.R;
import com.storesimple.layout.Forgotpassword_Layout;
import com.storesimple.module.StringVolleyPOST;
import com.storesimple.module.Tag;

public class Forgotpassword_Controller {
	private Context context;
	private Forgotpassword_Layout ForgotpasswordLayout; 
	private EditText accountInput;
	private EditText emailInput;
	private Button backButton;
	private Button sendBtn;
	private ProgressDialog processdialog;
	
	public Forgotpassword_Controller(Context context,Forgotpassword_Layout layout){
		this.context=context;
		ForgotpasswordLayout=layout;
		init();
		setButton();
	}
	
	protected void init(){
		accountInput=ForgotpasswordLayout.getAccountInput();
		emailInput=ForgotpasswordLayout.getEmailInput();
		backButton=ForgotpasswordLayout.getBackButton();
		sendBtn=ForgotpasswordLayout.getSendBtn();
	}
	
	private void setButton(){
		backButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent=new Intent();
				intent.setClass(context,MainActivity.class);
				context.startActivity(intent);
				((ForgotpasswordActivity)context).finish();
			}
		});
		sendBtn.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				String account=accountInput.getText().toString();
				String email=emailInput.getText().toString();
				
				if(!account.equals("") && !email.equals("")){
					sendEmail(account,email);
				}else{
					Toast.makeText(context,R.string.Inputnotfinish,Toast.LENGTH_SHORT).show();
				}
				
				/*new Thread(){
					@Override
					public void run() {
						super.run();
						
						try {
							MailSender sender=new MailSender("hary507050@gmail.com","GH738562");
							sender.sendMail("忘記密碼通知","通知~~","hary507050@gmail.com","hary50705@gmail.com");
						} catch (AddressException e) {
							e.printStackTrace();
						} catch (MessagingException e) {
							e.printStackTrace();
						}
					}
				}.start();*/
				
				/*Intent mailIntent=new Intent(android.content.Intent.ACTION_SEND);
				mailIntent.setType("plain/text");
				mailIntent.putExtra(android.content.Intent.EXTRA_EMAIL,"hary50705@gmail.com");
				mailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,"忘記密碼通知");
				mailIntent.putExtra(android.content.Intent.EXTRA_TEXT,"通知~~");
				context.startActivity(Intent.createChooser(mailIntent,"發送通知"));*/
			}
		});
	}
	
	private void sendEmail(String account,String email){
		processdialog=ProgressDialog.show(context,null,"Loading...",true,false);
		
		MainActivity.RQ.add(new StringVolleyPOST(Tag.SENDEMAIL_URL+"Account="+account+"&Email="+email
		    ,new StringVolleyPOST.OnStringResponse() {
			
			public void OnString(int state, StringVolleyPOST SV, String data) {
				SV.clean();
				processdialog.dismiss();
				if(state==StringVolleyPOST.STATE_OK){
					Log.e("Forgotpassword",data);
					try {
						JSONArray sendEmaildataArray=new JSONArray(data);
						JSONObject sendEmaildata=sendEmaildataArray.getJSONObject(0);
						String status=sendEmaildata.getString("Status");
						
						if(status.equals("ok")){
							Intent intent=new Intent();
							intent.setClass(context,MainActivity.class);
							context.startActivity(intent);
							((ForgotpasswordActivity)context).finish();
						}else{
							Toast.makeText(context,"寄信失敗",Toast.LENGTH_SHORT).show();
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
