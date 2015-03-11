package com.storesimple.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.storesimple.controller.FinishOrderContent_Controller;
import com.storesimple.frame.MainController;
import com.storesimple.frame.MainFragment;
import com.storesimple.layout.FinishOrderContent_Layout;

public class FinishOrderContent_Fragment extends MainFragment{
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return new FinishOrderContent_Layout(getActivity());
	}

	protected MainController onControllerCreated() {
		return new FinishOrderContent_Controller(this);
	}
	

}
