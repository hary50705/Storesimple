package com.storesimple.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.storesimple.controller.ReserveOrder_Controller;
import com.storesimple.frame.MainController;
import com.storesimple.frame.MainFragment;
import com.storesimple.layout.Order_Layout;

public class ReserveOrder_Fragment extends MainFragment{
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return new Order_Layout(getActivity());
	}

	protected MainController onControllerCreated() {
		return new ReserveOrder_Controller(this);
	}

}
