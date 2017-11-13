//package fr.livre.persistance.dao.user;
//
//import java.util.List;
//
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.hibernate.Query;
//import org.hibernate.Session;
//import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
//
//import fr.livre.persistance.common.RequeteRessources;
//import fr.livre.persistance.exception.PersistanceException;
//import fr.livre.persistance.user.UserPersistanceBean;
//
//public class UserDAOWithoutSpring extends HibernateDaoSupport implements IUserDAO{
//	
//	/**
//	 * Log.<br/>
//	 */
//	private Log log = LogFactory.getLog(UserDAOWithoutSpring.class);
//
//
//	public UserDAOWithoutSpring() {
//
//	}
//
//
//	/**
//	 * 
//	 */
//	public void create(Session session, UserPersistanceBean user) throws PersistanceException {
//		try {
//			session.save(user);
//			log.info(new StringBuffer("Creation de l'utilisateur numero ").append(user.getIdUser()).toString());
//		} catch (Exception e) {
//			log.error(e, e);
//			throw new PersistanceException(e);
//		}
//	}
//	
//
//	/**
//	 * 
//	 */
//	public UserPersistanceBean loadUserByLogin(Session session,String login) throws PersistanceException{
//		 UserPersistanceBean userPersistance = null;
//		 
//		 try{
//			 String requete = RequeteRessources.getRequeteRessources().getSQLRequest("loadUserByLogin");
//			 Query query = session.createQuery(requete);
//			 query.setParameter("login",login);
//			 List<UserPersistanceBean> listResult = query.list();
//			 if (listResult != null){
//				 if (listResult.size() > 1){
//					 throw new PersistanceException("Il y'a un utilisateur pour le login suivant");
//				 }
//				 
//				 if (listResult.size() == 1){
//					 userPersistance = listResult.get(0);					 
//				 }
//			 }
//		 }catch(Exception e){
//			 log.error(e,e);
//			 throw new PersistanceException(e);
//		 }
//		 
//		 return userPersistance;
//	}
//	
//
//}
