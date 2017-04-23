package com.hack.leetcode;

/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

 For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

 Note:
 You must do this in-place without making a copy of the array.
 */
public class moveZeros {
    public static void main(String[] args) {
        moveZeros mv = new moveZeros();
        int[] nums = {0, 1, 0, 3, 12};
//        int[] nums = {0,0,1};
        System.out.println("Before " + nums);
        mv.moveZeroes(nums);
        System.out.println("After " + nums.toString());
    }

    public void moveZeroes(int[] nums) {
        for(int i = nums.length-1 ; i >= 0; i--) {
            if (nums[i] == 0) {
                swapArrays(nums,i,nums.length);
            }
        }
    }

    private void swapArrays(int[] nums, int i, int length) {
        for (int j =i ; j<length-1; j++) {
            int swap = nums[j];
            nums[j] = nums[j+1];
            nums[j+1] = swap;
        }
    }
}
