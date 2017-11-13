package fr.livre.business.exception;

public class TechnicalException extends RuntimeException{
	
	public static final long serialVersionUID = 17432335664743L;

	
	/**
	 * Constructeur.<br/>
	 * @param message Message de l'exception.<br/>
	 */
	public TechnicalException(String message){
		super(message);
	}
	
	public TechnicalException(Throwable e){
		super(e);
	}
}
