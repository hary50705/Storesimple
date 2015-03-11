package com.storesimple.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.storesimple.controller.DayOrderContent_Controller;
import com.storesimple.frame.MainController;
import com.storesimple.frame.MainFragment;
import com.storesimple.layout.OrderContent_Layout;

public class DayOrderContent_Fragment extends MainFragment{
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return new OrderContent_Layout(getActivity());
	}
	
	protected MainController onControllerCreated() {
		return new DayOrderContent_Controller(this);
	}


	

}
