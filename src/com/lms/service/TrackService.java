package com.lms.service;

import com.lms.dao.TrackDao;
import com.lms.dao.impl.TrackDaoImpl;
import com.lms.model.Track;

import java.util.List;

public class TrackService {

    TrackDao trackDao = new TrackDaoImpl();

    public void insertTrack(Track track){
        trackDao.insert(track);
    }

    public List<Track> getAllTracks(){
        return trackDao.getAllTracks();
    }
    public Track getTrackById(int id){
        return trackDao.getTrackById(id);
    }


}
