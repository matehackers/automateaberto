package org.matehackers.com;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;

public class ConnectionReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context arg0, Intent arg1) {

		ConnectivityManager manager = (ConnectivityManager) arg0.getSystemService(Context.CONNECTIVITY_SERVICE);

	    NetworkInfo[] infos = manager.getAllNetworkInfo();
	    
	    for (NetworkInfo info : infos) {
	    	if(info.getType() == ConnectivityManager.TYPE_WIFI && info.isConnectedOrConnecting()) {
	    		WifiManager wifiManager = (WifiManager) arg0.getSystemService(Context.WIFI_SERVICE);
	    		WifiInfo wifiInfo = wifiManager.getConnectionInfo();
	 	    	if (wifiInfo.getBSSID() != null) {
	 	    	 	Intent intent = new Intent(arg0, ServicePoster.class);
	 	    		arg0.startService(intent);	 	    				;
	 	    	}
	 	   } 	
	    }
	}
}
