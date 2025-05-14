package com.lms.dao;

import com.lms.exception.InvalidIdException;
import com.lms.exception.InvalidInputException;
import com.lms.model.Learner;
import com.lms.utility.LearnerUtility;

import java.util.ArrayList;
import java.util.List;

public class LearnerDaoImpl implements LearnerDao {

    private LearnerUtility learnerUtility = new LearnerUtility();

    @Override
    public List<Learner> getAllLearners() {
        return learnerUtility.getSampleData();
    }
    @Override
    public Learner getLearnerById(int id) throws InvalidIdException {
        List<Learner> learners = learnerUtility.getSampleData();
        for(Learner learner : learners){
            if(learner.getId() == id){
                return learner;
            }
        }
        throw new InvalidIdException("Invalid Id");
    }

    @Override
    public void deleteLearnerById(int id) throws InvalidIdException{
        List<Learner> learners = learnerUtility.getSampleData();

        int size = learners.size();
        learners = learners.stream().filter(l->l.getId() != id).toList();
        int resetSize = learners.size();

        if(size == resetSize){
            throw new InvalidIdException("Invalid Id");
        }

        LearnerUtility.setLearners(learners);





    }
    @Override
    public Learner updateLearner(int id, Learner learner) throws InvalidIdException, InvalidInputException {
        deleteLearnerById(id);
        List<Learner> list = getAllLearners();
        List<Learner> newList = new ArrayList<>(list);
        newList.add(learner);
        LearnerUtility.setLearners(newList);
        System.out.println("Updated Successfuly");
        return learner;

    }

    @Override
    public void insertLearner(Learner learner){

        List<Learner> List = getAllLearners();
        List<Learner> newList = new ArrayList<>(List);
        newList.add(learner);
        LearnerUtility.setLearners(newList);
        System.out.println("Inserted Successfuly");

    }





}
