package facades;

import entity.Role;
import security.IUserFacade;
import entity.User;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import security.IUser;
import security.PasswordStorage;

public class UserFacade implements IUserFacade {

    EntityManagerFactory emf;

    public UserFacade(EntityManagerFactory emf) {
        this.emf = emf;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public IUser getUserByUserId(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(User.class, id);
        } finally {
            em.close();
        }
    }

    /*
  Return the Roles if users could be authenticated, otherwise null
     */
    @Override
    public List<String> authenticateUser(String userName, String password) {
        IUser user = getUserByUserId(userName);
        try {
            return user != null && PasswordStorage.verifyPassword(password, user.getPassword()) ? user.getRolesAsStrings() : null;
        } catch (PasswordStorage.CannotPerformOperationException | PasswordStorage.InvalidHashException ex) {
            Logger.getLogger(UserFacade.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public void createUser(String name, String pw) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            User user = new User(name, pw);
            Role role = new Role("User");
            user.addRole(role);
            em.persist(user);
            em.getTransaction().commit();
        } catch (Exception ex) {
            Logger.getLogger(UserFacade.class.getName()).log(Level.SEVERE, null, ex);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

    }

    @Override
    public List<IUser> getUsers() {
        EntityManager em = getEntityManager();

        Query query = em.createQuery("SELECT e from SEED_USER e");

        List<IUser> users = (List<IUser>) query.getResultList();
        em.close();
        return users;
    }

}
