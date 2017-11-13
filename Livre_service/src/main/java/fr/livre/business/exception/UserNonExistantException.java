package fr.livre.business.exception;

/**
 * Exception pour signaler qu'un utilisateur n'existe pas.<br/>
 * @author GZOULI
 *
 */
public class UserNonExistantException extends BusinessException{

	/**
	 * SerialVersionUID.<br/>
	 */
	private static final long serialVersionUID = 15334312592143L;

	
	public UserNonExistantException(String message) {
		super(message);
	}
	
	public UserNonExistantException(Throwable e) {
	
		super(e);
	}


}
