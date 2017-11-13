package fr.livre.business.common;

import java.util.ResourceBundle;

public class MailRessource {

	/**
	 * Cle Nom du mail.<br/>
	 */
	public static final String DEFAULT_KEY_MAIL_NAME = "mail.name";

	/**
	 * Cle login du mail.<br/>
	 */
	public static final String DEFAULT_KEY_MAIL_LOGIN = "mail.login";
	
	/**
	 * Cle mot de passe du mail.<br/>
	 */
	public static final String DEFAULT_KEY_MAIL_PASSWORD = "mail.password";


	/**
	 * Bundle du mail.<br/>
	 */
	private static final String DEFAULT_BUNDLE = "mail";
	
	private ResourceBundle bundle;
	
	/**
	 * Ressource mail.<br/>
	 */
      private static MailRessource mailRessource = new MailRessource();
      
      /**
		 * Constructeur.<br/>
		 */
      private MailRessource(){
    	  bundle = ResourceBundle.getBundle(DEFAULT_BUNDLE);
      }
      
      public static MailRessource getMailRessource(){
    	  return mailRessource;
      }
      
      public String getParameter(String keyParameter){
    	  return bundle.getString(keyParameter);
      }

}
