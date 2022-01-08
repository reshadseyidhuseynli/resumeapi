/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.implementation;

import com.company.entity.Skill;
import com.company.entity.User;
import com.company.entity.UserSkill;
import com.company.inter.AbstractDAO;
import com.company.inter.UserSkillDAOInter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SRSHD
 */
public class UserSkillDAO extends AbstractDAO implements UserSkillDAOInter {

    private UserSkill getUserSkill(ResultSet rs) throws Exception {
        int userId = rs.getInt("id");
        int skillId = rs.getInt("skill_id");
        String skillName = rs.getString("skill_name");
        int power = rs.getInt("power");

        User u = new User(userId);
        Skill s = new Skill(skillId, skillName);

        return new UserSkill(null, power, u, s);
    }

    @Override
    public List<UserSkill> getUserSkillByID(int userId) {
        List<UserSkill> result = new ArrayList<>();
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("SELECT u.*, s.id AS skill_id, s.name AS skill_name, us.power FROM user u"
                    + " LEFT JOIN user_skill us ON u.id = us.user_id"
                    + " LEFT JOIN skill s ON us.skill_id = s.id"
                    + " WHERE u.id = ?");
            stmt.setInt(1, userId);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                UserSkill us = getUserSkill(rs);
                result.add(us);
            }
        } catch (Exception ex) {
        }
        return result;
    }
}
