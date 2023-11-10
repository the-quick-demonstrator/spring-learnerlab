package com.example.demo.models;

import com.example.demo.models.Instructor;
import com.example.demo.models.People;

import java.util.Iterator;

public class Instructors extends People<Instructor> {

    public Instructors(Instructor...instructors){
        super(instructors);
    }

    @Override
    public Iterator<Instructor> iterator() {
        return null;
    }
}
