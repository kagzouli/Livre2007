package fr.livre.business.common;

import java.util.Collection;

public class MailBean {

	/**
	 * Source du mail
	 */
	private String sourceMail;

	/**
	 * Mot de passe
	 */
	private String password;

	/**
	 * Smtp mail (Ex : smtp.neuf.fr)
	 */
	private String smtpMail;

	/**
	 * Liste de destinataire
	 */
	private Collection<String> destinataire;

	private Collection<String> destinaireCopie;

	/**
	 * Destinataire cache
	 */
	private Collection<String> destinataireCache;

	/**
	 * Liste de piece jointe
	 */
	private Collection<String> listPieceJointe;

	/**
	 * Titre mail
	 */
	private String titreMail;

	/**
	 * Corps mail
	 */
	private String corpsMail;

	/**
	 * @return
	 */
	public String getCorpsMail() {
		return corpsMail;
	}

	/**
	 * @return
	 */
	public Collection<String> getDestinataire() {
		return destinataire;
	}

	/**
	 * @return
	 */
	public Collection<String> getDestinataireCache() {
		return destinataireCache;
	}

	/**
	 * @return
	 */
	public Collection<String> getListPieceJointe() {
		return listPieceJointe;
	}

	/**
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @return
	 */
	public String getSourceMail() {
		return sourceMail;
	}

	/**
	 * @return
	 */
	public String getTitreMail() {
		return titreMail;
	}

	/**
	 * @param string
	 */
	public void setCorpsMail(String string) {
		corpsMail = string;
	}

	/**
	 * @param collection
	 */
	public void setDestinataire(Collection<String> collection) {
		destinataire = collection;
	}

	/**
	 * @param collection
	 */
	public void setDestinataireCache(Collection<String> collection) {
		destinataireCache = collection;
	}

	/**
	 * @param collection
	 */
	public void setListPieceJointe(Collection<String> collection) {
		listPieceJointe = collection;
	}

	/**
	 * @param string
	 */
	public void setPassword(String string) {
		password = string;
	}

	/**
	 * @param string
	 */
	public void setSourceMail(String string) {
		sourceMail = string;
	}

	/**
	 * @param string
	 */
	public void setTitreMail(String string) {
		titreMail = string;
	}

	/**
	 * @return
	 */
	public String getSmtpMail() {
		return smtpMail;
	}

	/**
	 * @param string
	 */
	public void setSmtpMail(String string) {
		smtpMail = string;
	}

	/**
	 * @return
	 */
	public Collection<String> getDestinaireCopie() {
		return destinaireCopie;
	}

	/**
	 * @param collection
	 */
	public void setDestinaireCopie(Collection<String> collection) {
		destinaireCopie = collection;
	}

}
