package fr.livre.business.exception;

public class BusinessException extends Exception{
	
	public static final long serialVersionUID = 1743243464243L;

	
	/**
	 * Constructeur.<br/>
	 * @param message Message de l'exception.<br/>
	 */
	public BusinessException(String message){
		super(message);
	}
	
	public BusinessException(Throwable e){
		super(e);
	}

}
