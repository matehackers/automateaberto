package org.matehackers.com;

import android.app.Application;

public class Automateaberto extends Application implements ISettingsProvider {

	SettingsManager _manager;
	
	@Override
	public void onCreate() {
		super.onCreate();
		_manager = new SettingsManager(this);		
	}

	@Override
	public String getMacAddress() {
		return "4C:17:EB:DD:60:21";
	}

	@Override
	public int getTimeBetweenPosts() {
		return 5;
	}
	
	
}
