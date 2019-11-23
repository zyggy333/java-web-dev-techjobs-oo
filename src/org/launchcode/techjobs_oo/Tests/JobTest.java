package org.launchcode.techjobs_oo.Tests;


import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.Job;
import static org.junit.Assert.*;

public class JobTest {
    Job test_job1;
    Job test_job2;
    @Before
    public void createJobObject1(){
        Job test_job1 = new Job();
    }

    public void createJobObject2(){
        Job test_job2 = new Job();
    }

    //Verifies that two unique objects do not share the same ID
    @Test
    public void testIDEquality(){
        assertTrue(test_job1.getId() +1 == test_job2.getId());
    }

}
