package com.example.demo.ZReposotiry;

import com.example.demo.Entity.Course;
import com.example.demo.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course,Long> {
}
