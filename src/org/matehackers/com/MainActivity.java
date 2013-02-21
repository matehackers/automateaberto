package org.matehackers.com;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {

	Automateaberto _app;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        _app = (Automateaberto) getApplication();
    }

  
}
