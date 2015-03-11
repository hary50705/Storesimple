package com.storesimple.view;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.AbsListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.storesimple.R;
import com.storesimple.frame.MainParentLayout;
/*側邊選單-登出項目*/
public class MenuLoginoutItem extends MainParentLayout{
	private View loginoutImage;
	private TextView loginoutTitle;
	
	public MenuLoginoutItem(Context context) {
		super(context);
	}

	@Override
	protected void init() {
		AbsListView.LayoutParams LP=new AbsListView.LayoutParams(LayoutParams.MATCH_PARENT
									,WH.getH(10));
		this.setLayoutParams(LP);
		this.setBackgroundResource(R.drawable.left_bgoff);

		setLoginoutItem();
	}
	
	private void setLoginoutItem(){
		loginoutImage=new View(context);
		LayoutParams LP1=new LayoutParams(WH.getW(13)
				       ,WH.getW(13));
		LP1.leftMargin=WH.getW(5);
		LP1.addRule(RelativeLayout.CENTER_VERTICAL);
		loginoutImage.setLayoutParams(LP1);
		loginoutImage.setId(getRandomId());
		this.addView(loginoutImage);
		
		loginoutTitle=new TextView(context);
		LayoutParams LP2=new LayoutParams(LayoutParams.WRAP_CONTENT
				      ,LayoutParams.WRAP_CONTENT);
		LP2.addRule(RIGHT_OF,loginoutImage.getId());
		LP2.leftMargin=WH.getW(2);
		LP2.addRule(RelativeLayout.CENTER_VERTICAL);
		loginoutTitle.setLayoutParams(LP2);
		loginoutTitle.setTextSize(PX,WH.getTextSize(45));
		loginoutTitle.setTextColor(Color.WHITE);
		this.addView(loginoutTitle);
	}
	
	public View getLoginoutImage(){
		return loginoutImage;
	}
	
	public TextView getLoginoutTitle(){
		return loginoutTitle;
	}

}
