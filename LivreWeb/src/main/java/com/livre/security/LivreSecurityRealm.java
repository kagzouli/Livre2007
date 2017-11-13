package com.livre.security;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.securityfilter.realm.SimpleSecurityRealmBase;

import fr.livre.business.common.SpringApplicationContext;
import fr.livre.business.exception.TechnicalException;
import fr.livre.business.user.IUserBusinessService;
import fr.livre.business.user.UserBusinessBean;

public class LivreSecurityRealm extends SimpleSecurityRealmBase{

    /** Logger **/
    private final static Logger LOG = Logger.getLogger(LivreSecurityRealm.class);
    
    private static IUserBusinessService userService = null;

    /**
     * Authenticate a user.
     *
     * Implement this method in a subclass to avoid dealing with Principal objects.
     *
     * @param username a username
     * @param password a plain text password, as entered by the user
     *
     * @return null if the user cannot be authenticated, otherwise a Pricipal object is returned
     */
    public boolean booleanAuthenticate(String username, String password) {
        try {
        	
        	if (StringUtils.isBlank(username) || StringUtils.isBlank(password)){
        		return false;
        	}
        	
            UserBusinessBean user = this.getUserBusinessService().loadUserByLoginPass(username, password);
            return  user != null && !StringUtils.isBlank(user.getLogin());
        }catch (Exception exception) {
            //Erreur technique - On renvoie faux mais il aurait fall
            LOG.error(exception.getMessage(),exception);
            throw new TechnicalException(exception.getMessage());
        }
    }

    /**
     * Test for role membership.
     *
     * Implement this method in a subclass to avoid dealing with Principal objects.
     *
     * @param username The name of the user
     * @param role name of a role to test for membership
     * @return true if the user is in the role, false otherwise
     */
    public boolean isUserInRole(String username, String roleName) {
        boolean isUserInRole = false;
        try {
        	final UserBusinessBean user = this.getUserBusinessService().loadUserByLogin(username);
        
        	isUserInRole = user != null && user.getRole() != null && roleName.equals(user.getRole().getLibelle());
        	
        }catch (Exception exception) {
            //Erreur technique - On renvoie faux mais il aurait fall
            LOG.error(exception.getMessage(),exception);
            throw new TechnicalException(exception.getMessage());
        }
        return isUserInRole;

    }
    
    /**
     * 
     * @return
     */
    private IUserBusinessService getUserBusinessService(){
    	if (userService == null){
    		userService = SpringApplicationContext.getBean(IUserBusinessService.class);
    	}
    	return userService;
    	
    }

}
