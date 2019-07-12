package com.example.demo.Bootstrap;

import com.example.demo.Entity.Course;
import com.example.demo.Entity.Student;
import com.example.demo.ZReposotiry.CourseRepo;
import com.example.demo.ZReposotiry.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class initData implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private CourseRepo courseRepo;

    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();

    }

    public void initData() {
        Student s1 = new Student();
        s1.setName("Ali");

        Course c1 = new Course();
        c1.setName("C++");

        Course c2 = new Course();
        c2.setName("JAVA");


        s1.getCourse().add(c1);
        s1.getCourse().add(c2);
        c1.getStudent().add(s1);

        studentRepo.save(s1);
        courseRepo.save(c1);
        /*******************************************************************/



        Student s2 = new Student();
        s2.setName("Abdo");

        Course c3 = new Course();
        c3.setName("C#");


        s2.getCourse().add(c3);
        c3.getStudent().add(s2);

        studentRepo.save(s2);
        courseRepo.save(c3);



    }
}
