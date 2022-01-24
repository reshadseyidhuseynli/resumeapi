package com.company.service.implementation;

import com.company.dao.UserRepository;
import com.company.entity.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.company.service.inter.UserServiceInter;

@Service()
@Transactional
public class UserService implements UserServiceInter {

    @Autowired
    private UserRepository userDao;

    @Override
    public User getUserByID(int userId) {
        return userDao.getUserByID(userId);
    }

    @Override
    public User getUserByEmail(String email) {
        return userDao.getUserByEmail(email);
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public List<User> searchingUsers(String name, String surname) {
        return userDao.searchingUsers(name, surname);
    }

    @Override
    public boolean update(User u) {
        return userDao.update(u);
    }

    @Override
    public boolean delete(int userId) {
        return userDao.delete(userId);
    }

    @Override
    public boolean addUser(User u) {
        return userDao.addUser(u);
    }
}
