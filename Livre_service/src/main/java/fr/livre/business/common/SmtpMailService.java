package fr.livre.business.common;

import java.io.File;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fr.livre.business.exception.TechnicalException;

public class SmtpMailService implements IMailService {
	
	private Log log = LogFactory.getLog(SmtpMailService.class);

	/**
	 * Protocole d'envoi
	 */
	private static final String MAIL_PROTOCOLE = "smtp";

	/**
	 * Mail bean
	 */
	public static final String MAIL_BEAN = "MAIL_BEAN";

	/**
	 * Mail version
	 */
	private final static String MAILER_VERSION = "Java";

	public void sendMail(MailBean mailBean) throws TechnicalException {

		if (mailBean == null) {
			throw new TechnicalException("Le parametre d'entree du service " + MAIL_BEAN + " doit etre renseigne.");
		}

		if (mailBean != null) {

			try {
				// Pour se connecte a l'envoyeur de mail
				Properties props = System.getProperties();
				Session session = Session.getDefaultInstance(props);
				Transport transport = session.getTransport(MAIL_PROTOCOLE);

				checkValidityBean(mailBean);

				transport.connect(mailBean.getSmtpMail(), 25, mailBean.getSourceMail(), mailBean.getPassword());

				// Source du message
				Message message = new MimeMessage(session);
				if (log.isDebugEnabled()) {
					log.debug("L'envoyeur du mail est" + mailBean.getSourceMail() + " par le stmpMail " + mailBean.getSmtpMail());
				}
				message.setFrom(new InternetAddress(mailBean.getSourceMail()));

				// Destinataire du message
				Collection<String> listeDestinataire = mailBean.getDestinataire();
				if (listeDestinataire != null) {
					Iterator<String> itDestinataire = listeDestinataire.iterator();
					while (itDestinataire.hasNext()) {
						String destinataire = (String) itDestinataire.next();
						InternetAddress internetAddresses = new InternetAddress(destinataire);
						message.addRecipient(Message.RecipientType.TO, internetAddresses);
					}
				}

				// Destinaire copie
				Collection<String> listeDestinataireCopie = mailBean.getDestinaireCopie();
				if (listeDestinataireCopie != null) {
					Iterator<String> itDestinataireCopie = listeDestinataireCopie.iterator();
					while (itDestinataireCopie.hasNext()) {
						String destinataireCopie = (String) itDestinataireCopie.next();
						InternetAddress internetAddresses = new InternetAddress(destinataireCopie);
						message.addRecipient(Message.RecipientType.CC, internetAddresses);
					}
				}

				// Destinaire cache
				Collection<String> listeDestinaireCache = mailBean.getDestinataireCache();
				if (listeDestinaireCache != null) {
					Iterator<String> itDestinataireCache = listeDestinaireCache.iterator();
					while (itDestinataireCache.hasNext()) {
						String destinaireCache = (String) itDestinataireCache.next();
						InternetAddress internetAddresses = new InternetAddress(destinaireCache);
						message.addRecipient(Message.RecipientType.BCC, internetAddresses);
					}
				}
				message.setSubject(mailBean.getTitreMail());
				message.setHeader("X-Mailer", MAILER_VERSION);
				message.setSentDate(new Date());
				session.setDebug(true);

				// Ajout du corps du message
				Multipart multipart = new MimeMultipart();
				MimeBodyPart messageBodyPart = new MimeBodyPart();
				messageBodyPart.setText(mailBean.getCorpsMail());
				multipart.addBodyPart(messageBodyPart);

				// Liste des pieces jointes
				Collection<String> listePieceJointe = mailBean.getListPieceJointe();				
				if (listePieceJointe != null) {

					// Ajout des liens(Images,.doc,..)
					Iterator<String> itPieceJointe = listePieceJointe.iterator();
					while (itPieceJointe.hasNext()) {
						String pieceJointe = (String) itPieceJointe.next();
						messageBodyPart = new MimeBodyPart();
						messageBodyPart.setText("Attachement ");
						DataSource source = new FileDataSource(new File(pieceJointe));
						messageBodyPart.setDataHandler(new DataHandler(source));
						messageBodyPart.setFileName(pieceJointe);
						multipart.addBodyPart(messageBodyPart);
					}
				}
				message.setContent(multipart);
				
				//mPart.setContent(messageText, "TEXT/PLAIN");


				transport.sendMessage(message, message.getAllRecipients());
				transport.close();

			} catch (NoSuchProviderException e) {
				log.error(e);
				throw new TechnicalException(e);
			} catch (MessagingException e) {
				log.error(e);
				throw new TechnicalException(e);
			}
		}
	}

	/**
	 * Methode permettant de tester la validite du bean
	 * 
	 * @param mailBean
	 *            MailBean
	 * @throws TechnicalException
	 *             Exception de type MailBean
	 */
	private void checkValidityBean(MailBean mailBean) throws TechnicalException {

		if (mailBean.getSourceMail() == null) {
			throw new TechnicalException("Veuillez renseigner la source du mail.");
		}

		if (mailBean.getCorpsMail() == null) {
			throw new TechnicalException("Veuillez renseigner le corps du mail.");
		}

		Collection<String> listeDestinataire = mailBean.getDestinataire();
		if ((listeDestinataire == null) || (listeDestinataire.isEmpty())) {
			throw new TechnicalException("Veuillez renseigner au moins un destinaire.");
		}
	}

}
