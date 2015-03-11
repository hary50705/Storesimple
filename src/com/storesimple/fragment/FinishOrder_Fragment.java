package com.storesimple.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.storesimple.controller.FinishOrder_Controller;
import com.storesimple.frame.MainController;
import com.storesimple.frame.MainFragment;
import com.storesimple.layout.FinishOrder_Layout;

public class FinishOrder_Fragment extends MainFragment{
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return new FinishOrder_Layout(getActivity());
	}

	protected MainController onControllerCreated() {
		return new FinishOrder_Controller(this);
	}

}
