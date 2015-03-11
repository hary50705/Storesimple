package com.storesimple.controller;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.IMAC.Response.IntentZXing;
import com.storesimple.QRcodeActivity;
import com.storesimple.layout.QRcode_Layout;

public class QRcode_Controller {
	private QRcode_Layout QRcodeLayout;
	private Button closeBtn;
	private TextView takemealTime;
	private TextView account;
	private TextView name;
	private TextView paytype;
	private TextView totalmoney;
	private Activity Acty;
	
	public QRcode_Controller(Context context,QRcode_Layout layout){
		this.Acty=((QRcodeActivity)context);
		QRcodeLayout=layout;
		init();
	}
	
	protected void init(){
		closeBtn=QRcodeLayout.getCloseBtn();
		takemealTime=QRcodeLayout.getTakemealTime();
		account=QRcodeLayout.getAccount();
		name=QRcodeLayout.getName();
		paytype=QRcodeLayout.getPaytype();
		totalmoney=QRcodeLayout.getTotalmoney();
		
		setData();
		setButton();
	}
	
	private void setData(){
		Toast.makeText(Acty,Acty.getIntent().getExtras().getString(IntentZXing.REPONSE_DATA),Toast.LENGTH_SHORT).show();
		
		takemealTime.setText("取餐時間:2014/11/05 中午11:30");
		account.setText("帳號:0952xxxxxx");
		name.setText("吳承翰 先生");
		paytype.setText("付款方式:取餐付款");
		totalmoney.setText("消費金額:1000");
	}
	
	private void setButton(){
		closeBtn.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Acty.finish();
			}
		});
	}

}
