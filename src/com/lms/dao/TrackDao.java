package com.lms.dao;

import com.lms.model.Track;

public interface TrackDao {

    public void insert(Track track);
    public Track getAllTracks();
//    public Track getTrackById(int id);
}
