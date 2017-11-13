package fr.livre.persistance.user;

import java.io.Serializable;
import java.util.Set;

public class RolePersistanceBean implements Serializable{
	
	/**
	 * SerialVersionUID.<br/>
	 */
	public static final long serialVersionUID = 1243232437333L;
	
	/**
	 * Id Role.<br/>
	 */
	private Integer idRole;
	
	/**
	 * Label Role.<br/>
	 */
	private String labelRole;
	
	/**
	 * Descriptif role.<br/>
	 */
	private String descriptifRole;
	
	/**
	 * Liste des utilisateurs.<br/>
	 */
	private Set<UserPersistanceBean> users;

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

	/**
	 * @return the labelRole
	 */
	public String getLabelRole() {
		return labelRole;
	}

	/**
	 * @param labelRole the labelRole to set
	 */
	public void setLabelRole(String labelRole) {
		this.labelRole = labelRole;
	}

	/**
	 * @return the descriptifRole
	 */
	public String getDescriptifRole() {
		return descriptifRole;
	}

	/**
	 * @param descriptifRole the descriptifRole to set
	 */
	public void setDescriptifRole(String descriptifRole) {
		this.descriptifRole = descriptifRole;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descriptifRole == null) ? 0 : descriptifRole.hashCode());
		result = prime * result + ((idRole == null) ? 0 : idRole.hashCode());
		result = prime * result + ((labelRole == null) ? 0 : labelRole.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final RolePersistanceBean other = (RolePersistanceBean) obj;
		if (descriptifRole == null) {
			if (other.descriptifRole != null)
				return false;
		} else if (!descriptifRole.equals(other.descriptifRole))
			return false;
		if (idRole == null) {
			if (other.idRole != null)
				return false;
		} else if (!idRole.equals(other.idRole))
			return false;
		if (labelRole == null) {
			if (other.labelRole != null)
				return false;
		} else if (!labelRole.equals(other.labelRole))
			return false;
		return true;
	}

	/**
	 * @return the users
	 */
	public Set<UserPersistanceBean> getUsers() {
		return users;
	}

	/**
	 * @param users the users to set
	 */
	public void setUsers(Set<UserPersistanceBean> users) {
		this.users = users;
	}

}
