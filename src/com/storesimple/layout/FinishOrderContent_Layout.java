package com.storesimple.layout;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.storesimple.R;
import com.storesimple.frame.MainParentLayout;
import com.storesimple.view.FinishOrderDataView;

public class FinishOrderContent_Layout extends MainParentLayout{
	private TextView Account;
	private TextView TakemealTime;
	private TextView FinishOrderTime;
	private TextView Paytype;
	private RelativeLayout TimeDataLayout;
	private RelativeLayout OrderItemTitleLayout;
	private RelativeLayout PayDataLayout;
	private RelativeLayout WriteoffDataLayout;
	private ListView MealList;
	private ArrayList<TextView> Writeofflist;
	
	public FinishOrderContent_Layout(Context context) {
		super(context);
	}

	protected void init() {
		LayoutParams LP=new LayoutParams(LayoutParams.MATCH_PARENT
				       ,LayoutParams.MATCH_PARENT);
		this.setLayoutParams(LP);
		setAccount();
		setTimeData();
		setOrderItemTitle();
		setMealList();
		setPayData();
		setWriteoffData();
	}
	
	private void setAccount(){
		Account=new TextView(context);
		LayoutParams LP=new LayoutParams(LayoutParams.MATCH_PARENT
				       ,WH.getH(5));
		Account.setLayoutParams(LP);
		Account.setTextSize(PX,WH.getTextSize(40));
		Account.setGravity(Gravity.CENTER);
		Account.setId(getRandomId());
		this.addView(Account);
	}
	
	private void setTimeData(){
		{
			TimeDataLayout=new RelativeLayout(context);
			LayoutParams LP=new LayoutParams(LayoutParams.WRAP_CONTENT
					       ,WH.getH(6));
			LP.addRule(BELOW,Account.getId());
			LP.addRule(RelativeLayout.CENTER_HORIZONTAL);
			TimeDataLayout.setLayoutParams(LP);
			TimeDataLayout.setId(getRandomId());
			this.addView(TimeDataLayout);
		}
		
		TakemealTime=new TextView(context);
		LayoutParams LP1=new LayoutParams(WH.getW(48)
				        ,LayoutParams.MATCH_PARENT);
		TakemealTime.setLayoutParams(LP1);
		TakemealTime.setTextSize(PX,WH.getTextSize(29));
		TakemealTime.setTextColor(Color.WHITE);
		TakemealTime.setBackgroundResource(R.drawable.turn_left);
		TakemealTime.setPadding(WH.getW(2),0,0,0);
		TakemealTime.setId(getRandomId());
		TimeDataLayout.addView(TakemealTime);
		
		FinishOrderTime=new TextView(context);
		LayoutParams LP2=new LayoutParams(WH.getW(48)
				        ,LayoutParams.MATCH_PARENT);
		LP2.addRule(RIGHT_OF,TakemealTime.getId());
		FinishOrderTime.setLayoutParams(LP2);
		FinishOrderTime.setTextSize(PX,WH.getTextSize(29));
		FinishOrderTime.setTextColor(Color.WHITE);
		FinishOrderTime.setBackgroundResource(R.drawable.turn_right);
		FinishOrderTime.setPadding(WH.getW(2),0,0,0);
		TimeDataLayout.addView(FinishOrderTime);
	}
	
	private void setOrderItemTitle(){
		{
			OrderItemTitleLayout=new RelativeLayout(context);
			LayoutParams LP=new LayoutParams(LayoutParams.MATCH_PARENT
					       ,WH.getH(6));
			LP.addRule(BELOW,TimeDataLayout.getId());
			LP.topMargin=WH.getH(1);
			OrderItemTitleLayout.setLayoutParams(LP);
			OrderItemTitleLayout.setBackgroundResource(R.drawable.titlelist_bg);
			OrderItemTitleLayout.setId(getRandomId());
			this.addView(OrderItemTitleLayout);
		}
		
		TextView mealnameTitle=new TextView(context);
		LayoutParams LP1=new LayoutParams(WH.getW(30)
				        ,LayoutParams.MATCH_PARENT);
		mealnameTitle.setLayoutParams(LP1);
		mealnameTitle.setText(R.string.Mealname);
		mealnameTitle.setTextSize(PX,WH.getTextSize(40));
		mealnameTitle.setTextColor(Color.WHITE);
		mealnameTitle.setGravity(Gravity.CENTER);
		mealnameTitle.setId(getRandomId());
		OrderItemTitleLayout.addView(mealnameTitle);
		
		TextView quantityTitle=new TextView(context);
		LayoutParams LP2=new LayoutParams(WH.getW(20)
				        ,LayoutParams.MATCH_PARENT);
		LP2.addRule(RIGHT_OF,mealnameTitle.getId());
		quantityTitle.setLayoutParams(LP2);
		quantityTitle.setText(R.string.Quantity);
		quantityTitle.setTextSize(PX,WH.getTextSize(40));
		quantityTitle.setTextColor(Color.WHITE);
		quantityTitle.setGravity(Gravity.CENTER);
		quantityTitle.setId(getRandomId());
		OrderItemTitleLayout.addView(quantityTitle);
		
		TextView remarkTitle=new TextView(context);
		LayoutParams LP3=new LayoutParams(WH.getW(30)
				        ,LayoutParams.MATCH_PARENT);
		LP3.addRule(RIGHT_OF,quantityTitle.getId());
		remarkTitle.setLayoutParams(LP3);
		remarkTitle.setText(R.string.remark);
		remarkTitle.setTextSize(PX,WH.getTextSize(40));
		remarkTitle.setTextColor(Color.WHITE);
		remarkTitle.setGravity(Gravity.CENTER);
		remarkTitle.setId(getRandomId());
		OrderItemTitleLayout.addView(remarkTitle);
		
		TextView moneyTitle=new TextView(context);
		LayoutParams LP4=new LayoutParams(WH.getW(20)
				        ,LayoutParams.MATCH_PARENT);
		LP4.addRule(RIGHT_OF,remarkTitle.getId());
		moneyTitle.setLayoutParams(LP4);
		moneyTitle.setText(R.string.Money);
		moneyTitle.setTextSize(PX,WH.getTextSize(40));
		moneyTitle.setTextColor(Color.WHITE);
		moneyTitle.setGravity(Gravity.CENTER);
		moneyTitle.setId(getRandomId());
		OrderItemTitleLayout.addView(moneyTitle);
	}
	
	private void setMealList(){
		MealList=new ListView(context);
		LayoutParams LP=new LayoutParams(LayoutParams.MATCH_PARENT
				       ,WH.getH(25));
		LP.addRule(BELOW,OrderItemTitleLayout.getId());
		MealList.setLayoutParams(LP);
		MealList.setEnabled(false);
		MealList.setId(getRandomId());
		this.addView(MealList);
	}
	
	private void setPayData(){
		{
			PayDataLayout=new RelativeLayout(context);
			LayoutParams LP=new LayoutParams(LayoutParams.MATCH_PARENT
						   ,LayoutParams.WRAP_CONTENT);
			LP.addRule(BELOW,MealList.getId());
			LP.topMargin=WH.getH(2);
			LP.addRule(ALIGN_LEFT,TimeDataLayout.getId());
			LP.addRule(ALIGN_RIGHT,TimeDataLayout.getId());
			PayDataLayout.setLayoutParams(LP);
			PayDataLayout.setBackgroundResource(R.drawable.orderdataframe);
			PayDataLayout.setId(getRandomId());
			this.addView(PayDataLayout);
		}
		
		FinishOrderDataView OrderData=new FinishOrderDataView(context);
		LayoutParams LP=new LayoutParams(LayoutParams.MATCH_PARENT
				       ,WH.getH(7));
		OrderData.setLayoutParams(LP);
		
		OrderData.getOrderDataTitle().setText(R.string.Paytype);
		
		PayDataLayout.addView(OrderData);
		
		Paytype=OrderData.getOrderDataValue();	
	}
	
	private void setWriteoffData(){
		{
			WriteoffDataLayout=new RelativeLayout(context);
			LayoutParams LP=new LayoutParams(LayoutParams.MATCH_PARENT
					       ,LayoutParams.WRAP_CONTENT);
			LP.addRule(BELOW,PayDataLayout.getId());
			LP.topMargin=WH.getH(1);
			LP.addRule(ALIGN_LEFT,TimeDataLayout.getId());
			LP.addRule(ALIGN_RIGHT,TimeDataLayout.getId());
			WriteoffDataLayout.setLayoutParams(LP);
			WriteoffDataLayout.setBackgroundResource(R.drawable.orderdataframe);
			this.addView(WriteoffDataLayout);
		}
		
		String WriteoffItem[]=context.getResources().getStringArray(R.array.WriteoffItem);
		FinishOrderDataView storeview =null;
		Writeofflist=new ArrayList<>();
		for(int i=0;i<3;i++){
			FinishOrderDataView OrderData=new FinishOrderDataView(context);
			LayoutParams LP=new LayoutParams(LayoutParams.MATCH_PARENT
					       ,WH.getH(6));
			if(i>0){
				LP.addRule(BELOW,storeview.getId());
			}
			OrderData.setLayoutParams(LP);
			
			if(i<2){
				OrderData.setBackgroundResource(R.drawable.bottomframe);
				OrderData.setId(getRandomId());
			}
			
			OrderData.getOrderDataTitle().setText(WriteoffItem[i]);
			
			WriteoffDataLayout.addView(OrderData);
			
			Writeofflist.add(OrderData.getOrderDataValue());
			
			storeview=OrderData;
		}
	}
	
	public ListView getMealList(){
		return MealList;
	}
	
	public TextView getAccount(){
		return Account;
	}
	
	public TextView getTakemealTime(){
		return TakemealTime;
	}
	
	public TextView getFinishOrderTime(){
		return FinishOrderTime;
	}
	
	public TextView getPaytype(){
		return Paytype;
	}
	
	public ArrayList<TextView> getWriteofflist(){
		return Writeofflist;
	}
	
   
}
