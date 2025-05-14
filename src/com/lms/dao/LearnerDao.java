package com.lms.dao;

import com.lms.model.Learner;

import java.util.List;

public interface LearnerDao {

    List<Learner> getAllLearners();
    Learner getLearnerById(int id);
    void deleteLearnerById(int id);
    Learner updateLearner(int id, Learner learner);
    void insertLearner(Learner learner);

}
