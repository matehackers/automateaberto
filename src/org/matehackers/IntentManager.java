package org.matehackers;

import android.content.Intent;

public class IntentManager {

	public static final Intent POST = new Intent(C.ACTION_POST);

	public static Intent getArrivalIntent() {
		   Intent i = new Intent(C.ACTION_ARRIVAL);
		   i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		   i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
		   i.addFlags(Intent.FLAG_ACTIVITY_NO_USER_ACTION);
		   return i;
	};
		
}
