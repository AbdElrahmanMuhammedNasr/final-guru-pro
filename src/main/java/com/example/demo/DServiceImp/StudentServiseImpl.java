package com.example.demo.DServiceImp;

import com.example.demo.DService.StudentServise;
import com.example.demo.Entity.Student;
import com.example.demo.ZReposotiry.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiseImpl implements StudentServise {
    @Autowired
    private StudentRepo studentRepo;

    @Override
    public List<Student> findAllSudents() {
        return  studentRepo.findAll();
    }

    @Override
    public Student findOneStudent(Long id) {
        return studentRepo.findById(id).get();
    }

    @Override
    public void deleteOnestudent(Long id) {
            studentRepo.deleteById(id);
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepo.save(student);
    }
}
