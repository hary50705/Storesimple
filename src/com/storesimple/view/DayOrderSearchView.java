package com.storesimple.view;

import android.content.Context;
import android.text.InputType;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.storesimple.R;
import com.storesimple.frame.MainParentLayout;
/*當日訂單手機查詢各類狀態列表畫面*/
public class DayOrderSearchView extends MainParentLayout{
	private Button back_Btn;
	private Button search_Btn;
	private RelativeLayout SearchInputLayout;
	private EditText phonenumberInput;
	
	public DayOrderSearchView(Context context) {
		super(context);
	}

	@Override
	protected void init() {
		LayoutParams LP = new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.MATCH_PARENT);
		this.setLayoutParams(LP);
		this.setBackgroundResource(R.drawable.toptitle_bg);

		setBackButton();
		setSearchInput();
		setSearchButton();
	}
	
	private void setBackButton(){
		back_Btn=new Button(context);
		LayoutParams LP=new LayoutParams(WH.getW(9)
				        ,WH.getW(9));
		LP.addRule(RelativeLayout.CENTER_VERTICAL);
		LP.leftMargin=WH.getW(2);
		back_Btn.setLayoutParams(LP);
		back_Btn.setBackgroundResource(R.drawable.arrowleft);
		back_Btn.setId(getRandomId());
		this.addView(back_Btn);
	}
	
	private void setSearchInput(){
		{
			SearchInputLayout=new RelativeLayout(context);
			LayoutParams LP=new LayoutParams(LayoutParams.WRAP_CONTENT
					        ,WH.getH(5));
			LP.addRule(RelativeLayout.CENTER_IN_PARENT);
			SearchInputLayout.setLayoutParams(LP);
			SearchInputLayout.setId(getRandomId());
			this.addView(SearchInputLayout);
		}
		
		TextView searchHint=new TextView(context);
		LayoutParams LP1=new LayoutParams(LayoutParams.WRAP_CONTENT
				       ,LayoutParams.WRAP_CONTENT);
		LP1.addRule(RelativeLayout.CENTER_VERTICAL);
		searchHint.setLayoutParams(LP1);
		searchHint.setText("輸入手機號碼:");
		searchHint.setTextSize(PX,WH.getTextSize(35));
		searchHint.setId(getRandomId());
		SearchInputLayout.addView(searchHint);
		
		phonenumberInput=new EditText(context);
		LayoutParams LP2=new LayoutParams(WH.getW(30)
				       ,LayoutParams.MATCH_PARENT);
		LP2.addRule(RIGHT_OF,searchHint.getId());
		LP2.leftMargin=WH.getW(2);
		phonenumberInput.setLayoutParams(LP2);
		phonenumberInput.setTextSize(PX,WH.getTextSize(30));
		phonenumberInput.setInputType(InputType.TYPE_CLASS_PHONE);
		phonenumberInput.setBackgroundResource(R.drawable.login_wordbg);
		SearchInputLayout.addView(phonenumberInput);
	}
	
	private void setSearchButton(){
		search_Btn=new Button(context);
		LayoutParams LP=new LayoutParams(LayoutParams.WRAP_CONTENT
				       ,LayoutParams.WRAP_CONTENT);
		LP.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
		LP.addRule(RelativeLayout.CENTER_VERTICAL);
		LP.rightMargin=WH.getW(1);
		search_Btn.setLayoutParams(LP);
		search_Btn.setText("查詢");
		this.addView(search_Btn);
	}
	
	public Button getBackBtn(){
		return back_Btn;
	}
	
	public Button getSearchBtn(){
		return search_Btn;
	}
	
	public EditText getPhoneNumberInput(){
		return phonenumberInput;
	}

}
