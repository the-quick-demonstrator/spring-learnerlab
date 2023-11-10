package com.example.demo;

import com.example.demo.models.Student;
import com.example.demo.models.Students;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@SpringBootTest
@RunWith(SpringRunner.class)
//why do I not need a context configuration annotation here?
public class StudentConfigTest {

    @Autowired
    @Qualifier("students")
    private Students currentClass;

    @Autowired
    @Qualifier("previous_students")
    private Students previousClass;

    @Test
    public void testCurrentStudentsFindById(){
        String actual = currentClass.findById(6L).getName();
        String expected = "Dee";
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void testCurrentStudentsSize() {
        int actual = currentClass.getSize();
        int expected = 3;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCurrentStudentsLearn() {
        List<Student> classList= currentClass.findAll();
        for (Student student : classList) {
            student.learn(3.0);
        }
        Double actual = currentClass.findById(6L).getTotalStudyTime();
        Double expected = 3.0;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testPreviousStudents(){
        String actual = previousClass.findById(29L).getName();
        String expected = "Josh";
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void testPreviousStudentsSize(){
        int actual = previousClass.getSize();
        int expected = 3;
        Assert.assertEquals(actual,expected);
    }
}
