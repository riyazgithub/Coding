package com.hack.leetcode;

/**
 * Created by rafthab on 1/4/18.
 *
 * There are 1000 buckets, one and only one of them contains poison, the rest are filled with water. They all look the same.
 * If a pig drinks that poison it will die within 15 minutes. What is the minimum amount of pigs you need to figure out which bucket contains the poison within one hour.

 Answer this question, and write an algorithm for the follow-up general case.

 Follow-up:

 If there are n buckets and a pig drinking poison will die within m minutes,
 how many pigs (x) you need to figure out the "poison" bucket within p minutes? There is exact one bucket with poison.


 */
public class poorPigs {

    public static void main(String[] args) {
        poorPigs pp = new poorPigs();
        System.out.println( "So the pigs we need is  " + pp.poorPigs1(1000,15,60));
    }
    public int poorPigs1(int buckets, int minutesToDie, int minutesToTest) {
        int pigsNeeded =0;
        int affordablePartition = minutesToTest/ minutesToDie;
        int numberOfBucketsTotest = buckets / affordablePartition;
        pigsNeeded = findPigsNeeded(numberOfBucketsTotest);
        return pigsNeeded;
    }

    private int findPigsNeeded(int toTest) {
        int count =1;
        int divisor = toTest;
        while (divisor > 1) {
            divisor = divisor/2;
            count++;
        }
        return count;
    }
}
