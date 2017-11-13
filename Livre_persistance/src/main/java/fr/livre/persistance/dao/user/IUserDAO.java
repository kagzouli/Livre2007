package fr.livre.persistance.dao.user;

import java.util.List;

import fr.livre.persistance.exception.PersistanceException;
import fr.livre.persistance.user.CritereUserPersistanceBean;
import fr.livre.persistance.user.UserPersistanceBean;

/**
 * UserDAO.<br/>
 * 
 * @author GZOULI
 * 
 */
public interface IUserDAO {

	/**
	 * Methode permettant de creer un utilisateur en base.<br/>
	 * 
	 * @param user L'utilisateur en question.<br/>
	 * @throws PersistanceException Erreur technique.<br/>
	 */
	public void create(UserPersistanceBean user) throws PersistanceException;

	/**
	 * Methode permettant de modifier un utilisateur en base.<br/>
	 * 
	 * @param user L'utilisateur en question.<br/>
	 * @throws PersistanceException Erreur technique.<br/>
	 */
	public void modifier(UserPersistanceBean user) throws PersistanceException;

	/**
	 * Methode permettant de supprimer un utilisateur.<br/>
	 * @param user L'utilisateur a supprimer.<br/>
	 * @throws PersistanceException Erreur technique.<br/>
	 */
	public void supprimer(UserPersistanceBean user) throws PersistanceException;
	
	/**
	 * Methode permettant de recuperer un utilisateur a partir de son login.<br/>
	 * 
	 * @param login Login.<br/>
	 * @return Retourne l'utilisateur correspondant au login.<br/>
	 * @throws PersistanceException
	 *             Erreur technique.<br/>
	 */
	public UserPersistanceBean loadUserByLogin(String login) throws PersistanceException;
	
	/**
	 * Methode permettant de recuperer la liste d'utilisateurs a partir de critere de recherche.<br/>
	 * @param critere Critere de recherche.<br/>
	 * @return Retourne la liste d'utilisateur.<br/>
	 * @throws PersistanceException Erreur technique.<br/>
	 */
	public List<UserPersistanceBean> rechercheUser(CritereUserPersistanceBean critere) throws PersistanceException;
	
	/**
	 * Methode permettant de recuperer un utilisateur.<br/> 
	 * @param idUser L'identifiant de l'utilisateur.<br/>
	 * @return Retourne l'utilisateur.<br/>
	 * @throws PersistanceException Erreur technique.<br/>
	 */
	public UserPersistanceBean loadUser(Integer idUser) throws PersistanceException;
	
	 /**
     * Methode permettant de rechercher un utilisateur par login/ mot de passe.<br/>
     * 
     * @param login
     * @param password
     * @return
     */
	UserPersistanceBean loadUserByLoginPassword(final String login, final String password) throws PersistanceException;

}
