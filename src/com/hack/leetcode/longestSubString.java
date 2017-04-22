package com.hack.leetcode;

import java.util.HashMap;

/**
 * Created by rafthab on 4/22/17.
 */
public class longestSubString {
    /**
     *
     * https://leetcode.com/problems/longest-substring-without-repeating-characters/#/description
     * Given a string, find the length of the longest substring without repeating characters.

     Examples:

     Given "abcabcbb", the answer is "abc", which the length is 3.

     Given "bbbbb", the answer is "b", with the length of 1.

     Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

     Hide Company Tags
     */
    public static void main(String[] args) {
//        String input1 = new String("abcabcbb");
        String input1 = new String("pwwkew");
        char[] arrinput1 = input1.toCharArray();
        longestSubString lon = new longestSubString();
        HashMap<Character, Integer> gen = lon.generateHT();
        String longest = new String();
        for (int i = 0; i< arrinput1.length; i++) {
            String tmp = new String ();
            gen = lon.generateHT();
            for(int j = i ; j< arrinput1.length; j++) {
                if(lon.validateChar(gen, arrinput1[j])) {
                    tmp += arrinput1[j];
                } else {
                    j = arrinput1.length;
                }
            }
            System.out.println("Tmp Longest " + tmp);
            if(tmp.length() > longest.length()) {
                longest = tmp;
            }
        }
        System.out.println("Longest " + longest);
    }

    public HashMap<Character, Integer> generateHT() {
        HashMap<Character, Integer> hm = new HashMap<>();
        int begin = 'a';
        for(int i =0 ; i<26 ; i++) {
            hm.put((char)begin, 1);
            begin++;
        }
        return hm;
    }

    public boolean validateChar(HashMap<Character, Integer> hm , Character c) {
        Integer key = hm.get(c);
        if(key == null || key == 0) {
            return false;
        } else if (key > 0) {
            key--;
            hm.put(c,key);
            return true;
        }
        return false;
    }
}
