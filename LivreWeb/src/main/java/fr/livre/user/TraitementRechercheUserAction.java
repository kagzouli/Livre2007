package fr.livre.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fr.livre.business.user.CritereUserBusinessBean;
import fr.livre.business.user.IUserBusinessService;
import fr.livre.business.user.UserBusinessBean;
import fr.livre.common.Constante;
import fr.livre.common.LivreAction;
import fr.livre.login.DataContext;

public class TraitementRechercheUserAction extends LivreAction {

	/** Forward recherche */
	private static final String FORWARD_RECHERCHE = "recherche";

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

		if (log.isInfoEnabled()) {
			log.info(new StringBuffer("DEBUT de la methode execute de la classe ").append(this.getClass().getName().toString()));
		}
		
		//Est ce que l'objet dataContext est dans la session?
		HttpSession session = request.getSession(false);
		Object objectDataContext = session.getAttribute(Constante.DATA_CONTEXT);
		if ((objectDataContext == null) || (!(objectDataContext instanceof DataContext))){
			return mapping.findForward(FORWARD_RECHERCHE);
		}
		
		CritereForm critereForm = (CritereForm) form;
		
		CritereUserBusinessBean critereBusiness = UserHelper.getCritereBusinessFromWeb(critereForm);
		
		// Creation de l'utilisateur.
		IUserBusinessService userBusinessService = this.getUserBusinessService();
		List<UserBusinessBean>  listUserBusinessBean = userBusinessService.rechercheUser(critereBusiness);
		

		if (log.isInfoEnabled()) {
			log.info(new StringBuffer("END de la methode execute de la classe ").append(this.getClass().getName().toString()));
		}
		
		UserDataContext userDataContext = (UserDataContext) session.getAttribute(Constante.DATA_CONTEXT);
		userDataContext.setListUserBusinessBean(listUserBusinessBean);
		session.setAttribute(Constante.DATA_CONTEXT, userDataContext);

		return mapping.findForward(FORWARD_SUCCESS);
	}


}
