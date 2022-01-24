/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.implementation;

import com.company.entity.Skill;
import com.company.inter.AbstractDAO;
import com.company.inter.SkillDAOInter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SRSHD
 */
public class SkillDAO extends AbstractDAO implements SkillDAOInter {

    private Skill getSkill(ResultSet rs) throws Exception {
        int id = rs.getInt("id");
        String skillName = rs.getString("name");
        return new Skill(id, skillName);
    }

    @Override
    public List<Skill> getAllSkill() {
        List<Skill> result = new ArrayList<>();
        try (Connection c = connect()) {
            Statement stmt = c.createStatement();
            stmt.execute("SELECT * FROM skill");
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                Skill s = getSkill(rs);
                result.add(s);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

}
