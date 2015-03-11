package com.storesimple.layout;

import android.content.Context;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.storesimple.R;
import com.storesimple.frame.MainParentLayout;
/*忘記密碼畫面*/
public class Forgotpassword_Layout extends MainParentLayout {
	private RelativeLayout TitleLayout;
	private RelativeLayout AccountLayout;
	private RelativeLayout EmailLayout;
	private Button backButton;
	private Button send_Btn;
	private EditText accountInput;
	private EditText emailInput;
	
	public Forgotpassword_Layout(Context context) {
		super(context);
	}

	protected void init() {
		LayoutParams LP=new LayoutParams(LayoutParams.MATCH_PARENT
				       ,LayoutParams.MATCH_PARENT);
		this.setLayoutParams(LP);
		this.setBackgroundResource(R.drawable.password_bg);
		setTitle();
		setAccountLayout();
		setEmailLayout();
		setHint();
		setSendButton();
	}
	
	private void setTitle(){
		{
			TitleLayout=new RelativeLayout(context);
			LayoutParams LP=new LayoutParams(LayoutParams.MATCH_PARENT
					       ,WH.getH(10));
			TitleLayout.setLayoutParams(LP);
			TitleLayout.setBackgroundResource(R.drawable.toptitle_bg);
			TitleLayout.setId(getRandomId());
			this.addView(TitleLayout);
		}
		
		backButton=new Button(context);
		LayoutParams LP1=new LayoutParams(WH.getW(9)
				        ,WH.getW(9));
		LP1.addRule(RelativeLayout.CENTER_VERTICAL);
		LP1.leftMargin=WH.getW(2);
		backButton.setLayoutParams(LP1);
		backButton.setBackgroundResource(R.drawable.arrowleft);
		backButton.setId(getRandomId());
		TitleLayout.addView(backButton);
		
		View logoImage=new View(context);
		LayoutParams LP2=new LayoutParams(WH.getW(15)
				       ,WH.getW(15));
		LP2.addRule(RelativeLayout.CENTER_VERTICAL);
		LP2.leftMargin=WH.getW(25);
		logoImage.setLayoutParams(LP2);
		logoImage.setBackgroundResource(R.drawable.in_logo);
		logoImage.setId(getRandomId());
		TitleLayout.addView(logoImage);
		
		TextView Title=new TextView(context);
		LayoutParams LP3=new LayoutParams(LayoutParams.WRAP_CONTENT
				       ,LayoutParams.WRAP_CONTENT);
		LP3.addRule(RIGHT_OF,logoImage.getId());
		LP3.addRule(RelativeLayout.CENTER_VERTICAL);
		LP3.leftMargin=WH.getW(2);
		Title.setLayoutParams(LP3);
		Title.setText(R.string.Forgotpassword);
		Title.setTextSize(PX,WH.getTextSize(45));
		TitleLayout.addView(Title);
	}
	
	private void setAccountLayout(){
		{
			AccountLayout=new RelativeLayout(context);
			LayoutParams LP=new LayoutParams(LayoutParams.WRAP_CONTENT
					       ,WH.getH(5));
			LP.addRule(BELOW,TitleLayout.getId());
			LP.leftMargin=WH.getW(5);
			LP.topMargin=WH.getH(3);
			AccountLayout.setLayoutParams(LP);
			AccountLayout.setId(getRandomId());
			this.addView(AccountLayout);
		}
		
		TextView accounthint=new TextView(context);
		LayoutParams LP1=new LayoutParams(WH.getW(20)
				        ,LayoutParams.WRAP_CONTENT);
		LP1.addRule(RelativeLayout.CENTER_VERTICAL);
		accounthint.setLayoutParams(LP1);
		accounthint.setText(R.string.Account);
		accounthint.setTextSize(PX,WH.getTextSize(40));
		accounthint.setId(getRandomId());
		AccountLayout.addView(accounthint);
		
		accountInput=new EditText(context);
		LayoutParams LP2=new LayoutParams(WH.getW(60)
				        ,LayoutParams.MATCH_PARENT);
		LP2.addRule(RIGHT_OF,accounthint.getId());
		LP2.leftMargin=WH.getW(2);
		accountInput.setLayoutParams(LP2);
		accountInput.setTextSize(PX,WH.getTextSize(30));
		accountInput.setBackgroundResource(R.drawable.login_wordbg);
		accountInput.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
		AccountLayout.addView(accountInput);
	}
	
	private void setEmailLayout(){
		{
			EmailLayout=new RelativeLayout(context);
			LayoutParams LP=new LayoutParams(LayoutParams.WRAP_CONTENT
					       ,WH.getH(5));
			LP.addRule(BELOW,AccountLayout.getId());
			LP.addRule(ALIGN_LEFT,AccountLayout.getId());
			LP.addRule(ALIGN_RIGHT,AccountLayout.getId());
			LP.topMargin=WH.getH(2);
			EmailLayout.setLayoutParams(LP);
			EmailLayout.setId(getRandomId());
			this.addView(EmailLayout);
		}
		
			TextView emailhint=new TextView(context);
			LayoutParams LP1=new LayoutParams(WH.getW(20)
					        ,LayoutParams.WRAP_CONTENT);
			LP1.addRule(RelativeLayout.CENTER_VERTICAL);
			emailhint.setLayoutParams(LP1);
			emailhint.setText(R.string.Email);
			emailhint.setTextSize(PX,WH.getTextSize(40));
			emailhint.setId(getRandomId());
			EmailLayout.addView(emailhint);
			
			emailInput=new EditText(context);
			LayoutParams LP2=new LayoutParams(WH.getW(60)
					        ,LayoutParams.MATCH_PARENT);
			LP2.addRule(RIGHT_OF, emailhint.getId());
			LP2.leftMargin=WH.getW(2);
			emailInput.setLayoutParams(LP2);
			emailInput.setTextSize(PX,WH.getTextSize(30));
		    emailInput.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
			emailInput.setBackgroundResource(R.drawable.login_wordbg);
			EmailLayout.addView(emailInput);
	}
	
	private void setHint(){
		TextView sendfinishHint=new TextView(context);
		LayoutParams LP=new LayoutParams(LayoutParams.WRAP_CONTENT
				       ,LayoutParams.WRAP_CONTENT);
		LP.addRule(BELOW, EmailLayout.getId());
		LP.addRule(RelativeLayout.CENTER_HORIZONTAL);
		LP.topMargin=WH.getH(5);
		sendfinishHint.setLayoutParams(LP);
		sendfinishHint.setText(R.string.SendfinishHint);
		sendfinishHint.setTextSize(PX,WH.getTextSize(40));
		this.addView(sendfinishHint);
	}
	
	private void setSendButton(){
		send_Btn=new Button(context);
		LayoutParams LP1=new LayoutParams(LayoutParams.WRAP_CONTENT
				         ,LayoutParams.WRAP_CONTENT);
		LP1.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		LP1.bottomMargin=WH.getW(2);
		LP1.addRule(RelativeLayout.CENTER_HORIZONTAL);
		send_Btn.setLayoutParams(LP1);
		send_Btn.setText(R.string.Determine);
		send_Btn.setTextSize(PX,WH.getTextSize(40));
		this.addView(send_Btn);
	}
	
	public EditText getAccountInput(){
		return accountInput;
	}
	
	public EditText getEmailInput(){
		return emailInput;
	}
	
	public Button getBackButton(){
		return backButton;
	}
	
	public Button getSendBtn(){
		return send_Btn;
	}
}
