package com.hack.leetcode;

/**
 * Created by rafthab on 6/7/17.
 */
public class longestPalidromicsubstring {

/*    https://leetcode.com/problems/longest-palindromic-substring/#/description
    Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

    Input: "babad"

    Output: "bab"

    Note: "aba" is also a valid answer.

            Input: "cbbd"

    Output: "bb"
    */
    public String longestPalindrome(String s) {
        String longestPalindromeStr = new String();
        String possiblePalindrome = new String();
        int longestPossibleLen = 1;
        char[] inputStr = s.toCharArray();
        for (int count = 2; count < inputStr.length; count++) {
            for(int i = 0 ; i < inputStr.length-count+1; i++) {
                if(true) {
                    System.out.println(s.substring(i, i+count) + " " + isPalindrome(inputStr, i, i+count-1));
//                    Integer.pa
                }
            }
        }
        return longestPalindromeStr;

    }

    private boolean isPalindrome(char[] inputChar, int start, int end) {
        boolean isPalin = true;
        int strLen = end -start;
        for(int index = 0; index<Math.ceil((double)strLen/2); index++) {
            if(inputChar[start+index] != inputChar[end-index])
            {
                return !isPalin;
            }
        }
        return isPalin;
    }

    public static void main(String[] args) {
        longestPalidromicsubstring lps = new longestPalidromicsubstring();
        lps.longestPalindrome("babaaabd");
    }

}
