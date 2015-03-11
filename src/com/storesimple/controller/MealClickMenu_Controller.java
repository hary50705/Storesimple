package com.storesimple.controller;

import android.app.Dialog;
import android.app.Fragment;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.storesimple.FunctionActivity;
import com.storesimple.fragment.MealClass_Fragment;
import com.storesimple.layout.MealClickMenu_Layout;
import com.storesimple.module.Tag;
import com.storesimple.view.MealItem;

public class MealClickMenu_Controller {
	private Context context;
	private Fragment frag;
	private Dialog dialog;
	private MealClickMenu_Layout MealClickMenuLayout;
	private MealItem MealItem;
	private String mealItemID;
	private String source;
	private Button changeMealBtn,mealnotenoughBtn;
	
	public MealClickMenu_Controller(Context context,Fragment frag,Dialog dialog,MealClickMenu_Layout layout,MealItem mealItem,String mealItemID,String source){
		this.context=context;
		this.frag=frag;
		this.dialog=dialog;
		this.MealClickMenuLayout=layout;
		this.MealItem=mealItem;
		this.mealItemID=mealItemID;
		this.source=source;
		init();
	}
	
	protected void init(){
		changeMealBtn=MealClickMenuLayout.getChangeMealBtn();
		mealnotenoughBtn=MealClickMenuLayout.getMealnotenoughBtn();
		
		setButton();
	}
	
	private void setButton(){
		changeMealBtn.setOnClickListener(new OnClickListener() {//更換餐點
			
			public void onClick(View v) {
				Tag.SOURCE=source;//要紀錄是從當日訂單點選的 還是在預定訂單
				Tag.MEALITEMID=mealItemID;
				Tag.MEALNAME=MealItem.getMealname().getText().toString();
		
				frag.getFragmentManager().beginTransaction()
				.replace(((FunctionActivity)frag.getActivity()).getFrameType().getContentLayout().getId(),new MealClass_Fragment(),Tag.MEALCLASS_FRAGMENT)
				.commit();
				
				dialog.dismiss();
			}
		});
		
		mealnotenoughBtn.setOnClickListener(new OnClickListener() {//餐點不足
			
			public void onClick(View v) {
				String mealname=MealItem.getMealname().getText().toString();
				
				if(!mealname.contains("-餐點不足")){
					MealItem.getMealname().setText(mealname+"-餐點不足");
					MealItem.getPrice().setText("0");
				}
				dialog.dismiss();
			}
		});
	}

}
