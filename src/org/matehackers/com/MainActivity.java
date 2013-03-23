package org.matehackers.com;

import android.content.Intent;
import android.os.Bundle;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;

public class MainActivity extends SherlockActivity {

	AutomateabertoApp _app;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
   
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
  		getSupportMenuInflater().inflate(R.menu.activity_main,  menu);
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.menu_config:
			startActivity(new Intent(this, MatePreferenceActivity.class));
			break;
		case R.id.menu_post:
			startService(new Intent(this, ServicePoster.class));
			break;
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}
}