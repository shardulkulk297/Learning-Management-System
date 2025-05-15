package com.lms.service;

import com.lms.dao.CourseDao;
import com.lms.dao.impl.CourseDaoImpl;
import com.lms.model.Course;

import java.util.List;

public class CourseService {

    CourseDao courseDao = new CourseDaoImpl();

    public void insertCourse(Course course, int trackId){
        courseDao.insert(course, trackId);
    }

    public List<Course> getAllCourses(){
        return courseDao.getAllCourses();

    }
    public List<Course> getCoursesByTrackId(int id){
        return courseDao.getCoursesByTrackId(id);
    }

    public Course getCourseById(int id){
        return courseDao.getCourseById(id);
    }


}
