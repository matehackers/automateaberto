package org.matehackers.com;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

public class AutoMateAbertoHttpPoster {
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String post()
	{
	   String url = "http://mateaberto.herokuapp.com/checkins";
	   
	   try { 
		
		   HttpClient client = new DefaultHttpClient();
		   HttpPost  post = new HttpPost(url);
		   List data = new ArrayList();
		   data.add(new BasicNameValuePair("checkin[name]", "Alan"));
		   data.add(new BasicNameValuePair("checkin[arrive]", "2013-02-09 08:00:00 -200"));		   
		   data.add(new BasicNameValuePair("checkin[leave]", "2014-02-09 19:00:00 -200"));
		   post.setEntity(new UrlEncodedFormEntity(data));
		   		   
		   HttpResponse response = client.execute(post);
		   
		   return response.toString();
	   
	   } catch (Exception e) {
		   e.printStackTrace();
	   }
	   return null; 
	}
}
