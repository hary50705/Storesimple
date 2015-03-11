package com.storesimple.view;

import android.content.Context;
import android.widget.AbsListView;
import android.widget.TextView;

import com.storesimple.frame.MainParentLayout;
/*各類別餐點*/
public class MealClassContentItem extends MainParentLayout{
	private TextView Mealname;
	
	public MealClassContentItem(Context context) {
		super(context);
	}

	protected void init() {
		AbsListView.LayoutParams LP=new AbsListView.LayoutParams(LayoutParams.MATCH_PARENT
				                   ,LayoutParams.WRAP_CONTENT);
		this.setLayoutParams(LP);
		
		setMealClassContentItem();
	}
	
	private void setMealClassContentItem(){
		Mealname=new TextView(context);
		LayoutParams LP=new LayoutParams(LayoutParams.WRAP_CONTENT
				       ,LayoutParams.WRAP_CONTENT);
		Mealname.setLayoutParams(LP);
		Mealname.setTextSize(PX,40);
		this.addView(Mealname);
	}
	
	public TextView getMealname(){
		return Mealname;
	}

}
