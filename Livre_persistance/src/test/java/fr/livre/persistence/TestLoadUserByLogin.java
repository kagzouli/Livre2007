package fr.livre.persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import fr.livre.persistance.common.SessionFactoryDAO;
import fr.livre.persistance.dao.user.UserDAO;
import fr.livre.persistance.user.UserPersistanceBean;

public class TestLoadUserByLogin {
	
	public static void main(String[] args) {
		
		// Definition d'une transaction
		Session session = null;

		try {

			//Recuperation d'une SessionFactory
			SessionFactory sessionFactory = SessionFactoryDAO.getInstance().getSessionFactory();

			session = sessionFactory.openSession();

			UserPersistanceBean userBean = new UserDAO().loadUserByLogin("root");

			System.out.println("User Bean : "+userBean);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		
		
	}

}
