package org.matehackers.com;

import java.util.Date;
import java.util.Timer;

import android.content.Context;
import android.widget.Toast;

public class PostManager {

	private final int STATE_NOT_POSTING = 0;
	private final int STATE_POSTING = 1;
	
	private int _state;
	private int _timeBetweenPosts;
	private MateTimerTask _task;
	private Timer _timer;
	private static Context _context;
	
	public PostManager(Context context, Boolean allowPosting) { 
		_state =  STATE_NOT_POSTING; 
		_task = new MateTimerTask(context, allowPosting);
	}
	
	public boolean BeginPosting(int timeBetweenPosts) {
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(_task, new Date(), _timeBetweenPosts * 1000);
		Toast.makeText(_context, "Posting", Toast.LENGTH_LONG).show();
		_state = STATE_POSTING;
		return true;
	}

	public void updatePostingTime(int timeBetweenPosts) {
		_timeBetweenPosts = timeBetweenPosts;		
	}

	public boolean isPosting() {
		return _state == STATE_POSTING;
	}

	public boolean EndPosting() {
		_timer.cancel();
		_state = STATE_NOT_POSTING;
		Toast.makeText(_context, "Stopped Posting", Toast.LENGTH_LONG).show();
		return true;
	}

	public void setAllowPosting(Boolean allowPosting) {
		_task.setAllowPosting(allowPosting);
	}	
}
