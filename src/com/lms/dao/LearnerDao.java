package com.lms.dao;

import com.lms.exception.InvalidIdException;
import com.lms.exception.InvalidInputException;
import com.lms.model.Learner;

import java.util.List;

public interface LearnerDao {

    List<Learner> getAllLearners();
    Learner getLearnerById(int id) throws InvalidIdException;
    void deleteLearnerById(int id) throws InvalidIdException;
    Learner updateLearner(int id, Learner learner) throws InvalidIdException, InvalidInputException;
    void insertLearner(Learner learner) throws InvalidInputException;

}
