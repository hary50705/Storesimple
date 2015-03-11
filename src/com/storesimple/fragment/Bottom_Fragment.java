package com.storesimple.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.storesimple.controller.Bottom_Controller;
import com.storesimple.frame.MainController;
import com.storesimple.frame.MainFragment;
import com.storesimple.layout.Bottom_Layout;

public class Bottom_Fragment extends MainFragment{

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return new Bottom_Layout(getActivity());
	}

	protected MainController onControllerCreated() {
		return new Bottom_Controller(this);
	}
}
