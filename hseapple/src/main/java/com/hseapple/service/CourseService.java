package com.hseapple.service;

import com.hseapple.dao.CourseDao;
import com.hseapple.dao.CourseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    CourseDao courseDao;

    public CourseService(CourseDao courseDao){
        this.courseDao = courseDao;
    }
    public List<CourseEntity> findAllCourse() { return courseDao.findAll(); };
}