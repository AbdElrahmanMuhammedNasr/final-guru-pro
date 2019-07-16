package com.example.demo.Controller;

import com.example.demo.Entity.Course;
import com.example.demo.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

@Controller
//@RequestMapping(value = "/AllData")
public class ATheThymeLeafController {


    @Autowired
    private  StudentController studentController;
    @Autowired
    private  CourseController courseController;

    @GetMapping(value = "/")
    public String form( Model model){
        model.addAttribute("stu",new Student());
     //   model.addAttribute("cou",new Course());

        return "AddData"; //html
    }
    @PostMapping(value = "/save")
    public String Saveform (HttpServletRequest req){
           String sName="";
           String cName="";

        sName = req.getParameter("SName");
        cName = req.getParameter("CName");


        System.out.println(sName  +" "+cName);

        Student s = new Student();
        s.setName(sName);
        Course c = new Course();
        c.setName(cName);
        s.getCourse().add(c);
        studentController.saveTheData(s);
        courseController.saveTheData(c);
        return "redirect:/theAll";
    }


    /***************************Delete ********************/
    @GetMapping(value = "/delete/{id}")
    public  String deleteStudent(@PathVariable("id") Long id){
        studentController.deleteOneStudent(id);
        return "redirect:/theAll"; //Link
    }

    /***************************Show MoreDetail*************/
    @GetMapping(value = "/show/{id}")
    public String showStudentDetail(@PathVariable("id") String id,Model model) {
        try {
            model.addAttribute("on", studentController.getOneStudent(new Long(id)));
        }
        catch (Exception c){
            model.addAttribute("on", courseController.getOneCourse(new Long(id)));
        }
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

