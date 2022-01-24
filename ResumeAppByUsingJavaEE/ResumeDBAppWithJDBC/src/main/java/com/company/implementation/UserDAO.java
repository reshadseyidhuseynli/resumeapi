package com.company.implementation;

import com.company.entity.Country;
import com.company.entity.User;
import com.company.inter.AbstractDAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.company.inter.UserDAOInter;

public class UserDAO extends AbstractDAO implements UserDAOInter {

    private User getUser(ResultSet rs) throws Exception {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String surname = rs.getString("surname");
        String email = rs.getString("email");
        String phone = rs.getString("phone");
        String profileDescription = rs.getString("profile_description");
        String address = rs.getString("address");
        Date birthdate = rs.getDate("birthdate");
        int countryId = rs.getInt("country_id");
        int nationalityId = rs.getInt("nationality_id");
        String password = rs.getString("password");
        String countryName = rs.getString("country_name");
        String nationality = rs.getString("nationality");

        Country countryNameObj = new Country(countryId, countryName, null);
        Country nationalityObj = new Country(nationalityId, null, nationality);

        return new User(id, name, surname, email, phone, profileDescription, address, birthdate,
                countryId, nationalityId, password, countryNameObj, nationalityObj);
    }

    private User getUserSimple(ResultSet rs) throws Exception {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String surname = rs.getString("surname");
        String email = rs.getString("email");
        String phone = rs.getString("phone");
        String profileDescription = rs.getString("profile_description");
        String address = rs.getString("address");
        Date birthdate = rs.getDate("birthdate");
        int countryId = rs.getInt("country_id");
        int nationalityId = rs.getInt("nationality_id");
        String password = rs.getString("password");
        
        return new User(id, name, surname, email, phone, profileDescription, address, birthdate,
                countryId, nationalityId, password, null, null);
    }
    
    @Override
    public User getUserByID(int userID) {
        try (Connection c = connect()) {
            Statement stmt = c.createStatement();
            stmt.execute("SELECT"
                    + "	u.*,"
                    + "	c.name as country_name,"
                    + "	n.nationality "
                    + " FROM"
                    + "	USER u"
                    + "	LEFT JOIN country c ON u.country_id = c.id"
                    + "	LEFT JOIN country n ON u.nationality_id = n.id"
                    + " where u.id = " + userID);
            ResultSet rs = stmt.getResultSet();
            rs.next();
            return getUser(rs);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public User getUserByEmail(String email) {
        User result = null;
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("select * from user where email = ?");
            stmt.setString(1, email);
            stmt.executeQuery();
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                result = getUserSimple(rs);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public List<User> getAll() {
        List<User> result = new ArrayList<>();
        try (Connection c = connect()) {
            Statement stmt = c.createStatement();
            stmt.execute("SELECT"
                    + "	u.*,"
                    + "	c.name as country_name,"
                    + "	n.nationality"
                    + " FROM"
                    + "	USER u"
                    + "	LEFT JOIN country c ON u.country_id = c.id"
                    + "	LEFT JOIN country n ON u.nationality_id = n.id");
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                User u = getUser(rs);
                result.add(u);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public List<User> searchingUsers(String name, String surname) {
        List<User> result = new ArrayList<>();

        try (Connection c = connect()) {
            String sql = "SELECT"
                    + " u.*,"
                    + " c.name as country_name,"
                    + " n.nationality"
                    + " FROM"
                    + " USER u"
                    + " LEFT JOIN country c ON u.country_id = c.id"
                    + " LEFT JOIN country n ON u.nationality_id = n.id where 1=1";

            if (name != null && !name.trim().isEmpty()) {
                sql += " and u.name = ?";
            }
            if (surname != null && !surname.trim().isEmpty()) {
                sql += " and u.surname = ?";
            }

            PreparedStatement stmt = c.prepareStatement(sql);

            int i = 1;
            if (name != null && !name.trim().isEmpty()) {
                stmt.setString(i, name);
                i++;
            }
            if (surname != null && !surname.trim().isEmpty()) {
                stmt.setString(i, surname);
            }

            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                User u = getUser(rs);
                result.add(u);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean update(User u) {
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("update user set name = ?, surname = ?, email = ?, phone = ?, profile_description = ?, address = ?, birthdate = ? where id = ?");
            stmt.setString(1, u.getName());
            stmt.setString(2, u.getSurname());
            stmt.setString(3, u.getEmail());
            stmt.setString(4, u.getPhone());
            stmt.setString(5, u.getProfileDescription());
            stmt.setString(6, u.getAddress());
            stmt.setDate(7, u.getBirthDate());
            stmt.setInt(8, u.getId());

            return stmt.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        try (Connection c = connect()) {
            Statement stmt = c.createStatement();
            return stmt.execute("delete from user where id = " + id);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addUser(User u) {
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareCall("insert into user(name,"
                    + " surname,"
                    + " email,"
                    + " phone,"
                    + " profile_description,"
                    + " address,"
                    + " birthdate,"
                    + " country_id,"
                    + " nationality_id)"
                    + " values(?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, u.getName());
            stmt.setString(2, u.getSurname());
            stmt.setString(3, u.getEmail());
            stmt.setString(4, u.getPhone());
            stmt.setString(5, u.getProfileDescription());
            stmt.setString(6, u.getAddress());
            stmt.setDate(7, u.getBirthDate());
            stmt.setInt(8, u.getCountryId());
            stmt.setInt(9, u.getNationalityId());
            return stmt.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
