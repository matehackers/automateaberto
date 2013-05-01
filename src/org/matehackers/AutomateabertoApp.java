package org.matehackers;

import java.text.SimpleDateFormat;
import java.util.Locale;
import org.matehackers.R;

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
		_postManager = new PostManager();
	}
	
	private Boolean getAllowPosting() {
		return getBoolPreference(R.string.key_prefs_autopost);
	}

	@Override
	public String getMacAddress() {
		return getStrPreference(R.string.key_prefs_macaddress);
	}

	@Override
	public int getTimeBetweenPosts() {
		return getIntPreference(R.string.key_prefs_time_interval);
	}
	
	public String getUrl() {		
		return C.URL_MATE_ABERTO;
	}

	public SimpleDateFormat getDateFormat() {
		return new SimpleDateFormat(C.FORMATO_DATA,_locale);
	}

	public String getUser() {
		return getStrPreference(R.string.key_prefs_user);
	}

	public void newMacAddress(String bssid) {
		if ((C.DEBUG) || (!_postManager.isPosting() && (bssid.toLowerCase(_locale).compareTo(getMacAddress().toLowerCase(_locale)) == 0)))
			_postManager.beginPosting(new MateTimerTask(this, getAllowPosting(), null),getTimeBetweenPosts());
	}
	
	public void lostConnection() {
		_postManager.EndPosting();
	}

	public void setAllowPosting(Object newValue) {
		_postManager.setAllowPosting(((Boolean) newValue).booleanValue());
	}
	
	private String getStrPreference(int id) {
		return _preferences.getString(getResources().getString(id), "");		
	}
	
	private int getIntPreference(int id) {
		return Integer.valueOf(_preferences.getString(getResources().getString(id), "0"));
	}
	
	private boolean getBoolPreference(int id) {
		return _preferences.getBoolean(getResources().getString(id), false);
	}

	public boolean isPosting() {
		return _postManager.isPosting();
	}
}
