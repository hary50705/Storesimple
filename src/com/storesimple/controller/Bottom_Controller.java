package com.storesimple.controller;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.storesimple.FunctionActivity;
import com.storesimple.MainActivity;
import com.storesimple.fragment.DayOrderContent_Fragment;
import com.storesimple.frame.MainController;
import com.storesimple.layout.Bottom_Layout;
import com.storesimple.layout.FrameType;
import com.storesimple.module.StringVolleyPOST;
import com.storesimple.module.Tag;

public class Bottom_Controller extends MainController{
	private Bottom_Layout BottomLayout;
	private Button MenuBtn;
	private Button onstageBtn;
	private Button processBtn;
	private ProgressDialog processdialog;
	
	public Bottom_Controller(Fragment frag) {
		super(frag);
	}

	protected void init() {
		BottomLayout=(Bottom_Layout) frag.getView();
		MenuBtn=BottomLayout.getMenuBtn();
		onstageBtn=BottomLayout.getonstageBtn();
		processBtn=BottomLayout.getProcessBtn();
		
		setButton();
	}
	
	private void setButton(){
		MenuBtn.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				FrameType FrameType=((FunctionActivity)frag.getActivity()).getFrameType();
				FrameType.openDrawer(Gravity.LEFT);
			}
		});
		
		onstageBtn.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				setOrderStatus(Tag.PROCESSSTATUS-1);
			}
		});
		
		processBtn.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				setOrderStatus(Tag.PROCESSSTATUS+1);
			}
		});
	}
	
	private void setOrderStatus(final int orderstatus){
		String storeID=Tag.STOREID;
		String orderID=Tag.ORDERID;
		
		processdialog=ProgressDialog.show(context,null,"Loading...",true,false);
		
		MainActivity.RQ.add(new StringVolleyPOST(Tag.SETORDERSTATUS_URL+"Status="+orderstatus+"&StoreID="+storeID+"&OrderID="+orderID
			    ,new StringVolleyPOST.OnStringResponse() {
				
				public void OnString(int state, StringVolleyPOST SV, String data) {
					SV.clean();
					processdialog.dismiss();
					
					if(state==StringVolleyPOST.STATE_OK){
						Log.e("Bottom",data);
						
						try {
							JSONArray OrderStatusdataArray=new JSONArray(data);
							JSONObject OrderStatusdata=OrderStatusdataArray.getJSONObject(0);
							String status=OrderStatusdata.getString("Status");
							
							if(status.equals("ok")){
								Toast.makeText(context,"更改訂單狀態成功",Toast.LENGTH_SHORT).show();
								
								DayOrderContent_Fragment DayOrderContentFrag=(DayOrderContent_Fragment) frag.getFragmentManager()
																			.findFragmentByTag(Tag.DAYORDERCONTENT_FRAGMENT);
								
								if(DayOrderContentFrag != null){
									DayOrderContent_Controller DayorderContentCon= (DayOrderContent_Controller) DayOrderContentFrag.getController();
									DayorderContentCon.setProcessStatus(orderstatus);
								}
									
							}else{
								Toast.makeText(context,"更改訂單狀態失敗",Toast.LENGTH_SHORT).show();
							}
							
						} catch (JSONException e) {
							e.printStackTrace();
						}
						
					}else if(state==StringVolleyPOST.STATE_ERROR){
						Log.e("Bottom","網頁回傳資料失敗");
					}
				}
			}
			,null).getSR());	
	}
	
}
