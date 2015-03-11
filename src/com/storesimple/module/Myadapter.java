package com.storesimple.module;

import java.util.List;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class Myadapter extends BaseAdapter {
	private List<View> list;
    public Myadapter(List<View> list){
    	this.list=list;
    }
    
    /*取得item項目的數量*/
	public int getCount() {
		return list.size();
	}

	public Object getItem(int arg0) {
		return null;
	}

	
	public long getItemId(int arg0) {
		return 0;
	}
    
	/*取得每一項item*/
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		return list.get(arg0);
	}

}
