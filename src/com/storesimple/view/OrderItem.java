package com.storesimple.view;

import android.content.Context;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.storesimple.frame.WH;

/*訂單的列表項目*/
public class OrderItem extends LinearLayout{
	private Context context;
	private WH WH;
	private int PX = TypedValue.COMPLEX_UNIT_PX;
	private TextView Item1;//帳號
	private TextView Item2;//取餐時間
	private TextView Item3;//取餐方式
	
	public OrderItem(Context context) {
		super(context);
		this.context = context;
		WH = new WH(context);
		init();
	}

	protected void init() {
		AbsListView.LayoutParams LP=new AbsListView.LayoutParams(LayoutParams.MATCH_PARENT
								    ,WH.getH(10));
		this.setLayoutParams(LP);
		this.setOrientation(LinearLayout.HORIZONTAL);
		setItem();
	}
	
	private void setItem(){
		Item1=new TextView(context);
		LayoutParams LP1=new LayoutParams(LayoutParams.MATCH_PARENT
				       ,LayoutParams.MATCH_PARENT);
		LP1.weight=1;
		Item1.setLayoutParams(LP1);
		Item1.setTextSize(PX,WH.getTextSize(35));
		Item1.setGravity(Gravity.CENTER);
		this.addView(Item1);
		
		Item2=new TextView(context);
		LayoutParams LP2=new LayoutParams(LayoutParams.MATCH_PARENT
				       ,LayoutParams.MATCH_PARENT);
		LP2.weight=1;
		Item2.setLayoutParams(LP2);
		Item2.setTextSize(PX,WH.getTextSize(35));
		Item2.setGravity(Gravity.CENTER);
		this.addView(Item2);
		
		Item3=new TextView(context);
		LayoutParams LP3=new LayoutParams(LayoutParams.MATCH_PARENT
				       ,LayoutParams.MATCH_PARENT);
		LP3.weight=1;
		Item3.setLayoutParams(LP3);
		Item3.setTextSize(PX,WH.getTextSize(35));
		Item3.setGravity(Gravity.CENTER);
		this.addView(Item3);
	}
	
	public TextView getItem1(){
		return Item1;
	}
	
	public TextView getItem2(){
		return Item2;
	}
	
	public TextView getItem3(){
		return Item3;
	}
}
