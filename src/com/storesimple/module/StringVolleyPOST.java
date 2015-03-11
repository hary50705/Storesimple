package com.storesimple.module;

import java.util.Map;

import com.android.volley.AuthFailureError;
import com.android.volley.Request.Method;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

public class StringVolleyPOST {
	public static int STATE_OK = 0, STATE_ERROR = 1;
	private StringRequest SR;

	public interface OnStringResponse {//設置OnStringResponse介面
		public void OnString(int state, StringVolleyPOST SV, String data);
	}
    
	public StringVolleyPOST(String url, final OnStringResponse OSR,final Map<String, String> map) {
		/*與網頁連結並取得字串結果回傳*/
		SR = new StringRequest(Method.POST,url,new Response.Listener<String>() {
			public void onResponse(String arg0) {
				OSR.OnString(STATE_OK,StringVolleyPOST.this, arg0);
			}
		},new Response.ErrorListener() {
			public void onErrorResponse(VolleyError arg0) {
				OSR.OnString(STATE_ERROR,StringVolleyPOST.this, null);
			}
		}){
			protected Map<String, String> getParams() throws AuthFailureError {
				return map;
			}
		  };
	}
	
	public StringRequest getSR() {
		return SR;
	}
	
	public void clean(){
		SR.cancel();
		SR = null;
	}

}
