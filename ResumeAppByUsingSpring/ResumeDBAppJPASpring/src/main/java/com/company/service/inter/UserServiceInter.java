/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.service.inter;

import com.company.entity.User;
import java.util.List;


public interface UserServiceInter {

    public User getUserByID(int userID);
    
    public User getUserByEmail(String email);

    public List<User> getAll();

    public List<User> searchingUsers(String name, String surname);

    public boolean addUser(User u);

    public boolean update(User u);

    public boolean delete(int id);

}
