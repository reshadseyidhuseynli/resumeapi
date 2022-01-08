/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.implementation;

import com.company.entity.Country;
import com.company.inter.AbstractDAO;
import com.company.inter.CountryDAOInter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SRSHD
 */
public class CountryDAO extends AbstractDAO implements CountryDAOInter {

    private Country getCountry(ResultSet rs) throws Exception {
        int id = rs.getInt("id");
        String countryName = rs.getString("name");
        String nationality = rs.getString("nationality");
        return new Country(id, countryName, nationality);
    }

    @Override
    public List<Country> getAllCountry() {
        List<Country> result = new ArrayList<>();
        try (Connection c = connect()) {
            Statement stmt = c.createStatement();
            stmt.execute("SELECT * FROM country");
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                Country cty = getCountry(rs);
                result.add(cty);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

}
