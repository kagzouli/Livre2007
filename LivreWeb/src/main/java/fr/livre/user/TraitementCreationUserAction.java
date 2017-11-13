package fr.livre.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fr.livre.business.exception.LoginDejaExistantException;
import fr.livre.business.exception.RoleNonExistantException;
import fr.livre.business.exception.TechnicalException;
import fr.livre.business.user.IUserBusinessService;
import fr.livre.business.user.UserBusinessBean;
import fr.livre.common.LivreAction;

public class TraitementCreationUserAction extends LivreAction {

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {

		if (log.isInfoEnabled()) {
			log.info(new StringBuffer("DEBUT de la methode execute de la classe ").append(this.getClass().getName().toString()));
		}

		UserForm userForm = (UserForm) form;

		try {
			// Conversion de l'objet user web en objet user service.
			UserBusinessBean userBusinessBean = UserHelper.getUserBusinessFromWeb(userForm);

			// Creation de l'utilisateur.
			IUserBusinessService userBusinessService = this.getUserBusinessService();
			userBusinessService.createUser(userBusinessBean);

		} catch (LoginDejaExistantException e) {
			this.addError(request, "livre.inscription.erreur.loginexistedeja");
			return mapping.getInputForward();
		} catch (RoleNonExistantException e) {
			this.addError(request, "livre.inscription.erreur.rolenexistepas");
			return mapping.getInputForward();
		} catch (TechnicalException e) {
			return mapping.findForward(FORWARD_ECHEC);
		}

		if (log.isInfoEnabled()) {
			log.info(new StringBuffer("END de la methode execute de la classe ").append(this.getClass().getName().toString()));
		}

		return mapping.findForward(FORWARD_SUCCESS);
	}

}
