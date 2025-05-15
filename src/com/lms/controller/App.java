package com.lms.controller;

import com.lms.dao.CourseDao;
import com.lms.dao.LearnerDao;
import com.lms.exception.InvalidIdException;
import com.lms.exception.InvalidInputException;
import com.lms.model.Course;
import com.lms.model.Learner;
import com.lms.model.Track;
import com.lms.service.CourseService;
import com.lms.service.EnrollService;
import com.lms.service.LearnerService;
import com.lms.service.TrackService;

import java.time.LocalDate;
import java.util.ArrayList;
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
            System.out.println("6. Insert Track");
            System.out.println("7. Insert Course");
            System.out.println("8 Get all Courses");
            System.out.println("9. Get All courses by track id: ");
            System.out.println("10. Get Track by Id");
            System.out.println("11. Enroll to a course: ");
            System.out.println("0. Exit");
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
                    System.out.println("Enter Name");
                    String name = sc.next();
                    System.out.println("Enter Email");
                    String email = sc.next();
                    Learner learner = new Learner(name, email);

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
                    sc.nextLine();
                    System.out.println("Enter Track Name: ");
                    String TrackName = sc.nextLine();
                    TrackService service = new TrackService();
                    Track track = new Track(TrackName);
                    service.insertTrack(track);
                }

                case 7->{
                    sc.nextLine();
                    System.out.println("Enter course Title: ");
                    String title = sc.nextLine();

                    System.out.println("Enter course fee: ");
                    double fee = sc.nextDouble();
                    System.out.println("Enter course discount: ");
                    double discount = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Enter course publish date(YYYY-MM-DD): ");
                    String publishDate = sc.nextLine();
                    LocalDate date = LocalDate.parse(publishDate);
                    System.out.println("Enter TrackId: ");
                    int trackId = sc.nextInt();
                    CourseService courseService = new CourseService();
                    Course course = new Course();
                    course.setTitle(title);
                    course.setDiscount(discount);
                    course.setFee(fee);
                    course.setPublishDate(date);

                    courseService.insertCourse(course, trackId);

                }

                case 8->{
                    System.out.println("All Courses: ");

                    CourseService service = new CourseService();

                    List<Course> courses = service.getAllCourses();

                    for(Course course : courses){
                        System.out.println(course);
                    }

                }

                case 9->{
                    System.out.println("Enter TrackId");
                    int trackId = sc.nextInt();
                    CourseService service = new CourseService();

                    List<Course> courses = service.getCoursesByTrackId(trackId);

                    for(Course course : courses){
                        System.out.println(course);
                    }


                }
                case 11->{
                    System.out.println("Enter Learner Id: ");
                    int learnerId = sc.nextInt();
                    CourseService courseService = new CourseService();
                    List<Course> courses = courseService.getAllCourses();
                    for(Course course: courses){
                        System.out.println(course);
                    }
                    System.out.println("Enter Course Id for which you want to enroll: ");
                    int courseId = sc.nextInt();
                    EnrollService service = new EnrollService();
                    try{
                        service.enroll(learnerId, courseId, sc);
                    }
                    catch (InvalidIdException e)
                    {
                        System.out.println(e.getMessage());
                    }
                }

                case 0->{
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
