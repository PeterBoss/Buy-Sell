
package test;

import entity.User;
import facades.UserFacade;
import java.util.List;
import javax.persistence.Persistence;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import security.IUser;




public class LoginTest{
    
    
    @Test
    public void LoginTest(){
     UserFacade fac = new UserFacade(Persistence.createEntityManagerFactory("buysell"));
        
        List<IUser> users = fac.getUsers();
        String a = "abe";
        String b = "sha1:64000:18:MbevnM6DYZBvpkhTa2m8m363804m/zjh:fYwBgB1hjDZIU+OUuX9LahMc";

        User user = (User) users.get(0);
        System.out.println(user.getUserName());
        

        assertEquals(a, user.getUserName());
        assertEquals(b, user.getPassword());
    
    }
    
    
}
