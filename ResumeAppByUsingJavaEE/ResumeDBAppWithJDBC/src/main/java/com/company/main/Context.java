/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.main;

import com.company.implementation.CountryDAO;
import com.company.implementation.EmploymentHistoryDAO;
import com.company.implementation.SkillDAO;
import com.company.implementation.UserDAO;
import com.company.implementation.UserSkillDAO;
import com.company.inter.CountryDAOInter;
import com.company.inter.EmploymentHistoryDAOInter;
import com.company.inter.SkillDAOInter;
import com.company.inter.UserDAOInter;
import com.company.inter.UserSkillDAOInter;

/**
 *
 * @author SRSHD
 */
public class Context {

    public static UserDAOInter instanceUserDao() {
        return new UserDAO();
    }

    public static UserSkillDAOInter instanceUserSkillDao() {
        return new UserSkillDAO();
    }

    public static EmploymentHistoryDAOInter instanceEmploymentHistoryDao() {
        return new EmploymentHistoryDAO();
    }

    public static CountryDAOInter instanceCountryDao() {
        return new CountryDAO();
    }

    public static SkillDAOInter instanceSkillDao() {
        return new SkillDAO();
    }
}
