package com.hack.leetcode;

/**
 * Created by rafthab on 1/4/18.
 */
public class singleNumbers {

    public static void main(String[] args) {
        singleNumbers sn = new singleNumbers();
        System.out.println("The missing number "+ sn.singleNumber(new int[] {1,2,3,4,5,5,3,4,1}));
    }
    public int singleNumber(int[] nums) {
        int rem = 0;
        for(int i=0; i<nums.length; i++) {
            rem = rem ^ nums[i];
        }
        return rem;
    }
}
