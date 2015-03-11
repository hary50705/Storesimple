package com.storesimple.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.storesimple.controller.DetailContentTitle_Controller;
import com.storesimple.frame.MainController;
import com.storesimple.frame.MainFragment;
import com.storesimple.layout.DetailContentTitle_Layout;

public class DetailContentTitle_Fragment extends MainFragment{

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return new DetailContentTitle_Layout(getActivity());
	}

	protected MainController onControllerCreated() {
		return new DetailContentTitle_Controller(this);
	}

}
