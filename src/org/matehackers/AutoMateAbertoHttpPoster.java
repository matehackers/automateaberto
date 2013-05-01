package org.matehackers;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.content.Context;
import android.util.Log;

public class AutoMateAbertoHttpPoster {
	
	private static final int HTTP_RESPONSE_OK = 200;
	private AutomateabertoApp _app;
	
	public AutoMateAbertoHttpPoster(Context context) {
		this._app = (AutomateabertoApp) context;
	}
	
	public int post()
	{		      
	   try {
		   SimpleDateFormat dateFormat = _app.getDateFormat();
		   
		   HttpClient client = new DefaultHttpClient();
		   HttpPost  post = new HttpPost(_app.getUrl());
		   
		   List<BasicNameValuePair> data = new ArrayList<BasicNameValuePair>();
		   
		   Calendar calendar = Calendar.getInstance();
		   Date date = new Date();
		   calendar.setTime(date);
		   calendar.add(Calendar.MINUTE, 5);   
		   
		   data.add(new BasicNameValuePair("checkin[name]", _app.getUser()));
		   data.add(new BasicNameValuePair("checkin[arrive]", dateFormat.format(date)));		   
		   data.add(new BasicNameValuePair("checkin[leave]", dateFormat.format(calendar.getTime())));
		   data.add(new BasicNameValuePair("checkin[comment]", "checkin auto gerado pelo programa automateaberto"));
		   	
		   post.setEntity(new UrlEncodedFormEntity(data));
		   		   
		   HttpResponse response = client.execute(post);
		      
		   int statusCode = response.getStatusLine().getStatusCode();
		   
		   if (statusCode == HTTP_RESPONSE_OK) {
			   Log.d("matehackers.org.poster", "posted!");
			   _app.startActivity(IntentManager.getArrivalIntent());
		   }
		    
		    return statusCode;
	   } catch (Exception e) {
		   e.printStackTrace();
	   }
	   return -1; 
	}
}