package fr.livre.user;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fr.livre.business.user.IUserBusinessService;
import fr.livre.business.user.RoleBusinessBean;
import fr.livre.common.Constante;
import fr.livre.common.LivreAction;
import fr.livre.common.RoleBean;

public class InitCreationUserAction extends LivreAction{

	/* (non-Javadoc)
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (log.isInfoEnabled()){
			log.info(new StringBuffer("DEBUT de la methode execute de la classe ").append(this.getClass().getName().toString()));
		}
		
		UserForm userForm = (UserForm) form;
		
		//Recuperation des roles.<br/>
		IUserBusinessService userBusinessService = this.getUserBusinessService();
		List<RoleBusinessBean> listRoleBusiness = userBusinessService.loadRoles();
		List<RoleBean> listRoleBean = new ArrayList<RoleBean>();
		if (listRoleBusiness != null){
			Iterator<RoleBusinessBean> itRoleBusiness = listRoleBusiness.iterator();
			while (itRoleBusiness.hasNext()){
				RoleBusinessBean roleBusiness = itRoleBusiness.next();
				listRoleBean.add(RoleHelper.getRoleWebFromBusiness(roleBusiness));
			}
		}
		
		
		UserDataContext userDataContext = new UserDataContext();
		userDataContext.setListRole(listRoleBean);
		request.getSession(false).setAttribute(Constante.DATA_CONTEXT, userDataContext);

		if (log.isInfoEnabled()){
			log.info(new StringBuffer("END de la methode execute de la classe ").append(this.getClass().getName().toString()));
		}

		
		return mapping.findForward(FORWARD_SUCCESS);
	}

}
