package com.company.implementation;

import com.company.entity.EmploymentHistory;
import com.company.entity.User;
import com.company.inter.AbstractDAO;
import com.company.inter.EmploymentHistoryDAOInter;
import javax.persistence.EntityManager;
import java.util.List;

public class EmploymentHistoryDAO extends AbstractDAO implements EmploymentHistoryDAOInter {

    @Override
    public List<EmploymentHistory> getEmploymentHistoryByID(int userID) {
        EntityManager em = createEM();
        User u = em.find(User.class, userID);
        closeEmf();
        return u.getEmploymentHistoryList();
    }
}
