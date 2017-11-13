package fr.livre.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fr.livre.business.user.IUserBusinessService;
import fr.livre.business.user.UserBusinessBean;
import fr.livre.common.LivreAction;

public class InitConsultationUserAction extends LivreAction{
	
	/** Forward recherche */
	private static final String FORWARD_RECHERCHE = "recherche";


	/* (non-Javadoc)
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		if (log.isInfoEnabled()){
			log.info(new StringBuffer("DEBUT de la methode execute de la classe ").append(this.getClass().getName().toString()));
		}
		
		
		ConsultationUserForm consultationForm = (ConsultationUserForm) form;
		
		String stringIdUser = consultationForm.getIdUser();
		
	    Integer idUser = new Integer(stringIdUser);
	    
	    //Chargement de l'utilisateur souhaite
		IUserBusinessService userBusinessService = this.getUserBusinessService();
		UserBusinessBean userBean =  userBusinessService.loadUser(idUser);
		
		request.setAttribute("userBean", userBean);
	    
		
		
		if (log.isInfoEnabled()){
			log.info(new StringBuffer("FIN de la methode execute de la classe ").append(this.getClass().getName().toString()));
		}

		return mapping.findForward(FORWARD_SUCCESS);
	}

}
