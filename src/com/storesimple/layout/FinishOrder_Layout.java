package com.storesimple.layout;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.storesimple.R;
import com.storesimple.frame.MainParentLayout;

public class FinishOrder_Layout extends MainParentLayout{
	private LinearLayout OrderItemLayout;
	private ListView orderList;
	
	public FinishOrder_Layout(Context context) {
		super(context);
	}

	protected void init() {
		LayoutParams LP=new LayoutParams(LayoutParams.MATCH_PARENT
			       ,LayoutParams.MATCH_PARENT);
		this.setLayoutParams(LP);
		setOrderItem();
		setOrderList();
	}
	
	private void setOrderItem(){
		{
			OrderItemLayout=new LinearLayout(context);
			LayoutParams LP=new LayoutParams(LayoutParams.MATCH_PARENT
					       ,WH.getH(6));
			OrderItemLayout.setLayoutParams(LP);
			OrderItemLayout.setBackgroundResource(R.drawable.titlelist_bg);
			OrderItemLayout.setOrientation(LinearLayout.HORIZONTAL);
			OrderItemLayout.setId(getRandomId());
			this.addView(OrderItemLayout);
		}
		
		String orderItem[]=context.getResources().getStringArray(R.array.FinishOrderItem);
		for(int i=0;i<3;i++){
			TextView Item=new TextView(context);
			LinearLayout.LayoutParams LP1=new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT
					                    ,LayoutParams.MATCH_PARENT);
			LP1.weight=1;
			Item.setLayoutParams(LP1);
			Item.setText(orderItem[i]);
			Item.setTextSize(PX,WH.getTextSize(40));
			Item.setTextColor(Color.WHITE);
			Item.setGravity(Gravity.CENTER);
			OrderItemLayout.addView(Item);
		}
	}
	
	private void setOrderList(){
		orderList=new ListView(context);
		LayoutParams LP=new LayoutParams(LayoutParams.MATCH_PARENT
				       ,LayoutParams.WRAP_CONTENT);
		LP.addRule(BELOW,OrderItemLayout.getId());
		orderList.setLayoutParams(LP);
		this.addView(orderList);
	}
	
	public ListView getOrderList(){
		return orderList;
	}
}
