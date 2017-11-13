package fr.livre.login;

import fr.livre.common.LivreForm;

public class LoginForm  extends LivreForm{
	
	public static final long serialVersionUID = 1233243434343L;
	
	/**
	 * Login.<br/>
	 */
	private String j_username;
	
	/**
	 * Password.<br/>
	 */
	private String j_password;
	
	/**
	 * La locale du site.<br/>
	 */
	private String locale;

	/**
	 * @return the j_username
	 */
	public String getJ_username() {
		return j_username;
	}

	/**
	 * @param j_username the j_username to set
	 */
	public void setJ_username(String j_username) {
		this.j_username = j_username;
	}

	/**
	 * @return the j_password
	 */
	public String getJ_password() {
		return j_password;
	}

	/**
	 * @param j_password the j_password to set
	 */
	public void setJ_password(String j_password) {
		this.j_password = j_password;
	}

	/**
	 * @return the locale
	 */
	public String getLocale() {
		return locale;
	}

	/**
	 * @param locale the locale to set
	 */
	public void setLocale(String locale) {
		this.locale = locale;
	}

}
