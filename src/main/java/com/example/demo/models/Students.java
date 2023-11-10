package com.example.demo.models;

import com.example.demo.models.People;
import com.example.demo.models.Student;

import java.util.Iterator;

public class Students extends People<Student> implements Iterable<Student>{

    public Students(Student... students){
        super(students);
    }


    @Override
    public Iterator<Student> iterator() {
        return null;
    }
}
