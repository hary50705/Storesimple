package com.storesimple.controller;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.storesimple.FunctionActivity;
import com.storesimple.MainActivity;
import com.storesimple.R;
import com.storesimple.fragment.DayOrderContent_Fragment;
import com.storesimple.fragment.DetailContentTitle_Fragment;
import com.storesimple.frame.MainController;
import com.storesimple.frame.WH;
import com.storesimple.layout.DayOrder_Layout;
import com.storesimple.layout.DetailContentTitle_Layout;
import com.storesimple.module.CustomAnimation;
import com.storesimple.module.Myadapter;
import com.storesimple.module.StringVolleyPOST;
import com.storesimple.module.Tag;
import com.storesimple.view.OrderItem;

public class Dayorder_Controller extends MainController{
	private DetailContentTitle_Layout DetailContentTitleLayout;
	private TextView DetailContentTitle;
	private String storeID;
	private DayOrder_Layout DayOrderLayout;
	private Button NewOrderBtn;
	private Button MakePeriodOrderBtn;
	private Button FinishOrderBtn;
	private ListView orderList;
	private ArrayList<View> list;
	private ArrayList<String> orderIDlist;
	private Myadapter adapter;
	private ProgressDialog processdialog;
	private CustomAnimation animation;
	private WH wh;
	private AnimationSet startanimationset;
	private AnimationSet endanimationset;
	
	public Dayorder_Controller(Fragment frag) {
		super(frag);
	}

	protected void init() {
		wh=new WH(context);
		animation=new CustomAnimation(context);
		
		DetailContentTitle_Fragment DetailContentTitleFrag=(DetailContentTitle_Fragment) frag.getFragmentManager()
								     .findFragmentByTag(Tag.DETAILCONTENTTITLE_FRAGMENT);
		if(DetailContentTitleFrag!=null){
			DetailContentTitleLayout=(DetailContentTitle_Layout) DetailContentTitleFrag.getView();
			DetailContentTitle=DetailContentTitleLayout.getFunctionTitle();
			DetailContentTitle.setText(R.string.NewTitle);
			DetailContentTitleLayout.getDayOrderSearchBtn().setVisibility(View.VISIBLE);
		}
		
		storeID=Tag.STOREID;
		
		DayOrderLayout=(DayOrder_Layout) frag.getView(); 
		
		NewOrderBtn=DayOrderLayout.getNewOrderBtn();
		MakePeriodOrderBtn=DayOrderLayout.getMakePeriodOrderBtn();
		FinishOrderBtn=DayOrderLayout.getFinishOrderBtn();
		orderList=DayOrderLayout.getOrderList();
		
		setButton();
		setListClick();
		
		list=new ArrayList<>();
		orderIDlist=new ArrayList<>();
	}
	
	private void setButton(){
		NewOrderBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				DetailContentTitle.setText(R.string.NewTitle);
				setDayOrder("0", storeID);
			}
		});
		
		MakePeriodOrderBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				DetailContentTitle.setText(R.string.MakePeriodTitle);
				setDayOrder("1", storeID);
			}
		});
		
		FinishOrderBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				DetailContentTitle.setText(R.string.FinishTitle);
				setDayOrder("2", storeID);
			}
		});
	}
	
	private void setListClick(){
		orderList.setOnItemClickListener(new OnItemClickListener() {
			
			public void onItemClick(AdapterView<?> arg0, View arg1, final int arg2,
					long arg3) {
				DayOrderContent_Fragment DayOrderContentFrag = new DayOrderContent_Fragment();
				Bundle bundle = new Bundle();
				bundle.putString("orderID", orderIDlist.get(arg2));
				DayOrderContentFrag.setArguments(bundle);

				FragmentTransaction transaction = frag.getFragmentManager()
						                          .beginTransaction();
				// transaction.setCustomAnimations(R.animator.fragmentin,R.animator.fragmentout);
				transaction.replace(((FunctionActivity) frag.getActivity()).getFrameType().getContentLayout().getId(),DayOrderContentFrag, Tag.DAYORDERCONTENT_FRAGMENT)
						   .commit();
			}
		});
	}
	
	private void setDayOrder(String status,String storeID ){
		processdialog=ProgressDialog.show(context,null,"Loading...",true,false);
		
		MainActivity.RQ.add(new StringVolleyPOST(Tag.GETDAYORDER_URL+"Status="+status+"&StoreID="+storeID+"&PickupTime=2015/03/21"
		    ,new StringVolleyPOST.OnStringResponse() {
			
			public void OnString(int state, StringVolleyPOST SV, String data) {
				SV.clean();
				processdialog.dismiss();
				
				if(state == StringVolleyPOST.STATE_OK){
					Log.e("Dayorder",data);
					try {
						JSONArray dayOrderdataArray=new JSONArray(data);
						list.clear();
						orderIDlist.clear();
						for(int i=0;i<dayOrderdataArray.length();i++){
							JSONObject dayOrderdata=dayOrderdataArray.getJSONObject(i);
							String orderID=dayOrderdata.getString("OrderID");
							String account=dayOrderdata.getString("Account");
							String pickupTime=dayOrderdata.getString("PickupTime");
							String pickupType=dayOrderdata.getString("PickupType");
							
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
		
		DayOrderLayout.setAnimation(startanimationset);
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
				setDayOrder("0",storeID);
			}
		});
	}
	
	public void onEndAnimationController() {
		animation.setAnimationTranslate(0,wh.getW(100),0,0,400,0,false,0);
		
		endanimationset=new AnimationSet(false);
		endanimationset.setInterpolator(new LinearInterpolator());
		endanimationset.addAnimation(animation.getTranslate());
		
		DayOrderLayout.setAnimation(endanimationset);
		endanimationset.startNow();
	}
	
	public void onDestroyController() {
		DetailContentTitleLayout.getFunctionTitleView().setVisibility(View.VISIBLE);
		DetailContentTitleLayout.getDayOrderSearchView().setVisibility(View.GONE);
		DetailContentTitleLayout.getDayOrderSearchBtn().setVisibility(View.GONE);
		
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
