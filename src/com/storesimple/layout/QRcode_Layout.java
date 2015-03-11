package com.storesimple.layout;

import android.content.Context;
import android.view.Gravity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.storesimple.R;
import com.storesimple.frame.MainParentLayout;
/*QRcode核銷畫面*/
public class QRcode_Layout extends MainParentLayout{
	private RelativeLayout TitleLayout,DataLayout;
	private ImageView QRcodeImage;
	private Button Close_Btn;
	private TextView TakemealTime,Account,Name,Paytype,Totalmoney;
	
	public QRcode_Layout(Context context) {
		super(context);
	}

	protected void init() {
		LayoutParams LP=new LayoutParams(LayoutParams.MATCH_PARENT
				       ,LayoutParams.MATCH_PARENT);
		this.setLayoutParams(LP);
		
		setTitle();
		setQRcode();
		setData();
	}
	
	private void setTitle(){
		{
			TitleLayout=new RelativeLayout(context);
			LayoutParams LP=new LayoutParams(LayoutParams.MATCH_PARENT
					       ,WH.getH(10));
			TitleLayout.setLayoutParams(LP);
			TitleLayout.setId(getRandomId());
			this.addView(TitleLayout);
		}
		
		TextView Title=new TextView(context);
		LayoutParams LP1=new LayoutParams(LayoutParams.WRAP_CONTENT
				         ,LayoutParams.WRAP_CONTENT);
		LP1.addRule(RelativeLayout.CENTER_IN_PARENT);
		Title.setLayoutParams(LP1);
		Title.setText(R.string.QRcodeTitle);
		Title.setTextSize(PX,WH.getTextSize(40));
		TitleLayout.addView(Title);
		
		Close_Btn=new Button(context);
		LayoutParams LP2=new LayoutParams(LayoutParams.WRAP_CONTENT
				        ,LayoutParams.WRAP_CONTENT);
		LP2.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
		LP2.rightMargin=WH.getW(2);
		LP2.addRule(RelativeLayout.CENTER_VERTICAL);
		Close_Btn.setLayoutParams(LP2);
		Close_Btn.setText(R.string.Close);
		Close_Btn.setTextSize(PX,WH.getTextSize(40));
		TitleLayout.addView(Close_Btn);
	}
	
	private void setQRcode(){
		QRcodeImage=new ImageView(context);
		LayoutParams LP=new LayoutParams(WH.getW(60)
				       ,WH.getH(40));
		LP.addRule(BELOW,TitleLayout.getId());
		LP.topMargin=WH.getH(10);
		LP.addRule(RelativeLayout.CENTER_HORIZONTAL);
		QRcodeImage.setLayoutParams(LP);
		QRcodeImage.setBackgroundResource(R.drawable.qrcode);
		QRcodeImage.setId(getRandomId());
		this.addView(QRcodeImage);
	}
	
	private void setData(){
		{
			DataLayout=new RelativeLayout(context);
			LayoutParams LP=new LayoutParams(WH.getW(80)
					       ,LayoutParams.WRAP_CONTENT);
			LP.addRule(BELOW,QRcodeImage.getId());
			LP.topMargin=WH.getH(5);
			LP.addRule(RelativeLayout.CENTER_HORIZONTAL);
			DataLayout.setLayoutParams(LP);
			this.addView(DataLayout);
		}
		
		TakemealTime=new TextView(context);
		LayoutParams LP1=new LayoutParams(LayoutParams.MATCH_PARENT
				        ,LayoutParams.WRAP_CONTENT);
		TakemealTime.setLayoutParams(LP1);
		TakemealTime.setTextSize(PX,WH.getTextSize(35));
		TakemealTime.setGravity(Gravity.CENTER_HORIZONTAL);
		TakemealTime.setId(getRandomId());
		DataLayout.addView(TakemealTime);
		
		Account=new TextView(context);
		LayoutParams LP2=new LayoutParams(WH.getW(40)
				        ,LayoutParams.WRAP_CONTENT);
		LP2.addRule(BELOW,TakemealTime.getId());
		Account.setLayoutParams(LP2);
		Account.setTextSize(PX,WH.getTextSize(35));
		Account.setGravity(Gravity.CENTER_HORIZONTAL);
		Account.setId(getRandomId());
		DataLayout.addView(Account);
		
		Name=new TextView(context);
		LayoutParams LP3=new LayoutParams(WH.getW(40)
				        ,LayoutParams.WRAP_CONTENT);
		LP3.addRule(RIGHT_OF,Account.getId());
		LP3.addRule(BELOW,TakemealTime.getId());
		Name.setLayoutParams(LP3);
		Name.setTextSize(PX,WH.getTextSize(35));
		Name.setGravity(Gravity.CENTER_HORIZONTAL);
		Name.setId(getRandomId());
		DataLayout.addView(Name);
		
		Paytype=new TextView(context);
		LayoutParams LP4=new LayoutParams(WH.getW(40)
				        ,LayoutParams.WRAP_CONTENT);
		LP4.addRule(BELOW,Account.getId());
		Paytype.setLayoutParams(LP4);
		Paytype.setTextSize(PX,WH.getTextSize(35));
		Paytype.setGravity(Gravity.CENTER_HORIZONTAL);
		Paytype.setId(getRandomId());
		DataLayout.addView(Paytype);
		
		Totalmoney=new TextView(context);
		LayoutParams LP5=new LayoutParams(WH.getW(40)
				        ,LayoutParams.WRAP_CONTENT);
		LP5.addRule(RIGHT_OF,Paytype.getId());
		LP5.addRule(BELOW,Name.getId());
		Totalmoney.setLayoutParams(LP5);
		Totalmoney.setTextSize(PX,WH.getTextSize(35));
		Totalmoney.setGravity(Gravity.CENTER_HORIZONTAL);
		DataLayout.addView(Totalmoney);
	}
	
	public Button getCloseBtn(){
		return Close_Btn;
	}
	
	public ImageView getQRcodeImage(){
		return QRcodeImage;
	}
	
	public TextView getTakemealTime(){
		return TakemealTime;
	}
	
	public TextView getAccount(){
		return Account;
	}
	
	public TextView getName(){
		return Name;
	}
	
	public TextView getPaytype(){
		return Paytype;
	}
	
	public TextView getTotalmoney(){
		return Totalmoney;
	}
}
