package com.example.demo.models;

import com.example.demo.models.Learner;

public interface Teacher {

    void teach(Learner learner, double numberOfHours);

    void lecture(Iterable<? extends Learner> learners, double numberOfHours);
}
