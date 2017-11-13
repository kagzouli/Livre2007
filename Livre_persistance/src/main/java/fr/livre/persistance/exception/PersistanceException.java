package fr.livre.persistance.exception;

public class PersistanceException extends Exception{
	
	public static final long serialVersionUID = 12433436669743L;

	
	/**
	 * Constructeur.<br/>
	 * @param message Message de l'exception.<br/>
	 */
	public PersistanceException(String message){
		super(message);
	}
	
	public PersistanceException(Throwable e){
		super(e);
	}

}
