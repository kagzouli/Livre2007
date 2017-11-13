package fr.livre.user;

import fr.livre.common.LivreForm;

public class ConsultationUserForm extends LivreForm{
	
	/**
	 * Serial version UID.<br/>
	 */
	public static final long serialVersionUID = 1243463474643L;

	
	/**
	 * Identifiant de l'utilisateur
	 */
	private String idUser;

	/**
	 * @return the idUser
	 */
	public String getIdUser() {
		return idUser;
	}

	/**
	 * @param idUser the idUser to set
	 */
	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

}
