package com.storesimple.layout;

import android.content.Context;
import android.view.Gravity;
import android.widget.RelativeLayout;

import com.storesimple.frame.MainDrawerLayout;

public class FrameType extends MainDrawerLayout{
	private RelativeLayout MainContentLayout;
	private RelativeLayout DrawerMenuLayout;
	private RelativeLayout TitleLayout;
	private RelativeLayout BottomLayout;
	private RelativeLayout ContentLayout;
	
	public FrameType(Context context) {
		super(context);
	}

	protected void init() {
		LayoutParams LP=new LayoutParams(LayoutParams.MATCH_PARENT
				       ,LayoutParams.MATCH_PARENT);
		this.setLayoutParams(LP);
		
		setLayout();
		setTitle();
		setBottom();
		setContent();
	}
	
	private void setLayout(){
		MainContentLayout=new RelativeLayout(context);
		LayoutParams LP1=new LayoutParams(LayoutParams.MATCH_PARENT
				       ,LayoutParams.MATCH_PARENT);
		MainContentLayout.setLayoutParams(LP1);
		this.addView(MainContentLayout);
		
		DrawerMenuLayout=new RelativeLayout(context);
		LayoutParams LP2=new LayoutParams(WH.getW(50)
				        ,LayoutParams.MATCH_PARENT);
		LP2.gravity=Gravity.START;
		DrawerMenuLayout.setLayoutParams(LP2);
		DrawerMenuLayout.setId(getRandomId());
		this.addView(DrawerMenuLayout);
	}
	
	private void setTitle(){
		TitleLayout=new RelativeLayout(context);
		RelativeLayout.LayoutParams LP=new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT
				                     ,WH.getH(10));
		TitleLayout.setLayoutParams(LP);
		TitleLayout.setId(getRandomId());
		MainContentLayout.addView(TitleLayout);
	}
	
	private void setBottom(){
		BottomLayout=new RelativeLayout(context);
		RelativeLayout.LayoutParams LP=new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT
				       ,LayoutParams.WRAP_CONTENT);
		LP.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		BottomLayout.setLayoutParams(LP);
		BottomLayout.setId(getRandomId());
		MainContentLayout.addView(BottomLayout);
	}
	
	private void setContent(){
		ContentLayout=new RelativeLayout(context);
		RelativeLayout.LayoutParams LP=new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT
				       ,LayoutParams.MATCH_PARENT);
		LP.addRule(RelativeLayout.BELOW,TitleLayout.getId());
		LP.addRule(RelativeLayout.ABOVE,BottomLayout.getId());
		ContentLayout.setLayoutParams(LP);
		ContentLayout.setId(getRandomId());
		MainContentLayout.addView(ContentLayout);
	}
	
	public RelativeLayout getDrawerMenuLayout(){
		return DrawerMenuLayout;
	}
	
	public RelativeLayout getTitleLayout(){
		return TitleLayout;
	}
	
	public RelativeLayout getContentLayout(){
		return ContentLayout;
	}
	
	public RelativeLayout getBottomLayout(){
		return BottomLayout;
	}
	
}
