package org.matehackers.com;

import java.util.TimerTask;

import android.content.Context;
import android.content.Intent;

public class MateTimerTask extends TimerTask {

	AutomateabertoApp _app;
	boolean _allowPosting;
		
	MateTimerTask(Context context, boolean allowPosting) {
		_app =  (AutomateabertoApp) context;
		_allowPosting = allowPosting;
	}
		
	@Override
	public void run() {
		if (_allowPosting)
			_app.startService(new Intent(_app,ServicePoster.class));
	}

	public void setAllowPosting(Boolean allowPosting) {
		_allowPosting = allowPosting;
	}
	
}
