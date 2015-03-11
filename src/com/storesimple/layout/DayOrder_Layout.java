package com.storesimple.layout;

import android.content.Context;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.storesimple.R;
import com.storesimple.frame.MainParentLayout;

public class DayOrder_Layout extends MainParentLayout{
	private LinearLayout StatusButtonLayout;
	private Button newOrder_Btn;
	private Button makePeriodOrder_Btn;
	private Button finishOrder_Btn;
	private Order_Layout OrderLayout;
	
	public DayOrder_Layout(Context context) {
		super(context);
	}

	@Override
	protected void init() {
		LayoutParams LP=new LayoutParams(LayoutParams.MATCH_PARENT
				      ,LayoutParams.MATCH_PARENT);
		this.setLayoutParams(LP);
		
		setStatusButton();
		setOrder();
	}
	
	private void setStatusButton(){
		{
			StatusButtonLayout=new LinearLayout(context);
			LayoutParams LP=new LayoutParams(LayoutParams.MATCH_PARENT
					       ,LayoutParams.WRAP_CONTENT);
			StatusButtonLayout.setLayoutParams(LP);
			StatusButtonLayout.setOrientation(LinearLayout.HORIZONTAL);;
			StatusButtonLayout.setId(getRandomId());
			this.addView(StatusButtonLayout);
		}
		
		newOrder_Btn=new Button(context);
		LinearLayout.LayoutParams LP1=new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT
				                     ,LayoutParams.WRAP_CONTENT);
		LP1.weight=1;
		newOrder_Btn.setLayoutParams(LP1);
		newOrder_Btn.setText(R.string.New);
		StatusButtonLayout.addView(newOrder_Btn);
		
		makePeriodOrder_Btn=new Button(context);
		LinearLayout.LayoutParams LP2=new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT
				                    ,LayoutParams.WRAP_CONTENT);
		LP2.weight=1;
		makePeriodOrder_Btn.setLayoutParams(LP2);
		makePeriodOrder_Btn.setText(R.string.MakePeriod);
		StatusButtonLayout.addView(makePeriodOrder_Btn);
		
		finishOrder_Btn=new Button(context);
		LinearLayout.LayoutParams LP3=new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT
				                    ,LayoutParams.WRAP_CONTENT);
		LP3.weight=1;
		finishOrder_Btn.setLayoutParams(LP3);
		finishOrder_Btn.setText(R.string.Finish);
		StatusButtonLayout.addView(finishOrder_Btn);
	}
	
	private void setOrder(){
		OrderLayout=new Order_Layout(context);
		LayoutParams LP=new LayoutParams(LayoutParams.MATCH_PARENT
			           ,LayoutParams.MATCH_PARENT);
		LP.addRule(BELOW,StatusButtonLayout.getId());
	    OrderLayout.setLayoutParams(LP);
		this.addView(OrderLayout);
	}
	
	public Button getNewOrderBtn(){
		return newOrder_Btn;
	}
	
	public Button getMakePeriodOrderBtn(){
		return makePeriodOrder_Btn;
	}
	
	public Button getFinishOrderBtn(){
		return finishOrder_Btn;
	}
	
	public ListView getOrderList(){
		return OrderLayout.getOrderList();
	}
}
