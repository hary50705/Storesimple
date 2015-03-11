package com.storesimple;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;

import com.storesimple.fragment.Bottom_Fragment;
import com.storesimple.fragment.DayOrderContent_Fragment;
import com.storesimple.fragment.Dayorder_Fragment;
import com.storesimple.fragment.DetailContentTitle_Fragment;
import com.storesimple.fragment.FinishOrder_Fragment;
import com.storesimple.fragment.MealClass_Fragment;
import com.storesimple.fragment.Menu_Fragment;
import com.storesimple.fragment.ReserveOrder_Fragment;
import com.storesimple.fragment.ReserverOrderContent_Fragment;
import com.storesimple.layout.FrameType;
import com.storesimple.module.Tag;

public class FunctionActivity extends Activity{
	private FrameType Frametype;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Frametype=new FrameType(this);
		setContentView(Frametype);
		
		Bundle bundle=getIntent().getExtras();
		if(bundle != null){
			Tag.CATEGORYID=bundle.getString("CategoryID");
			Tag.STOREID=bundle.getString("StoreID");
		}
		
		getFragmentManager().beginTransaction()
		.add(Frametype.getDrawerMenuLayout().getId(),new Menu_Fragment(),Tag.MENU_FRAGMENT)
		.commit();
		
		getFragmentManager().beginTransaction()
		.add(Frametype.getTitleLayout().getId(),new DetailContentTitle_Fragment(),Tag.DETAILCONTENTTITLE_FRAGMENT)
		.commit();
		
		getFragmentManager().beginTransaction()
		.add(Frametype.getContentLayout().getId(),new Dayorder_Fragment(),Tag.DAYORDER_FRAGMENT)
		.commit();
		
		getFragmentManager().beginTransaction()
		.add(Frametype.getBottomLayout().getId(),new Bottom_Fragment(),Tag.BOTTOM_FRAGMENT)
		.commit();
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		FragmentManager Manager=getFragmentManager();
		if(keyCode == KeyEvent.KEYCODE_BACK){
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
			
			}else{
				AlertDialog.Builder builder=new Builder(this);
				builder.setTitle("登出");
				builder.setMessage("確認要登出?");
				builder.setNegativeButton("確認",new OnClickListener() {
					
					public void onClick(DialogInterface dialog, int which) {
						Intent intent=new Intent();
						intent.setClass(FunctionActivity.this,MainActivity.class);
						FunctionActivity.this.startActivity(intent);
						FunctionActivity.this.finish();
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
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}
	
	public FrameType getFrameType(){
		return Frametype;
	}
	
	private void setFragmentReplace(Fragment fragment,String tag){
		getFragmentManager().beginTransaction()
		.replace(getFrameType().getContentLayout().getId(),fragment,tag)
		.commit();
	}
	
}
