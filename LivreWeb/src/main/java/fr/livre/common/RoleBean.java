package fr.livre.common;

public class RoleBean {
	
	/**
	 * Constante droit administrateur.<br/>
	 */
	public static final String DROIT_ROOT = "root";
	
	/**
	 * Constante droit utilisateur.<br/>
	 */
	public static final String DROIT_USER = "user";
	
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
