package com.company.implementation;

import com.company.entity.User;
import com.company.inter.AbstractDAO;
import java.util.List;
import com.company.inter.UserDAOInter;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class UserDAO extends AbstractDAO implements UserDAOInter {

    @Override
    public User getUserByID(int userId) {
        EntityManager em = createEM();

        User u = em.find(User.class, userId);

        closeEmf();
        return u;
    }

    @Override
    public User getUserByEmail(String email) {
        EntityManager em = createEM();
        Query q = em.createQuery("select u from User u where u.email=:e", User.class);
        q.setParameter("e", email);
        List<User> list = q.getResultList();
        closeEmf();
        if (list.size() == 1) {
            User result = list.get(0);
            return result;
        } else {
            return null;
        }
    }

    @Override
    public List<User> getAll() {
        EntityManager em = createEM();
        Query q = em.createQuery("select u from User u", User.class);
        List<User> list = q.getResultList();
        closeEmf();
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

        EntityManager em = createEM();
        Query q = em.createQuery(jpql, User.class);
        if (name != null && !name.trim().isEmpty()) {
            q.setParameter("n", name);
        }
        if (surname != null && !surname.trim().isEmpty()) {
            q.setParameter("sn", surname);
        }

        List<User> list = q.getResultList();
        closeEmf();
        return list;
    }

    @Override
    public boolean update(User u) {
        EntityManager em = createEM();

        em.getTransaction().begin();
        em.merge(u);
        em.getTransaction().commit();

        closeEmf();
        return true;
    }

    @Override
    public boolean delete(int userId) {
        EntityManager em = createEM();

        User u = em.find(User.class, userId);

        em.getTransaction().begin();
        em.remove(u);
        em.getTransaction().commit();

        closeEmf();
        return true;
    }

    @Override
    public boolean addUser(User u) {
        EntityManager em = createEM();

        em.getTransaction().begin();
        em.persist(u);
        em.getTransaction().commit();

        closeEmf();
        return true;
    }
}
