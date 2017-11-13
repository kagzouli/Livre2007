package fr.livre.persistance.dao.user;

import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.livre.persistance.common.RequeteRessources;
import fr.livre.persistance.exception.PersistanceException;
import fr.livre.persistance.user.CritereUserPersistanceBean;
import fr.livre.persistance.user.UserPersistanceBean;

@Repository
public class UserDAO  implements IUserDAO {

	/**
	 * Log.<br/>
	 */
	private Log log = LogFactory.getLog(UserDAO.class);

	@Autowired
	private SessionFactory sessionFactory;

	public UserDAO() {

	}

	/**
	 * 
	 */
	public void create(final UserPersistanceBean user) throws PersistanceException {
		try {

			this.getSession().save(user);
			log.info(new StringBuffer("Creation de l'utilisateur numero ").append(user.getIdUser()).toString());
		} catch (Exception e) {
			log.error(e, e);
			throw new PersistanceException(e);
		}
	}

	public void modifier(final UserPersistanceBean user) throws PersistanceException {
		try {
			this.getSession().update(user);
			log.info(new StringBuffer("Modification de l'utilisateur numero ").append(user.getIdUser()).toString());
		} catch (Exception e) {
			log.error(e, e);
			throw new PersistanceException(e);
		}

	}

	/**
	 * 
	 */
	public UserPersistanceBean loadUserByLogin(final String login) throws PersistanceException {
		UserPersistanceBean userPersistance = null;
		try {

			String requete = RequeteRessources.getRequeteRessources().getSQLRequest("loadUserByLogin");
			Query query = this.getSession().createQuery(requete);
			query.setParameter("login", login);
			List<UserPersistanceBean> listResult = query.list();
			if (listResult != null) {
				if (listResult.size() > 1) {
					throw new HibernateException("Il y'a un utilisateur pour le login suivant");
				}

				if (listResult.size() == 1) {
					userPersistance = listResult.get(0);
				}
			}

		} catch (Exception e) {
			log.error(e, e);
			throw new PersistanceException(e);
		}
		return userPersistance;

	}

	public List<UserPersistanceBean> rechercheUser(final CritereUserPersistanceBean critere)
			throws PersistanceException {
		List<UserPersistanceBean> listUserPersistance = Collections.emptyList();
		try {
			// On veut recuperer des utilisateurs
			Criteria critereRecherche = this.getSession()
					.createCriteria(UserPersistanceBean.class, "user");

			if (critere != null) {
				// Critere de recherche login.
				if (!StringUtils.isEmpty(critere.getLogin())) {
					String crit = new StringBuffer(40).append(critere.getLogin()).append("%").toString();
					critereRecherche.add(Restrictions.like("user.login", crit));
				}

				// Critrere de recherche nom.
				if (!StringUtils.isEmpty(critere.getNom())) {
					String crit = new StringBuffer(40).append(critere.getNom()).append("%").toString();
					critereRecherche.add(Restrictions.like("user.nom", crit));
				}

				// Critere de recherche prenom.
				if (!StringUtils.isEmpty(critere.getPrenom())) {
					String crit = new StringBuffer(40).append(critere.getPrenom()).append("%").toString();
					critereRecherche.add(Restrictions.like("user.prenom", crit));
				}

				// Critere de recherche mail.
				if (!StringUtils.isEmpty(critere.getMail())) {
					String crit = new StringBuffer(40).append(critere.getMail()).append("%").toString();
					critereRecherche.add(Restrictions.like("user.mail", crit));
				}

				// Critere de recherche role.
				if (!StringUtils.isEmpty(critere.getRole())) {
					Criteria criteriaRole = critereRecherche.createCriteria("role");
					criteriaRole.add(Restrictions.eq("labelRole", critere.getRole()));

					// critereRecherche.add(Expression.like("user.role.labelRole",critere.getRole()));
				}

				// Trie croissant sur les logins.
				critereRecherche.addOrder(Order.asc("login"));
			}

			// Recherche de la liste des utilisateurs persistance.
			listUserPersistance = critereRecherche.list();

		} catch (Exception e) {
			log.error(e, e);
			throw new PersistanceException(e);
		}
		return listUserPersistance;
	}

	public UserPersistanceBean loadUser(final Integer idUser) throws PersistanceException {
		UserPersistanceBean userPersistance = null;
		try {

			userPersistance = (UserPersistanceBean) this.getSession()
					.load(UserPersistanceBean.class, idUser, LockMode.READ);

			log.info(new StringBuffer("Chargement de l'utilisateur numero ").append(idUser).toString());

		} catch (Exception e) {
			log.error(e, e);
			throw new PersistanceException(e);
		}
		return userPersistance;

	}

	public void supprimer(final UserPersistanceBean user) throws PersistanceException {
		try {
			this.getSession().delete(user);
			log.info(new StringBuffer("Suppression de l'utilisateur numero ").append(user.getIdUser()).toString());
		} catch (Exception e) {
			log.error(e, e);
			throw new PersistanceException(e);
		}

	}

	@Override
	public UserPersistanceBean loadUserByLoginPassword(String login, String password) throws PersistanceException {
		UserPersistanceBean user = null;
		try {

			if (StringUtils.isBlank(login) || StringUtils.isBlank(password)) {
				throw new IllegalArgumentException("Le login ou le mot de passe ne peuvent pas etre null");
			}

			// On veut recuperer des utilisateurs
			Criteria critereRecherche = this.getSession()
					.createCriteria(UserPersistanceBean.class, "user");

			// Critere de recherche login.
			critereRecherche.add(Restrictions.eq("user.login", login));
			critereRecherche.add(Restrictions.eq("user.password", password));

			// Recherche de la liste des utilisateurs persistance.
			List<UserPersistanceBean> listUserPersistance = critereRecherche.list();
			if (listUserPersistance != null && !listUserPersistance.isEmpty()) {
				user = listUserPersistance.get(0);
			}

		} catch (Exception e) {
			log.error(e, e);
			throw new PersistanceException(e);
		}
		return user;
	}

	// Hibernate method.
	protected Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
}
