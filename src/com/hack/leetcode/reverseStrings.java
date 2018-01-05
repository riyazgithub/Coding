package com.hack.leetcode;

/**
 * Created by rafthab on 1/4/18.
 */
public class reverseStrings {

    public static void main(String[] args) {
        reverseStrings rs = new reverseStrings();
        System.out.println(rs.reverseString("Riyaz"));
    }
    public String reverseString(String s) {

        char[] sArr = s.toCharArray();
        char[] rev = new char[sArr.length];
        int position = 0;
        for (int i =sArr.length-1 ; i>=0; i--) {
            rev[position] = sArr[i];
            position++;
        }
        return new String(rev);
    }
}
