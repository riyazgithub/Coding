package com.hack.leetcode;

/**
 * Created by rafthab on 9/14/17.
 * https://leetcode.com/problems/reverse-integer/description/
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 */
public class reverseint {
    public static void main(String[] args) {
        reverseint ri = new reverseint();
        System.out.println(ri.reverse(-2147));

    }
    public int reverse(int x) {
        boolean positive = true;
        int returnInt = 0;
        if (x < -2147483647)
            return returnInt;
        if(x < 0) {
            positive = false;
            x = x * -1;
        }
        String rev = String.valueOf(x);
        rev = new StringBuilder(rev).reverse().toString();
        long revDouble = Long.parseLong(rev);
        if(revDouble > 2147483647)
            return returnInt;
        returnInt = Integer.parseInt(rev);
        if(!positive)
            returnInt = returnInt * -1;

        return returnInt;
    }
}
