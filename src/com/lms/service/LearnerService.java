package com.lms.service;

import com.lms.dao.LearnerDao;
import com.lms.dao.LearnerDaoImpl;
import com.lms.exception.InvalidIdException;
import com.lms.exception.InvalidInputException;
import com.lms.model.Learner;

import java.util.List;

public class LearnerService {

    LearnerDao learnerDao = new LearnerDaoImpl();

    public List<Learner> getAllLearners(){
        return learnerDao.getAllLearners();
    }

    public Learner getLearnerById(int id) throws InvalidIdException{
        return learnerDao.getLearnerById(id);
    }

    public void deleteLearnerById(int id) throws InvalidIdException
    {
        learnerDao.deleteLearnerById(id);
    }
    public Learner updateLearner(int id, Learner learner) throws InvalidIdException, InvalidInputException {
        return learnerDao.updateLearner(id, learner);
    }

    public void insertLearner(Learner learner) throws InvalidInputException {
        learnerDao.insertLearner(learner);
    }

}
