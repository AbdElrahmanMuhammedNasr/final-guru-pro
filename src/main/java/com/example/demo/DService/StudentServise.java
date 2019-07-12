package com.example.demo.DService;

import com.example.demo.Entity.Student;

import java.util.List;

public interface StudentServise {
    List<Student> findAllSudents();

    Student findOneStudent(Long id);

    void deleteOnestudent(Long id);

    Student saveStudent(Student student);



}
