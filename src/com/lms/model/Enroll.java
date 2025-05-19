package com.lms.model;

import com.lms.Enums.Coupon;

import java.time.LocalDate;

public class Enroll {

    private Learner learner;
    private Course course;
    private LocalDate enrollDate;
    private String couponUsed;
    private Coupon coupon;
    private double feePaid;

    public Enroll(){

    }
    public Enroll(Learner learner, Course course, LocalDate enrollDate, String couponUsed, double feePaid) {
        this.learner = learner;
        this.course = course;
        this.enrollDate = enrollDate;
        this.couponUsed = couponUsed;
        this.feePaid = feePaid;
    }

    public Learner getLearner() {
        return learner;
    }
    public void setLearner(Learner learner) {
        this.learner = learner;
    }
    public Course getCourse() {
        return course;
    }
    public void setCourse(Course course) {
        this.course = course;
    }
    public LocalDate getEnrollDate() {
        return enrollDate;
    }
    public void setEnrollDate(LocalDate enrollDate) {
        this.enrollDate = enrollDate;
    }
    public String getCouponUsed() {
        return couponUsed;
    }
    public void setCouponUsed(String couponUsed) {
        this.couponUsed = couponUsed;
    }
    public double getFeePaid() {
        return feePaid;
    }
    public void setFeePaid(double feePaid) {
        this.feePaid = feePaid;
    }
    public Coupon getCoupon(){
        return coupon;
    }
    public void setCoupon(){
        this.coupon = coupon;
    }

    @Override
    public String toString() {
        return "Enroll{" + "learner=" + learner + ", course=" + course + ", enrollDate=" + enrollDate + ", couponUsed=" + couponUsed + ", feePaid=" + feePaid + '}';
    }
}
