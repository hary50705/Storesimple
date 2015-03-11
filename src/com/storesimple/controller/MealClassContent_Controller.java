package com.storesimple.controller;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

import com.storesimple.FunctionActivity;
import com.storesimple.MainActivity;
import com.storesimple.fragment.DayOrderContent_Fragment;
import com.storesimple.fragment.ReserverOrderContent_Fragment;
import com.storesimple.frame.MainController;
import com.storesimple.layout.MealClassContent_Layout;
import com.storesimple.module.Myadapter;
import com.storesimple.module.StringVolleyPOST;
import com.storesimple.module.Tag;
import com.storesimple.view.MealClassContentItem;

public class MealClassContent_Controller extends MainController{
	private MealClassContent_Layout MealClassContentLayout;
	private ListView ClassContentList;
	private String classItemID;
	private String source;
	private String mealname;
	private String orderID;
	private String replacemealname;
	private String mealItemID;
	private ProgressDialog processdialog;
	private ArrayList<View> list;
	private ArrayList<String> mealIDlist;
	private Myadapter adapter;
	
	public MealClassContent_Controller(Fragment frag) {
		super(frag);
	}

	protected void init() {
		MealClassContentLayout=(MealClassContent_Layout) frag.getView(); 
		ClassContentList=MealClassContentLayout.getMealList();
		
		Bundle bundle=frag.getArguments();
		if(bundle != null){
			classItemID=bundle.getString("classItemID");
		}
		
		orderID=Tag.ORDERID;
		source=Tag.SOURCE;
		mealItemID=Tag.MEALITEMID;
		mealname=Tag.MEALNAME;
		
		setItemClick();
		setClassContentlist(classItemID);
	}
	
	private void setItemClick(){
		ClassContentList.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> parent, View view,
					final int position, long id) {
				replacemealname=((MealClassContentItem)view).getMealname().getText().toString();
				
				AlertDialog.Builder builder=new Builder(context);
				builder.setTitle("更換餐點");
				builder.setMessage("是否將\""+mealname+"\"改成餐點\""+replacemealname+"\"?");
				builder.setNegativeButton("確認",new OnClickListener() {
					
					public void onClick(DialogInterface dialog, int which) {
						changMeal(mealItemID,mealIDlist.get(position));
						dialog.dismiss();
					}
				});
				
				builder.setPositiveButton("取消",new OnClickListener() {
					
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
					}
				});
				builder.create().show();
			}
		});
	}
	
	private void setClassContentlist(String classItemID){
		processdialog=ProgressDialog.show(context,null,"Loading...",true,false);
		
		MainActivity.RQ.add(new StringVolleyPOST(Tag.GETMEALCLASSCONTENT_URL+"CategoryID="+classItemID
		    ,new StringVolleyPOST.OnStringResponse() {
			
			public void OnString(int state, StringVolleyPOST SV, String data) {
				SV.clean();
				processdialog.dismiss();
				if(state==StringVolleyPOST.STATE_OK){
					Log.e("MealClassContent",data);
					try {
						JSONArray MealClassContentArray=new JSONArray(data);
						
						list=new ArrayList<>();
						mealIDlist=new ArrayList<>();
						for(int i=0;i<MealClassContentArray.length();i++){
							JSONObject MealClassContentdata=MealClassContentArray.getJSONObject(i);
							String mealID=MealClassContentdata.getString("ID");
							String name=MealClassContentdata.getString("Name");
							String value=MealClassContentdata.getString("Value");
							
							MealClassContentItem Item=new MealClassContentItem(context);
							Item.getMealname().setText(name);
							
							list.add(Item);
							mealIDlist.add(mealID);
						}
						
						adapter=new Myadapter(list);
						ClassContentList.setAdapter(adapter);
						
					} catch (JSONException e) {
						e.printStackTrace();
					}
					
				}else if(state==StringVolleyPOST.STATE_ERROR){
					Log.e("MealClassContent","網頁回傳資料失敗");
				}	
			}
		}
		,null).getSR());
	}
	
	private void changMeal(String mealItemID,String mealID){
		MainActivity.RQ.add(new StringVolleyPOST(Tag.CHANGEMEAL_URL+"ItemID="+mealItemID+"&NewItemID="+mealID
			    ,new StringVolleyPOST.OnStringResponse() {
				
				public void OnString(int state, StringVolleyPOST SV, String data) {
					SV.clean();
					if(state==StringVolleyPOST.STATE_OK){
						Log.e("MealClassContent",data);
						try {
							JSONArray changeStatusArray = new JSONArray(data);
							JSONObject changeStatusdata=changeStatusArray.getJSONObject(0);
							String status=changeStatusdata.getString("Status");
							if(status.equals("ok")){
								switch(source){
									case "DayOrder":{
										DayOrderContent_Fragment DayOrderContentFrag=new DayOrderContent_Fragment();
										Bundle bundle=new Bundle();
										bundle.putString("orderID",orderID);
										DayOrderContentFrag.setArguments(bundle);
							
										frag.getFragmentManager().beginTransaction()
										.replace(((FunctionActivity)frag.getActivity()).getFrameType().getContentLayout().getId(),DayOrderContentFrag,Tag.DAYORDERCONTENT_FRAGMENT)
										.commit();
										
										break;
									}
									
									case "ReserverOrder":{
										ReserverOrderContent_Fragment ReserverOrderContentFrag=new ReserverOrderContent_Fragment();
										Bundle bundle=new Bundle();
										bundle.putString("orderID",orderID);
										ReserverOrderContentFrag.setArguments(bundle);
										
										frag.getFragmentManager().beginTransaction()
										.replace(((FunctionActivity)frag.getActivity()).getFrameType().getContentLayout().getId(),ReserverOrderContentFrag,Tag.RESERVERORDERCONTENT_FRAGMENT)
										.commit();
										
										break;
									}
									
									default:
										break;
								}
					
							}else{
								Toast.makeText(context,"更換餐點失敗",Toast.LENGTH_SHORT).show();
							}
						} catch (JSONException e) {
							e.printStackTrace();
						}
						
					}else if(state==StringVolleyPOST.STATE_ERROR){
						Log.e("MealClassContent","網頁回傳資料失敗");
					}	
				}
			}
			,null).getSR());
	}
	
	public void onDestroyController() {
		if(list != null){
			list.clear();
			list=null;
		}
		
		if(mealIDlist != null){
			mealIDlist.clear();
			mealIDlist=null;
		}
		
		if(adapter != null){
			adapter=null;
		}
	}
}
