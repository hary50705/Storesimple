package com.storesimple.view;

import android.content.Context;
import android.graphics.Color;
import android.widget.AbsListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.storesimple.R;
import com.storesimple.frame.MainParentLayout;
/*側邊選單功能項目*/
public class MenuFunctionItem extends MainParentLayout{
	private TextView functionTitle;
	
	public MenuFunctionItem(Context context) {
		super(context);
	}

	@Override
	protected void init() {
		AbsListView.LayoutParams LP=new AbsListView.LayoutParams(LayoutParams.MATCH_PARENT
				                   ,WH.getH(10));
		this.setLayoutParams(LP);
		this.setBackgroundResource(R.drawable.left_bgoff);
		
		setMenuFunctionItem();
	}
	
	private void setMenuFunctionItem(){
		functionTitle=new TextView(context);
		LayoutParams LP=new LayoutParams(LayoutParams.WRAP_CONTENT
				      ,LayoutParams.WRAP_CONTENT);
		LP.leftMargin=WH.getW(5);
		LP.addRule(RelativeLayout.CENTER_VERTICAL);
		functionTitle.setLayoutParams(LP);
		functionTitle.setTextSize(PX,WH.getTextSize(45));
		functionTitle.setTextColor(Color.WHITE);
		this.addView(functionTitle);
	}
	
	public TextView getFunctionTitle(){
		return functionTitle;
	}

}
