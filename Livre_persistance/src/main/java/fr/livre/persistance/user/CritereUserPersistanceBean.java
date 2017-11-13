package fr.livre.persistance.user;

import java.io.Serializable;


public class CritereUserPersistanceBean implements Serializable{
	
	/**
	 * SerialVersionUID.<br/>
	 */
	public static final long serialVersionUID = 14111321512L;
	
	/**
	 * Login.<br/>
	 */
	private String login;
	
	/**
	 * Nom.<br/>
	 */
	private String nom;
	
	/**
	 * prenom.<br/>
	 */
	private String prenom;
	
	/**
	 * Mail.<br/>
	 */
	private String mail;
	
	/**
	 * Role.<br/>
	 */
	private String role;

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * @param mail the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

}
