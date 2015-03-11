package com.storesimple.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.storesimple.controller.MealClass_Controller;
import com.storesimple.frame.MainController;
import com.storesimple.frame.MainFragment;
import com.storesimple.layout.MealClass_Layout;

public class MealClass_Fragment extends MainFragment{
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return new MealClass_Layout(getActivity());
	}

	protected MainController onControllerCreated() {
		return new MealClass_Controller(this);
	}

}
