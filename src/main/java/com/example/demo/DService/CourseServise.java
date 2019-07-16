package com.example.demo.DService;

import com.example.demo.Entity.Course;

import java.util.List;

public interface CourseServise {
    List<Course> findAllCourse();

    Course findOneCourse(Long id);

    //void deleteOneCourse(Long id);

    Course SaveCourse(Course course);
}
