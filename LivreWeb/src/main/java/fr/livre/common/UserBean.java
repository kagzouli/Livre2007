package fr.livre.common;

import java.io.Serializable;

public class UserBean implements Serializable{
	
	public static final long serialVersionUID = 1233243464243L;
	
	/**
	 * Login.<br/>
	 */
	private String login;
	
	/**
	 * Role.<br/>
	 */
	private RoleBean role;
	

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
	 * @return the role
	 */
	public RoleBean getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(RoleBean role) {
		this.role = role;
	}
}
