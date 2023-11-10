package com.example.demo.models;

public class Student extends Person implements Learner {

    double totalStudyTime = 0;

    public Student(Long id, String name) {
        super(id, name);
    }

    @Override
    public void learn(double numberOfHours) {
        totalStudyTime += numberOfHours;
    }

    public double getTotalStudyTime() {
        return totalStudyTime;
    }
}
