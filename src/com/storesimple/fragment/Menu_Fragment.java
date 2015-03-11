package com.storesimple.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.storesimple.controller.Menu_Controller;
import com.storesimple.frame.MainController;
import com.storesimple.frame.MainFragment;
import com.storesimple.layout.Menu_Layout;

public class Menu_Fragment extends MainFragment{
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return new Menu_Layout(getActivity());
	}

	@Override
	protected MainController onControllerCreated() {
		return new Menu_Controller(this);
	}

}
