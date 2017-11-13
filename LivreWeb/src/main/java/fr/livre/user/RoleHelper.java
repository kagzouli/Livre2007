package fr.livre.user;

import fr.livre.business.user.RoleBusinessBean;
import fr.livre.common.RoleBean;

public final class RoleHelper {
	
	/**
	 * Methode permettant de recuperer un role web a partir d'un role business.<br/>
	 * @param roleBusiness Role business.<br/>
	 * @return Retourne le role web.<br/>
	 */
	public static RoleBean getRoleWebFromBusiness(RoleBusinessBean roleBusiness){
		RoleBean roleBean = null;
		
		if (roleBusiness != null){
			roleBean = new RoleBean();
			roleBean.setLibelle(roleBusiness.getLibelle());
		}
		return roleBean;
	}

}
