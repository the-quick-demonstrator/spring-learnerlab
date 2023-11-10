package com.example.demo;

import com.example.demo.models.Classroom;
import com.example.demo.models.Instructor;
import com.example.demo.models.Instructors;
import com.example.demo.models.Students;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration
public class ClassroomConfigTest {

    @Autowired
    @Qualifier("classroom")
    private Classroom currentCohort;

    @Autowired
    @Qualifier ("previous_classroom")
    private Classroom previousCohort;

    @Test
    public void testCurrentCohortSize(){
        int actual = currentCohort.getStudents().getSize();
        int expected = 3;
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void testCurrentCohortFindStudentName(){
        String actual = currentCohort.getStudents().findById(6L).getName();
        String expected = "Dee";
        Assert.assertEquals(actual,expected);
    }

    @Test (expected = NullPointerException.class)
    public void testCurrentCohortFindInstructorNull(){
        String actual = currentCohort.getInstructors().findById(6L).getName();
        Assert.assertNull(actual);
    }

    @Test
    public void testCurrentCohortFindInstructorNameNotNull(){
        String actual = currentCohort.getInstructors().findById(1L).getName();
        String expected = "Leon Hunter";
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void testHostLecture(){
        //given
        Instructor host = currentCohort.getInstructors().findById(1L);
        Double expected = 15.0;
        //when
        currentCohort.hostLecture(host, 45.0);
        Double actual = currentCohort.getStudents().findById(6L).getTotalStudyTime();
        //then
        Assert.assertEquals(expected, actual);

    }

}
