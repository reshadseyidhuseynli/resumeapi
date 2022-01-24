/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.inter;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author SRSHD
 */
public abstract class AbstractDAO {

    public Connection connect() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/Resume";
        String username = "root";
        String password = "12345";
        Connection c = DriverManager.getConnection(url, username, password);
        return c;
    }

    private static EntityManagerFactory emf = null;

    public EntityManager createEM() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("resumePU");
        }
        EntityManager em = emf.createEntityManager();
        return em;
    }

    public void closeEmf() {
        emf.close();
        emf = null;
    }
}
