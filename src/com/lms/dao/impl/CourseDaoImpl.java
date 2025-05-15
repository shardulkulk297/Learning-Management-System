package com.lms.dao.impl;

import com.lms.dao.CourseDao;
import com.lms.model.Course;
import com.lms.utility.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.List;

public class CourseDaoImpl implements CourseDao {

    @Override
    public void insert(Course course, int trackId){

        try{
            Connection con = DBUtil.getConnection();
            String sql = "INSERT Into Course(title, fee, discount, publish_date, track_id) VALUES(?,?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, course.getTitle());
            stmt.setDouble(2, course.getFee());
            stmt.setDouble(3, course.getDiscount());
            stmt.setString(4, course.getPublishDate().toString());
            stmt.setInt(5, trackId);

            int rowsAdded = stmt.executeUpdate();
            if(rowsAdded > 0){
                System.out.println("Inserted Successfully");
            }
            else {
                throw new SQLException("Insert Failed");
            }
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }



    }

    @Override
    public List<Course> getAllCourses(){
        return null;
    }

    @Override
    public Course getCourseByTrackId(int id){
        return null;
    }



}
