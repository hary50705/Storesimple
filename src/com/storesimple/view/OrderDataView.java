package com.storesimple.view;

import android.content.Context;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.storesimple.frame.MainParentLayout;

/*訂單內容的各項項目*/
public class OrderDataView extends MainParentLayout{
	private TextView orderDataTitle;
	private TextView orderDataValue;
	
	public OrderDataView(Context context) {
		super(context);
	}

	@Override
	protected void init() {	
		setOrderData();
	}
	
	private void setOrderData(){
		orderDataTitle=new TextView(context);
		LayoutParams LP1=new LayoutParams(LayoutParams.WRAP_CONTENT
				        ,LayoutParams.WRAP_CONTENT);
		LP1.leftMargin=WH.getW(2);
		LP1.addRule(RelativeLayout.CENTER_VERTICAL);
		orderDataTitle.setLayoutParams(LP1);
		orderDataTitle.setTextSize(PX,WH.getTextSize(35));
		orderDataTitle.setId(getRandomId());
		this.addView(orderDataTitle);
		
		orderDataValue=new TextView(context);
		LayoutParams LP2=new LayoutParams(LayoutParams.WRAP_CONTENT
				        ,LayoutParams.WRAP_CONTENT);
		LP2.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
		LP2.addRule(RelativeLayout.CENTER_VERTICAL);
		LP2.rightMargin=WH.getW(2);
		orderDataValue.setLayoutParams(LP2);
		orderDataValue.setTextSize(PX,WH.getTextSize(35));
		this.addView(orderDataValue);
	}
	
	public TextView getOrderDataTitle(){
		return orderDataTitle;
	}
	
	public TextView getOrderDataValue(){
		return orderDataValue;
	}
}
