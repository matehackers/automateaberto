package org.matehackers.com;
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

public class AutoMateAbertoHttpPoster {
	
	private AutomateabertoApp _app;
	
	public AutoMateAbertoHttpPoster(Context context) {
		this._app = (AutomateabertoApp) _app;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public int post()
	{		      
	   try {
		   SimpleDateFormat dateFormat = _app.getDateFormat();
		   
		   HttpClient client = new DefaultHttpClient();
		   HttpPost  post = new HttpPost(_app.getUrl());
		   
		   List data = new ArrayList();
		   
		   Calendar calendar = Calendar.getInstance();
		   Date date = new Date();
		   calendar.setTime(date);
		   calendar.add(Calendar.MINUTE, 5);   
		   
		   data.add(new BasicNameValuePair("checkin[name]", _app.getUser()));
		   data.add(new BasicNameValuePair("checkin[arrive]", dateFormat.format(date)));		   
		   data.add(new BasicNameValuePair("checkin[leave]", dateFormat.format(calendar.getTime())));
		   post.setEntity(new UrlEncodedFormEntity(data));
		   		   
		   HttpResponse response = client.execute(post);
		   
		   return response.getStatusLine().getStatusCode();
	   
	   } catch (Exception e) {
		   e.printStackTrace();
	   }
	   return -1; 
	}
}