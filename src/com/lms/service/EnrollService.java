package com.lms.service;

import com.lms.Enums.Coupon;
import com.lms.dao.EnrollDao;
import com.lms.dao.impl.EnrollDaoImpl;
import com.lms.exception.InvalidIdException;
import com.lms.model.Course;
import com.lms.model.Enroll;
import com.lms.model.Learner;

import java.time.LocalDate;
import java.util.Scanner;

public class EnrollService {

    public void enroll(int learnerId, int courseId, Scanner sc) throws InvalidIdException {

        Enroll enroll = new Enroll();

        LearnerService learnerService = new LearnerService();
        Learner learner = learnerService.getLearnerById(learnerId);
        enroll.setLearner(learner);
        CourseService courseService = new CourseService();
        Course course = courseService.getCourseById(courseId);
        enroll.setCourse(course);

        System.out.println("Do you have a coupon? (Y/N): ");
        String ans = sc.next();
        String couponCode;
        if(ans.equals("Y"))
        {
            System.out.println("Enter coupon code: ");
            couponCode = sc.next();
            Coupon coupon = Coupon.valueOf(couponCode); //illegalargument exception
            double discount = coupon.getDiscount();
            double feePaid = course.getFee() + (course.getFee() * (discount / 100));
            double courseDiscount = course.getDiscount() + discount;
            course.setDiscount(courseDiscount);
            enroll.setFeePaid(feePaid);
            enroll.setCouponUsed(couponCode);
        }
        else{
            couponCode = null;
            enroll.setCouponUsed(couponCode);
            enroll.setFeePaid(course.getFee());
        }

        EnrollDao enrollDao = new EnrollDaoImpl();

        LocalDate date = LocalDate.now();
        enroll.setEnrollDate(date);


        enrollDao.insertEnroll(enroll);

    }
}
