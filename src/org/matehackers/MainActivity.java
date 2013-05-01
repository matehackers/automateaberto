package org.matehackers;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;

public class MainActivity extends SherlockActivity {

	private	AutomateabertoApp _app;
	private WebView view;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		view = (WebView) findViewById(R.id.webView1);
		view.loadUrl(C.MATE_ABERTO_LANDING);
		view.setInitialScale(C.DEFAULT_INITIAL_SCALE);
		_app = (AutomateabertoApp) getApplication();
	}
   
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getSupportMenuInflater().inflate(R.menu.activity_main,  menu);
		menu.findItem(R.id.menu_status).setVisible(_app.isPosting());
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public void onStart() {
		super.onStart();
		Intent intent = getIntent();
		if (intent.getAction().compareTo(C.ACTION_ARRIVAL) == 0) {
			view.reload();
			Toast.makeText(this, C.MSG_ARRIVAL, Toast.LENGTH_LONG).show();
		}
		
		
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.menu_refresh:
			toastie(C.MSG_RELOADING);
			view.reload();
			break;
		case R.id.menu_config:
			startActivity(new Intent(this, MatePreferenceActivity.class));
			break;
		case R.id.menu_post:
			toastie(C.MSG_POSTING);
			startService(IntentManager.POST);
			break;
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}
	
	private void toastie(String message) {
		Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
	}
}