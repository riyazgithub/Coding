package com.hack.leetcode;

/**
 * Created by rafthab on 9/16/17.
 * https://leetcode.com/problems/3sum-closest/description/
 *     For example, given array S = {-1 2 1 -4}, and target = 1.
 *     The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 *     [1,1,-1,-1,3] 3
 */
public class sumClosest {
    public static void main(String[] args) {
        sumClosest sc = new sumClosest();
        sc.threeSumClosest(new int[]{-1,2,1,-4}, 1);
    }
    public int threeSumClosest(int[] nums, int target) {
        int closestSum = 0;
        int[] modifiedNum = parse1(nums);
        int[] modifiedNum1 = parse2(modifiedNum, target);
        int findMinIndex = findMin(modifiedNum1);
        return modifiedNum[findMinIndex];

    }

    public int findMin(int[] modified) {
        int min = modified[2];
        int retIndex = 2;
        for(int i = 2; i<modified.length; i++) {
            if(min > modified[i]) {
                min = modified[i];
                retIndex = i;
            }
        }
        return retIndex;
    }
    public int[] parse1(int[] nums) {
        int[] retNum = new int[nums.length];
        for(int i=2; i<nums.length; i++) {
            retNum[i] = nums[i-2] + nums[i-1] + nums[i];
        }
        return retNum;
    }

    public int[] parse2(int[] nums, int target) {
        int[] retNum = new int[nums.length];
        for(int i=2; i<nums.length; i++) {
            retNum[i] = Math.abs(nums[i] - target);
        }
        return retNum;
    }

}
