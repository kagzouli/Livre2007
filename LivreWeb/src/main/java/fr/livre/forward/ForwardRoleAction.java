package fr.livre.forward;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fr.livre.common.Constante;
import fr.livre.common.LivreAction;
import fr.livre.common.RoleBean;
import fr.livre.common.UserBean;

public class ForwardRoleAction extends LivreAction{
	
	/**
	 * Forward root.<br/>
	 */
	private static final String FORWARD_ROOT = "root";
	
	private static final String FORWARD_USER = "user";

	/* (non-Javadoc)
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		if (log.isInfoEnabled()){
			log.info(new StringBuffer("DEBUT de la methode execute de la classe ").append(this.getClass().getName().toString()));
		}
		
		HttpSession session = request.getSession(false);
		
		String forward = FORWARD_ECHEC;
		RoleBean role = null;
		if (request.isUserInRole(RoleBean.DROIT_ROOT)){
			role = new RoleBean();
			role.setLibelle(RoleBean.DROIT_ROOT);
			forward = FORWARD_ROOT;
		}
		else if (request.isUserInRole(RoleBean.DROIT_USER)){
			role = new RoleBean();
			role.setLibelle(RoleBean.DROIT_USER);
			forward = FORWARD_USER;
		}
		
		UserBean userBean = new UserBean();
		userBean.setLogin(request.getRemoteUser());
		userBean.setRole(role);
		session.setAttribute(Constante.USER_DATA,userBean);
		
		if (log.isInfoEnabled()){
			log.info(new StringBuffer("END de la methode execute de la classe ").append(this.getClass().getName().toString()));
		}
		
		
		return mapping.findForward(forward);
	}
	
	

}
