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
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.storesimple.FunctionActivity;
import com.storesimple.MainActivity;
import com.storesimple.R;
import com.storesimple.fragment.DetailContentTitle_Fragment;
import com.storesimple.fragment.ReserverOrderContent_Fragment;
import com.storesimple.frame.MainController;
import com.storesimple.frame.WH;
import com.storesimple.layout.DetailContentTitle_Layout;
import com.storesimple.layout.Order_Layout;
import com.storesimple.module.CustomAnimation;
import com.storesimple.module.Myadapter;
import com.storesimple.module.StringVolleyPOST;
import com.storesimple.module.Tag;
import com.storesimple.view.OrderItem;

public class ReserveOrder_Controller extends MainController{
	private String storeID;
	private Order_Layout OrderLayout;
	private ListView orderList;
	private ArrayList<View> list;
	private ArrayList<String> orderIDlist;
	private Myadapter adapter;
	private ProgressDialog processdialog;
	private CustomAnimation animation;
	private WH wh;
	private AnimationSet startanimationset;
	private AnimationSet endanimationset;
	
	public ReserveOrder_Controller(Fragment frag) {
		super(frag);
	}
	
	protected void init() {
		wh=new WH(context);
		animation=new CustomAnimation(context);
		
		DetailContentTitle_Fragment DetailContentTitleFrag = (DetailContentTitle_Fragment) frag.getFragmentManager()
				                                           .findFragmentByTag(Tag.DETAILCONTENTTITLE_FRAGMENT);
		if (DetailContentTitleFrag != null) {
			DetailContentTitle_Layout DetailContentTitleLayout = (DetailContentTitle_Layout) DetailContentTitleFrag.getView();
			DetailContentTitleLayout.getFunctionTitle().setText(R.string.ReserveOrder);
		}
		
		storeID=Tag.STOREID;
		
		OrderLayout=(Order_Layout) frag.getView();
		orderList=OrderLayout.getOrderList();
		
		setListClick();
		
		list=new ArrayList<>();
		orderIDlist=new ArrayList<>();
	}
	
	private void setListClick(){
		orderList.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				ReserverOrderContent_Fragment ReserverOrderContentFrag=new ReserverOrderContent_Fragment();
				Bundle bundle=new Bundle();
				bundle.putString("orderID",orderIDlist.get(arg2));
				ReserverOrderContentFrag.setArguments(bundle);
				
				frag.getFragmentManager().beginTransaction()
				.replace(((FunctionActivity)frag.getActivity()).getFrameType().getContentLayout().getId(),ReserverOrderContentFrag,Tag.RESERVERORDERCONTENT_FRAGMENT)
				.commit();
			}
		});
	}
	
	private void SetReserveOrder(String storeID){
		processdialog=ProgressDialog.show(context,null,"Loading...",true,false);
		
		MainActivity.RQ.add(new StringVolleyPOST(Tag.GETRESERVEORDER_URL+"StoreID="+storeID
		    ,new StringVolleyPOST.OnStringResponse() {
			
			public void OnString(int state,StringVolleyPOST SV,String data) {
				SV.clean();
				processdialog.dismiss();
				if(state==StringVolleyPOST.STATE_OK){
					Log.e("ReserveOrder",data);
					try {
						JSONArray reserveOrderdataArray=new JSONArray(data);
						
						for(int i=0;i<reserveOrderdataArray.length();i++){
							JSONObject reservedata=reserveOrderdataArray.getJSONObject(i);
							String orderID=reservedata.getString("OrderID");
							String account=reservedata.getString("Account");
							String pickupTime=reservedata.getString("PickupTime");
							String pickupType=reservedata.getString("PickupType");
							
							OrderItem Item=new OrderItem(context);
							if((i%2)==0){
								Item.setBackgroundResource(R.drawable.ordertitle_bg);
							}
							Item.getItem1().setText(account);
							Item.getItem2().setText(pickupTime);
						
							switch(pickupType){
								case "0":{
									Item.getItem3().setText(R.string.Delivery);
									break;
								}
								
								case "1":{
									Item.getItem3().setText(R.string.Taketheshop);
									break;
								}
								
								case "2":{
									Item.getItem3().setText(R.string.Internaluse);
									break;
								}
								
								default:
									break;
							}
							list.add(Item);
							orderIDlist.add(orderID);
						}
						
						adapter=new Myadapter(list);
						orderList.setAdapter(adapter);
						
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
	
	public void onStartAnimationController() {
		animation.setAnimationTranslate(0,0,-wh.getH(100),0,400,0,false,0);
		
		startanimationset=new AnimationSet(true);
		startanimationset.setInterpolator(new LinearInterpolator());
		startanimationset.addAnimation(animation.getTranslate());
		
		OrderLayout.startAnimation(startanimationset);
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
				SetReserveOrder(storeID);
			}
		});
	}
	
	public void onEndAnimationController() {
		animation.setAnimationTranslate(0,wh.getW(100),0,0,400,0,false,0);
		
		endanimationset=new AnimationSet(false);
		endanimationset.setInterpolator(new LinearInterpolator());
		endanimationset.addAnimation(animation.getTranslate());
		
		OrderLayout.startAnimation(endanimationset);
		endanimationset.startNow();
	}
	
	public void onDestroyController() {
		if(list != null){
			list.clear();
			list=null;
		}
		
		if(orderIDlist != null){
			orderIDlist.clear();
			orderIDlist=null;
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
