package org.matehackers.com;

import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.EditTextPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.text.InputType;

public class MatePreferenceActivity extends PreferenceActivity {


	AutomateabertoApp _app;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		addPreferencesFromResource(R.xml.mate_preferences);

		_app = (AutomateabertoApp) getApplication();	
		
		PreferenceManager manager = getPreferenceManager();
		
		EditTextPreference auto = (EditTextPreference) manager.findPreference(getString(R.string.key_prefs_macardores));
		
		auto.getEditText().setInputType(InputType.TYPE_CLASS_NUMBER);

		CheckBoxPreference check = (CheckBoxPreference) manager.findPreference(getString(R.string.key_prefs_autopost));
		
		check.setOnPreferenceChangeListener(new OnPreferenceChangeListener() {			
			@Override
			public boolean onPreferenceChange(Preference preference, Object newValue) {
				_app.setAllowPosting(newValue);
				return true;
			}
		});
	}	
}
