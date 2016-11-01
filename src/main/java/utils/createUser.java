package utils;

import facades.UserFacade;
import javax.persistence.Persistence;

/**
 *
 * @author Peter
 */
public class createUser {

    public static void main(String[] args) {
        UserFacade fac = new UserFacade(Persistence.createEntityManagerFactory("pu_development"));
    }
    
}
