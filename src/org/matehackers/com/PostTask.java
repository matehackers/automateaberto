package org.matehackers.com;

import android.os.AsyncTask;

public class PostTask extends AsyncTask<Void, Void, String> {

	@Override
	protected String doInBackground(Void... params) {
        AutoMateAbertoHttpPoster poster = new AutoMateAbertoHttpPoster();
		return poster.post();
	}
	
}
