package com.hack.g2g;

import java.util.HashMap;

/**
 * Created by rafthab on 1/10/18.
 *
 * Input :  string = "this is a test string"
 pattern = "tist"
 Output :  Minimum window is "t stri"
 Explanation: "t stri" contains all the characters
 of pattern.

 Input :  string = "geeksforgeeks"
 pattern = "ork"
 Output :  Minimum window is "ksfor"
 */
public class smallestWindowInString {
    public String smallestWindow(String inputString, String smallStr) {
        String retStr = new String();
        char[] inputArr = inputString.toCharArray();
        char[] smallArr = smallStr.toCharArray();
        HashMap <Character, Integer> hm = new HashMap<>();
        int smallStrLen = smallArr.length;
        // recording the string in a hashmap
        for(char c : smallArr) {
            if(hm.get(c) == null) {
                hm.put(c,1);
            } else {
                Integer i = hm.get(c);
                i++;
                hm.put(c, i);
            }
        }


        return retStr;
    }
}
