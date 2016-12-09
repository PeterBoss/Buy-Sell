
package test;

import entity.User;
import facades.UserFacade;
import java.util.List;
import javax.persistence.Persistence;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import security.IUser;
import security.PasswordStorage;




public class LoginTest{
    
    
    @Test
    public void LoginTest() throws PasswordStorage.CannotPerformOperationException{
     UserFacade fac = new UserFacade(Persistence.createEntityManagerFactory("buysell"));
        
        List<IUser> users = fac.getUsers();
        String a = "aalf";
        String b = "sha1:64000:18:wiFgXDuxbconnyPJP4v0fglHJiRWTfjy:3b5TpoDbhdTORrMemJf8jBiz";
        User u = new User("aalf", "test");
        System.out.println(u.getPassword());
        
        User user = (User) users.get(0);
        
        assertEquals(a, user.getUserName());
        assertEquals(b, user.getPassword());
//        assertEquals(u.getUserName(), user.getUserName());
//        assertEquals(u.getPassword(), user.getPassword());
    
    }
    
    
}
