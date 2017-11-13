package fr.livre.persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import fr.livre.persistance.common.SessionFactoryDAO;
import fr.livre.persistance.dao.user.RoleDAO;
import fr.livre.persistance.user.RolePersistanceBean;

public class TestLoadRoleByLabel {
	
	public static void main(String[] args) {
		
		// Definition d'une transaction
		Session session = null;

		try {

			//Recuperation d'une SessionFactory
			SessionFactory sessionFactory = SessionFactoryDAO.getInstance().getSessionFactory();

			session = sessionFactory.openSession();

			RolePersistanceBean roleBean = new RoleDAO().loadRoleByLabel("root");

			System.out.println("Role Bean : "+roleBean);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

}
