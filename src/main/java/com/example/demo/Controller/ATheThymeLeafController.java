package com.example.demo.Controller;

import com.example.demo.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
//@RequestMapping(value = "/AllData")
public class ATheThymeLeafController {

    @Autowired
    private  StudentController studentController;
    @Autowired
    private  CourseController courseController;


    /***************************Delete ********************/
    @GetMapping(value = "/delete/{id}")
    public  String deleteStudent(@PathVariable("id") Long id){
        studentController.deleteOneStudent(id);
        return "redirect:/theAll"; //Link
    }
    @GetMapping(value = "/delete/C/{id}")
    public  String deleteCourse(@PathVariable("id") Long id){
         courseController.deleteOneCourse(id);
        return "redirect:/theAll"; //Link
    }

    /***************************Show MoreDetail*************/
    @GetMapping(value = "/show/{id}")
    public String showStudentDetail(@PathVariable("id") String id,Model model) {
            model.addAttribute("on", studentController.getOneStudent(new Long(id)));

        return "one";
    }
    @GetMapping(value = "/show/C/{id}")
    public String showCourseDetail(@PathVariable("id") String id,Model model) {
        model.addAttribute("on", courseController.getOneCourse(new Long(id)));
        return "one";
    }



    /****************************** Display Data***********************************/
    @GetMapping(value = "/theAll")
    public  String getAllData(Model model){
        model.addAttribute("StudentData" , studentController.getAllStudent() );
        model.addAttribute("CourseData" , courseController.getAllCourse());
        return "index";
    }


}

