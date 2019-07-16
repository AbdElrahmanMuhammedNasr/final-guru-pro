package com.example.demo.Controller;


import com.example.demo.DService.CourseServise;
import com.example.demo.Entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/Course")
public class CourseController {

    @Autowired
    private CourseServise courseServise; // interface

    @GetMapping(value = "/getAll")
    public List<Course> getAllCourse(){
        return courseServise.findAllCourse();
    }

    @GetMapping(value = "/get/{id}")
    public Course getOneCourse(@PathVariable Long id){
        return courseServise.findOneCourse(id);
    }

    @PostMapping(value = "/save")
    public void saveTheData(Course course){

        courseServise.SaveCourse(course);
    }


}
