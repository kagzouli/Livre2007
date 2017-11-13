package fr.livre.persistance.dao.user;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.livre.persistance.common.RequeteRessources;
import fr.livre.persistance.exception.PersistanceException;
import fr.livre.persistance.user.RolePersistanceBean;

/**
 * DAO du role.<br/>
 * 
 * @author GZOULI
 * 
 */
@Repository
public class RoleDAO implements IRoleDAO {

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * Log.<br/>
	 */
	private Log log = LogFactory.getLog(UserDAO.class);

	public RoleDAO() {

	}

	/**
	 * 
	 */
	public RolePersistanceBean loadRoleByLabel(final String label) throws PersistanceException {
		RolePersistanceBean role = null;
		try {

			String requete = RequeteRessources.getRequeteRessources().getSQLRequest("loadRoleByLabel");

			// Recupere la session courante.
			Query query = this.getSession().createQuery(requete);
			query.setParameter("label", label);
			List<RolePersistanceBean> listResult = query.list();
			if (listResult != null) {
				if (listResult.size() > 1) {
					throw new HibernateException("Il y'a un role pour le label suivant.");
				}

				if (listResult.size() == 1) {
					role = listResult.get(0);
				}
			}

		} catch (Exception e) {
			log.error(e, e);
			throw new PersistanceException(e);
		}
		return role;

	}

	public List<RolePersistanceBean> loadRoles() throws PersistanceException {
		List<RolePersistanceBean> listRoles = new ArrayList<RolePersistanceBean>();
		try {
	
			Query query = this.getSession().createQuery(" from RolePersistanceBean");
			listRoles = query.list();


		} catch (Exception e) {
			log.error(e, e);
			throw new PersistanceException(e);
		}
		return listRoles;


	}
	
	// Hibernate method.
		protected Session getSession(){
			return this.sessionFactory.getCurrentSession();
		}
}
