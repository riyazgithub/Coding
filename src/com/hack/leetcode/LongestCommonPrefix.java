package com.hack.leetcode;

/**
 * Created by rafthab on 9/11/17.
 * Write a function to find the longest common prefix string amongst an array of strings.
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        String[] strs = {"Leetsingle","Leetcode", "LeeBruce", "LeetCode"};
        System.out.println("Common Prefix " + lcp.longestCommonPrefix(strs));
    }
    public String longestCommonPrefix(String[] strs) {
        String commonPrefix = new String ();
        if(strs.length>0) {
            commonPrefix = strs[0];
            for(int i =1; i< strs.length; i++) {
                commonPrefix = commonPrefix(commonPrefix,strs[i]);
            }
        }

        return commonPrefix;
    }

    public String commonPrefix(String str1, String sr2){
        String commonPrefix = new String();
        Integer len = str1.length()>sr2.length()? sr2.length() : str1.length();
        for(int i =0; i<len; i++){
            if(str1.charAt(i) == sr2.charAt(i)) {
                commonPrefix += str1.charAt(i);
            } else {
                i = len;
            }
        }
        return commonPrefix;
    }
}
