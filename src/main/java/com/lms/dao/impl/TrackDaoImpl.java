package com.lms.dao.impl;

import com.lms.dao.TrackDao;
import com.lms.model.Track;
import com.lms.utility.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    public List<Track> getAllTracks(){
        Track track = null;
        List<Track> tracks = null;
        boolean flag = false;
        try{
            Connection con = DBUtil.getConnection();
            String sql = "Select * FROM Track";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                flag = true;
                track = new Track(rs.getInt("id"), rs.getString("name"));
                tracks = new ArrayList<>();
                tracks.add(track);
            }
            if(flag)
            {
                con.close();
            }
            else{
                System.out.println("No records Found");
            }

        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }

        return tracks;
    }

    @Override
    public Track getTrackById(int trackId){
        Track track = null;
        try{

            Connection con = DBUtil.getConnection();
            String sql = "Select * from Track WHERE id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, trackId);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                track = new Track(trackId, rs.getString("name"));
                con.close();
                return track;
            }
            else{
                throw new SQLException("No Records Found");
            }

        }

        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return track;
    }



}
