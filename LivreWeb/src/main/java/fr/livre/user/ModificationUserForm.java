package fr.livre.user;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;

import fr.livre.common.LivreForm;

public class ModificationUserForm extends LivreForm {

	/**
	 * Serial version UID.<br/>
	 */
	public static final long serialVersionUID = 1247264474313L;

	/**
	 * Identifiant l'utilisateur.<br/>
	 */
	private String idUser;

	/**
	 * Login.<br/>
	 */
	private String login;

	/**
	 * Mot de passe.<br/>
	 */
	private String password;

	/**
	 * Mot de passe2.<br/>
	 */
	private String password2;

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
	private String role;

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login
	 *            the login to set
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
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the password2
	 */
	public String getPassword2() {
		return password2;
	}

	/**
	 * @param password2
	 *            the password2 to set
	 */
	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom
	 *            the nom to set
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
	 * @param prenom
	 *            the prenom to set
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
	 * @param adresse
	 *            the adresse to set
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
	 * @param mail
	 *            the mail to set
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
	 * @param role
	 *            the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * @return the idUser
	 */
	public String getIdUser() {
		return idUser;
	}

	/**
	 * @param idUser
	 *            the idUser to set
	 */
	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.struts.validator.ValidatorForm#validate(org.apache.struts.action.ActionMapping,
	 *      javax.servlet.http.HttpServletRequest)
	 */
	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = super.validate(mapping, request);

		if ((errors == null) || (errors.isEmpty())) {
			if ((this.password != null) && (!this.password.equals(this.password2))) {
				ActionError error = new ActionError("livre.error.twopassworddifferent");
				errors.add(ActionErrors.GLOBAL_ERROR, error);
			}
		}

		return errors;
	}


}
