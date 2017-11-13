package fr.livre.persistance.common;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import fr.livre.persistance.exception.PersistanceException;

/**
 * Singleton.<br/>
 * 
 * @author GZOULI
 * 
 */
public class SessionFactoryDAO {
	
	/**
	 * Log.<br/>
	 */
	private Log log = LogFactory.getLog(SessionFactoryDAO.class);

	/**
	 * SessionFactoryDAO.<br/>
	 */
	private static SessionFactoryDAO sessionFactoryDAO = new SessionFactoryDAO();

	/**
	 * SessionFactory.<br/>
	 */
	private SessionFactory sessionFactory;

	/**
	 * Constructeur.<br/>
	 */
	private SessionFactoryDAO() {

	}

	/**
	 * Methode permettant de recuperer un SessionFactoryDAO.<br/>
	 * 
	 * @return Recuperer un sessionFactoryDAO.<br/>
	 */
	public static SessionFactoryDAO getInstance() {
		return sessionFactoryDAO;
	}

	/**
	 * Methode permettant de recuperer un sessionFactory.<br/>
	 * @return Retourne une SessionFactory.<br/>
	 * @throws PersistanceException Erreur technique.<br/>
	 */
	public SessionFactory getSessionFactory() throws PersistanceException{
		try {
			if (this.sessionFactory == null) {
				this.sessionFactory = new Configuration().configure().buildSessionFactory();
			}
		} catch (Exception e) {
			log.error(e, e);
			throw new PersistanceException(e);
		}
		return this.sessionFactory;
	}

}
