package fr.livre.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fr.livre.common.LivreAction;
import fr.livre.common.RoleBean;

public class InitInscriptionAction extends LivreAction{

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		if (log.isInfoEnabled()){
			log.info(new StringBuffer("DEBUT de la methode execute de la classe ").append(this.getClass().getName().toString()));
		}

		UserForm userForm = (UserForm) form;
		userForm.setRole(RoleBean.DROIT_USER);
	
		
		
		if (log.isInfoEnabled()){
			log.info(new StringBuffer("END de la methode execute de la classe ").append(this.getClass().getName().toString()));
		}

		
		return mapping.findForward(FORWARD_SUCCESS);
	}
	

}
