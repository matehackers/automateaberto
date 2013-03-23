package org.matehackers.com;

import android.app.IntentService;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.widget.Toast;

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

	private Handler _toastHandler;

	private Runnable _message = new Runnable() {
		@Override
		public void run() {
			Toast.makeText(ServicePoster.this, C.MSG_ARRIVAL, Toast.LENGTH_LONG).show();
			AutoMateAbertoHttpPoster poster = new AutoMateAbertoHttpPoster(ServicePoster.this);
			poster.post();
		}
	};
	
	@Override
	public void onCreate() {
		super.onCreate();
		_toastHandler = new Handler();
	}
	
	@Override
	protected void onHandleIntent(Intent intent) {
		_toastHandler.post(_message);
	}
	
}