package org.launchcode.techjobs_oo.Tests;

import org.junit.Test;
import org.launchcode.techjobs_oo.*;
import static org.junit.Assert.*;

public class JobTest {
    Job test_job1 = new Job();
    Job test_job2 = new Job();
    Job test_job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    Job test_job4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    Job test_job5 = new Job("Product tester", new Employer(""), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    //Verifies that two created objects do not share the same ID
    @Test
    public void testSettingJobId(){
        assertTrue(test_job1.getId() +1 == test_job2.getId());
    }


    //Verifies that the Job class correctly initializes all fields
    @Test
    public void testJobConstructorSetsAllFields(){

        assertEquals(23,test_job3.getId());
        assertEquals("Product tester",test_job3.getName());
        assertEquals("ACME", test_job3.getEmployer().toString());
        assertEquals("Desert",test_job3.getLocation().toString());
        assertEquals("Quality control",test_job3.getPositionType().toString());
        assertEquals("Persistence",test_job3.getCoreCompetency().toString());
    }

    //Verifies that no two Job objects are equal due to the id being different
    @Test
    public void testJobsForEquality(){
        assertFalse(test_job3.equals(test_job4));
    }

    //Verifies that blank lines are before and after the data returned by ToString
    @Test
    public void toStringInitialTest(){
        String[] testJobStr = Job.toString(test_job4).split("\n");
        assertTrue(testJobStr[0].isBlank());
        assertTrue(testJobStr[testJobStr.length-1].isBlank());
    }

    //Verifies the toString method adds labels for each field in its return
    @Test
    public void toStringLabelTest(){
        String testLabelString = Job.toString(test_job4);
        assertTrue(testLabelString.contains("ID:"));
        assertTrue(testLabelString.contains("Name:"));
        assertTrue(testLabelString.contains("Employer:"));
        assertTrue(testLabelString.contains("Location:"));
        assertTrue(testLabelString.contains("Position Type:"));
        assertTrue(testLabelString.contains("Core Competency:"));
    }

    @Test
    public void toStringEmptyFieldTest(){
        String testEmptyString = Job.toString(test_job5);
        assertTrue(testEmptyString.contains("Data not available"));
    }



}
