package fr.livre.login;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.Globals;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fr.livre.common.LivreAction;

public class InitLoginAction extends LivreAction{
	
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		
		if (log.isInfoEnabled()){
			log.info(new StringBuffer("DEBUT de la methode execute de la classe ").append(this.getClass().getName().toString()));
		}
	
		LoginForm loginForm = (LoginForm) form;
	    String locale = loginForm.getLocale();
		if ((locale != null) && (!locale.trim().equals(""))){
			//Si il y'a deja une session qui existe		        
			HttpSession session = request.getSession(false);
			//On met la locale dedans
			session.setAttribute(Globals.LOCALE_KEY, new Locale(locale));
		}
		
		
		if (log.isInfoEnabled()){
			log.info(new StringBuffer("END de la methode execute de la classe ").append(this.getClass().getName().toString()));
		}

		
		return mapping.findForward(FORWARD_SUCCESS);
	}
	
	
}
