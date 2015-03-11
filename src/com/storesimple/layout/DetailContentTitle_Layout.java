package com.storesimple.layout;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.storesimple.frame.MainParentLayout;
import com.storesimple.view.DayOrderSearchView;
import com.storesimple.view.FunctionTitleView;
/*詳細內容標題畫面*/
public class DetailContentTitle_Layout extends MainParentLayout{
	private FunctionTitleView FunctionTitle;
	private DayOrderSearchView DayOrderSearch;
	
	public DetailContentTitle_Layout(Context context) {
		super(context);
	}

	protected void init() {
		LayoutParams LP=new LayoutParams(LayoutParams.MATCH_PARENT
				       ,LayoutParams.MATCH_PARENT);
		this.setLayoutParams(LP);
		
		setFunctionTitle();
		setDayOrderSearch();
	}
	
	private void setFunctionTitle(){
		FunctionTitle=new FunctionTitleView(context);
		this.addView(FunctionTitle);
	}
	
	private void setDayOrderSearch(){
		DayOrderSearch=new DayOrderSearchView(context);
		DayOrderSearch.setVisibility(View.GONE);
		this.addView(DayOrderSearch);
	}
	/*最上面功能標題畫面的物件*/
	public RelativeLayout getFunctionTitleView(){
		return FunctionTitle;
	}
	
	public TextView getFunctionTitle(){
		return FunctionTitle.getTitle();
	}
	
	public Button getBackBtn(){
		return FunctionTitle.getBackBtn();
	}
	
	public Button getDayOrderSearchBtn(){
		return FunctionTitle.getDayOrderSearchBtn();
	}
	
	/*當日訂單手機查詢各類狀態列表畫面的物件*/
	public RelativeLayout getDayOrderSearchView(){
		return DayOrderSearch;
	}
	
	public Button getBackFunctionTitleBtn(){
		return DayOrderSearch.getBackBtn();
	}
	
	public Button getSearchBtn(){
		return DayOrderSearch.getSearchBtn();
	}
	
	public EditText getPhoneNumberInput(){
		return DayOrderSearch.getPhoneNumberInput();
	}

}
