package com.storesimple.controller;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.Animation.AnimationListener;
import android.widget.ListView;
import android.widget.TextView;

import com.storesimple.MainActivity;
import com.storesimple.R;
import com.storesimple.fragment.DetailContentTitle_Fragment;
import com.storesimple.frame.MainController;
import com.storesimple.frame.WH;
import com.storesimple.layout.DetailContentTitle_Layout;
import com.storesimple.layout.FinishOrderContent_Layout;
import com.storesimple.module.CustomAnimation;
import com.storesimple.module.Myadapter;
import com.storesimple.module.StringVolleyPOST;
import com.storesimple.module.Tag;
import com.storesimple.view.MealItem;

public class FinishOrderContent_Controller extends MainController{
	private DetailContentTitle_Layout DetailContentTitleLayout;
	private String orderID;
	private FinishOrderContent_Layout FinishOrderContentLayout;
	private ListView mealList;
	private TextView account;
	private TextView takemealTime;
	private TextView finishOrderTime;
	private TextView payType;
	private ProgressDialog processdialog;
	private ArrayList<TextView> writeofflist;
	private ArrayList<View> list;
	private ArrayList<String> mealItemIDlist;
	private Myadapter adapter;
	private CustomAnimation animation;
	private WH wh;
	private AnimationSet startanimationset;
	private AnimationSet endanimationset;
	
	public FinishOrderContent_Controller(Fragment frag) {
		super(frag);
	}

	protected void init() {
		wh=new WH(context);
		animation=new CustomAnimation(context);
		
		DetailContentTitle_Fragment DetailContentTitleFrag=(DetailContentTitle_Fragment) frag.getFragmentManager()
				                   .findFragmentByTag(Tag.DETAILCONTENTTITLE_FRAGMENT);
		if(DetailContentTitleFrag!=null){
			DetailContentTitleLayout=(DetailContentTitle_Layout) DetailContentTitleFrag.getView();
			DetailContentTitleLayout.getFunctionTitle().setText(R.string.FinishOrder);
			DetailContentTitleLayout.getBackBtn().setVisibility(View.VISIBLE);
		}
		
		Bundle bundle=frag.getArguments();
		if(bundle != null){
			orderID=bundle.getString("orderID");
		}
		
		FinishOrderContentLayout=(FinishOrderContent_Layout) frag.getView();
		mealList=FinishOrderContentLayout.getMealList();
		account=FinishOrderContentLayout.getAccount();
		takemealTime=FinishOrderContentLayout.getTakemealTime();
		finishOrderTime=FinishOrderContentLayout.getFinishOrderTime();
		payType=FinishOrderContentLayout.getPaytype();
		writeofflist=FinishOrderContentLayout.getWriteofflist();
	}
	
	private void setFinishOrderContent(String orderID ){
		processdialog=ProgressDialog.show(context,null,"Loading...",true,false);
		
		MainActivity.RQ.add(new StringVolleyPOST(Tag.GETORDERCONTENT_URL+"OrderID="+orderID
		    ,new StringVolleyPOST.OnStringResponse() {
			
			public void OnString(int state, StringVolleyPOST SV, String data) {
				SV.clean();
				processdialog.dismiss();
				if(state==StringVolleyPOST.STATE_OK){
					Log.e("FinishOrderContent",data);
					try {
						JSONObject OrderContentdata=new JSONObject(data);
						String orderaccount=OrderContentdata.getString("Account");
						String pickupTime=OrderContentdata.getString("PickupTime");
						String finishTime=OrderContentdata.getString("FinishTime");
						String payMent=OrderContentdata.getString("Payment");
						String orderpayStatus=OrderContentdata.getString("PayStatus");
						String verificationTime=OrderContentdata.getString("VerificationTime");
						String verificationType=OrderContentdata.getString("VerificationType");
						String verificationStatus=OrderContentdata.getString("VerificationStatus");
						JSONArray mealItemArray=OrderContentdata.getJSONArray("Items");
						
						account.setText("帳號:"+orderaccount);
						takemealTime.setText("預計取餐時間:\n"+pickupTime);
						finishOrderTime.setText("完成訂單時間:\n"+finishTime);
						
						payType.setText(payMent);
						writeofflist.get(0).setText(verificationTime);
						writeofflist.get(1).setText(verificationType);
						writeofflist.get(2).setText(verificationStatus);
						
						list=new ArrayList<>();
						mealItemIDlist=new ArrayList<>();
						for(int i=0;i<mealItemArray.length();i++){
							JSONObject mealItem=mealItemArray.getJSONObject(i);
							MealItem Item=new MealItem(context);
							Item.getMealname().setText(mealItem.getString("ProductName"));
							Item.getQuantity().setText(mealItem.getString("Quantity"));
							Item.getRemark().setText(mealItem.getString("Type1"));
							Item.getPrice().setText(mealItem.getString("Value"));
							
							list.add(Item);
							mealItemIDlist.add(mealItem.getString("ID"));
						}
						
						adapter=new Myadapter(list);
						mealList.setAdapter(adapter);
						
					} catch (JSONException e) {
						e.printStackTrace();
					}
					
				}else if(state==StringVolleyPOST.STATE_ERROR){
					Log.e("FinishOrderContent","網頁回傳資料失敗");
				}	
			}
		}
		,null).getSR());
	}
	
	public void onStartAnimationController() {
		animation.setAnimationTranslate(0,0,-wh.getH(100),0,400,0,false,0);
		
		startanimationset=new AnimationSet(true);
		startanimationset.setInterpolator(new LinearInterpolator());
		startanimationset.addAnimation(animation.getTranslate());
		
		FinishOrderContentLayout.setAnimation(startanimationset);
		startanimationset.startNow();
		
		startanimationset.setAnimationListener(new AnimationListener() {
			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void onAnimationEnd(Animation animation) {
				// TODO Auto-generated method stub
				setFinishOrderContent(orderID);
			}
		});
	}
	
	public void onEndAnimationController() {
		animation.setAnimationTranslate(0,wh.getW(100),0,0,400,0,false,0);
		
		endanimationset=new AnimationSet(false);
		endanimationset.setInterpolator(new LinearInterpolator());
		endanimationset.addAnimation(animation.getTranslate());
		
		FinishOrderContentLayout.setAnimation(endanimationset);
		endanimationset.startNow();
	}
	
	public void onDestroyController() {
		DetailContentTitleLayout.getBackBtn().setVisibility(View.GONE);
		
		if(list != null){
			list.clear();
			list=null;
		}
		
		if(mealItemIDlist != null){
			mealItemIDlist.clear();
			mealItemIDlist=null;
		}
		
		if(adapter != null){
			adapter=null;
		}
		
		if(animation !=null){
			animation=null;
		}
		
		if(startanimationset != null){
			startanimationset=null;
		}
		
		if(endanimationset != null){
			endanimationset=null;
		}
	}
}
