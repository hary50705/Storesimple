package com.storesimple.controller;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.storesimple.FunctionActivity;
import com.storesimple.fragment.DayOrderContent_Fragment;
import com.storesimple.fragment.Dayorder_Fragment;
import com.storesimple.fragment.FinishOrder_Fragment;
import com.storesimple.fragment.MealClass_Fragment;
import com.storesimple.fragment.ReserveOrder_Fragment;
import com.storesimple.fragment.ReserverOrderContent_Fragment;
import com.storesimple.frame.MainController;
import com.storesimple.layout.DetailContentTitle_Layout;
import com.storesimple.module.Tag;

public class DetailContentTitle_Controller extends MainController{
	private DetailContentTitle_Layout DetailContentTitleLayout;
	private RelativeLayout functionTitleView;
	private RelativeLayout dayOrderSearchView;
	private Button backBtn;
	private Button dayOrderSearchBtn;
	private Button backFunctionTitleBtn;
	private Button searchBtn;
	private EditText phoneNumberInput;
	
	public DetailContentTitle_Controller(Fragment frag) {
		super(frag);
	}

	protected void init() {
		DetailContentTitleLayout=(DetailContentTitle_Layout) frag.getView();
		functionTitleView=DetailContentTitleLayout.getFunctionTitleView();
		dayOrderSearchView=DetailContentTitleLayout.getDayOrderSearchView();
		backBtn=DetailContentTitleLayout.getBackBtn();
		dayOrderSearchBtn=DetailContentTitleLayout.getDayOrderSearchBtn();
		backFunctionTitleBtn=DetailContentTitleLayout.getBackFunctionTitleBtn();
		searchBtn=DetailContentTitleLayout.getSearchBtn();
		phoneNumberInput=DetailContentTitleLayout.getPhoneNumberInput();
		
		setButton();
	}
	
	private void setButton(){
		backBtn.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				FragmentManager Manager=frag.getFragmentManager();
				if(Manager.findFragmentByTag(Tag.DAYORDERCONTENT_FRAGMENT)!=null){
					
					setFragmentReplace(new Dayorder_Fragment(),Tag.DAYORDER_FRAGMENT);
				
				}else if(Manager.findFragmentByTag(Tag.RESERVERORDERCONTENT_FRAGMENT)!=null){
					
					setFragmentReplace(new ReserveOrder_Fragment(),Tag.RESERVEORDER_FRAGMENT);
					
				}else if(Manager.findFragmentByTag(Tag.FINISHORDERCONTENT_FRAGMENT)!=null){
					
					setFragmentReplace(new FinishOrder_Fragment(),Tag.FINISHORDER_FRAGMENT);
				
				}else if(Manager.findFragmentByTag(Tag.MEALCLASS_FRAGMENT)!=null){
					String source=Tag.SOURCE;
					String orderID=Tag.ORDERID;
					
					switch(source){
						case "DayOrder":{
							DayOrderContent_Fragment DayOrderContentFrag=new DayOrderContent_Fragment();
							Bundle bundle=new Bundle();
							bundle.putString("orderID",orderID);
							DayOrderContentFrag.setArguments(bundle);
							
							setFragmentReplace(DayOrderContentFrag,Tag.DAYORDERCONTENT_FRAGMENT);
							
							break;
						}
						
						case "ReserverOrder":{
							ReserverOrderContent_Fragment  ReserverContentFrag=new ReserverOrderContent_Fragment();
							Bundle bundle=new Bundle();
							bundle.putString("orderID",orderID);
							ReserverContentFrag.setArguments(bundle);
							
							setFragmentReplace(ReserverContentFrag,Tag.RESERVERORDERCONTENT_FRAGMENT);
							
							break;
						}
						
						default:
							break;
					}
					
				}else if(Manager.findFragmentByTag(Tag.MEALCLASSCONTENT_FRAGMENT)!=null){
					
					setFragmentReplace(new MealClass_Fragment(),Tag.MEALCLASS_FRAGMENT);
				
				}
			}
		});
		
		dayOrderSearchBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				functionTitleView.setVisibility(View.GONE);
				dayOrderSearchView.setVisibility(View.VISIBLE);
			}
		});
		
		backFunctionTitleBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				functionTitleView.setVisibility(View.VISIBLE);
				dayOrderSearchView.setVisibility(View.GONE);
			}
		});
		
		searchBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
			}
		});
	}
	
	private void setFragmentReplace(Fragment fragment,String tag){
		frag.getFragmentManager().beginTransaction()
		.replace(((FunctionActivity)frag.getActivity()).getFrameType().getContentLayout().getId(),fragment,tag)
		.commit();
	}
	
}
