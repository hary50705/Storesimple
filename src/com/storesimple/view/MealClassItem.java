package com.storesimple.view;

import android.content.Context;
import android.widget.AbsListView;
import android.widget.TextView;

import com.storesimple.frame.MainParentLayout;
/*餐點類別*/
public class MealClassItem extends MainParentLayout{
	private TextView Classname;
	
	public MealClassItem(Context context) {
		super(context);
	}

	protected void init() {
		AbsListView.LayoutParams LP=new AbsListView.LayoutParams(LayoutParams.MATCH_PARENT
				                   ,LayoutParams.WRAP_CONTENT);
		this.setLayoutParams(LP);
		
		setMealClassItem();
	}
	
	private void setMealClassItem(){
		Classname=new TextView(context);
		LayoutParams LP=new LayoutParams(LayoutParams.WRAP_CONTENT
				       ,LayoutParams.WRAP_CONTENT);
		Classname.setLayoutParams(LP);
		Classname.setTextSize(PX,WH.getTextSize(40));
		this.addView(Classname);
	} 
	
	public TextView getClassname(){
		return Classname;
	}

}
