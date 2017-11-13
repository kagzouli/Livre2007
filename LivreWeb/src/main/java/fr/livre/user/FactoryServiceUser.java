package fr.livre.user;

import fr.livre.business.user.IUserBusinessService;
import fr.livre.business.user.UserBusinessService;

/**
 * Factory permettant de creer le service pour les utilisateurs.<br/>
 * @author GZOULI
 *
 */
public final class FactoryServiceUser {
	/**
	 * Instance pour singleton.<br/>
	 */
	private static FactoryServiceUser factory = new FactoryServiceUser();
	
	private FactoryServiceUser(){
	}
	
	/**
	 * Methode permettant de retourner la FactoryServiceUser.<br/>
	 * @return Retourne FactoryServiceUser.<br/>
	 */
	public static FactoryServiceUser getInstance(){
		return factory;
	}
	
	/**
	 * Methode permettant de retourner une instance du service user.<br/>
	 * @return Retourne l'instance du service user.<br/>
	 */
	public IUserBusinessService createUserService(){
		IUserBusinessService service = new UserBusinessService();
		return service;
	}

}
