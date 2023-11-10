package com.example.demo;

import com.example.demo.models.Alumni;
import com.example.demo.models.Instructor;
import com.example.demo.models.Student;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration
public class AlumniTest {

    @Autowired
    Alumni alumni;

    @Test
    public void testExecuteBootcampStudentHours() {
        //given
        Double expected = 1200.00;
        //when
        Student josh = alumni.getStudents().findById(29L);
        Double actual = josh.getTotalStudyTime();
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testBootCampLectureHoursTest(){
        //given
        Double expected = alumni.getNumberOfHoursToTeachEachStudents();
        //when
        Instructor leon = alumni.getInstructors().findById(1L);
        Double actual = leon.getTotalTeachTime();
        //then
        Assert.assertEquals(expected, actual);
    }
}
