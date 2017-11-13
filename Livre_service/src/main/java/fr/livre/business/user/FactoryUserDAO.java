package fr.livre.business.user;

import fr.livre.persistance.dao.user.IUserDAO;
import fr.livre.persistance.dao.user.UserDAO;

public class FactoryUserDAO {
	
	/**
	 * Methode permettant de creer un IUserDAO.<br/>
	 * @return Retourne un IUserDAO.<br/>
	 */
	public static IUserDAO createUserDAO(){
		IUserDAO userDAO = new UserDAO();
		return userDAO;
	}

}
