package com.example.demo.configurations;

import com.example.demo.models.Classroom;
import com.example.demo.models.Student;
import com.example.demo.models.Students;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {

    @Bean(name = "students")
    public Students currentStudents(){
        return new Students(
                new Student(6L, "Dee"),
                new Student(7L, "Zach"),
                new Student(8L, "Jen")
        );
    }

    @Bean (name = "previous_students")
    public Students previousStudents(){
        return new Students(
                new Student(28L, "Jack"),
                new Student(29L, "Josh"),
                new Student(30L, "James")
        );
    }

}
