package com.storesimple.frame;

import android.app.Fragment;
import android.content.Context;
public abstract class MainController {
	protected Fragment frag;
	protected Context context;

	public MainController(Fragment frag) {
		this.frag = frag;
		this.context = frag.getActivity();
		init();
	}

	protected abstract void init();
	
	public boolean onBack(){
		return false;
	}
	
	public void onDestroyController() {}
	
	public void onStartAnimationController() {}
	
	public void onEndAnimationController() {}
}
