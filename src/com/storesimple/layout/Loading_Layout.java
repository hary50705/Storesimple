package com.storesimple.layout;

import android.content.Context;

import com.storesimple.R;
import com.storesimple.frame.MainParentLayout;

public class Loading_Layout extends MainParentLayout{

	public Loading_Layout(Context context) {
		super(context);
	}

	protected void init() {
		LayoutParams LP=new LayoutParams(LayoutParams.MATCH_PARENT
				       ,LayoutParams.MATCH_PARENT);
		this.setLayoutParams(LP);
		this.setBackgroundResource(R.drawable.loadingpage);
	}
	
}
