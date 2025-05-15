package com.lms.dao;

import com.lms.model.Track;

import java.util.List;

public interface TrackDao {

    public void insert(Track track);
    public List<Track> getAllTracks();
    public Track getTrackById(int trackId);
//    public Track getTrackById(int id);
}
