package fr.livre.persistence;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import fr.livre.persistance.common.SessionFactoryDAO;
import fr.livre.persistance.dao.user.UserDAO;
import fr.livre.persistance.exception.PersistanceException;
import fr.livre.persistance.user.RolePersistanceBean;
import fr.livre.persistance.user.UserPersistanceBean;

public class TestCreateUser {

	private static Log log = LogFactory.getLog(TestCreateUser.class);

	public static void main(String[] args) {
		UserPersistanceBean userPersistanceBean = new UserPersistanceBean();
		userPersistanceBean.setLogin("koko");
		userPersistanceBean.setPassword("koko");
		userPersistanceBean.setNom("koko");
		userPersistanceBean.setPrenom("jono");
		userPersistanceBean.setAdresse("7 rue des jonolo");
		userPersistanceBean.setMail("jojo@jojo.com");
		RolePersistanceBean rolePersistance = new RolePersistanceBean();
		rolePersistance.setIdRole(new Integer(1));
		userPersistanceBean.setRole(rolePersistance);

		// Definition d'une transaction
		Transaction transaction = null;
		Session session = null;

		try {

			//Recuperation d'une SessionFactory
			SessionFactory sessionFactory = SessionFactoryDAO.getInstance().getSessionFactory();

			session = sessionFactory.openSession();

			// Ouverture transaction
			transaction = session.beginTransaction();

			new UserDAO().create(userPersistanceBean);

			// Commit transaction
			transaction.commit();
		} catch (PersistanceException e) {
			// Rollback transaction
			transaction.rollback();
			log.error(e, e);
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

}
