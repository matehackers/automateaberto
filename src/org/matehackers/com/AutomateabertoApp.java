package org.matehackers.com;

import java.text.SimpleDateFormat;
import java.util.Locale;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class AutomateabertoApp extends Application implements ISettingsProvider {

	SettingsManager _settingsManager;
	PostManager _postManager;
	SharedPreferences _preferences;
	Locale _locale;
	
	
	@Override
	public void onCreate() {
		super.onCreate();
		_locale = new Locale("pt","BR");
		_settingsManager = new SettingsManager(this);
		_preferences = PreferenceManager.getDefaultSharedPreferences(this);		
		_postManager = new PostManager(this, getAllowPosting());
	}
	
	private Boolean getAllowPosting() {
		return _preferences.getBoolean(getResources().getString(R.string.key_prefs_autopost), false);
	}

	@Override
	public String getMacAddress() {
		return "4C:17:EB:DD:60:25".toLowerCase(_locale);
	}

	@Override
	public int getTimeBetweenPosts() {
		return 5;
	}
	
	public String getUrl() {		
		return "http://mateaberto.herokuapp.com/checkins";
	}

	public SimpleDateFormat getDateFormat() {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm",_locale);
	}

	public String getUser() {
		return "Alan";
	}

	public void newMacAddress(String bssid) {
		if (!_postManager.isPosting() && (bssid.toLowerCase(_locale).compareTo(getMacAddress()) == 0))
			_postManager.BeginPosting(getTimeBetweenPosts());
	}
	
	public void lostConnection() {
		if (_postManager.isPosting())
			_postManager.EndPosting();
	}

	public void setAllowPosting(Object newValue) {
		_postManager.setAllowPosting(((Boolean) newValue).booleanValue());
	}
	
}
