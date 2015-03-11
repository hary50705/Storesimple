package com.storesimple.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.storesimple.controller.StoreGPSLocation_Controller;
import com.storesimple.frame.MainController;
import com.storesimple.frame.MainFragment;
import com.storesimple.layout.StoreGPSLocation_Layout;

public class StoreGPSLocation_Fragment extends MainFragment{
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		return new StoreGPSLocation_Layout(getActivity());
	}

	@Override
	protected MainController onControllerCreated() {
		
		return new StoreGPSLocation_Controller(this);
	}

}
