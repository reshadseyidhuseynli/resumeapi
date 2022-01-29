/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.main;

import com.company.entity.User;
import com.company.inter.UserDAOInter;
import java.util.List;

/**
 *
 * @author SRSHD
 */
public class Main {

    public static void main(String[] args) throws Exception {
        UserDAOInter userDao = Context.instanceUserDao();
        
        List<User> list = userDao.searchingUsers("Resad", "Seyidhuseynli");
        System.out.println(list);
    }
}
