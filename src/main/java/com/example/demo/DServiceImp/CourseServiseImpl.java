package com.example.demo.DServiceImp;

import com.example.demo.DService.CourseServise;
import com.example.demo.Entity.Course;
import com.example.demo.ZReposotiry.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiseImpl implements CourseServise {
    @Autowired
    private CourseRepo courseRepo;

    @Override
    public List<Course> findAllCourse() {
        return courseRepo.findAll();
    }

    @Override
    public Course findOneCourse(Long id) {
        return courseRepo.findById(id).get();
    }

 /*   @Override
    public void deleteOneCourse(Long id) {
         courseRepo.deleteById(id);
    }
*/
    @Override
    public Course SaveCourse(Course course) {
        return courseRepo.save(course);
    }
}
