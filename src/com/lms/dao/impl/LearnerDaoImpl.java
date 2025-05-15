package com.lms.dao.impl;

import com.lms.dao.LearnerDao;
import com.lms.exception.InvalidIdException;
import com.lms.exception.InvalidInputException;
import com.lms.model.Learner;
import com.lms.utility.DBUtil;
import com.lms.utility.LearnerUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LearnerDaoImpl implements LearnerDao {

    private LearnerUtility learnerUtility = new LearnerUtility();

    @Override
    public List<Learner> getAllLearners() {
        Connection con;
        List<Learner> learners = new ArrayList<>();
        Learner learner = null;
        boolean flag = false;
        try{
            con = DBUtil.getConnection();
            String sql = "Select * FROM Learner";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                flag = true;
                learner = new Learner(rs.getInt("id"), rs.getString("name"), rs.getString("email"));
                learners.add(learner);

            }

            if(flag)
            {
                con.close();
                return learners;
            }
            else{
                System.out.println("No records Found");
            }
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return learners;
    }
    @Override
    public Learner getLearnerById(int id) throws InvalidIdException {
       Connection con;
        Learner learner = null;
       try{
           con = DBUtil.getConnection();
           String sql = "Select * FROM learner WHERE id = ?";
           PreparedStatement stmt = con.prepareStatement(sql);
           stmt.setInt(1, id);
           ResultSet rs = stmt.executeQuery();

           if(rs.next()){
               learner = new Learner(id, rs.getString("name"), rs.getString("email"));
               con.close();
               return learner;

           }
           else{
               throw new InvalidIdException("Id not Found");
           }

       }
       catch(SQLException e)
       {
           System.out.println(e.getMessage());
       }
        return learner;


    }

    @Override
    public void deleteLearnerById(int id) throws InvalidIdException{
        Connection con;

        try{
            con = DBUtil.getConnection();
            String sql = "DELETE FROM Learner WHERE id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            int rowsDeleted = stmt.executeUpdate();

            if(rowsDeleted > 0){
                System.out.println("Deleted Successfully");
            }
            else{
                throw new InvalidIdException("Id not Found");
            }
            con.close();
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }




    }
    @Override
    public Learner updateLearner(int id, Learner learner) throws InvalidIdException, InvalidInputException {
       Connection con;


       try{
           con = DBUtil.getConnection();
           String sql = "UPDATE Learner SET name = ?, email = ? WHERE id = ?";
           PreparedStatement stmt = con.prepareStatement(sql);
           stmt.setString(1, learner.getName());
           stmt.setString(2, learner.getEmail());
           stmt.setInt(3, id);
           int rowsUpdated = stmt.executeUpdate();

           if(rowsUpdated > 0){
               System.out.println("Updated Successfully");
           }
           else{
               throw new InvalidIdException("Id not Found");
           }
           con.close();
           return learner;
       }
       catch(SQLException e)
       {
           System.out.println(e.getMessage());
       }
       return learner;

    }

    @Override
    public void insertLearner(Learner learner) throws InvalidInputException{

        Connection con;

        try{
            con = DBUtil.getConnection();
            String sql = "INSERT into Learner (name, email) VALUES(?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, learner.getName());
            stmt.setString(2, learner.getEmail());
            int rowsAdded = stmt.executeUpdate();

            if(rowsAdded > 0){
                System.out.println("Inserted Successfully");
            }
            else{
                throw new InvalidInputException("Invalid Input");
            }
            con.close();
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }

    }





}
