package com.lms.service;

import com.lms.dao.CourseDao;
import com.lms.dao.impl.CourseDaoImpl;
import com.lms.model.Course;

public class CourseService {

    CourseDao courseDao = new CourseDaoImpl();

    public void insertCourse(Course course, int trackId){
        courseDao.insert(course, trackId);
    }


}
