package com.lms.utility;

import com.lms.model.Learner;

import java.util.ArrayList;
import java.util.List;

public class LearnerUtility {


    private static List<Learner> learners;

    {
        learners = new ArrayList<>();
    }

    public List<Learner> getSampleData(){
        populateList();
        return learners;
    }


    public void populateList(){

        if(!learners.isEmpty()) {
            return;
        }

        Learner learner1 = new Learner(1, "Ashok", "<EMAIL>");
        Learner learner2 = new Learner(2, "Raj", "<EMAIL>");
        Learner learner3 = new Learner(3, "Raj", "<EMAIL>");
        Learner learner4 = new Learner(4, "Raj", "<EMAIL>");

        learners = new ArrayList<>();
        learners.add(learner1);
        learners.add(learner2);
        learners.add(learner3);
        learners.add(learner4);


    }

    public static void setLearners(List<Learner> learners) {
        LearnerUtility.learners = learners;
    }

}
