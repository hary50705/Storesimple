package com.storesimple.layout;

import android.content.Context;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.storesimple.R;
import com.storesimple.frame.MainParentLayout;
/*側邊選單畫面*/
public class Menu_Layout extends MainParentLayout{
	private View titleLogo;
	private ListView menuList;
	
	public Menu_Layout(Context context) {
		super(context);
	}

	@Override
	protected void init() {
		DrawerLayout.LayoutParams LP=new DrawerLayout.LayoutParams(WH.getW(50)
				        ,LayoutParams.MATCH_PARENT);
		this.setLayoutParams(LP);
		this.setBackgroundResource(R.drawable.left_bg);
		
		setTitleLogo();
		setMenuList();
	}
	
	private void setTitleLogo(){
		titleLogo=new View(context);
		LayoutParams LP=new LayoutParams(WH.getW(25)
				       ,WH.getW(25));
		LP.topMargin=WH.getH(1);
		LP.addRule(RelativeLayout.CENTER_HORIZONTAL);
		titleLogo.setLayoutParams(LP);
		titleLogo.setBackgroundResource(R.drawable.menulogo);
		titleLogo.setId(getRandomId());
		this.addView(titleLogo);
	}
	
	private void setMenuList(){
		menuList=new ListView(context);
		LayoutParams LP=new LayoutParams(LayoutParams.MATCH_PARENT
				       ,LayoutParams.WRAP_CONTENT);
		LP.addRule(BELOW,titleLogo.getId());
		LP.topMargin=WH.getH(1);
		menuList.setLayoutParams(LP);
		this.addView(menuList);
	}
	
	public ListView getMenuList(){
		return menuList;
	}
	
}
