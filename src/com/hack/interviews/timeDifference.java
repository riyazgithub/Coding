package com.hack.interviews;

import com.sun.source.tree.AssertTree;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by rafthab on 10/9/17.
 */
public class timeDifference {

    public static void main(String[] args) {

        timeDifference tDiff = new timeDifference();
        System.out.println(tDiff.secondsDelta("5:11 am","5:12 pm"));

    }

    public int secondsDelta(String time1, String time2) {

        // Note: The code assumes time2 is the future time and time1 is present and returns the time difference between future and present.
        int secondDelta = 0;
        // Each time has 3 components hour, minutes and am/pm, covert time in to tuples of 24 hours and then convert them to second of the day
        int timeSecond1 = convertToSecond(time1);
        int timeSecond2 = convertToSecond(time2);

        if(timeSecond2 < timeSecond1) {
            //Note: 60 seconds minus is to remove the subtraction trade off
            // gather time left of the day
            secondDelta += ((24 * 3600) - timeSecond1);
            // add delta to reach to timesecond1

            secondDelta += timeSecond2;
        }else {

            secondDelta = timeSecond2 - timeSecond1;
        }

        return secondDelta;
    }

    private int convertToSecond(String time) {
        int returnSecond = 0;
        // Get hour
        returnSecond += Integer.parseInt(time.substring(0,time.indexOf(':'))) * 3600; // converting hour to seconds
        returnSecond += Integer.parseInt(time.substring(time.indexOf(':') +1, time.indexOf(' '))) * 60;
        if(time.substring(time.indexOf(' ')+1).equals("pm")) {
            returnSecond += 12 * 3600;
        }
        return returnSecond;
    }

    @Test
    public void testSecondDifference(){
        int secondDelta = secondsDelta("5:11 am","5:12 am");
        Assert.assertTrue(secondDelta == 60, "Delta Difference is incorrect");
        // Same input with am/ pm difference
        secondDelta = secondsDelta("5:11 am","5:12 pm");
        Assert.assertTrue(secondDelta == 43260, "Delta Difference is incorrect");
    }

    @Test
    public void testSecondDifferenceWithGreaterTime(){
        int secondDelta = secondsDelta("5:11 am","5:10 am");
        Assert.assertTrue(secondDelta == 86340, "Delta Difference is incorrect");
        // Same input with am/ pm difference
        secondDelta = secondsDelta("5:11 pm","5:12 am");
        Assert.assertTrue(secondDelta == 43260, "Delta Difference is incorrect");
    }

}
