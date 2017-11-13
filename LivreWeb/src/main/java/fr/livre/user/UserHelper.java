package fr.livre.user;

import org.apache.commons.lang.StringUtils;

import fr.livre.business.user.CritereUserBusinessBean;
import fr.livre.business.user.RoleBusinessBean;
import fr.livre.business.user.UserBusinessBean;

/**
 * Classe permettant de convertir un UserForm en UserBusinessBean.<br/>
 * @author GZOULI
 *
 */
public class UserHelper {
	
	/**
	 * Methode permettant de convertir un user web en user service.<br/>
	 * @param userForm User form.<br/>
	 * @return Retourne l'utilisateur service.<br/>
	 */
	public static UserBusinessBean getUserBusinessFromWeb(UserForm userForm){
		
		UserBusinessBean userBusiness = null;
		
		if (userForm != null){
			userBusiness = new UserBusinessBean();
			userBusiness.setLogin(userForm.getLogin());
			userBusiness.setPassword(userForm.getPassword());
			userBusiness.setNom(userForm.getNom());
			userBusiness.setPrenom(userForm.getPrenom());
			userBusiness.setAdresse(userForm.getAdresse());
			userBusiness.setMail(userForm.getMail());
			
			if ((!StringUtils.isEmpty(userForm.getRole()))){
				RoleBusinessBean roleBusiness = new RoleBusinessBean();
				roleBusiness.setLibelle(userForm.getRole());
				userBusiness.setRole(roleBusiness);
			}
		}
		return userBusiness;
		
	}
	
	/**
	 * Methode permettant de convertir un user web en user service.<br/>
	 * @param userForm ModificationUser form.<br/>
	 * @return Retourne l'utilisateur service.<br/>
	 */
	public static UserBusinessBean getUserBusinessFromWeb(ModificationUserForm userForm){
		
		UserBusinessBean userBusiness = null;
		
		if (userForm != null){
			userBusiness = new UserBusinessBean();
			if (!StringUtils.isEmpty(userForm.getIdUser())){
				userBusiness.setIdUser(new Integer(userForm.getIdUser()));				
			}
			userBusiness.setLogin(userForm.getLogin());
			userBusiness.setPassword(userForm.getPassword());
			userBusiness.setNom(userForm.getNom());
			userBusiness.setPrenom(userForm.getPrenom());
			userBusiness.setAdresse(userForm.getAdresse());
			userBusiness.setMail(userForm.getMail());
			
			if ((!StringUtils.isEmpty(userForm.getRole()))){
				RoleBusinessBean roleBusiness = new RoleBusinessBean();
				roleBusiness.setLibelle(userForm.getRole());
				userBusiness.setRole(roleBusiness);
			}
		}
		return userBusiness;
		
	}

	
	/**
	 * Methode permettant de convertir des criteres web en criteres business.<br/>
	 * @param critereForm Critere web.<br/>
	 * @return Retourne des criteres business.<br/>
	 */
	public static CritereUserBusinessBean getCritereBusinessFromWeb(CritereForm critereForm){
		CritereUserBusinessBean critereBusiness = null;
		if (critereForm != null){
			critereBusiness = new CritereUserBusinessBean();
			critereBusiness.setLogin(critereForm.getLogin());
			critereBusiness.setNom(critereForm.getNom());
			critereBusiness.setPrenom(critereForm.getPrenom());
			critereBusiness.setMail(critereForm.getMail());
			critereBusiness.setRole(critereForm.getRole());
		}
		return critereBusiness;
	}

}
