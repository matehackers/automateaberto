package org.matehackers;


/*
 * 
 * classe responsável pelas constantes do programa
 */
public class C {

	// Versão
	public static final boolean DEBUG = false;
	
	// Mensagens mostradas aos usuários.
	
	public static final String MSG_ARRIVAL = "//youRhere";
	public static final String MSG_POSTED_FMTD = "//message sent";
	public static final String MSG_RELOADING = "//relo%ding..";
	public static final String MSG_POSTING = "//posting..";
	
	// Ações
	
	public static final String ACTION_ARRIVAL = "org.matehackers.intents.arrival";
	public static final String ACTION_POST = "org.matehackers.intents.post";
	
	// Constantes variadas
	
	public static final int DEFAULT_INITIAL_SCALE = 80;
	public static final String FORMATO_DATA = "yyyy-MM-dd HH:mm";
	public static final String URL_MATE_ABERTO = "http://mateaberto.herokuapp.com/checkins";
	public static final String MATE_ABERTO_LANDING = "http://mateaberto.herokuapp.com";
	
}
