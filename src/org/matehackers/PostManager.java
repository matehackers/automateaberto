package org.matehackers;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class PostManager {

	private ScheduledThreadPoolExecutor executor;
	private MateTimerTask task;
		
	public void beginPosting(MateTimerTask task,long timeBetweenPosts) {
		if (!isPosting()) {
			this.task = task;
			executor = new ScheduledThreadPoolExecutor(1);
			executor.scheduleAtFixedRate(task, 0, timeBetweenPosts, TimeUnit.MINUTES);
		}
	}

	public void EndPosting() {
		if (executor == null) {
			executor.shutdownNow();			
			cleanUp();
		}
	}
	
	private void cleanUp() {
		executor = null;
		task = null;
	}
	
	public void setAllowPosting(boolean allowPosting) {
		if (task != null)
			task.setAllowPosting(allowPosting);
	}

	public boolean isPosting() {
		return (executor != null && !executor.isShutdown());
	}

}
