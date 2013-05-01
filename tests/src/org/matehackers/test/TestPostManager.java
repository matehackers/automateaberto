package org.matehackers.test;

import java.util.Date;

import org.matehackers.MateTimerTask;
import org.matehackers.PostManager;
import org.matehackers.base.interfaces.ICallbackReceiver;

import android.test.AndroidTestCase;
import android.test.mock.MockContext;

public class TestPostManager extends AndroidTestCase implements ICallbackReceiver {
	
	private MateTimerTask task;
	private Object lock;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		this.lock = new Object();
		this.task = new MateTimerTask(new MockContext(),true, this);
	}
	
	public void testPostManagerSetUp() {
		PostManager manager = new PostManager();
		assertTrue(manager.getState() == PostManager.STATE_NOT_POSTING);
	}
	
	public void testBeginPostingInit() {
		PostManager manager = new PostManager();
		manager.beginPosting (task,1);
		assertTrue(manager.getState() == PostManager.STATE_POSTING);
	}
	
	public void testBeginPostingSchedule() throws InterruptedException  {
		PostManager manager = new PostManager();
		long inicio = new Date().getTime();
		manager.beginPosting(task, 1);
		synchronized (lock) {
			lock.wait();
		}
		assertEquals(new Date().getTime() - inicio, 1000,100);
	}

	@Override
	public void onOperationExecuted() {
		synchronized (lock) {
			lock.notify();
		}
	}
	
}
