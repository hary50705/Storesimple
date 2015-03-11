package com.storesimple.view;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.storesimple.R;
import com.storesimple.frame.MainParentLayout;
/*最上面功能標題畫面*/
public class FunctionTitleView extends MainParentLayout{
	private RelativeLayout TitleLayout;
	private Button back_Btn;
	private Button dayOrderSearch_Btn;
	private View logoImage;
	private TextView title;
	
	public FunctionTitleView(Context context) {
		super(context);
	}

	@Override
	protected void init() {
		LayoutParams LP = new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.MATCH_PARENT);
		this.setLayoutParams(LP);
		this.setBackgroundResource(R.drawable.toptitle_bg);

		setBackButton();
		setTitle();
		setDayOrderSearchButton();	
	}
	
	private void setBackButton(){
		back_Btn=new Button(context);
		LayoutParams LP=new LayoutParams(WH.getW(9)
				        ,WH.getW(9));
		LP.addRule(RelativeLayout.CENTER_VERTICAL);
		LP.leftMargin=WH.getW(2);
		back_Btn.setLayoutParams(LP);
		back_Btn.setBackgroundResource(R.drawable.arrowleft);
		back_Btn.setVisibility(View.GONE);
		back_Btn.setId(getRandomId());
		this.addView(back_Btn);
	}
	
	private void setTitle(){
		{
			TitleLayout=new RelativeLayout(context);
			LayoutParams LP=new LayoutParams(LayoutParams.WRAP_CONTENT
					        ,LayoutParams.WRAP_CONTENT);
			LP.addRule(RelativeLayout.CENTER_IN_PARENT);
			TitleLayout.setLayoutParams(LP);
			this.addView(TitleLayout);
		}
		
		logoImage=new View(context);
		LayoutParams LP1=new LayoutParams(WH.getW(15)
				       ,WH.getW(15));
		logoImage.setLayoutParams(LP1);
		logoImage.setBackgroundResource(R.drawable.in_logo);
		logoImage.setId(getRandomId());
		TitleLayout.addView(logoImage);
		
		title=new TextView(context);
		LayoutParams LP2=new LayoutParams(LayoutParams.WRAP_CONTENT
				       ,LayoutParams.WRAP_CONTENT);
		LP2.addRule(RIGHT_OF,logoImage.getId());
		LP2.addRule(RelativeLayout.CENTER_VERTICAL);
		LP2.leftMargin=WH.getW(5);
		title.setLayoutParams(LP2);
		title.setTextSize(PX,WH.getTextSize(45));
		TitleLayout.addView(title);
	}
	
	private void setDayOrderSearchButton(){
		dayOrderSearch_Btn=new Button(context);
		LayoutParams LP=new LayoutParams(LayoutParams.WRAP_CONTENT
				       ,LayoutParams.WRAP_CONTENT);
		LP.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
		LP.addRule(RelativeLayout.CENTER_VERTICAL);
		LP.rightMargin=WH.getW(1);
		dayOrderSearch_Btn.setLayoutParams(LP);
		dayOrderSearch_Btn.setText("查詢");
		dayOrderSearch_Btn.setVisibility(View.GONE);
		this.addView(dayOrderSearch_Btn);
	}
	
	public TextView getTitle(){
		return title;
	}
	
	public Button getBackBtn(){
		return back_Btn;
	}
	
	public Button getDayOrderSearchBtn(){
		return dayOrderSearch_Btn;
	}

}
