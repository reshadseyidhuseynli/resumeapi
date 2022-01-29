package com.company.implementation;

import com.company.entity.User;
import com.company.entity.UserSkill;
import com.company.inter.AbstractDAO;
import com.company.inter.UserSkillDAOInter;
import javax.persistence.EntityManager;
import java.util.List;

public class UserSkillDAO extends AbstractDAO implements UserSkillDAOInter {

    @Override
    public List<UserSkill> getUserSkillByID(int userId) {
        EntityManager em = createEM();
        User u = em.find(User.class, userId);
        List<UserSkill> result = u.getUserSkillList();
        closeEmf();
        return result;
    }
}
