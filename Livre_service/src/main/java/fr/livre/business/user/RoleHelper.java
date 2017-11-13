package fr.livre.business.user;

import fr.livre.persistance.user.RolePersistanceBean;

public class RoleHelper {
	
	/**
	 * Methode permettant de convertir un role business en role persistance.<br/>
	 * @param roleBusiness Role business.<br/>
	 * @return Retourne un role persistance.<br/>
	 */
	public static RolePersistanceBean getRolePersistanceFromBusiness(RoleBusinessBean roleBusiness){
		RolePersistanceBean rolePersistance = null;
		
		if (roleBusiness != null){
			rolePersistance = new RolePersistanceBean();
			rolePersistance.setIdRole(roleBusiness.getIdRole());
			rolePersistance.setLabelRole(roleBusiness.getLibelle());
		}
		return rolePersistance;
	}
	
	/**
	 * Methode permettant de convertir un role persistance en role business.<br/>
	 * @param rolePersistance Role persistance.<br/>
	 * @return Retourne un role business.<br/>
	 */
	public static RoleBusinessBean getRoleBusinessFromPersistance(RolePersistanceBean rolePersistance){
		RoleBusinessBean roleBusiness = null;
		if (rolePersistance != null){
			roleBusiness = new RoleBusinessBean();
			roleBusiness.setIdRole(rolePersistance.getIdRole());
			roleBusiness.setLibelle(rolePersistance.getLabelRole());
		}
		return roleBusiness;
	}

}
