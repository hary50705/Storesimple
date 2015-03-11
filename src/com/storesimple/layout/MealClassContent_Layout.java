package com.storesimple.layout;

import android.content.Context;
import android.widget.ListView;

import com.storesimple.frame.MainParentLayout;
/*各類別餐點畫面*/
public class MealClassContent_Layout extends MainParentLayout{
	private ListView MealList;
	public MealClassContent_Layout(Context context) {
		super(context);
	}

	protected void init() {
		LayoutParams LP=new LayoutParams(LayoutParams.MATCH_PARENT
				       ,LayoutParams.WRAP_CONTENT);
		this.setLayoutParams(LP);
		
		setMealList();
	}
	
	private void setMealList(){
		MealList=new ListView(context);
		LayoutParams LP=new LayoutParams(LayoutParams.MATCH_PARENT
				       ,LayoutParams.WRAP_CONTENT);
		MealList.setLayoutParams(LP);
		this.addView(MealList);
	}
	
	public ListView getMealList(){
		return MealList;
	}
}
