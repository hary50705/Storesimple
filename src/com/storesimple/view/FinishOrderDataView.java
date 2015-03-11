package com.storesimple.view;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.storesimple.R;
import com.storesimple.frame.MainParentLayout;

public class FinishOrderDataView extends MainParentLayout{
	private TextView OrderDataTitle;
	private TextView OrderDataValue;

	public FinishOrderDataView(Context context) {
		super(context);
	}

	@Override
	protected void init() {
		setOrderData();
	}
	
	private void setOrderData(){
		OrderDataTitle=new TextView(context);
		LayoutParams LP1=new LayoutParams(LayoutParams.WRAP_CONTENT
				        ,LayoutParams.WRAP_CONTENT);
		LP1.leftMargin=WH.getW(2);
		LP1.addRule(RelativeLayout.CENTER_VERTICAL);
		OrderDataTitle.setLayoutParams(LP1);
		OrderDataTitle.setTextSize(PX,WH.getTextSize(35));
		OrderDataTitle.setId(getRandomId());
		this.addView(OrderDataTitle);
		
		OrderDataValue=new TextView(context);
		LayoutParams LP2=new LayoutParams(WH.getW(50)
				        ,WH.getW(8));
		LP2.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
		LP2.addRule(RelativeLayout.CENTER_VERTICAL);
		LP2.rightMargin=WH.getW(2);
		OrderDataValue.setLayoutParams(LP2);
		OrderDataValue.setTextSize(PX,WH.getTextSize(25));
		OrderDataValue.setTextColor(Color.WHITE);
		OrderDataValue.setBackgroundResource(R.drawable.bn);
		OrderDataValue.setGravity(Gravity.CENTER);
		this.addView(OrderDataValue);
	}
	
	public TextView getOrderDataTitle(){
		return OrderDataTitle;
	}
	
	public TextView getOrderDataValue(){
		return OrderDataValue;
	}

}
