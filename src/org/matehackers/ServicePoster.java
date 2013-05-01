package org.matehackers;

import android.app.IntentService;
import android.content.Intent;
import android.os.IBinder;

public class ServicePoster extends IntentService {
	
	public ServicePoster() {
		super("ServicePoster");
	}
	
	public ServicePoster(String name) {
		super(name);
	}

	@Override
	public IBinder onBind(Intent arg0) {
		return null;
	}
	
	@Override
	public void onCreate() {
		super.onCreate();
	}
	
	@Override
	protected void onHandleIntent(Intent intent) {
		AutoMateAbertoHttpPoster poster =  
				new AutoMateAbertoHttpPoster(ServicePoster.this.getApplication());
		poster.post();
	}
	
}