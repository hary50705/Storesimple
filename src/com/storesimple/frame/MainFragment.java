package com.storesimple.frame;

import android.app.Fragment;
import android.os.Bundle;

public abstract class MainFragment extends Fragment {
	protected MainController MC;

	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		MC = onControllerCreated();
		onStartAnimationController();
	}

	protected abstract MainController onControllerCreated();

	public MainController getController() {
		return MC;
	}

	public void onDestroyController() {
		MC.onDestroyController();
	}

	public void onDestroyView() {
		onEndAnimationController();
		onDestroyController();
		super.onDestroyView();
	}

	public void onStartAnimationController(){
		if (MC != null)
	      MC.onStartAnimationController();
	}

	public void onEndAnimationController() {
		if (MC != null)
			MC.onEndAnimationController();
	}
}
