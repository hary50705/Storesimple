package com.storesimple.controller;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

import com.storesimple.FunctionActivity;
import com.storesimple.MainActivity;
import com.storesimple.R;
import com.storesimple.fragment.DetailContentTitle_Fragment;
import com.storesimple.fragment.MealClassContent_Fragment;
import com.storesimple.frame.MainController;
import com.storesimple.frame.WH;
import com.storesimple.layout.DetailContentTitle_Layout;
import com.storesimple.layout.MealClass_Layout;
import com.storesimple.module.StringVolleyPOST;
import com.storesimple.module.Tag;

public class MealClass_Controller extends MainController implements OnClickListener{
	private WH wh;
	private String storeID;
	private MealClass_Layout MealClassLayout;
	private RelativeLayout ClassLayout;
	private ProgressDialog processdialog;
	private ArrayList<String> classItemIDlist;
	
	public MealClass_Controller(Fragment frag) {
		super(frag);
	}

	protected void init() {
		DetailContentTitle_Fragment DetailContentTitleFrag=(DetailContentTitle_Fragment) frag.getFragmentManager()
				                                          .findFragmentByTag(Tag.DETAILCONTENTTITLE_FRAGMENT);
		if(DetailContentTitleFrag!=null){
			DetailContentTitle_Layout DetailContentTitleLayout=(DetailContentTitle_Layout) DetailContentTitleFrag.getView();
			DetailContentTitleLayout.getFunctionTitle().setText(R.string.ChangeMeal);
			DetailContentTitleLayout.getBackBtn().setVisibility(View.VISIBLE);
		}
		
		wh=new WH(context);
		
		storeID=Tag.STOREID;
		
		MealClassLayout=(MealClass_Layout) frag.getView();
		ClassLayout=MealClassLayout.getClassLayout();
		
		setClasslist(storeID);
	}
	
	@Override
	public void onClick(View v) {
		MealClassContent_Fragment MealClassContentFrag=new MealClassContent_Fragment();
		
		Bundle bundle=new Bundle();
		bundle.putString("classItemID",classItemIDlist.get((int)v.getTag()));
		MealClassContentFrag.setArguments(bundle);
		
		frag.getFragmentManager().beginTransaction()
		.replace(((FunctionActivity)frag.getActivity()).getFrameType().getContentLayout().getId(),MealClassContentFrag,Tag.MEALCLASSCONTENT_FRAGMENT)
		.commit();	
	}
	
	private void setClasslist(String storeID){
		processdialog=ProgressDialog.show(context,null,"Loading...",true,false);
		
		MainActivity.RQ.add(new StringVolleyPOST(Tag.GETMEALCLASSLIST_URL+"StoreID="+storeID
		    ,new StringVolleyPOST.OnStringResponse() {
			
			public void OnString(int state, StringVolleyPOST SV, String data) {
				SV.clean();
				processdialog.dismiss();
				if(state==StringVolleyPOST.STATE_OK){
					Log.e("MealClass",data);
					try {
						JSONArray MealClassArray=new JSONArray(data);
						setClassButton(MealClassArray);
					} catch (JSONException e) {
						e.printStackTrace();
					}
					
				}else if(state==StringVolleyPOST.STATE_ERROR){
					Log.e("InstantRank","網頁回傳資料失敗");
				}	
			}
		}
		,null).getSR());
	}
	
	private void setClassButton(JSONArray MealClassArray){
		try {
			classItemIDlist=new ArrayList<>();
			Button storeButton = null;
			for(int i=0;i<MealClassArray.length();i++){
				JSONObject MealClassdata;
				
				MealClassdata = MealClassArray.getJSONObject(i);
				String classItemID=MealClassdata.getString("ID");
				String name=MealClassdata.getString("Name");
				
				Button class_Btn=new Button(context);
				LayoutParams LP=new LayoutParams(wh.getW(40)
						       ,wh.getW(20));
				class_Btn.setLayoutParams(LP);
				if(i%2 == 0){
					LP.topMargin=wh.getH(3);
					if(i>0){
						LP.addRule(RelativeLayout.BELOW,storeButton.getId());
					}
					class_Btn.setId(getRandomId());
					storeButton=class_Btn;
				}else{
					LP.addRule(RelativeLayout.RIGHT_OF,storeButton.getId());
					LP.addRule(RelativeLayout.ALIGN_TOP,storeButton.getId());
					LP.addRule(RelativeLayout.ALIGN_BOTTOM,storeButton.getId());
					LP.leftMargin=wh.getW(3);
				}
				class_Btn.setText(name);
				class_Btn.setTextSize(TypedValue.COMPLEX_UNIT_PX,40);
				class_Btn.setBackgroundResource(R.drawable.orderbutton);
				class_Btn.setTag(i);
				class_Btn.setOnClickListener(this);
				ClassLayout.addView(class_Btn);
				
				classItemIDlist.add(classItemID);
			}
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	
	public void onDestroyController() {		
		if(classItemIDlist != null){
			classItemIDlist.clear();
			classItemIDlist=null;
		}
		
	}

	protected int getRandomId() {
		return (int) (Math.random() * 1000000);
	}

}
