package fr.livre.business.user;

import java.io.Serializable;

public class RoleBusinessBean implements Serializable{
	
	/**
	 * Serial Version UID.<br/>
	 */
	public static final long serialVersionUID = 1543343264143L;
	
	/**
	 * IdRole.<br/>
	 */
	private Integer idRole;

	
	/**
	 * Libelle du role.<br/>
	 */
	private String libelle;

	/**
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * @return the idRole
	 */
	public Integer getIdRole() {
		return idRole;
	}

	/**
	 * @param idRole the idRole to set
	 */
	public void setIdRole(Integer idRole) {
		this.idRole = idRole;
	}

}
