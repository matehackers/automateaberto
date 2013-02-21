package org.matehackers.com;

public class PostManager {

	private final int STATE_NOT_POSTING = 0;
	private final int STATE_POSTING = 0;
	
	private static PostManager _instance;
	private int _state;
	private int _timeBetweenPosts;
	private AutoMateAbertoHttpPoster _poster;
	
	static PostManager getInstance() {
		if (_instance == null) {
			_instance  = new PostManager();
		}
		return _instance;
	}
	
	private PostManager() { 
		_state =  STATE_NOT_POSTING; 
		_poster = new AutoMateAbertoHttpPoster();
	}
	
	public void BeginPosting(int timeBetweenPosts) {
		if (isPosting()) 
			updatePostingTime(timeBetweenPosts);
		else
			beginTimedPosting(timeBetweenPosts);
	}

	private void beginTimedPosting(int timeBetweenPosts) {
		
				
	}

	private void updatePostingTime(int timeBetweenPosts) {
		_timeBetweenPosts = timeBetweenPosts;		
	}


	private boolean isPosting() {
		return false;
	}

	
	
	
}
