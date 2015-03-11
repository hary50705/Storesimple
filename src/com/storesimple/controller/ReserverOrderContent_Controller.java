package com.storesimple.controller;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

import com.storesimple.MainActivity;
import com.storesimple.R;
import com.storesimple.fragment.DetailContentTitle_Fragment;
import com.storesimple.frame.MainController;
import com.storesimple.frame.WH;
import com.storesimple.layout.DetailContentTitle_Layout;
import com.storesimple.layout.MealClickMenu_Layout;
import com.storesimple.layout.OrderContent_Layout;
import com.storesimple.module.CustomAnimation;
import com.storesimple.module.Myadapter;
import com.storesimple.module.StringVolleyPOST;
import com.storesimple.module.Tag;
import com.storesimple.view.MealItem;

public class ReserverOrderContent_Controller extends MainController{
	private DetailContentTitle_Layout DetailContentTitleLayout;
	private String orderID;
	private OrderContent_Layout OrderContentLayout;
	private ListView mealList;
	private ArrayList<TextView> moneylist;
	private ArrayList<View> list;
	private ArrayList<String> mealItemIDlist;
	private TextView account;
	private TextView takemealType;
	private TextView finishMealTime;
	private TextView payType;
	private TextView payStatus;
	private TextView address;
	private ProgressDialog processdialog;
	private Myadapter adapter;
	private CustomAnimation animation;
	private WH wh;
	private AnimationSet startanimationset;
	private AnimationSet endanimationset;
	
	public ReserverOrderContent_Controller(Fragment frag) {
		super(frag);
	}

	protected void init() {
		wh=new WH(context);
		animation=new CustomAnimation(context);
		
		DetailContentTitle_Fragment DetailContentTitleFrag=(DetailContentTitle_Fragment) frag.getFragmentManager()
                                                          .findFragmentByTag(Tag.DETAILCONTENTTITLE_FRAGMENT);
		if(DetailContentTitleFrag!=null){
			DetailContentTitleLayout=(DetailContentTitle_Layout) DetailContentTitleFrag.getView();
			DetailContentTitleLayout.getFunctionTitle().setText(R.string.ReserveOrder);
			DetailContentTitleLayout.getBackBtn().setVisibility(View.VISIBLE);
		}
		
		/*接收更換餐點後需更換的資訊*/
		Bundle bundle=frag.getArguments();
		if(bundle != null){
			orderID=bundle.getString("orderID");
			Tag.ORDERID=orderID;
		}
		
		OrderContentLayout=(OrderContent_Layout) frag.getView();
		mealList=OrderContentLayout.getMealList();
		moneylist=OrderContentLayout.getMoneylist();
		account=OrderContentLayout.getAccount();
		finishMealTime=OrderContentLayout.getfinishOrderTime();
		takemealType=OrderContentLayout.getTakemealType();
		payType=OrderContentLayout.getPaytype();
		payStatus=OrderContentLayout.getPaystatus();
		address=OrderContentLayout.getAddress();
		
		setListClick();
	}
	
	private void setListClick(){
		/*隱藏餐點更換、刪除餐點、餐點不足等功能*/
		/*mealList.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				//自訂Dialog Layout
				AlertDialog.Builder builder=new Builder(context);
				MealClickMenu_Layout MealClickMenuLayout =new MealClickMenu_Layout(context);
				builder.setView(MealClickMenuLayout);
				Dialog dialog=builder.create();
				dialog.show();
				
				//Dialog樣式設定
				Window window=dialog.getWindow();
				WindowManager.LayoutParams LP=window.getAttributes();
				LP.width=LayoutParams.MATCH_PARENT;
				LP.height=LayoutParams.WRAP_CONTENT;
				//LP.dimAmount=1.0f;//設定Dialog背景透明度
				window.setAttributes(LP);
				
				MealClickMenu_Controller MealClickMenuContro=new MealClickMenu_Controller(context,frag,dialog,MealClickMenuLayout,(MealItem)view,mealItemIDlist.get(position),"ReserverOrder");
			}
		});
		
		mealList.setOnItemLongClickListener(new OnItemLongClickListener() {

			public boolean onItemLongClick(AdapterView<?> parent, View view,
					int position, long id) {
				AlertDialog.Builder builder=new Builder(context);
				builder.setTitle("刪除餐點");
				builder.setMessage("確認要刪除此餐點?");
				builder.setNegativeButton("確認",new OnClickListener() {
					
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
					}
				});
				
				builder.setPositiveButton("取消",new OnClickListener() {
					
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
					}
				});
				builder.create().show();
				return true;
			}
		});*/
	}
	
	private void setReserverOrderContent(String  orderID){
		processdialog=ProgressDialog.show(context,null,"Loading...",true,false);
		
		MainActivity.RQ.add(new StringVolleyPOST(Tag.GETORDERCONTENT_URL+"OrderID="+orderID
		    ,new StringVolleyPOST.OnStringResponse() {
			
			public void OnString(int state, StringVolleyPOST SV, String data) {
				SV.clean();
				processdialog.dismiss();
				if(state==StringVolleyPOST.STATE_OK){
					Log.e("ReserverOrderContent",data);
					try {
						JSONObject OrderContentdata=new JSONObject(data);
						String orderaccount=OrderContentdata.getString("Account");
						String pickupType=OrderContentdata.getString("PickupType");
						String finishTime=OrderContentdata.getString("FinishTime");
						String paySum=OrderContentdata.getString("PaySum");
						String sendAddress=OrderContentdata.getString("ShipAddress");
						String payMent=OrderContentdata.getString("Payment");
						String orderpayStatus=OrderContentdata.getString("PayStatus");
						JSONArray mealItemArray=OrderContentdata.getJSONArray("Items");
						
						account.setText("帳號:"+orderaccount);
						finishMealTime.setText("完成訂單時間:\n"+finishTime);
						address.setText(sendAddress);
						payType.setText(payMent);
						payStatus.setText(orderpayStatus);
						
						switch(pickupType){
							case "0":{
								takemealType.setText("取餐方式:外送");
								break;
							}
							
							case "1":{
								takemealType.setText("取餐方式:店內取");
								break;
							}
							
							case "2":{
								takemealType.setText("取餐方式:內用");
								break;
							}
							
							default:
								break;
						}
						
						for(int i=0;i<4;i++){
							moneylist.get(i).setText(paySum);
						}
						
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
					Log.e("ReserverOrderContent","網頁回傳資料失敗");
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
		
		OrderContentLayout.startAnimation(startanimationset);
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
				setReserverOrderContent(orderID);
			}
		});
	}
	
	public void onEndAnimationController() {
		animation.setAnimationTranslate(0,wh.getW(100),0,0,400,0,false,0);
		
		endanimationset=new AnimationSet(false);
		endanimationset.setInterpolator(new LinearInterpolator());
		endanimationset.addAnimation(animation.getTranslate());
		
		OrderContentLayout.startAnimation(endanimationset);
		endanimationset.startNow();
	}
	
	public void onDestroyController() {
		DetailContentTitleLayout.getBackBtn().setVisibility(View.GONE);
		
		if(moneylist != null){
			moneylist.clear();
			moneylist=null;
		}
		
		if(list != null){
			list.clear();
			list=null;
		}
		
		if(mealItemIDlist != null){
			mealItemIDlist.clear();
			mealItemIDlist=null;
		}
		
		if(adapter != null){
			adapter=null ;
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