package org.matehackers.com;

public interface ISettingsProvider {

	String getMacAddress();
	
	/*
	 * retorna o tempo em minutos entre cada post
	 */
	int getTimeBetweenPosts();

}
