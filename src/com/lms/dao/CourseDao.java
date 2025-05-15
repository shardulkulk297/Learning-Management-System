package com.lms.dao;

import com.lms.model.Course;

import java.util.List;

public interface CourseDao {

    public void insert(Course course, int trackId);
    public List<Course> getAllCourses();
    public Course getCourseByTrackId(int trackId);
}
