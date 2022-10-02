package com.spring.boot.API.Assignment.SpringBootAPIAssignment.controller;

import com.spring.boot.API.Assignment.SpringBootAPIAssignment.entity.Courses;
import com.spring.boot.API.Assignment.SpringBootAPIAssignment.service.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CoursesController {

    @Autowired
    CoursesService cservice;


    // 1.save ("/addCourse")
    @PostMapping("/addCourse")
    public Courses addCourse(@RequestBody Courses course){
        return cservice.addCourse(course);
    }

    // 2.getById
    @GetMapping("/getCourseById/{course_id}")
    public Courses getCourseById(@PathVariable int course_id){
        return cservice.getCourseById(course_id);
    }

    // 3.returnAllCourses (use default path->  /courses)
    @GetMapping
    public List<Courses> getAllCourses(){
        return cservice.getAllCourses();
    }

    // 4.returnNumberOfCourses
    @GetMapping("/getTotalCourses")
    public int getTotalCourses(){
        return cservice.countCourses();
    }

    // 5.deletecoursebyid
    @DeleteMapping("/deleteCourse/{course_id}")
    public void deleteCourse(@PathVariable int course_id){
        cservice.deleteCourse(course_id);
    }

    // 6.CheckCourseExistence
    @GetMapping("/checkCourseExistence/{course_id}")
    public boolean checkCourseExistence(@PathVariable int course_id){
        return cservice.doesCourseExists(course_id);
    }
}
