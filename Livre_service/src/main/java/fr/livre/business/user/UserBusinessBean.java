package fr.livre.business.user;

import java.io.Serializable;

public class UserBusinessBean implements Serializable{
	
	/**
	 * SerialVersionUID.<br/>
	 */
	public static final long serialVersionUID = 1442342263143L;

	/**
	 * Id User.<br/>
	 */
	private Integer idUser;
	
	/**
	 * Login.<br/>
	 */
	private String login;

	/**
	 * Mot de passe.<br/>
	 */
	private String password;
	
	/**
	 * Nom.<br/>
	 */
	private String nom;

	/**
	 * Prenom.<br/>
	 */
	private String prenom;
	
	/**
	 * Adresse.<br/>
	 */
	private String adresse;
	
	/**
	 * Mail.<br/>
	 */
	private String mail;
	
	/**
	 * Role.<br/>
	 */
	private RoleBusinessBean role;

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
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
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
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
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
	public RoleBusinessBean getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(RoleBusinessBean role) {
		this.role = role;
	}

	/**
	 * @return the idUser
	 */
	public Integer getIdUser() {
		return idUser;
	}

	/**
	 * @param idUser the idUser to set
	 */
	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}


}
