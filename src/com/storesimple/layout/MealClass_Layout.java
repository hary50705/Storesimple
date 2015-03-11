package com.storesimple.layout;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import com.storesimple.R;
import com.storesimple.frame.MainParentLayout;
/*選擇餐點類別畫面*/
public class MealClass_Layout extends MainParentLayout{
	private ScrollView scroll;
	private RelativeLayout ClassLayout;
	
	public MealClass_Layout(Context context) {
		super(context);
	}

	protected void init() {
		LayoutParams LP=new LayoutParams(LayoutParams.MATCH_PARENT
				       ,LayoutParams.MATCH_PARENT);
		this.setLayoutParams(LP);
		this.setBackgroundResource(R.drawable.changebg);
		
		setScroll();
		setClassLayout();
	}
	
	private void setScroll(){
		scroll=new ScrollView(context);
		LayoutParams LP=new LayoutParams(WH.getW(90)
				       ,WH.getH(60));
		LP.topMargin=WH.getH(10);
		LP.addRule(RelativeLayout.CENTER_HORIZONTAL);
		scroll.setLayoutParams(LP);
		scroll.setBackgroundColor(Color.WHITE);
		
		this.addView(scroll);
	}
	
	private void setClassLayout(){
		ClassLayout=new RelativeLayout(context);
		ScrollView.LayoutParams LP=new ScrollView.LayoutParams(LayoutParams.WRAP_CONTENT
				       ,LayoutParams.WRAP_CONTENT);
		LP.gravity=Gravity.CENTER_HORIZONTAL;
		ClassLayout.setLayoutParams(LP);
		scroll.addView(ClassLayout);
	}
	
	public RelativeLayout getClassLayout(){
		return ClassLayout;
	}
	
}
