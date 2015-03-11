package com.storesimple.controller;

import java.util.ArrayList;

import android.app.AlertDialog;
import android.app.Fragment;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Color;
import android.support.v4.widget.DrawerLayout.DrawerListener;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.storesimple.FunctionActivity;
import com.storesimple.MainActivity;
import com.storesimple.QRcodeScanActivity;
import com.storesimple.R;
import com.storesimple.fragment.Dayorder_Fragment;
import com.storesimple.fragment.FinishOrder_Fragment;
import com.storesimple.fragment.ReserveOrder_Fragment;
import com.storesimple.fragment.StoreGPSLocation_Fragment;
import com.storesimple.frame.MainController;
import com.storesimple.layout.FrameType;
import com.storesimple.layout.Menu_Layout;
import com.storesimple.module.Myadapter;
import com.storesimple.module.Tag;
import com.storesimple.view.MenuFunctionItem;
import com.storesimple.view.MenuLoginoutItem;

public class Menu_Controller extends MainController{
	private FrameType FrameType;
	private Menu_Layout MenuLayout;
	private ListView MenuList;
	private ArrayList<View> list;
	private String MenuFunctionTitle[];
	private Myadapter adapter;
	private int menuItemIndex;//紀錄上一次按下按鈕索引值
	private boolean listClick;//判斷是否有選擇功能(觸發ListClick)
	
	public Menu_Controller(Fragment frag) {
		super(frag);
	}

	protected void init() {
		FrameType=((FunctionActivity)frag.getActivity()).getFrameType();
		MenuLayout=(Menu_Layout) frag.getView();
		MenuList=MenuLayout.getMenuList(); 
		menuItemIndex=1;
		setList();
		setListClick();
	}
	
	private void setList(){
		list=new ArrayList<>();
		MenuFunctionTitle=context.getResources().getStringArray(R.array.MenuFunctionTitle);
		for(int i=0;i<7;i++){
			if(i==6){
				MenuLoginoutItem LoginoutItem =new MenuLoginoutItem(context);
				LoginoutItem.getLoginoutImage().setBackgroundResource(R.drawable.singnout);
				LoginoutItem.getLoginoutTitle().setText(MenuFunctionTitle[i]);
				list.add(LoginoutItem);
			}else{
				MenuFunctionItem FunctionItem=new MenuFunctionItem(context);
				FunctionItem.getFunctionTitle().setText(MenuFunctionTitle[i]);
				list.add(FunctionItem);
			}	
		}
		adapter=new Myadapter(list);
		MenuList.setAdapter(adapter);
		
		((MenuFunctionItem) list.get(1)).setBackgroundResource(R.drawable.left_bgon);
		((MenuFunctionItem) list.get(1)).getFunctionTitle().setTextColor(Color.BLACK);
	}
	
	private void setListClick(){
		MenuList.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
			
				if(position != menuItemIndex){
					
					if (menuItemIndex == 6) {
						((MenuLoginoutItem) list.get(menuItemIndex)).setBackgroundResource(R.drawable.left_bgoff);
						((MenuLoginoutItem) list.get(menuItemIndex)).getLoginoutTitle().setTextColor(Color.WHITE);
					} else {
						((MenuFunctionItem) list.get(menuItemIndex)).setBackgroundResource(R.drawable.left_bgoff);
						((MenuFunctionItem) list.get(menuItemIndex)).getFunctionTitle().setTextColor(Color.WHITE);
					}
					
					if(position == 6){
						((MenuLoginoutItem)view).setBackgroundResource(R.drawable.left_bgon);
						((MenuLoginoutItem)view).getLoginoutTitle().setTextColor(Color.BLACK);
					}else{
						((MenuFunctionItem)view).setBackgroundResource(R.drawable.left_bgon);
						((MenuFunctionItem)view).getFunctionTitle().setTextColor(Color.BLACK);
					}
				}
				menuItemIndex=position;
				listClick=true;
				FrameType.closeDrawer(Gravity.LEFT);
			}
		});
		
		FrameType.setDrawerListener(new DrawerListener() {
			
			@Override
			public void onDrawerStateChanged(int arg0) {
				
			}
			
			@Override
			public void onDrawerSlide(View arg0, float arg1) {
				
			}
			
			@Override
			public void onDrawerOpened(View arg0) {
				
			}
			
			@Override
			public void onDrawerClosed(View arg0) {
				if(listClick){
					switch(menuItemIndex){
						case 0:{//關閉店家功能
							Intent intent=new Intent();
							intent.setClass(context,MainActivity.class);
							context.startActivity(intent);
							((FunctionActivity)context).finish();
											
							break;
						}
						
						case 1:{//當日訂單
							Dayorder_Fragment DayorderFrag=(Dayorder_Fragment) frag.getFragmentManager()
									                     .findFragmentByTag(Tag.DAYORDER_FRAGMENT);
							if(DayorderFrag==null){
								frag.getFragmentManager().beginTransaction()
								.replace(((FunctionActivity)frag.getActivity()).getFrameType().getContentLayout().getId(),new Dayorder_Fragment(),Tag.DAYORDER_FRAGMENT)
								.commit();
							}
							
							break;
						}
						
						case 2:{//預訂訂單
							ReserveOrder_Fragment ReserveOrderFrag = (ReserveOrder_Fragment) frag.getFragmentManager()
									                              .findFragmentByTag(Tag.RESERVEORDER_FRAGMENT);
							if (ReserveOrderFrag == null) {
								frag.getFragmentManager().beginTransaction()
									.replace(((FunctionActivity) frag.getActivity()).getFrameType().getContentLayout().getId(),new ReserveOrder_Fragment(),Tag.RESERVEORDER_FRAGMENT)
									.commit();
							}
							
							break;
						}
						
						case 3:{//已完成訂單
							FinishOrder_Fragment FinishOrderFrag = (FinishOrder_Fragment) frag.getFragmentManager()
									                            .findFragmentByTag(Tag.FINISHORDER_FRAGMENT);
							if (FinishOrderFrag == null) {
								frag.getFragmentManager().beginTransaction()
									.replace(((FunctionActivity) frag.getActivity()).getFrameType().getContentLayout().getId(),new FinishOrder_Fragment(),Tag.FINISHORDER_FRAGMENT)
									.commit();
							}
							
							break;
						}
						
						case 4:{//QRcode掃描
							Intent intent=new Intent();
							intent.setClass(context,QRcodeScanActivity.class);
							context.startActivity(intent);
							//((FunctionActivity)context).finish();//在其它功能頁面會出錯
							break;
						}
						
						case 5:{//店家定位
							StoreGPSLocation_Fragment StoreGPSLocationFrag = (StoreGPSLocation_Fragment) frag.getFragmentManager()
									                                 .findFragmentByTag(Tag.STOREGPSLOCATION_FRAGMENT);
							if (StoreGPSLocationFrag == null) {
								frag.getFragmentManager().beginTransaction()
									.replace(((FunctionActivity) frag.getActivity()).getFrameType().getContentLayout().getId(),new StoreGPSLocation_Fragment(),Tag.STOREGPSLOCATION_FRAGMENT)
									.commit();
							}
							
							break;
						}
						
						case 6:{//登出
							AlertDialog.Builder builder=new Builder(context);
							builder.setTitle("登出");
							builder.setMessage("確認要登出?");
							builder.setNegativeButton("確認",new OnClickListener() {
								
								public void onClick(DialogInterface dialog, int which) {
									Intent intent=new Intent();
									intent.setClass(context,MainActivity.class);
									context.startActivity(intent);
									((FunctionActivity)context).finish();
									dialog.dismiss();
								}
							});
							
							builder.setPositiveButton("取消",new OnClickListener() {
								
								public void onClick(DialogInterface dialog, int which) {
									dialog.dismiss();
								}
							});
							
							builder.create().show();
							break;
						}
						
						default:
							break;
					}
				}
				listClick=false;
			}
		});
	}
	
	public void onDestroyController() {
		if(list != null){
			list.clear();
			list=null;
		}
		
		if(MenuFunctionTitle != null){
			MenuFunctionTitle=null;
		}
		
		if(adapter != null){
			adapter=null;
		}
	}
	

}
