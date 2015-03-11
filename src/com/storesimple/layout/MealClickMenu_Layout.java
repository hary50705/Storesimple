package com.storesimple.layout;

import android.content.Context;
import android.widget.Button;

import com.storesimple.R;
import com.storesimple.frame.MainParentLayout;
/*更換餐點和餐點不足Dialog*/
public class MealClickMenu_Layout extends MainParentLayout{
	private Button ChangeMeal_Btn,Mealnotenough_Btn;
	
	public MealClickMenu_Layout(Context context) {
		super(context);
	}

	protected void init() {
		LayoutParams LP=new LayoutParams(LayoutParams.MATCH_PARENT
				       ,LayoutParams.WRAP_CONTENT);
		this.setLayoutParams(LP);
		
		setMenu();
	}
	
	private void setMenu(){
		ChangeMeal_Btn=new Button(context);
		LayoutParams LP1=new LayoutParams(LayoutParams.MATCH_PARENT
				       ,WH.getH(20));
		ChangeMeal_Btn.setLayoutParams(LP1);
		ChangeMeal_Btn.setText(R.string.ChangeMeal);
		ChangeMeal_Btn.setTextSize(PX,WH.getTextSize(40));	
		ChangeMeal_Btn.setBackgroundResource(R.drawable.button);
		ChangeMeal_Btn.setId(getRandomId());
		this.addView(ChangeMeal_Btn);
		
		Mealnotenough_Btn=new Button(context);
		LayoutParams LP2=new LayoutParams(LayoutParams.MATCH_PARENT
				        ,WH.getH(20));
		LP2.addRule(BELOW,ChangeMeal_Btn.getId());
		Mealnotenough_Btn.setLayoutParams(LP2);
		Mealnotenough_Btn.setText(R.string.Mealnotenough);
		Mealnotenough_Btn.setTextSize(PX,WH.getTextSize(40));
		Mealnotenough_Btn.setBackgroundResource(R.drawable.button);
		this.addView(Mealnotenough_Btn);
	}
	
	public Button getChangeMealBtn(){
		return ChangeMeal_Btn;
	}
	
	public Button getMealnotenoughBtn(){
		return Mealnotenough_Btn;
	}
}
