package com.example.demo.models;

import com.example.demo.models.Learner;
import com.example.demo.models.Person;
import com.example.demo.models.Teacher;

import java.util.ArrayList;
import java.util.List;

public class Instructor extends Person implements Teacher {

    double totalTeachTime = 0;

    public Instructor(Long id, String name) {
        super(id, name);
    }

    @Override
    public void teach(Learner learner, double numberOfHours) {
        learner.learn(numberOfHours);
    }

    @Override
    public void lecture(Iterable<? extends Learner> learners, double numberOfHours) {
        List<Learner> classSize = new ArrayList<>();
        learners.forEach(classSize::add);
        totalTeachTime += numberOfHours;
        double numberOfHoursPerLearner = numberOfHours / classSize.size();

        for (Learner learner : classSize) {
            teach(learner, numberOfHoursPerLearner);
            }
        }

    public double getTotalTeachTime() {
        return totalTeachTime;
    }
}
