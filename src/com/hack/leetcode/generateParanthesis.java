package com.hack.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by rafthab on 9/16/17.
 * https://leetcode.com/problems/generate-parentheses/description/
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 *
 * [
 "((()))",
 "(()())",
 "(())()",
 "()(())",
 "()()()"
 ]
 */
public class generateParanthesis {
    public static void main(String[] args) {
        generateParanthesis gen = new generateParanthesis();
        long startTime = System.nanoTime();
        gen.generateParenthesis(6);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime)/1000000000;
        System.out.println("Duration Taken in ms "+ duration);
    }

    public List<String> generateParenthesis(int n) {
        String inputString = new String();
        for(int i =0;i<n;i++) {
            inputString +="()";
        }
        List<String> retList = new ArrayList<String>();
        permuteParanthesis(inputString.toCharArray(), (ArrayList<String>) retList, 0, n*2 -1);
        return retList;
    }

    public  void permuteParanthesis(char[] arrOfChar, ArrayList<String> retList, int l, int r) {
        if(l == r && validateParan(arrOfChar)) {
            String str = String.valueOf(arrOfChar);
            System.out.println("String "+ str);
            if(retList.indexOf(str) < 0) {
                retList.add(str);
            }
        } else {
            for(int i =l; i<=r; i++) {
                arrOfChar = swap(arrOfChar, l, i);
                permuteParanthesis(arrOfChar, retList, l+1, r);
                arrOfChar = swap(arrOfChar, l, i);
            }
        }
    }

    public char[] swap(char[] str, int l, int r) {
        char tmp = str[l];
        str[l] = str[r];
        str[r] = tmp;
        return str;
    }

    public boolean validateParan(char[] string) {
        int openCount = 0;
        for(char c : string) {
            if(c == '(') {
                openCount++;
            } else if(c == ')') {
                openCount--;
                if(openCount < 0) return false;
            }
        }
        if (openCount !=0) return false;
        return true;
    }
}
