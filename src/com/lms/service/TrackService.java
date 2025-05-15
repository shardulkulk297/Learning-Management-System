package com.lms.service;

import com.lms.dao.TrackDao;
import com.lms.dao.impl.TrackDaoImpl;
import com.lms.model.Track;

public class TrackService {

    TrackDao trackDao = new TrackDaoImpl();

    public void insertTrack(Track track){
        trackDao.insert(track);
    }

    public Track getAllTracks(){
        return trackDao.getAllTracks();
    }


}
