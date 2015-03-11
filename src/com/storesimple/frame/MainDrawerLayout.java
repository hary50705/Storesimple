package com.storesimple.frame;

import android.content.Context;
import android.support.v4.widget.DrawerLayout;
import android.util.TypedValue;

public abstract class MainDrawerLayout extends DrawerLayout{
	protected int WRAP_CONTENT = LayoutParams.WRAP_CONTENT,
			MATCH_PARENT = LayoutParams.MATCH_PARENT,
			PX = TypedValue.COMPLEX_UNIT_PX;
	protected Context context;
	protected WH WH;
	
	public MainDrawerLayout(Context context){
		super(context);
		this.context = context;
		WH = new WH(context);
		//setMath_Wrap();
		init();
	}
	
	protected abstract void init();
	
	protected void setMath_Wrap() {
		LayoutParams LP = new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.MATCH_PARENT);
		this.setLayoutParams(LP);
	}

	protected int getRandomId() {
		return (int) (Math.random() * 1000000);
	}

	protected LayoutParams getLayoutParams(int Widht, int Height) {
		return new LayoutParams(Widht, Height);
	}
}
