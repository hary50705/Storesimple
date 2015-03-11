package com.storesimple.layout;

import android.content.Context;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.storesimple.frame.MainParentLayout;

public class StoreGPSLocation_Layout extends MainParentLayout{
	private RelativeLayout LocationDataLayout;
	private RelativeLayout LongitudeLayout;
	private RelativeLayout LatitudeLayout;
	private EditText longitudeInput;
	private EditText latitudeInput;

	public StoreGPSLocation_Layout(Context context) {
		super(context);
	}

	@Override
	protected void init() {
		LayoutParams LP=new LayoutParams(LayoutParams.MATCH_PARENT
				       ,LayoutParams.MATCH_PARENT);
		this.setLayoutParams(LP);
		
		setLocationDataLayout();
		setLongitude();
		setLatitude();
	}
	
	private void setLocationDataLayout(){
		LocationDataLayout=new RelativeLayout(context);
		LayoutParams LP=new LayoutParams(LayoutParams.WRAP_CONTENT
				       ,LayoutParams.WRAP_CONTENT);
		LP.addRule(RelativeLayout.CENTER_IN_PARENT);
		LocationDataLayout.setLayoutParams(LP);
		this.addView(LocationDataLayout);
	}
	
	private void setLongitude(){
		{
			LongitudeLayout=new RelativeLayout(context);
			LayoutParams LP=new LayoutParams(WH.getW(70)
				       ,WH.getH(8));
			LongitudeLayout.setLayoutParams(LP);
			LongitudeLayout.setId(getRandomId());
			LocationDataLayout.addView(LongitudeLayout);
		}
		
		TextView longitudeHint=new TextView(context);
		LayoutParams LP1=new LayoutParams(LayoutParams.WRAP_CONTENT
				        ,LayoutParams.WRAP_CONTENT);
		LP1.addRule(RelativeLayout.CENTER_VERTICAL);
		longitudeHint.setLayoutParams(LP1);
		longitudeHint.setText("經度:");
		longitudeHint.setTextSize(PX,WH.getTextSize(35));
		longitudeHint.setId(getRandomId());
		LongitudeLayout.addView(longitudeHint);
		
		longitudeInput=new EditText(context);
		LayoutParams LP2=new LayoutParams(LayoutParams.MATCH_PARENT
				        ,LayoutParams.MATCH_PARENT);
		LP2.addRule(RIGHT_OF,longitudeHint.getId());
		longitudeInput.setLayoutParams(LP2);
		longitudeInput.setTextSize(PX,WH.getTextSize(35));
		LongitudeLayout.addView(longitudeInput);
	}
	
	private void setLatitude(){
		{
			LatitudeLayout=new RelativeLayout(context);
			LayoutParams LP=new LayoutParams(WH.getW(70)
				       ,WH.getH(8));
			LP.addRule(BELOW,LongitudeLayout.getId());
			LP.topMargin=WH.getH(2);
			LatitudeLayout.setLayoutParams(LP);
			LocationDataLayout.addView(LatitudeLayout);
		}
		
		TextView latitudeHint=new TextView(context);
		LayoutParams LP1=new LayoutParams(LayoutParams.WRAP_CONTENT
				        ,LayoutParams.WRAP_CONTENT);
		LP1.addRule(RelativeLayout.CENTER_VERTICAL);
		latitudeHint.setLayoutParams(LP1);
		latitudeHint.setText("緯度:");
		latitudeHint.setTextSize(PX,WH.getTextSize(35));
		latitudeHint.setId(getRandomId());
		LatitudeLayout.addView(latitudeHint);
		
		latitudeInput=new EditText(context);
		LayoutParams LP2=new LayoutParams(LayoutParams.MATCH_PARENT
				        ,LayoutParams.MATCH_PARENT);
		LP2.addRule(RIGHT_OF,latitudeHint.getId());
		latitudeInput.setLayoutParams(LP2);
		latitudeInput.setTextSize(PX,WH.getTextSize(35));
		LatitudeLayout.addView(latitudeInput);
	}
	
	public EditText getLongitudeInput(){
		return longitudeInput;
	}
	
	public EditText getLatitudeInput(){
		return latitudeInput;
	}

}
