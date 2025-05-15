package com.lms.dao.impl;

import com.lms.dao.TrackDao;
import com.lms.model.Track;
import com.lms.utility.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TrackDaoImpl implements TrackDao {

    @Override
    public void insert(Track track)
    {
        try{
            Connection con = DBUtil.getConnection();
            String sql = "INSERT Into Track (name) VALUES(?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, track.getName());
            int rowsAdded = stmt.executeUpdate();
            if(rowsAdded > 0){
                System.out.println("Inserted Successfully");
            }
            else{
                throw new SQLException("Insert Failed");
            }
            con.close();
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public Track getAllTracks(){
        Track track = null;
        boolean flag = false;
        try{
            Connection con = DBUtil.getConnection();
            String sql = "Select * FROM Track";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                flag = true;
                track = new Track(rs.getInt("id"), rs.getString("name"));
            }
            if(flag)
            {
                con.close();
                return track;
            }
            else{
                System.out.println("No records Found");
            }

        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }

        return track;
    }



}
