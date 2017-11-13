package fr.livre.user;

import java.util.List;

import fr.livre.business.user.UserBusinessBean;
import fr.livre.common.RoleBean;
import fr.livre.login.DataContext;

public class UserDataContext extends DataContext{
	
	/**
	 * list role.<br/>
	 */
      private List<RoleBean> listRole;
      

  	/**
  	 * List user.<br/>
  	 */
  	private List<UserBusinessBean> listUserBusinessBean;

	/**
	 * @return the listRole
	 */
	public List<RoleBean> getListRole() {
		return listRole;
	}

	/**
	 * @param listRole the listRole to set
	 */
	public void setListRole(List<RoleBean> listRole) {
		this.listRole = listRole;
	}

	/**
	 * @return the listUserBusinessBean
	 */
	public List<UserBusinessBean> getListUserBusinessBean() {
		return listUserBusinessBean;
	}

	/**
	 * @param listUserBusinessBean the listUserBusinessBean to set
	 */
	public void setListUserBusinessBean(List<UserBusinessBean> listUserBusinessBean) {
		this.listUserBusinessBean = listUserBusinessBean;
	}

}
