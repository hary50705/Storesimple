package com.storesimple.controller;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.storesimple.fragment.DetailContentTitle_Fragment;
import com.storesimple.frame.MainController;
import com.storesimple.layout.DetailContentTitle_Layout;
import com.storesimple.layout.StoreGPSLocation_Layout;
import com.storesimple.module.Tag;

public class StoreGPSLocation_Controller extends MainController implements LocationListener{
	private EditText longitudeInput;
	private EditText latitudeInput;
	private LocationManager locationManager;
	
	public StoreGPSLocation_Controller(Fragment frag) {
		super(frag);
	}

	@Override
	protected void init() {
		DetailContentTitle_Fragment DetailContentTitleFrag = (DetailContentTitle_Fragment) frag.getFragmentManager()
				                    .findFragmentByTag(Tag.DETAILCONTENTTITLE_FRAGMENT);
		if (DetailContentTitleFrag != null) {
			DetailContentTitle_Layout DetailContentTitleLayout = (DetailContentTitle_Layout) DetailContentTitleFrag.getView();
			DetailContentTitleLayout.getFunctionTitle().setText("店家定位");
		}
		
		StoreGPSLocation_Layout StoreGPSLocationLayout=(StoreGPSLocation_Layout) frag.getView();
		longitudeInput=StoreGPSLocationLayout.getLongitudeInput();
		latitudeInput=StoreGPSLocationLayout.getLatitudeInput();
		
		setGPSsetting();
	}
	
	private void setGPSsetting(){
		locationManager=(LocationManager) (context.getSystemService(Context.LOCATION_SERVICE));
		locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
	            1000,1,this);
		
		if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) && locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
			Location location=locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
			setLocation(location);
		}else{
			Toast.makeText(context, "請開啟定位服務", Toast.LENGTH_SHORT).show();
			context.startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));//開啟設定頁面
		}
	}
	
	private void setLocation(Location location){
		if(location != null){
			double longitude=location.getLongitude();
			double latitude=location.getLatitude();
			
			longitudeInput.setText(String.valueOf(longitude));
			latitudeInput.setText(String.valueOf(latitude));
			//Log.e("StoreGPSLocation","經度:"+longitude+",緯度:"+latitude);
		}else{
			Log.e("StoreGPSLocation","尚未取得位址");
		}
	}

	@Override
	public void onLocationChanged(Location location) {//當地點改變時
		setLocation(location);
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {//定位狀態改變
		// TODO Auto-generated method stub
	}

	@Override
	public void onProviderEnabled(String provider) {//當GPS或網路定位功能開啟
		Log.e("StoreGPSLocation","GPS啟動");
		setGPSsetting();
	}

	@Override
	public void onProviderDisabled(String provider) {//當GPS或網路定位功能關閉時
		Log.e("StoreGPSLocation","請開啟定位服務");
		Toast.makeText(context, "請開啟定位服務", Toast.LENGTH_SHORT).show();
		context.startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));//開啟設定頁面
	}
	
	public void onDestroyController() {
		if(locationManager != null){
			locationManager.removeUpdates(this);
			locationManager=null;
		}
		
		if(locationManager != null){
			locationManager.removeUpdates(this);
		}
	}

}
