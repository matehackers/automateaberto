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
	public void onReceive(Context context, Intent intent) {

		ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		AutomateabertoApp _app = (AutomateabertoApp) context.getApplicationContext();
		
	    NetworkInfo[] infos = manager.getAllNetworkInfo();
	    
	    for (NetworkInfo info : infos) {
	    	if(info.getType() == ConnectivityManager.TYPE_WIFI && info.isConnectedOrConnecting()) {
	    		WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
	    		WifiInfo wifiInfo = wifiManager.getConnectionInfo();
	 	    	if (wifiInfo.getBSSID() != null) {
	 	    		_app.newMacAddress(wifiInfo.getBSSID());
	 	    	} 
	 	    } 
	    	else if (info.getType() == ConnectivityManager.TYPE_WIFI && !info.isConnected()) 
	    		_app.lostConnection();
	    	
	    }
	}

}
