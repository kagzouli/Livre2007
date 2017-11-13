package fr.livre.persistance.common;

import java.util.ResourceBundle;

public final class RequeteRessources{
	
	/**
	 * Bundle par default.<br/>
	 */
	private static final String DEFAULT_BUNDLE = "requete";
	
	/**
	 * Bundle.<br/>
	 */
	private ResourceBundle bundle;
	
	/**
	 * Requete ressources.<br/>
	 */
	private static RequeteRessources requeteRessources = new RequeteRessources();
	
	private RequeteRessources(){
		bundle = ResourceBundle.getBundle(DEFAULT_BUNDLE);
	}
	
	/**
	 * Recuperer RequeteRessources.<br/>
	 * @return recupere RequeteRessources.<br/>
	 */
	public static RequeteRessources getRequeteRessources(){
		return requeteRessources;
	}
	
	public String getSQLRequest(String keyRequest){
		return bundle.getString(keyRequest);
	}
	

}
