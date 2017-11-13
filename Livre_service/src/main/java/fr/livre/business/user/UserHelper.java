package fr.livre.business.user;

import fr.livre.persistance.user.CritereUserPersistanceBean;
import fr.livre.persistance.user.RolePersistanceBean;
import fr.livre.persistance.user.UserPersistanceBean;

public class UserHelper {
	
	/**
	 * Methode permettant de convertir un objet user business en objet user persitance.<br/>
	 * @param userBean User business.<br/>
	 * @return Retourne un user persitance.<br/>
	 */
	public static UserPersistanceBean getUserPersistanceFromBusiness(UserBusinessBean userBean){
		UserPersistanceBean userPersistance = null;
		
		if (userBean != null){
			userPersistance = new UserPersistanceBean();
			userPersistance.setIdUser(userBean.getIdUser());
			userPersistance.setLogin(userBean.getLogin());
			userPersistance.setPassword(userBean.getPassword());
			userPersistance.setNom(userBean.getNom());
			userPersistance.setPrenom(userBean.getPrenom());
			userPersistance.setAdresse(userBean.getAdresse());
			userPersistance.setMail(userBean.getMail());
			
			RoleBusinessBean roleBusiness = userBean.getRole();
			if (roleBusiness != null){
				RolePersistanceBean rolePersistance = RoleHelper.getRolePersistanceFromBusiness(roleBusiness);
				userPersistance.setRole(rolePersistance);
			}
		}
		return userPersistance;
	}
	
	/**
	 * Methode permettant de convertir de UserPersistanceBean en UserBusinessBean.<br/>
	 * @param userPersistance UserPersistanceBean.<br/>
	 * @return Retourne UserBusinessBean.<br/>
	 */
	public static UserBusinessBean getUserBusinessFromPersistance(UserPersistanceBean userPersistance){
		UserBusinessBean userBusiness = null;
		
		if (userPersistance != null){
			userBusiness = new UserBusinessBean();
			userBusiness.setIdUser(userPersistance.getIdUser());
			userBusiness.setLogin(userPersistance.getLogin());
			userBusiness.setPassword(userPersistance.getPassword());
			userBusiness.setNom(userPersistance.getNom());
			userBusiness.setPrenom(userPersistance.getPrenom());
			userBusiness.setAdresse(userPersistance.getAdresse());
			userBusiness.setMail(userPersistance.getMail());
			
			RolePersistanceBean rolePersistance = userPersistance.getRole();
			
			if (rolePersistance != null){
				RoleBusinessBean roleBusiness = RoleHelper.getRoleBusinessFromPersistance(rolePersistance);
				userBusiness.setRole(roleBusiness);
			}
		}
		
		return userBusiness;
	}
	
	/**
	 * Methode permettant de convertir un objet business en objet persistance.<br/>
	 * @param critereBusiness Critere business.<br/>
	 * @return Retourne un critere persistance.<br/>
	 */
	public static CritereUserPersistanceBean getCriterePersistanceFromBusiness(CritereUserBusinessBean critereBusiness){
		CritereUserPersistanceBean criterePersistance = null;
		if (critereBusiness != null){
			criterePersistance = new CritereUserPersistanceBean();
			criterePersistance.setLogin(critereBusiness.getLogin());
			criterePersistance.setNom(critereBusiness.getNom());
			criterePersistance.setPrenom(critereBusiness.getPrenom());
			criterePersistance.setMail(critereBusiness.getMail());
			criterePersistance.setRole(critereBusiness.getRole());
		}
		return criterePersistance;
	}

}
