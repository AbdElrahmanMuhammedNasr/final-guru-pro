package com.example.demo.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long Id;
    private  String name;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name ="Student_Course",joinColumns = @JoinColumn(name="student_id"),inverseJoinColumns = @JoinColumn(name = "course_id"))
    @JsonIgnore
    private List <Course> course = new ArrayList<Course>();



}
