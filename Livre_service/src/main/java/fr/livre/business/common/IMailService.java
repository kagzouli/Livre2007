package fr.livre.business.common;

import fr.livre.business.exception.TechnicalException;

public interface IMailService {
	
	/**
	 * Methode permettant d'envoyer des mails.<br/>
	 * @param mailBean L'objet mail.<br/>
	 * @throws TechnicalException Erreur.<br/>
	 */
	public void sendMail(MailBean mailBean) throws TechnicalException;

}
