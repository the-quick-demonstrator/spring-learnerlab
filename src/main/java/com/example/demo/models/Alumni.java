package com.example.demo.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class Alumni {

    @Autowired
    @Qualifier("instructors")
    Instructors instructors;

    @Autowired
    @Qualifier("previous_students")
    Students students;

    double numberOfHoursToTeachEachStudents = 1200;

    public Alumni(){}

    public Alumni(Instructors instructors, Students students) {
        this.instructors = instructors;
        this.students = students;
    }

    @PostConstruct
    public void executeBootCamp(){
        Iterable<Student> group = students.findAll();
        Iterable<Instructor> hosts = instructors.findAll();
        List<Instructor> hostList = new ArrayList<>();
        hosts.forEach(hostList::add);
        for (Instructor instructor : hostList) {
            instructor.lecture(group, getNumberOfHoursToTeachEachStudents());

        }

    }

    public Instructors getInstructors() {
        return instructors;
    }

    public Students getStudents() {
        return students;
    }

    public double getNumberOfHoursToTeachEachStudents() {
        return (numberOfHoursToTeachEachStudents * students.getSize())/ instructors.getSize();
    }
}
