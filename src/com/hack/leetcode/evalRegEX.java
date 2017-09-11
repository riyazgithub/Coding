package com.hack.leetcode;


import com.sun.tools.corba.se.idl.StringGen;

/*
 Created by rafthab on 9/11/17.

https://leetcode.com/problems/regular-expression-matching/description/
 '.' Matches any single character.
 '*' Matches zero or more of the preceding element.

 The matching should cover the entire input string (not partial).

 The function prototype should be:
 bool isMatch(const char *s, const char *p)

 Some examples:
 isMatch("aa","a") → false
 isMatch("aa","aa") → true
 isMatch("aaa","aa") → false
 isMatch("aa", "a*") → true
 isMatch("aa", ".*") → true
 isMatch("ab", ".*") → true
 isMatch("aab", "c*a*b") → true
 */
public class evalRegEX {
     public static void main(String[] args) {
      evalRegEX evalR = new evalRegEX();
         System.out.println("So is it a match "+evalR.isMatch("aabccbdef", "a*bc*bdef"));
     }

     public boolean isMatch(String s, String p) {
         String convertedInput = convertString(s);
         System.out.println("Original: "+s+" Converted String: " + convertedInput);
         Boolean isMatchReturn = true;

         return isMatchReturn;
     }

     public String convertString(String s) {
         String returnStr = new String();
         char[] sArr = s.toCharArray();
         for (int i = 0; i<sArr.length; i++) {
             int occurance = 0;
             char prev = sArr[i];
             while(i<sArr.length && prev==sArr[i]) {
                 i++;
                 occurance++;
             }
             i--;
             returnStr += prev + "" +occurance;
         }
         return returnStr;
     }
}
