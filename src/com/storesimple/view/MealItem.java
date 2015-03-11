package com.storesimple.view;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.AbsListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.storesimple.frame.MainParentLayout;
/*餐點列表*/
public class MealItem extends MainParentLayout{
	private RelativeLayout MealItemLayout;
	private RelativeLayout OtherItemLayout;
	private TextView mealName;
	private TextView quantity;
	private TextView remark;
	private TextView price;
	
	public MealItem(Context context) {
		super(context);
	}

	protected void init() {
		AbsListView.LayoutParams LP=new AbsListView.LayoutParams(LayoutParams.MATCH_PARENT
				                   ,LayoutParams.WRAP_CONTENT);
		this.setLayoutParams(LP);
		
		setMealItem();
		setOtherItem();
	}
	
	private void setMealItem(){
		{
			MealItemLayout=new RelativeLayout(context);
			LayoutParams LP=new LayoutParams(LayoutParams.MATCH_PARENT
					       ,WH.getH(8));
			MealItemLayout.setLayoutParams(LP);
			MealItemLayout.setId(getRandomId());
			this.addView(MealItemLayout);
		}
		
		mealName=new TextView(context);//餐點名稱
		LayoutParams LP1=new LayoutParams(WH.getW(30)
				        ,LayoutParams.MATCH_PARENT);
		mealName.setLayoutParams(LP1);
		mealName.setTextSize(PX,WH.getTextSize(30));
		mealName.setGravity(Gravity.CENTER);
		mealName.setId(getRandomId());
		MealItemLayout.addView(mealName);
		
		quantity=new TextView(context);//口味
		LayoutParams LP2=new LayoutParams(WH.getW(20)
				        ,LayoutParams.MATCH_PARENT);
		LP2.addRule(RIGHT_OF,mealName.getId());
		quantity.setLayoutParams(LP2);
		quantity.setTextSize(PX,WH.getTextSize(30));
		quantity.setGravity(Gravity.CENTER);
		quantity.setId(getRandomId());
		MealItemLayout.addView(quantity);
		
		remark=new TextView(context);//備註
		LayoutParams LP3=new LayoutParams(WH.getW(30)
				        ,LayoutParams.MATCH_PARENT);
		LP3.addRule(RIGHT_OF,quantity.getId());
		remark.setLayoutParams(LP3);
		remark.setTextSize(PX,WH.getTextSize(30));
		remark.setGravity(Gravity.CENTER);
		remark.setId(getRandomId());
		MealItemLayout.addView(remark);
		
		price=new TextView(context);//價錢
		LayoutParams LP4=new LayoutParams(WH.getW(20)
				        ,LayoutParams.MATCH_PARENT);
		LP4.addRule(RIGHT_OF,remark.getId());
		price.setLayoutParams(LP4);
		price.setTextSize(PX,WH.getTextSize(30));
		price.setGravity(Gravity.CENTER);
		price.setId(getRandomId());
		MealItemLayout.addView(price);
	}
	
	private void setOtherItem(){
		{
			OtherItemLayout=new RelativeLayout(context);
			LayoutParams LP=new LayoutParams(LayoutParams.MATCH_PARENT
					       ,WH.getH(15));
			LP.addRule(BELOW,MealItemLayout.getId());
			OtherItemLayout.setLayoutParams(LP);
			OtherItemLayout.setVisibility(View.GONE);
			this.addView(OtherItemLayout);
		}
		
		TextView otherHint=new TextView(context);
		LayoutParams LP1=new LayoutParams(LayoutParams.WRAP_CONTENT
				        ,LayoutParams.WRAP_CONTENT);
		otherHint.setLayoutParams(LP1);
		otherHint.setText("加料項目:");
		otherHint.setTextSize(PX,WH.getTextSize(30));
		OtherItemLayout.addView(otherHint);
	}
	
	public RelativeLayout getOtherItemLayout(){
		return OtherItemLayout;
	}
	
	public TextView getMealname(){
		return mealName;
	}
	
	public TextView getQuantity(){
		return quantity;
	}
	
	public TextView getRemark(){
		return remark;
	}
	
	public TextView getPrice(){
		return price;
	}
	
}
