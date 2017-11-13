package fr.livre.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fr.livre.business.user.IUserBusinessService;
import fr.livre.common.LivreAction;

public class TraitementSuppressionUserAction extends LivreAction{

	/* (non-Javadoc)
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ConsultationUserForm userForm = (ConsultationUserForm) form;
		String stringIdUser = userForm.getIdUser();
		
		Integer idUser = new Integer(stringIdUser);

		// Suppression de l'utilisateur.
		IUserBusinessService userBusinessService = this.getUserBusinessService();
		userBusinessService.supprimerUser(idUser);
		
		return mapping.findForward(FORWARD_SUCCESS);
	}

}
