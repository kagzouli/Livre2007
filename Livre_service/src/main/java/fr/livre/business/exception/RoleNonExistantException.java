package fr.livre.business.exception;

/**
 * Exception pour signaler qu'un role n'existe pas.<br/>
 * @author GZOULI
 *
 */
public class RoleNonExistantException extends BusinessException{

	/**
	 * SerialVersionUID.<br/>
	 */
	private static final long serialVersionUID = 12334332512143L;

	
	public RoleNonExistantException(String message) {
		super(message);
	}
	
	public RoleNonExistantException(Throwable e) {
	
		super(e);
	}

}
