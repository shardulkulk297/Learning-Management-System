package com.lms.service;

import com.lms.dao.LearnerDao;
import com.lms.dao.impl.LearnerDaoImpl;
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

        if(id <= 0){
            throw new InvalidIdException("Invalid Id");
        }

        return learnerDao.getLearnerById(id);
    }

    public void deleteLearnerById(int id) throws InvalidIdException
    {
        if(id <= 0){
            throw new InvalidIdException("Invalid Id");
        }
        learnerDao.deleteLearnerById(id);
    }
    public Learner updateLearner(int id, Learner learner) throws InvalidIdException, InvalidInputException {
        if(id <= 0){
            throw new InvalidIdException("Invalid Id");
        }
        if(learner.getName() == null || learner.getEmail() == null){
            throw new InvalidInputException("Invalid Input");
        }
        if(learner.getName().trim().isEmpty() || learner.getEmail().trim().isEmpty()){
            throw new InvalidInputException("Invalid Input");
        }
        if(learner == null)
        {
            throw new InvalidInputException("Invalid Input");
        }
        return learnerDao.updateLearner(id, learner);
    }

    public void insertLearner(Learner learner) throws InvalidInputException {
        if(learner.getName() == null || learner.getEmail() == null){
            throw new InvalidInputException("Invalid Input");
        }
        if(learner.getName().trim().isEmpty() || learner.getEmail().trim().isEmpty()){
            throw new InvalidInputException("Invalid Input");
        }
        if(learner == null)
        {
            throw new InvalidInputException("Invalid Input");
        }
        learnerDao.insertLearner(learner);
    }

}
