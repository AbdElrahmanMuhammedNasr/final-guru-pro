package com.example.demo.Controller;

import com.example.demo.DService.StudentServise;
import com.example.demo.Entity.Student;
import com.example.demo.ZReposotiry.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/Student")
public class StudentController {
    @Autowired
    private StudentServise studentServise; // interface

    @Autowired
    private StudentRepo studentRepo;

    @GetMapping(value = "/getAll")
    public List <Student> getAllStudent(){

        return studentRepo.findAllStudentsIamNewMethod();
    }

    @GetMapping(value = "/get/{id}")
    public Student getOneStudent(@PathVariable Long id){

        return studentServise.findOneStudent(id);
    }

    @GetMapping(value = "/delete/{id}")
    public void deleteOneStudent(@PathVariable Long id){

        studentServise.deleteOnestudent(id);
    }

    @PostMapping(value = "/save")
    public void saveTheData(Student student){
        studentServise.saveStudent(student);
    }

}
