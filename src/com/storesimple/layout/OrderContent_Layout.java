package com.storesimple.layout;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.storesimple.R;
import com.storesimple.frame.MainParentLayout;
import com.storesimple.view.OrderDataView;
/*當日訂單與預定訂單 訂單內容*/
public class OrderContent_Layout extends MainParentLayout{
	private RelativeLayout OrderDataLayout;
	private RelativeLayout OrderItemTitleLayout;
	private RelativeLayout BottomLayout;
	private RelativeLayout MoneyhintLayout;
	private RelativeLayout MoneyDataLayout;
	private RelativeLayout NotehintLayout;
	private RelativeLayout NoteLayout;
	private RelativeLayout PayDataLayout;
	private TextView account;
	private TextView takeMealType;
	private TextView finishOrderTime;
	private TextView address;
	private TextView payType;
	private TextView payStatus;
	private ListView mealList;
	private ScrollView bottomScroll;
	private ArrayList<TextView> moneylist;
	
	public OrderContent_Layout(Context context) {
		super(context);
	}

	protected void init() {
		LayoutParams LP=new LayoutParams(LayoutParams.MATCH_PARENT
				       ,LayoutParams.MATCH_PARENT);
		this.setLayoutParams(LP);
		setAccount();
		setOrderData();
		setOrderItemTitle();
		setBottomLayout();
		setMoneyhint();
		setMoneyData();
		setNotehint();
		setNote();
		setPayData();
		setMealList();
	}
	
	private void setAccount(){
		account=new TextView(context);
		LayoutParams LP=new LayoutParams(LayoutParams.WRAP_CONTENT
				       ,WH.getH(5));
		LP.addRule(RelativeLayout.CENTER_HORIZONTAL);
		account.setLayoutParams(LP);
		account.setTextSize(PX,WH.getTextSize(40));
		account.setId(getRandomId());
		this.addView(account);
	}
	
	private void setOrderData(){
		{
			OrderDataLayout=new RelativeLayout(context);
			LayoutParams LP=new LayoutParams(LayoutParams.WRAP_CONTENT
					       ,WH.getH(6));
			LP.addRule(BELOW,account.getId());
			LP.addRule(RelativeLayout.CENTER_HORIZONTAL);
			OrderDataLayout.setLayoutParams(LP);
			OrderDataLayout.setId(getRandomId());
			this.addView(OrderDataLayout);
		}
		
		takeMealType=new TextView(context);
		LayoutParams LP1=new LayoutParams(WH.getW(48)
				        ,LayoutParams.MATCH_PARENT);
		takeMealType.setLayoutParams(LP1);
		takeMealType.setTextSize(PX,WH.getTextSize(30));
		takeMealType.setTextColor(Color.WHITE);
		takeMealType.setBackgroundResource(R.drawable.turn_left);
		takeMealType.setGravity(Gravity.CENTER);
		takeMealType.setId(getRandomId());
		OrderDataLayout.addView(takeMealType);
		
		finishOrderTime=new TextView(context);
		LayoutParams LP2=new LayoutParams(WH.getW(48)
				        ,LayoutParams.MATCH_PARENT);
		LP2.addRule(RIGHT_OF,takeMealType.getId());
		finishOrderTime.setLayoutParams(LP2);
		finishOrderTime.setPadding(WH.getW(2),0,0,0);
		finishOrderTime.setTextSize(PX,WH.getTextSize(29));
		finishOrderTime.setTextColor(Color.WHITE);
		finishOrderTime.setBackgroundResource(R.drawable.turn_right);
		OrderDataLayout.addView(finishOrderTime);
	}
	
	private void setOrderItemTitle(){
		{
			OrderItemTitleLayout=new RelativeLayout(context);
			LayoutParams LP=new LayoutParams(LayoutParams.MATCH_PARENT
					       ,WH.getH(6));
			LP.addRule(BELOW,OrderDataLayout.getId());
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
	
	
	private void setBottomLayout(){
		bottomScroll=new ScrollView(context);
		LayoutParams LP1=new LayoutParams(LayoutParams.MATCH_PARENT
				         ,WH.getH(30));
		bottomScroll.setLayoutParams(LP1);
		LP1.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		LP1.addRule(ALIGN_LEFT,OrderDataLayout.getId());
		LP1.addRule(ALIGN_RIGHT,OrderDataLayout.getId());
		LP1.bottomMargin=WH.getH(2);
		this.addView(bottomScroll);
		
		BottomLayout=new RelativeLayout(context);
		ScrollView.LayoutParams LP=new ScrollView.LayoutParams(LayoutParams.MATCH_PARENT
				        ,LayoutParams.WRAP_CONTENT);
		BottomLayout.setLayoutParams(LP);
		BottomLayout.setId(getRandomId());
		bottomScroll.addView(BottomLayout);
	}
	
	private void setMoneyhint(){
		{
			MoneyhintLayout=new RelativeLayout(context);
			LayoutParams LP=new LayoutParams(LayoutParams.WRAP_CONTENT
					       ,LayoutParams.WRAP_CONTENT);
			MoneyhintLayout.setLayoutParams(LP);
			MoneyhintLayout.setId(getRandomId());
			BottomLayout.addView(MoneyhintLayout);
		}
		
		View moneyImage=new View(context);
		LayoutParams LP1=new LayoutParams(WH.getW(6)
				       ,WH.getW(6));
		moneyImage.setLayoutParams(LP1);
		moneyImage.setBackgroundResource(R.drawable.moneyicon);
		moneyImage.setId(getRandomId());
		MoneyhintLayout.addView(moneyImage);
		
		TextView moneyhint=new TextView(context);
		LayoutParams LP2=new LayoutParams(LayoutParams.WRAP_CONTENT
				        ,LayoutParams.WRAP_CONTENT);
		LP2.addRule(RIGHT_OF,moneyImage.getId());
		moneyhint.setLayoutParams(LP2);
		moneyhint.setText(R.string.Money);
		moneyhint.setTextSize(PX,WH.getTextSize(35));
		MoneyhintLayout.addView(moneyhint);
	}
	
	private void setMoneyData(){
		{
			MoneyDataLayout=new RelativeLayout(context);
			LayoutParams LP=new LayoutParams(LayoutParams.MATCH_PARENT
					       ,LayoutParams.WRAP_CONTENT);
			LP.addRule(BELOW,MoneyhintLayout.getId());
			MoneyDataLayout.setLayoutParams(LP);
			MoneyDataLayout.setBackgroundResource(R.drawable.orderdataframe);
			MoneyDataLayout.setId(getRandomId());
			BottomLayout.addView(MoneyDataLayout);
		}
		
		String moneyDataTitle[]=context.getResources().getStringArray(R.array.MoneyDataTitle);
		OrderDataView storeView=null;
		moneylist=new ArrayList<>();
		for(int i=0;i<4;i++){
			OrderDataView OrderData=new OrderDataView(context);
			LayoutParams LP=new LayoutParams(LayoutParams.MATCH_PARENT
				           ,WH.getH(5));
			if(i>0){
				LP.addRule(BELOW,storeView.getId());
			}
			OrderData.setLayoutParams(LP);
			OrderData.getOrderDataTitle().setText(moneyDataTitle[i]);
			if(i!=3){
				OrderData.setBackgroundResource(R.drawable.bottomframe);
				OrderData.setId(getRandomId());
			}
			MoneyDataLayout.addView(OrderData);
			
			moneylist.add(OrderData.getOrderDataValue());
			
			storeView=OrderData;
		}
	}
	
	private void setNotehint(){
		{
			NotehintLayout=new RelativeLayout(context);
			LayoutParams LP=new LayoutParams(LayoutParams.WRAP_CONTENT
					       ,LayoutParams.WRAP_CONTENT);
			LP.addRule(BELOW,MoneyDataLayout.getId());
			NotehintLayout.setLayoutParams(LP);
			NotehintLayout.setId(getRandomId());
			BottomLayout.addView(NotehintLayout);
		}
		
		View notehintImage=new View(context);
		LayoutParams LP1=new LayoutParams(WH.getW(6)
				       ,WH.getW(6));
		notehintImage.setLayoutParams(LP1);
		notehintImage.setBackgroundResource(R.drawable.listicon);
		notehintImage.setId(getRandomId());
		NotehintLayout.addView(notehintImage);
		
		TextView notehint=new TextView(context);
		LayoutParams LP2=new LayoutParams(LayoutParams.WRAP_CONTENT
				        ,LayoutParams.WRAP_CONTENT);
		LP2.addRule(RIGHT_OF,notehintImage.getId());
		notehint.setLayoutParams(LP2);
		notehint.setText(R.string.Note);
		notehint.setTextSize(PX,WH.getTextSize(35));
		NotehintLayout.addView(notehint);
	}
	
	private void setNote(){
		{
			NoteLayout=new RelativeLayout(context);
			LayoutParams LP=new LayoutParams(LayoutParams.MATCH_PARENT
					       ,LayoutParams.WRAP_CONTENT);
			LP.addRule(BELOW,NotehintLayout.getId());
			NoteLayout.setLayoutParams(LP);
			NoteLayout.setBackgroundResource(R.drawable.orderdataframe);
			BottomLayout.addView(NoteLayout);
		}
		
		address=new TextView(context);
		LayoutParams LP1=new LayoutParams(LayoutParams.MATCH_PARENT
				       ,LayoutParams.WRAP_CONTENT);
		address.setLayoutParams(LP1);
		address.setPadding(WH.getW(2),0,0,0);
		address.setTextSize(PX,WH.getTextSize(35));
		address.setBackgroundResource(R.drawable.bottomframe);
		address.setGravity(Gravity.CENTER_VERTICAL);
		address.setId(getRandomId());
		NoteLayout.addView(address);
	}
	
	private void setPayData(){
		{
			PayDataLayout=new RelativeLayout(context);
			LayoutParams LP=new LayoutParams(LayoutParams.MATCH_PARENT
						   ,LayoutParams.WRAP_CONTENT);
			LP.addRule(BELOW,address.getId());
			PayDataLayout.setLayoutParams(LP);
			PayDataLayout.setBackgroundResource(R.drawable.bottomframe);
			NoteLayout.addView(PayDataLayout);
		}
		
		payType=new TextView(context);
		LayoutParams LP1=new LayoutParams(LayoutParams.WRAP_CONTENT
				       ,LayoutParams.WRAP_CONTENT);
		LP1.leftMargin=WH.getW(2);
		LP1.addRule(RelativeLayout.CENTER_VERTICAL);
		payType.setLayoutParams(LP1);
		payType.setTextSize(PX,WH.getTextSize(35));
		payType.setId(getRandomId());
		PayDataLayout.addView(payType);
		
		payStatus=new TextView(context);
		LayoutParams LP2=new LayoutParams(LayoutParams.WRAP_CONTENT
				        ,LayoutParams.WRAP_CONTENT);
		LP2.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
		LP2.addRule(RelativeLayout.CENTER_VERTICAL);
		LP2.rightMargin=WH.getW(2);
		payStatus.setLayoutParams(LP2);
		payStatus.setTextSize(PX,WH.getTextSize(35));
		PayDataLayout.addView(payStatus);
	}
	
	private void setMealList(){
		mealList=new ListView(context);
		LayoutParams LP=new LayoutParams(LayoutParams.MATCH_PARENT
				       ,LayoutParams.WRAP_CONTENT);
		LP.addRule(BELOW,OrderItemTitleLayout.getId());
		LP.addRule(ABOVE,BottomLayout.getId());
		LP.bottomMargin=WH.getH(2);
		mealList.setLayoutParams(LP);
		this.addView(mealList);
	}
	
	public ScrollView getBottomScroll(){
		return bottomScroll;
	}
	
	public ArrayList<TextView> getMoneylist(){
		return moneylist;
	}
	
	public ListView getMealList(){
		return mealList;
	}
	
	public TextView getAccount(){
		return account;
	}
	
	public TextView getTakemealType(){
		return takeMealType;
	}
	
	public TextView getfinishOrderTime(){
		return finishOrderTime;
	}
	
	public TextView getAddress(){
		return address;
	}
	
	public TextView getPaytype(){
		return payType;
	}
	
	public TextView getPaystatus(){
		return payStatus;
	}
}
