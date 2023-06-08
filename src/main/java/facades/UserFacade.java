package facades;

import entities.Role;
import entities.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import security.errorhandling.AuthenticationException;

/**
 * @author lam@cphbusiness.dk
 */
public class UserFacade {

    private static EntityManagerFactory emf;
    private static UserFacade instance;

    private UserFacade() {
    }

    /**
     *
     * @param _emf
     * @return the instance of this facade.
     */
    public static UserFacade getUserFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new UserFacade();
        }
        return instance;
    }

    public User getVerifiedUser(String username, String password) throws AuthenticationException {
        EntityManager em = emf.createEntityManager();
        User user;
        try {
            user = em.find(User.class, username);
            if (user == null || !user.verifyPassword(password)) {
                throw new AuthenticationException("Invalid user name or password");
            }
        } finally {
            em.close();
        }
        return user;
    }

    public User createUser(User user) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return user;
    }

    public User addUser(String username, String password, String address, String phone, String email, String birthyear, String gender) {
        EntityManager em = emf.createEntityManager();
        User user = new User(username, password, address, phone, email, birthyear, gender);
        Role role = new Role("user");
        user.addRole(role);
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        em.close();

        return user;
    }

    public User deleteUser(String username) {
        EntityManager em = emf.createEntityManager();
        User user = em.find(User.class, username);

        em.getTransaction().begin();
        em.remove(user);
        em.getTransaction().commit();
        em.close();
        return user;
    }

    public User getUser(String username) {
        EntityManager em = emf.createEntityManager();
        User user = em.find(User.class, username);
        em.close();
        return user;
    }

}
