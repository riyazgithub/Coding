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
        if(s.length() == 1) return s;
        String longestPalindromeStr = new String();
        String possiblePalindrome = new String();
        int longestPossibleLen = 1;
        char[] inputStr = s.toCharArray();
        for(int i =0; i<inputStr.length-1; i++) {
            for(int j = i+1; j<inputStr.length; j++) {
                if(j-i+1 > longestPossibleLen) {
                    if(isPalindrome(inputStr,i,j)) {
                        longestPossibleLen = j-i+1;
                        longestPalindromeStr = s.substring(i,j+1);
                    }
                }
            }
        }
        if(longestPossibleLen == 1) {
            longestPalindromeStr = s.substring(0,1);
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
        System.out.println("Final " + lps.longestPalindrome("bb"));
        System.out.println("Final " + lps.longestPalindrome("geeksskeeg"));
        System.out.println("Final " + lps.longestPalindrome("abcda"));
    }

}
