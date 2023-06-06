package utils;

import entities.Guide;
import entities.Role;
import entities.Trip;
import entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Tester {

  public static void main(String[] args) {

    EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
    EntityManager em = emf.createEntityManager();

    User user = new User("user", "test", "gadevej", "12345678", "mail.com", "2000", "human");
    User admin = new User("admin", "test", "vejgade", "23456789", "mail.com", "2001", "human");

    Role userRole = new Role("user");
    Role adminRole = new Role("admin");

    Guide g1 = new Guide("Hans", "Human", "12/12/1985", "Profile1", "Image");
    Guide g2 = new Guide("Ben", "Human", "12/12/1985", "Profile2", "Image");

    Trip t1 = new Trip("Around Copenhagen", "06/06/2020", "12:00", "Rådhuspladsen", "4 hours", "PackingList");
    Trip t2 = new Trip("Around Aarhus", "06/06/2020", "13:00", "Rådhuspladsen", "5 hours", "PackingList");

    em.getTransaction().begin();
    user.addRole(userRole);
    admin.addRole(adminRole);

    t1.addUsers(user);
    t1.addGuide(g1);
    t2.addUsers(admin);
    t2.addGuide(g2);

    em.persist(user);
    em.persist(admin);
    em.persist(userRole);
    em.persist(adminRole);
    em.persist(g1);
    em.persist(g2);
    em.persist(t1);
    em.persist(t2);

    em.getTransaction().commit();




   
  }

}
