package com.company.dao;

import com.company.entity.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

@Repository()
public class UserRepositoryCustomImpl implements UserRepositoryCustom {

    @PersistenceContext
    EntityManager em;
    
    @Override
    public User getUserByID(int userId) {
        User u = em.find(User.class, userId);
        return u;
    }

    @Override
    public User getUserByEmail(String email) {
        Query q = em.createQuery("select u from User u where u.email=:e", User.class);
        q.setParameter("e", email);
        List<User> list = q.getResultList();
        if (list.size() == 1) {
            User result = list.get(0);
            return result;
        } else {
            return null;
        }
    }

    @Override
    public List<User> getAll() {
        Query q = em.createQuery("select u from User u", User.class);
        List<User> list = q.getResultList();
        return list;
    }

    @Override
    public List<User> searchingUsers(String name, String surname) {
        String jpql = "select u from User u where 1=1";
        if (name != null && !name.trim().isEmpty()) {
            jpql += " and u.name = :n";
        }
        if (surname != null && !surname.trim().isEmpty()) {
            jpql += " and u.surname = :sn";
        }

        Query q = em.createQuery(jpql, User.class);
        if (name != null && !name.trim().isEmpty()) {
            q.setParameter("n", name);
        }
        if (surname != null && !surname.trim().isEmpty()) {
            q.setParameter("sn", surname);
        }

        List<User> list = q.getResultList();
        return list;
    }

    @Override
    public boolean update(User u) {
        em.merge(u);
        return true;
    }

    @Override
    public boolean delete(int userId) {
        User u = em.find(User.class, userId);
        em.remove(u);
        return true;
    }

    @Override
    public boolean addUser(User u) {
        em.getTransaction().begin();
        em.persist(u);
        em.getTransaction().commit();
        return true;
    }
}
