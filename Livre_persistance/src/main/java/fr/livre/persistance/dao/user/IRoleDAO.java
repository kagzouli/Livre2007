package fr.livre.persistance.dao.user;

import java.util.List;

import fr.livre.persistance.exception.PersistanceException;
import fr.livre.persistance.user.RolePersistanceBean;


/**
 * RoleDAO.<br/>
 * @author GZOULI
 *
 */
public interface IRoleDAO
{
	/**
	 * Methode permettant de recuperer un role a partir de son libelle.<br/>
	 * @param label Libelle.<br/>
	 * @return Retourne le role correspondant.<br/>
	 * @throws PersistanceException Erreur technique.<br/>
	 */
	public RolePersistanceBean loadRoleByLabel(String label) throws PersistanceException;
	
	/**
	 * Methode permettant de recuperer l'ensemble des roles.<br/>
	 * @return Retourne la liste des roles.<br/>
	 * @throws PersistanceException Erreur technique.<br/>
	 */
	public List<RolePersistanceBean> loadRoles() throws PersistanceException;
}
