package com.storesimple.module;

public class Tag {
	public final static String DAYORDER_FRAGMENT="DayorderFragment";
	public final static String MENU_FRAGMENT="MenuFragment";
	public final static String RESERVEORDER_FRAGMENT="ReserveOrderFragment";
	public final static String DETAILCONTENTTITLE_FRAGMENT="DetailContentTitleFragment";
	public final static String FINISHORDER_FRAGMENT="FinishOrderFragment";
	public final static String DAYORDERCONTENT_FRAGMENT="DayOrderContentFragment";
	public final static String RESERVERORDERCONTENT_FRAGMENT="ReserverOrderContentFragment";
	public final static String FINISHORDERCONTENT_FRAGMENT="FinishOrderContentFragment";
	public final static String BOTTOM_FRAGMENT="BottomFragment";
	public final static String MEALCLASS_FRAGMENT="MealClassFragment";
	public final static String MEALCLASSCONTENT_FRAGMENT="MealClassContentFragment";
	public final static String STOREGPSLOCATION_FRAGMENT="StoreGPSLocationFragment";
	
	public final static String GETLOGINDATA_URL="http://mealws.chis.com.tw/Store.asmx/Login?";
	public final static String GETDAYORDER_URL="http://mealws.chis.com.tw/Order.asmx/Retrieve?";
 	public final static String GETRESERVEORDER_URL="http://mealws.chis.com.tw/Order.asmx/RetrievePre?";
	public final static String GETORDERCONTENT_URL="http://mealws.chis.com.tw/Order.asmx/RetrieveDetail?";
	public final static String GETMEALCLASSLIST_URL="http://mealws.chis.com.tw/Product.asmx/RetrieveCategory?";
	public final static String GETMEALCLASSCONTENT_URL="http://mealws.chis.com.tw/Product.asmx/Retrieve?"; 
	public final static String CHANGEMEAL_URL="http://mealws.chis.com.tw/Order.asmx/ChangeItem?";
	public final static String SENDEMAIL_URL="http://mealws.chis.com.tw/Store.asmx/Forgot?";
	public final static String SETORDERSTATUS_URL="http://mealws.chis.com.tw/Order.asmx/SetStatus?";
	
	public static String CATEGORYID;//店家類別ID
	public static String STOREID;//店家ID
	public static String SOURCE;//要更換當日訂單或預訂訂單
	public static String MEALITEMID;//要更換的餐點ID
	public static String MEALNAME;//要更換的餐點名稱
	public static String ORDERID;//訂單ID
	
	public static int PROCESSSTATUS;//當日訂單-訂單狀態
}
