/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao;

import com.company.entity.EmploymentHistory;
import java.util.List;

/**
 *
 * @author SRSHD
 */
public interface EmploymentHistoryDAOInter {

    public List<EmploymentHistory> getEmploymentHistoryByID(int userID);
}
