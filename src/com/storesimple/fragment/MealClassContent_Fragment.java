package com.storesimple.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.storesimple.controller.MealClassContent_Controller;
import com.storesimple.frame.MainController;
import com.storesimple.frame.MainFragment;
import com.storesimple.layout.MealClassContent_Layout;

public class MealClassContent_Fragment extends MainFragment{

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return new MealClassContent_Layout(getActivity());
	}

	protected MainController onControllerCreated() {
		
		return new MealClassContent_Controller(this);
	}

}
