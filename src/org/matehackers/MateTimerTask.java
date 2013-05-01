package org.matehackers;

import org.matehackers.base.interfaces.ICallbackReceiver;

import android.content.Context;

public class MateTimerTask implements Runnable {

	Context context;
	boolean allowPosting;
	private ICallbackReceiver callbackReceiver;
	
	public MateTimerTask(Context context, boolean allowPosting, ICallbackReceiver receiver) {
		this.context =  context;
		this.allowPosting = allowPosting;
		this.callbackReceiver = receiver;
	}
		
	@Override
	public void run() {
		if (allowPosting) post();
	}

	private void post() {
		if (callbackReceiver != null)
		callbackReceiver.onOperationExecuted();
		context.startService(IntentManager.POST);		
	}

	public void setAllowPosting(Boolean allowPosting) {
		this.allowPosting = allowPosting;
	}
	
}
