package com.lms.controller;

import com.lms.dao.LearnerDao;
import com.lms.exception.InvalidIdException;
import com.lms.exception.InvalidInputException;
import com.lms.model.Learner;
import com.lms.service.LearnerService;

import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        LearnerService learnerService = new LearnerService();

        while(true){
            System.out.println("---------LMS--------------");
            System.out.println("1. Get All Learners");
            System.out.println("2. Get Learner By Id");
            System.out.println("3. Delete Learner By Id");
            System.out.println("4. Update Learner");
            System.out.println("5. Insert Learner");
            System.out.println("6. Exit");
            System.out.println("-----------------------");
            System.out.println( "Enter Choice");
            int choice = sc.nextInt();
            switch (choice){
                case 1-> {

                    List<Learner> learners = learnerService.getAllLearners();

                    for (Learner learner : learners) {
                        System.out.println(learner);
                    }
                }
                case 2-> {
                    System.out.println("Enter Id");

                    int id = sc.nextInt();
                    try {
                        Learner learner = learnerService.getLearnerById(id);
                        System.out.println(learner);
                    } catch (InvalidIdException e) {
                        String message = e.getMessage();
                        System.out.println(message);
                    }
                }
                case 3-> {
                        System.out.println("Enter Id");
                        int id = sc.nextInt();

                        try {
                            learnerService.deleteLearnerById(id);
                        } catch (InvalidIdException e) {
                            String message = e.getMessage();
                            System.out.println(message);
                        }
                }
                case 4-> {
                    System.out.println("Enter Id");
                    int id = sc.nextInt();
                    System.out.println("Enter Name");
                    String name = sc.next();
                    System.out.println("Enter Email");
                    String email = sc.next();
                    Learner learner = new Learner(id, name, email);
                    try{
                        learnerService.updateLearner(id, learner);
                    }
                    catch (InvalidIdException | InvalidInputException e)
                    {
                        String message = e.getMessage();
                        System.out.println(message);
                    }
                }

                case 5->{
                    System.out.println("Enter Id:");
                    int id = sc.nextInt();
                    System.out.println("Enter Name");
                    String name = sc.next();
                    System.out.println("Enter Email");
                    String email = sc.next();
                    Learner learner = new Learner(id, name, email);

                    try{
                        learnerService.insertLearner(learner);
                    }
                    catch (InvalidInputException e)
                    {
                        String message = e.getMessage();
                        System.out.println(message);
                    }
                }

                case 6->{
                    System.exit(0);
                    System.out.println("Thanks for Visiting!");
                }
                default->{
                    System.out.println("Invalid Choice");
                }
            }
        }

    }

}
