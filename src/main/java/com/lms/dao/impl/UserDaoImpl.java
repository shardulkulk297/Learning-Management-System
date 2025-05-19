package com.lms.dao.impl;

import com.lms.dao.UserDao;
import com.lms.exception.UserNotFoundException;
import com.lms.model.User;
import com.lms.utility.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {

    @Override
    public void signUp(User user) {

        try{
            Connection con = DBUtil.getConnection();
            String sql = "INSERT INTO user(username, password, role) VALUES(?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getRole());
            int rowsAdded = stmt.executeUpdate();
            if(rowsAdded > 0){
                System.out.println("User Signed Up Successfully");
            }
            else{
                throw new SQLException("Insert Failed");
            }
            con.close();
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }


    }

    @Override
    public boolean signIn(String username, String password) throws UserNotFoundException{

        try{
            Connection con = DBUtil.getConnection();
            String sql = "SELECT * FROM user WHERE username = ? AND password = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                return true;
            }
            else{
                return false;
            }

        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }


    return false;

    }

    @Override
    public User getUserByUsername(String username) throws UserNotFoundException {
        User user = null;
        try{
            Connection con = DBUtil.getConnection();
            String sql = "SELECT * FROM user WHERE username = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, username);

            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
                return user;
            }
            else{
                throw new UserNotFoundException("User not found");
            }
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public boolean isUsernameAvailable(String username) {
        return false;
    }



}
