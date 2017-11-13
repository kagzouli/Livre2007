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
//import fr.livre.persistance.user.RolePersistanceBean;
//
///**
// * DAO du role.<br/>
// * @author GZOULI
// *
// */
//public class RoleDAOWithoutSpring extends HibernateDaoSupport implements IRoleDAO{
//	
//	
//	/**
//	 * Log.<br/>
//	 */
//	private Log log = LogFactory.getLog(UserDAO.class);
//
//
//	public RoleDAOWithoutSpring() {
//
//	}
//	
//    /**
//     * 
//     */
//	public RolePersistanceBean loadRoleByLabel(Session session,String label) throws PersistanceException{
//		RolePersistanceBean role = null;
//				 
//		 try{
//			 String requete = RequeteRessources.getRequeteRessources().getSQLRequest("loadRoleByLabel");
//			 Query query = session.createQuery(requete);
//			 query.setParameter("label",label);
//			 List<RolePersistanceBean> listResult = query.list();
//			 if (listResult != null){
//				 if (listResult.size() > 1){
//					 throw new PersistanceException("Il y'a un role pour le label suivant.");
//				 }
//				 
//				 if (listResult.size() == 1){
//					 role = listResult.get(0);					 
//				 }
//			 }
//		 }catch(Exception e){
//			 log.error(e,e);
//			 throw new PersistanceException(e);
//		 }
//		 
//		
//		return role;
//		
//	}
//
//
//}
