package fr.livre.common;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.Globals;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;

import fr.livre.business.common.SpringApplicationContext;
import fr.livre.business.user.IUserBusinessService;

public class LivreAction extends Action{
	
	protected final Log log = LogFactory.getLog(LivreAction.class);

	protected static IUserBusinessService userBusinessService;
	
	/**
	 * Success.<br/>
	 */
	protected static final String FORWARD_SUCCESS = "success";
	
	protected static final String FORWARD_ECHEC = "echec";
	
	/**
	 * Methode permettant d'ajouter une erreur.<br/>
	 * @param request La requete.<br/>
	 * @param keyError La cle de l'erreur a rajouter.<br/>
	 */
	protected void addError(HttpServletRequest request,String keyError){
		ActionErrors errors = (ActionErrors) request.getAttribute(Globals.ERROR_KEY);
		ActionError error = new ActionError(keyError);
		
		if ((errors == null) || (errors.size() == 0)){
			errors = new ActionErrors();
		}
		
		errors.add(ActionErrors.GLOBAL_ERROR,error);
		this.saveErrors(request, errors);	

	}
	
	protected IUserBusinessService getUserBusinessService(){
		if (userBusinessService == null){
			userBusinessService = SpringApplicationContext.getBean(IUserBusinessService.class);
		}
		return userBusinessService;
	}

}
