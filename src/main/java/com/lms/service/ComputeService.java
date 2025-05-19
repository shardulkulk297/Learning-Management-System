package com.lms.service;

import com.lms.model.Learner;

import java.util.List;

public class ComputeService {

    public double computePercentage(double total, double marks_scored){

        if(marks_scored > total){
            throw new IllegalArgumentException("Marks cannot be greater than total marks");
        }

        if(marks_scored < 0){
            throw new IllegalArgumentException("Marks cannot be negative");
        }

        return (marks_scored / total) * 100;
    }

    public char computeGrade(double percentage){

        if(percentage >= 90){
            return 'A';
        }
        else if(percentage >= 80){
            return 'B';
        }
        else if(percentage >= 70){
            return 'C';
        }
        else if(percentage >= 60){
            return 'D';
        }
        else{
            return 'F';
        }

    }

    public List<Learner> filterListById(List<Learner> learners, int id){

        if(learners == null){
            throw new RuntimeException("List cannot be null");
        }
        if(learners.size() == 0){
            throw new RuntimeException("List cannot be empty");
        }

        return learners.stream().filter(l->l.getId() != id).toList();

    }


}
