package com.hseapple.controller;

import com.hseapple.dao.CourseDao;
import com.hseapple.dao.CourseEntity;
import com.hseapple.service.CourseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

    @Autowired
    CourseService courseService;

//    Logger logger = LoggerFactory.getLogger(CourseController.class);

    @GetMapping({"/home"})
    public String index() {
//        logger.info("Endpoint Hello World");
        return "Hello World!";
    }

    @RequestMapping(value = "/courses", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<CourseEntity> getCourses(){
        return courseService.findAllCourse();
    }

}