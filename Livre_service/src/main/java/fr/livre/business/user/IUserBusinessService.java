package fr.livre.business.user;

import java.util.List;

import fr.livre.business.exception.LoginDejaExistantException;
import fr.livre.business.exception.RoleNonExistantException;
import fr.livre.business.exception.TechnicalException;
import fr.livre.business.exception.UserNonExistantException;
import fr.livre.persistance.exception.PersistanceException;

public interface IUserBusinessService {

	/**
	 * Methode permettant de creer un utilisateur dans le referentiel.<br/>
	 * @param user L'utilisateur a creer.<br/>
	 * @throws LoginDejaExistantException Le login de l'utilisateur existe deja.<br/>
	 * @throws RoleNonExistantException Le role de l'utilisateur n'existe pas.<br/>
	 */
	void createUser(UserBusinessBean user) throws LoginDejaExistantException,RoleNonExistantException;
	
	/**
	 * Methode permettant de modifier un utilisateur.<br/>
	 * @param user Utilisateur.<br/>
	 * @throws LoginDejaExistantException Le login de l'utilisateur existe deja.<br/>
	 * @throws UserNonExistantException L'utilisateur n'existe pas.<br/>
	 * @throws RoleNonExistantException Le role n'existe pas.<br/>
	 */
	void modifierUser(UserBusinessBean user) throws LoginDejaExistantException,UserNonExistantException,RoleNonExistantException;
	
	/**
	 * Methode permettant de supprimer un utilisateur a partir de son id.<br/>
	 * @param idUser Identifiant utilisateur.<br/>
	 * @throws UserNonExistantException User non existant.<br/>
	 */
	void supprimerUser(Integer idUser) throws UserNonExistantException;
	
	
	/**
	 * Methode permettant de recuperer la liste des roles.<br/>
	 * @return Retourne la liste des roles.<br/>
	 */
	List<RoleBusinessBean> loadRoles() throws TechnicalException;
	
	/**
	 * Methode permettant de recuperer une liste d'utilisateur.<br/>
	 * @param critere Critere de recherche.<br/>
	 * @return Retourne une liste d'utilisateurs.<br/>
	 */
	List<UserBusinessBean> rechercheUser(CritereUserBusinessBean critere);

	/**
	 * Methode permettant de recuperer un utilisateur a partir de son identifiant.<br/>
	 * @param idUser L'identifiant user.<br/>
	 * @return Retourne l'utilisateur voulu.<br/>
	 */
    UserBusinessBean loadUser(Integer idUser); 
    
    /**
     * Methode permettant de rechercher un utilisateur par login/ mot de passe.<br/>
     * 
     * @param login
     * @param password
     * @return
     */
    UserBusinessBean loadUserByLoginPass(final String login, final String password);
    
	/**
	 * Methode permettant de recuperer un utilisateur a partir de son login.<br/>
	 * 
	 * @param login Login.<br/>
	 * @return Retourne l'utilisateur correspondant au login.<br/>
	 * @throws PersistanceException
	 *             Erreur technique.<br/>
	 */
	public UserBusinessBean loadUserByLogin(String login) throws PersistanceException;


}
