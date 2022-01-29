package com.company.implementation;

import com.company.entity.Skill;
import com.company.inter.AbstractDAO;
import com.company.inter.SkillDAOInter;
import javax.persistence.EntityManager;
import java.util.List;

public class SkillDAO extends AbstractDAO implements SkillDAOInter {

    @Override
    public List<Skill> getAllSkill() {
        EntityManager em = createEM();
        List<Skill> result = em.createQuery("SELECT s from Skill s", Skill.class).getResultList();
        closeEmf();
        return result;
    }

}
