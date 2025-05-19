package com.lms.dao.impl;

import com.lms.dao.EnrollDao;
import com.lms.model.Enroll;
import com.lms.utility.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EnrollDaoImpl implements EnrollDao {

    @Override
    public void insertEnroll(Enroll enroll){

        try{
            Connection con = DBUtil.getConnection();
            String sql = "Insert into Enroll(learner_id, course_id, coupon_used, date_of_enroll, fee_paid) VALUES(?,?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, enroll.getLearner().getId());
            stmt.setInt(2, enroll.getCourse().getId());
            stmt.setString(3, enroll.getCouponUsed());
            stmt.setString(4, enroll.getEnrollDate().toString());
            stmt.setDouble(5, enroll.getFeePaid());
            int rowsAdded = stmt.executeUpdate();
            if(rowsAdded > 0){
                System.out.println("Enrolled to the course: " + enroll.getCourse().getTitle() + " successfully");
            }
            else{
                throw new SQLException("Insert Failed");
            }
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }

    }

}
