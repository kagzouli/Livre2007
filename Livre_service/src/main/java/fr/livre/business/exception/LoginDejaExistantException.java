package fr.livre.business.exception;

/**
 * Exception permettant de signaler que le login existe deja.<br/>
 * @author GZOULI
 *
 */
public class LoginDejaExistantException extends BusinessException{

	/**
	 * SerialVersionUID.<br/>
	 */
	private static final long serialVersionUID = 12234332212133L;

	
	public LoginDejaExistantException(String message) {
		super(message);
	}
	
	public LoginDejaExistantException(Throwable e) {
		super(e);
	}
}
