package com.example.demo.configurations;


import com.example.demo.models.Classroom;
import com.example.demo.models.Instructors;
import com.example.demo.models.Students;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
public class ClassroomConfig {

    @Bean(name = "classroom")
    @DependsOn ({"instructors", "students"})
    public Classroom currentCohort(Instructors instructors, @Qualifier ("students") Students students){
        return new Classroom(instructors, students);
    }

    @Bean(name = "previous_classroom")
    @DependsOn ({"instructors", "previous_students"})
    public Classroom previousCohort(Instructors instructors, @Qualifier("previous_students") Students students){
        return new Classroom(instructors, students);
    }
}
