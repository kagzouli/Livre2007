package fr.livre.business.user;

import fr.livre.persistance.dao.user.IRoleDAO;
import fr.livre.persistance.dao.user.RoleDAO;

/**
 * Factory permettant creer un roleDAO.<br/>
 * @author GZOULI
 *
 */
public class FactoryRoleDAO {
	
	/**
	 * Methode permettant de creer un IRoleDAO.<br/>
	 * @return Retourne un IRoleDAO.<br/>
	 */
	public static IRoleDAO createRoleDAO(){
		IRoleDAO roleDAO = new RoleDAO();
		return roleDAO;
	}

}
