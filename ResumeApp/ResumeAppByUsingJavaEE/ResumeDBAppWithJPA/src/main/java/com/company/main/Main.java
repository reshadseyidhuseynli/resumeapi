/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mycompany.main;

import com.company.inter.UserDAOInter;

/**
 *
 * @author SRSHD
 */
public class Main {

    public static void main(String[] args) throws Exception {
        UserDAOInter userDao = Context.instanceUserDao();
        
        System.out.println(userDao.getUserByID(1).getEmail());
        
    }
}
