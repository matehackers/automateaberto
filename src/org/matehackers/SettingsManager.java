package org.matehackers;

public class SettingsManager {

	ISettingsProvider _provider;
	
	public SettingsManager(ISettingsProvider provider) {
		_provider = provider;
	}
	
	public String getMacAddress()
	{
		return _provider.getMacAddress();
	}	
}
