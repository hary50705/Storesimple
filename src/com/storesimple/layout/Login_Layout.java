package com.storesimple.layout;


import com.storesimple.R;
import com.storesimple.frame.MainParentLayout;

import android.content.Context;
import android.graphics.Color;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

/*登入畫面*/
public class Login_Layout extends MainParentLayout{
	private View title;
	private View bottom;
	private RelativeLayout LoginLayout;
	private RelativeLayout LoginTitleLayout;
	private RelativeLayout AccountLayout;
	private RelativeLayout PasswordLayout;
	private EditText accountInput;
	private EditText passwordInput;
	private Button registerAccount_Btn;
	private Button login_Btn;
	private Button forgotpassword_Btn;
	
	public Login_Layout(Context context) {
		super(context);
	}

	protected void init() {
		LayoutParams LP=new LayoutParams(LayoutParams.MATCH_PARENT
				       ,LayoutParams.MATCH_PARENT);
		this.setLayoutParams(LP);
	    
		setTitle();
		setBottom();
		setMiddle();
		setLoginTitle();
		setAccountLayout();
		setPasswordLayout();
		setLoginButton();
	}
	
	private void setTitle(){
		title=new View(context);
		LayoutParams LP=new LayoutParams(LayoutParams.MATCH_PARENT
				       ,WH.getH(10));
		title.setLayoutParams(LP);
		title.setBackgroundResource(R.drawable.logintitle);
		title.setId(getRandomId());
		this.addView(title);
	}
	
	private void setBottom(){
		bottom=new View(context);
		LayoutParams LP=new LayoutParams(LayoutParams.MATCH_PARENT
				       ,WH.getH(5));
		LP.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		bottom.setLayoutParams(LP);
		bottom.setBackgroundResource(R.drawable.bottom);
		bottom.setId(getRandomId());
		this.addView(bottom);
	}
	
	private void setMiddle(){
		RelativeLayout middleLayout=new RelativeLayout(context);
		LayoutParams LP1=new LayoutParams(LayoutParams.MATCH_PARENT
				       ,LayoutParams.MATCH_PARENT);
		LP1.addRule(BELOW,title.getId());
		LP1.addRule(ABOVE,bottom.getId());
		middleLayout.setLayoutParams(LP1);
		middleLayout.setBackgroundResource(R.drawable.memberloginbg);
		this.addView(middleLayout);
		
		LoginLayout=new RelativeLayout(context);
		LayoutParams LP2=new LayoutParams(WH.getW(80)
				        ,WH.getH(35));
		LP2.addRule(RelativeLayout.CENTER_HORIZONTAL);
		LP2.topMargin=WH.getH(25);
		LoginLayout.setLayoutParams(LP2);
		LoginLayout.setBackgroundResource(R.drawable.login_bg);
		middleLayout.addView(LoginLayout);
	}
	
	private void setLoginTitle(){
		{
			LoginTitleLayout=new RelativeLayout(context);
			LayoutParams LP=new LayoutParams(LayoutParams.MATCH_PARENT
						  ,WH.getH(5));
			LP.topMargin=WH.getH(2);
			LP.leftMargin=WH.getW(5);
			LP.rightMargin=WH.getW(5);
			LoginTitleLayout.setLayoutParams(LP);
			LoginTitleLayout.setId(getRandomId());
			LoginLayout.addView(LoginTitleLayout);
		}
		
		View loginTitleImage=new View(context);
		LayoutParams LP1=new LayoutParams(WH.getH(5),LayoutParams.MATCH_PARENT);
		loginTitleImage.setLayoutParams(LP1);
		loginTitleImage.setBackgroundResource(R.drawable.login_icon);
		loginTitleImage.setId(getRandomId());
		LoginTitleLayout.addView(loginTitleImage);
		
		TextView loginTitle=new TextView(context);
		LayoutParams LP2=new LayoutParams(LayoutParams.WRAP_CONTENT
				        ,LayoutParams.WRAP_CONTENT);
		LP2.addRule(RIGHT_OF,loginTitleImage.getId());
		loginTitle.setLayoutParams(LP2);
		loginTitle.setText(R.string.LoginTitle);
		loginTitle.setTextSize(PX,WH.getTextSize(45));
		loginTitle.setTextColor(0xFFFF9600);
		LoginTitleLayout.addView(loginTitle);
		
		registerAccount_Btn=new Button(context);
		LayoutParams LP3=new LayoutParams(WH.getW(30)
				       ,LayoutParams.MATCH_PARENT);
		LP3.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
		registerAccount_Btn.setLayoutParams(LP3);
		registerAccount_Btn.setText(R.string.RegisterAccount);
		registerAccount_Btn.setTextSize(PX,WH.getTextSize(30));
		registerAccount_Btn.setTextColor(Color.WHITE);
		registerAccount_Btn.setGravity(Gravity.CENTER);
		registerAccount_Btn.setBackgroundResource(R.drawable.register_iconbg);
		LoginTitleLayout.addView(registerAccount_Btn);
	}
	
	private void setAccountLayout(){
		{
			AccountLayout=new RelativeLayout(context);
			LayoutParams LP=new LayoutParams(LayoutParams.MATCH_PARENT
						   ,WH.getH(6));
			LP.addRule(BELOW,LoginTitleLayout.getId());
			LP.addRule(ALIGN_LEFT,LoginTitleLayout.getId());
			LP.addRule(ALIGN_RIGHT,LoginTitleLayout.getId());
			LP.topMargin=WH.getH(2);
			AccountLayout.setLayoutParams(LP);
			AccountLayout.setId(getRandomId());
			LoginLayout.addView(AccountLayout);
		}
		
		View accountImage=new View(context);
		LayoutParams LP1=new LayoutParams(WH.getH(6)
						,LayoutParams.MATCH_PARENT);
		accountImage.setLayoutParams(LP1);
		accountImage.setBackgroundResource(R.drawable.login_member);
		accountImage.setId(getRandomId());
		AccountLayout.addView(accountImage);
		
		accountInput=new EditText(context);
		LayoutParams LP2=new LayoutParams(LayoutParams.MATCH_PARENT
						,LayoutParams.MATCH_PARENT);
		LP2.addRule(RIGHT_OF,accountImage.getId());
		accountInput.setLayoutParams(LP2);
		accountInput.setText("eva");
		accountInput.setTextSize(PX,WH.getTextSize(40));
		accountInput.setBackgroundResource(R.drawable.login_wordbg);
		accountInput.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
		AccountLayout.addView(accountInput);
	}
	
	private void setPasswordLayout(){
		{
			PasswordLayout=new RelativeLayout(context);
			LayoutParams LP=new LayoutParams(LayoutParams.MATCH_PARENT
						   ,WH.getH(6));
			LP.addRule(BELOW,AccountLayout.getId());
			LP.addRule(ALIGN_LEFT,LoginTitleLayout.getId());
			LP.addRule(ALIGN_RIGHT,LoginTitleLayout.getId());
			LP.topMargin=WH.getH(2);
			PasswordLayout.setLayoutParams(LP);
			PasswordLayout.setId(getRandomId());
			LoginLayout.addView(PasswordLayout);
		}
		
		View passwordImage=new View(context);
		LayoutParams LP1=new LayoutParams(WH.getH(6)
						,LayoutParams.MATCH_PARENT);
		passwordImage.setLayoutParams(LP1);
		passwordImage.setBackgroundResource(R.drawable.login_keyword);
		passwordImage.setId(getRandomId());
		PasswordLayout.addView(passwordImage);
		
		passwordInput=new EditText(context);
		LayoutParams LP2=new LayoutParams(LayoutParams.MATCH_PARENT
						,LayoutParams.MATCH_PARENT);
		LP2.addRule(RIGHT_OF,passwordImage.getId());
		passwordInput.setLayoutParams(LP2);
		passwordInput.setText("537010");
		passwordInput.setTextSize(PX,WH.getTextSize(40));
		passwordInput.setBackgroundResource(R.drawable.login_wordbg);	
		passwordInput.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
		PasswordLayout.addView(passwordInput);
	}
	
	private void setLoginButton(){
		login_Btn = new Button(context);
		LayoutParams LP1 = new LayoutParams(WH.getW(30),
				         WH.getH(6));
		LP1.addRule(BELOW,PasswordLayout.getId());
		LP1.addRule(ALIGN_LEFT,LoginTitleLayout.getId());
		LP1.topMargin=WH.getH(2);
		login_Btn.setLayoutParams(LP1);
		login_Btn.setText(R.string.Login);
		login_Btn.setTextColor(Color.WHITE);
		login_Btn.setTextSize(PX,WH.getTextSize(35));
		login_Btn.setGravity(Gravity.CENTER);
		login_Btn.setBackgroundResource(R.drawable.loginbutoon_bg);
		login_Btn.setId(getRandomId());
		LoginLayout.addView(login_Btn);
				
		forgotpassword_Btn = new Button(context);
		LayoutParams LP2 = new LayoutParams(WH.getW(30),
						 WH.getH(6));
		LP2.addRule(ALIGN_RIGHT,LoginTitleLayout.getId());
		LP2.addRule(ALIGN_TOP,login_Btn.getId());
		forgotpassword_Btn.setLayoutParams(LP2);
		forgotpassword_Btn.setText(R.string.Forgotpassword);
		forgotpassword_Btn.setTextColor(Color.WHITE);
		forgotpassword_Btn.setTextSize(PX,WH.getTextSize(35));
		forgotpassword_Btn.setGravity(Gravity.CENTER);
		forgotpassword_Btn.setBackgroundResource(R.drawable.loginbutoon_bg);
		LoginLayout.addView(forgotpassword_Btn);
	}
	
	public EditText getAccountInput(){
		return accountInput;
	}
	
	public EditText getPasswordInput(){
		return passwordInput;
	}
	
	public Button getRegisterAccountBtn(){
		return registerAccount_Btn;
	}
	
	public Button getLoginBtn(){
		return login_Btn;
	}
	
	public Button getForgotpasswordBtn(){
		return forgotpassword_Btn;
	}
	
}
