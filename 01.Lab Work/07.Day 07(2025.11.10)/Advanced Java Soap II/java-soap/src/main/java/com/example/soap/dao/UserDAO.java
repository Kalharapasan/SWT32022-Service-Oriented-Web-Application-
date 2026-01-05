package com.example.soap.dao;

import com.example.soap.entity.User;
import javax.persistence.*;
import java.util.List;

public class UserDAO {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("UserPU");

    public List<User> getAllUsers() {
        EntityManager em = emf.createEntityManager();
        List<User> users = em.createQuery("SELECT u FROM User u", User.class).getResultList();
        em.close();
        return users;
    }

    public User getUserById(int id) {
        EntityManager em = emf.createEntityManager();
        User user = em.find(User.class, id);
        em.close();
        return user;
    }

    public void createUser(User user) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        em.close();
    }

    public void updateUser(User user) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();
        em.close();
    }

    public void deleteUser(int id) {
        EntityManager em = emf.createEntityManager();
        User user = em.find(User.class, id);
        if(user != null){
            em.getTransaction().begin();
            em.remove(user);
            em.getTransaction().commit();
        }
        em.close();
    }
}
