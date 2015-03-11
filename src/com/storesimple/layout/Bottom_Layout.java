package com.storesimple.layout;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.storesimple.R;
import com.storesimple.frame.MainParentLayout;
/*底部的畫面*/
public class Bottom_Layout extends MainParentLayout{
	private Button menu_Btn;
	private Button onstage_Btn;
	private Button process_Btn;
	private RelativeLayout ProcessButtonLayout;
	
	public Bottom_Layout(Context context) {
		super(context);
	}

	protected void init() {
		LayoutParams LP=new LayoutParams(LayoutParams.MATCH_PARENT
			            ,WH.getH(10));
		this.setLayoutParams(LP);
		this.setBackgroundResource(R.drawable.bottomtitlebg);
		setMenuButton();
		setProcessButton();
	}
	
	private void setMenuButton(){
		menu_Btn=new Button(context);
		LayoutParams LP=new LayoutParams(WH.getW(10)
				       ,WH.getW(10));
		LP.addRule(RelativeLayout.CENTER_VERTICAL);
		LP.leftMargin=WH.getW(5);
		menu_Btn.setLayoutParams(LP);
		menu_Btn.setBackgroundResource(R.drawable.menuicon);
		this.addView(menu_Btn);	
	}
	
	private void setProcessButton(){
		{
			ProcessButtonLayout=new RelativeLayout(context);
			LayoutParams LP=new LayoutParams(LayoutParams.WRAP_CONTENT
					       ,WH.getW(15));
			LP.addRule(RelativeLayout.CENTER_HORIZONTAL);
			ProcessButtonLayout.setLayoutParams(LP);
			this.addView(ProcessButtonLayout);
		}
		
		onstage_Btn=new Button(context);
		LayoutParams LP1=new LayoutParams(WH.getW(30)
				       ,LayoutParams.MATCH_PARENT);
		onstage_Btn.setLayoutParams(LP1);
		onstage_Btn.setText("上一狀態");
		onstage_Btn.setTextSize(PX,WH.getTextSize(30));
		onstage_Btn.setVisibility(View.GONE);
		onstage_Btn.setId(getRandomId());
		ProcessButtonLayout.addView(onstage_Btn);
		
		process_Btn=new Button(context);
		LayoutParams LP2=new LayoutParams(WH.getW(30)
				       ,LayoutParams.MATCH_PARENT);
		LP2.addRule(RIGHT_OF,onstage_Btn.getId());
		process_Btn.setLayoutParams(LP2);
		process_Btn.setTextSize(PX,WH.getTextSize(30));
		process_Btn.setVisibility(View.GONE);
		ProcessButtonLayout.addView(process_Btn);
	}
	
	public Button getMenuBtn(){
		return menu_Btn;
	}
	
	public Button getonstageBtn(){
		return onstage_Btn;
	}
	
	public Button getProcessBtn(){
		return process_Btn;
	}
	
}
