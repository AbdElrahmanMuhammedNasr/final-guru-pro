package com.example.demo.ZReposotiry;

import com.example.demo.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepo extends JpaRepository<Student ,Long> {

    @Query(value = "SELECT * FROM STUDENT ",nativeQuery = true)
    public List<Student> findAllStudentsIamNewMethod();
}
