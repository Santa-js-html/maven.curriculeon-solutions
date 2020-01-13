package com.github.curriculeon;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by leon on 1/13/2020.
 */
public class TestInstructor {
    @Test
    public void testImplementation() {
        Instructor instructor = new Instructor(0L, "");
        Assert.assertTrue(instructor instanceof Teacher);
    }

    @Test
    public void testInheritance() {
        Instructor instructor = new Instructor(0L, "");
        Assert.assertTrue(instructor instanceof Person);
    }

    @Test
    public void testTeach() {
        Teacher instructor = new Instructor(0L, "");
        Learner student = new Student(0L, "");
        Double numberOfHoursToTeach = 10.0;
        Double expectedNumberOfHoursLearned = student.getTotalStudyTime() + numberOfHoursToTeach;

        // when
        instructor.teach(student, numberOfHoursToTeach);
        Double actualNumberOfHoursLearned = student.getTotalStudyTime();

        // then
        Assert.assertEquals(expectedNumberOfHoursLearned, actualNumberOfHoursLearned, 0);
    }

    @Test
    public void testLecture() {
        Teacher instructor = new Instructor(0L, "");
        Student[] students = Students.getInstance().toArray();
        Double numberOfHoursToTeach = 3.0;

        // when
        instructor.lecture(students, numberOfHoursToTeach);

        for (int i = 0; i < students.length; i++) {
            Student student = students[i];
            Double expectedNumberOfHoursLearned = student.getTotalStudyTime() + numberOfHoursToTeach;
            Double actualNumberOfHoursLearned = student.getTotalStudyTime();

            // then
            Assert.assertEquals(expectedNumberOfHoursLearned, actualNumberOfHoursLearned, 0);
        }
    }
}
