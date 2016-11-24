package utils;

import entity.User;
import facades.UserFacade;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Persistence;
import security.IUser;

/**
 *
 * @author Peter
 */
public class testing {

    public static void main(String[] args) {
        UserFacade fac = new UserFacade(Persistence.createEntityManagerFactory("pu_development"));
        
        List<IUser> users = fac.getUsers();
        
        User user = (User) users.get(0);
        System.out.println(user.getUserName());
        
    }
    
}
