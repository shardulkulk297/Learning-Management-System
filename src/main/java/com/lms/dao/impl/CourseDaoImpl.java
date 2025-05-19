package com.lms.dao.impl;

import com.lms.dao.CourseDao;
import com.lms.model.Course;
import com.lms.model.Track;
import com.lms.service.TrackService;
import com.lms.utility.DBUtil;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
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
        boolean flag = false;
        List<Course> courses = new ArrayList<>();

        try{
            Connection con = DBUtil.getConnection();
            String sql = "Select * FROM Course";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                flag = true;
                Course course = new Course();
                course.setId(rs.getInt("id"));
                course.setTitle(rs.getString("title"));
                course.setFee(rs.getDouble("fee"));
                course.setDiscount(rs.getDouble("discount"));
                course.setPublishDate(LocalDate.parse(rs.getString("publish_date")));

                TrackService service = new TrackService();
                Track track = service.getTrackById(rs.getInt("track_id"));

                course.setTrack(track);
                courses.add(course);
            }

            if(flag){
                System.out.println("Courses Found");
            }
            else{
                System.out.println("No records Found");
            }
            con.close();
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }

        return courses;

    }

    @Override
    public List<Course> getCoursesByTrackId(int id){
        boolean flag = false;
        List<Course> courses = new ArrayList<>();
        try{

            Connection con = DBUtil.getConnection();
            String sql = "Select * from Course WHERE track_id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                flag = true;
                Course course = new Course();
                course.setId(rs.getInt("id"));
                course.setTitle(rs.getString("title"));
                course.setFee(rs.getDouble("fee"));
                course.setDiscount(rs.getDouble("discount"));
                course.setPublishDate(LocalDate.parse(rs.getString("publish_date")));

                TrackService service = new TrackService();
                Track track = service.getTrackById(rs.getInt("track_id"));

                course.setTrack(track);
                courses.add(course);
            }
            if(flag){
                System.out.println("Courses Found");
            }
            else{
                throw new SQLException("No Records Found");
            }
            con.close();

        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return courses;
    }

    public Course getCourseById(int id){
        Course course = null;
        try{
            Connection con = DBUtil.getConnection();
            String sql = "Select * from Course Where id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                course = new Course();
                course.setId(rs.getInt("id"));
                course.setTitle(rs.getString("title"));
                course.setFee(rs.getDouble("fee"));
                course.setDiscount(rs.getDouble("discount"));
                course.setPublishDate(LocalDate.parse(rs.getString("publish_date")));
                TrackService trackService = new TrackService();
                Track track = trackService.getTrackById(rs.getInt("track_id"));
                course.setTrack(track);
                return course;
            }
            else{
                System.out.println("Course not found");
            }

        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return course;
    }



}
