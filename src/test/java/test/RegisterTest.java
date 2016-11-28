


package test;

import entity.Role;
import entity.User;
import facades.UserFacade;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import org.junit.Test;


public class RegisterTest {
    
    
    
    
    @Test
    public void testRegister(){
    EntityManager em = Persistence.createEntityManagerFactory("buysell").createEntityManager();
    try {
      System.out.println("Creating TEST Users");
      if (em.find(User.class, "user") == null) {
        em.getTransaction().begin();
        
        Role userRole = new Role("User");
        Role adminRole = new Role("Admin");
        
        User user = new User("user", "test");
        user.addRole(userRole);
        
        User admin = new User("admin", "test");
        admin.addRole(adminRole);
        
        User both = new User("user_admin", "test");
        both.addRole(userRole);
        both.addRole(adminRole);
        
        em.persist(userRole);
        em.persist(adminRole);
        em.persist(user);
        em.persist(admin);
        em.persist(both);
        em.getTransaction().commit();
        System.out.println("Created TEST Users");
      }
    } catch (Exception ex) {
      Logger.getLogger(UserFacade.class.getName()).log(Level.SEVERE, null, ex);
      em.getTransaction().rollback();
    } finally {
      em.close();
    }
    
    }
    
}
