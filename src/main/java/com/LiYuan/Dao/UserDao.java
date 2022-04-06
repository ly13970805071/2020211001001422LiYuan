package com.LiYuan.Dao;

import com.LiYuan.Model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDao implements IUserDao {
    String sql = "";
    PreparedStatement ps = null;
    ResultSet rs = null;

    @Override
    public boolean saveUser(Connection con, User user) throws SQLException {
        //insert ... into usertable
        sql = "insert into usertable values(?,?,?,?,?,?)";
        ps = con.prepareStatement(sql);
        ps.setInt(1, user.getId());
        ps.setString(2, user.getUsername());
        ps.setString(3, user.getPassword());
        ps.setString(4, user.getEmail());
        ps.setString(5, user.getGender());
        ps.setDate(6, (java.sql.Date) user.getBirthdate());
        ps.executeUpdate();
        return true;
    }

    @Override
    public int deleteUser(Connection con, User user) throws SQLException {
        //delete ... where id=?
        sql = "delete from usertable where id=?";
        ps = con.prepareStatement(sql);
        ps.setInt(1, user.getId());
        ps.executeUpdate();
        return 1;
    }

    @Override
    public int updateUser(Connection con, User user) throws SQLException {
        //update ... set ... where id=?
        sql = "update usertable set username=?,password=?,email=?,gender=?,birthdate=? where id=?";
        ps = con.prepareStatement(sql);
        ps.setString(1, user.getUsername());
        ps.setString(2, user.getPassword());
        ps.setString(3, user.getEmail());
        ps.setString(4, user.getGender());
        ps.setDate(5, (java.sql.Date) user.getBirthdate());
        ps.setInt(6, user.getId());
        ps.executeUpdate();
        return 1;
    }

    @Override
    public User findById(Connection con, Integer id) throws SQLException {
        //select ... where id = ?
        sql = "select * from usertable where id=?";
        ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        rs = ps.executeQuery();
        User user = new User();
        if (rs.next()) {
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
        }
        return user;
    }

    @Override
    public User findByUsernamePassword(Connection con, String username, String password) throws SQLException {
        //user for login
        //select ... where username = ? and password = ?
        sql = "select * from usertable where username=? and password=?";
        ps = con.prepareStatement(sql);
        ps.setString(1, username);
        ps.setString(2, password);
        rs = ps.executeQuery();
        User user = new User();
        if (rs.next()) {
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
        }
        return user;
    }

    @Override
    public List<User> findByUsername(Connection con, String username) throws SQLException {
        //select ... where username = ?
        sql = "select * from usertable where username=?";
        return select(con, sql, username);
    }

    @Override
    public List<User> findByPassword(Connection con, String password) throws SQLException {
        //select ... where password = ?
        sql = "select * from usertable where password=?";
        return select(con, sql, password);
    }

    @Override
    public List<User> findByEmail(Connection con, String email) throws SQLException {
        //select ... where email = ?
        sql = "select * from usertable where email=?";
        return select(con, sql, email);
    }

    @Override
    public List<User> findByGender(Connection con, String gender) throws SQLException {
        //select ... where gender = ?
        sql = "select * from usertable where gender=?";
        return select(con, sql, gender);
    }

    @Override
    public List<User> findByBirthdate(Connection con, Date birthDate) throws SQLException {
        //select ... where birthdate = ?
        List<User> list = new ArrayList<User>();

        sql = "select * from usertable where birthdate=?";
        ps = con.prepareStatement(sql);
        ps.setDate(1, (java.sql.Date) birthDate);
        rs = ps.executeQuery();
        while (rs.next()) {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
            list.add(user);
        }
        return list;
    }

    @Override
    public List<User> findAllUser(Connection con) throws SQLException {
        //select * from usertable
        List<User> list = new ArrayList<User>();

        sql = "select * from usertable";
        Statement stmt = con.createStatement();
        rs = stmt.executeQuery(sql);
        while (rs.next()) {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
            list.add(user);
        }
        return list;
    }

    private List<User> select(Connection con, String sql, String s) throws SQLException {
        List<User> list = new ArrayList<User>();

        ps = con.prepareStatement(sql);
        ps.setString(1, s);
        rs = ps.executeQuery();
        while (rs.next()) {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
            list.add(user);
        }
        return list;
    }
}
