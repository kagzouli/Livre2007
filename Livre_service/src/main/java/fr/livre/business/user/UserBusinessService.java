package fr.livre.business.user;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import fr.livre.business.common.IMailService;
import fr.livre.business.common.MailBean;
import fr.livre.business.common.MailRessource;
import fr.livre.business.common.SmtpMailService;
import fr.livre.business.exception.LoginDejaExistantException;
import fr.livre.business.exception.RoleNonExistantException;
import fr.livre.business.exception.TechnicalException;
import fr.livre.business.exception.UserNonExistantException;
import fr.livre.persistance.dao.user.IRoleDAO;
import fr.livre.persistance.dao.user.IUserDAO;
import fr.livre.persistance.exception.PersistanceException;
import fr.livre.persistance.user.CritereUserPersistanceBean;
import fr.livre.persistance.user.RolePersistanceBean;
import fr.livre.persistance.user.UserPersistanceBean;

@Transactional(readOnly=true)
@Service
public class UserBusinessService implements IUserBusinessService {

	protected Log log = LogFactory.getLog(IUserBusinessService.class);
	
	public static final String TRANSACTION_MANAGER = "transactionManager";	


	/**
	 * UserDAO.<br/>
	 */
	@Autowired
	private IUserDAO userDAO;

	/**
	 * RoleDAO.<br/>
	 */
	@Autowired
	private IRoleDAO roleDAO;

	@Transactional(rollbackFor=Throwable.class, propagation = Propagation.REQUIRED, transactionManager=TRANSACTION_MANAGER)
	public void createUser(UserBusinessBean user) throws LoginDejaExistantException, RoleNonExistantException, TechnicalException {

		try {

			// Conversion user business en user persistance
			UserPersistanceBean userPersistance = UserHelper.getUserPersistanceFromBusiness(user);

			// Verification que le login n'existe pas deja
			UserPersistanceBean userPersiByLog = userDAO.loadUserByLogin(userPersistance.getLogin());
			if (userPersiByLog != null) {
				throw new LoginDejaExistantException("Le login existe deja.");
			}

			// Verification que le role existe vraiment
			RolePersistanceBean rolePersistance = userPersistance.getRole();
			if (((rolePersistance != null) && (rolePersistance.getLabelRole() != null) && (!rolePersistance.getLabelRole().equals("")))) {
				RolePersistanceBean rolePersistanceRecup = roleDAO.loadRoleByLabel(rolePersistance.getLabelRole());
				if (rolePersistanceRecup == null) {
					throw new RoleNonExistantException("Le role de l'utilisateur n'existe pas.");
				}
				userPersistance.setRole(rolePersistanceRecup);
			}
			// Creation de l'utilisateur.
			userDAO.create(userPersistance);

			// Envoi d'un email de confirmation.
			// this.sendEMailConfirmationCreationUser(user);

		} catch (RoleNonExistantException e) {
			log.info(e, e);
			throw e;
		} catch (LoginDejaExistantException e) {
			log.info(e, e);
			throw e;
		} catch (Exception e) {
			log.error(e, e);
			throw new TechnicalException(e);
		}
	}

	@Transactional(rollbackFor=Throwable.class, propagation = Propagation.REQUIRED, transactionManager=TRANSACTION_MANAGER)
	public void modifierUser(UserBusinessBean user) throws LoginDejaExistantException, UserNonExistantException, RoleNonExistantException, TechnicalException {
		try {

			// Conversion user business en user persistance
			UserPersistanceBean userPersistance = UserHelper.getUserPersistanceFromBusiness(user);

			// Verification que l'utilisateur existe.
			UserPersistanceBean userCharge = userDAO.loadUser(user.getIdUser());
			if (userCharge == null) {
				throw new UserNonExistantException("L'utilisateur demande n'existe pas.");
			}

			// Verification que le login n'existe pas deja
			UserPersistanceBean userPersiByLog = userDAO.loadUserByLogin(userPersistance.getLogin());
			if ((userPersiByLog != null) && (!userPersiByLog.getIdUser().equals(userPersistance.getIdUser()))) {
				throw new LoginDejaExistantException("Le login existe deja.");
			}

			// Verification que le role existe vraiment
			RolePersistanceBean rolePersistance = userPersistance.getRole();
			if (((rolePersistance != null) && (rolePersistance.getLabelRole() != null) && (!rolePersistance.getLabelRole().equals("")))) {
				RolePersistanceBean rolePersistanceRecup = roleDAO.loadRoleByLabel(rolePersistance.getLabelRole());
				if (rolePersistanceRecup == null) {
					throw new RoleNonExistantException("Le role de l'utilisateur n'existe pas.");
				}
				userPersistance.setRole(rolePersistanceRecup);
			}
			// Creation de l'utilisateur.
			userCharge.setLogin(userPersistance.getLogin());
			userCharge.setPassword(userPersistance.getPassword());
			userCharge.setNom(userPersistance.getNom());
			userCharge.setPrenom(userPersistance.getPrenom());
			userCharge.setAdresse(userPersistance.getAdresse());
			userCharge.setMail(userPersistance.getMail());
			userCharge.setRole(userPersistance.getRole());
			userDAO.modifier(userCharge);

			// Envoi d'un email de confirmation.
			// this.sendEMailConfirmationCreationUser(user);

		} catch (RoleNonExistantException e) {
			log.info(e, e);
			throw e;
		} catch (UserNonExistantException e) {
			log.info(e, e);
			throw e;
		} catch (LoginDejaExistantException e) {
			log.info(e, e);
			throw e;
		} catch (Exception e) {
			log.error(e, e);
			throw new TechnicalException(e);
		}
	}

	@Transactional(rollbackFor=Throwable.class, propagation = Propagation.REQUIRED, transactionManager=TRANSACTION_MANAGER)
	public void supprimerUser(Integer idUser) throws UserNonExistantException,TechnicalException {
		// Verification que l'utilisateur existe.
		try {
			UserPersistanceBean userCharge = userDAO.loadUser(idUser);
			if (userCharge == null) {
				throw new UserNonExistantException("L'utilisateur demande n'existe pas.");
			}

			userDAO.supprimer(userCharge);
		} catch (UserNonExistantException e) {
			log.info(e, e);
			throw e;
		} catch (Exception e) {
			log.error(e, e);
			throw new TechnicalException(e);
		}
	}

	/**
	 * Methode permettant d'envoyer un e-mail de confirmation pour la creation
	 * du user.<br/>
	 * 
	 * @param user
	 *            Utilisateur.<br/>
	 */
	private void sendEMailConfirmationCreationUser(UserBusinessBean user) throws TechnicalException {
		MailBean mailBean = new MailBean();
		MailRessource mailRessource = MailRessource.getMailRessource();
		mailBean.setSmtpMail(mailRessource.getParameter(MailRessource.DEFAULT_KEY_MAIL_NAME));
		mailBean.setSourceMail(mailRessource.getParameter(MailRessource.DEFAULT_KEY_MAIL_LOGIN));
		mailBean.setPassword(mailRessource.getParameter(MailRessource.DEFAULT_KEY_MAIL_PASSWORD));

		StringBuffer buffer = new StringBuffer("Bonjour ");
		buffer.append(user.getLogin());
		buffer.append(",\n\n Votre demande d'inscription au site livre en ligne a bien été pris en compte. Voici vos identifiants :");
		buffer.append("\n\n Login : ");
		buffer.append(user.getLogin());
		buffer.append("\n Password : ");
		buffer.append(user.getPassword());
		buffer.append("\n\n Cordialement.");
		buffer.append("\n\n Webmaster Livre en ligne");

		mailBean.setCorpsMail(buffer.toString());

		Collection<String> destinataires = new ArrayList<String>();
		destinataires.add(user.getMail());
		mailBean.setDestinataire(destinataires);

		mailBean.setTitreMail("Confirmation d'inscription");

		IMailService mailService = new SmtpMailService();
		mailService.sendMail(mailBean);
	}

	public List<RoleBusinessBean> loadRoles() throws TechnicalException {
		List<RoleBusinessBean> listRolesBusiness = new ArrayList<RoleBusinessBean>();

		try {
			List<RolePersistanceBean> listRolesPersistance = roleDAO.loadRoles();
			if (listRolesPersistance != null) {
				Iterator<RolePersistanceBean> itRolePersistance = listRolesPersistance.iterator();
				while (itRolePersistance.hasNext()) {
					RolePersistanceBean rolePersistanceBean = itRolePersistance.next();
					listRolesBusiness.add(RoleHelper.getRoleBusinessFromPersistance(rolePersistanceBean));
				}

			}
		} catch (Exception e) {
			log.error(e, e);
			throw new TechnicalException(e);
		}

		return listRolesBusiness;
	}

	public List<UserBusinessBean> rechercheUser(CritereUserBusinessBean critereBusiness) throws TechnicalException {
		List<UserBusinessBean> listUserBusiness = new ArrayList<UserBusinessBean>();

		try {
			CritereUserPersistanceBean criterePersistance = UserHelper.getCriterePersistanceFromBusiness(critereBusiness);
			List<UserPersistanceBean> listUserPersistance = userDAO.rechercheUser(criterePersistance);

			if ((listUserPersistance != null) && (!listUserPersistance.isEmpty())) {
				Iterator<UserPersistanceBean> itUserPersistance = listUserPersistance.iterator();
				while (itUserPersistance.hasNext()) {
					UserPersistanceBean userPersistanceBean = itUserPersistance.next();
					UserBusinessBean userBusinessBean = UserHelper.getUserBusinessFromPersistance(userPersistanceBean);
					listUserBusiness.add(userBusinessBean);
				}
			}
		} catch (Exception e) {
			log.error(e, e);
			throw new TechnicalException(e);
		}
		return listUserBusiness;
	}

	public UserBusinessBean loadUser(Integer idUser) throws TechnicalException {
		UserBusinessBean userBean = null;

		try {
			if (idUser != null) {
				UserPersistanceBean userPersistance = userDAO.loadUser(idUser);
				if (userPersistance != null) {
					userBean = UserHelper.getUserBusinessFromPersistance(userPersistance);
				}
			}
		} catch (Exception e) {
			log.error(e, e);
			throw new TechnicalException(e);
		}

		return userBean;

	}

	@Override
	public UserBusinessBean loadUserByLoginPass(String login, String password) {
		UserBusinessBean userBean = null;

		try {
			if (login != null && password != null) {
				UserPersistanceBean userPersistance = userDAO.loadUserByLoginPassword(login, password);
				if (userPersistance != null) {
					userBean = UserHelper.getUserBusinessFromPersistance(userPersistance);
				}
			}
		} catch (Exception e) {
			log.error(e, e);
			throw new TechnicalException(e);
		}

		return userBean;
	}

	@Override
	public UserBusinessBean loadUserByLogin(String login) throws PersistanceException {
		UserBusinessBean userBean = null;

		try {
			if (login != null) {
				UserPersistanceBean userPersistance = userDAO.loadUserByLogin(login);
				if (userPersistance != null) {
					userBean = UserHelper.getUserBusinessFromPersistance(userPersistance);
				}
			}
		} catch (Exception e) {
			log.error(e, e);
			throw new TechnicalException(e);
		}

		return userBean;
	}

}
