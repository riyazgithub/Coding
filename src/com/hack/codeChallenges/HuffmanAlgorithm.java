package com.hack.codeChallenges;

/**
 * Created by rafthab on 2/28/17.
 */
public class HuffmanAlgorithm {

    static String compress(String str) {
        String retStr = "";
        if (str != null) {
            char[] strArr = str.toCharArray();
            int strlen = strArr.length;
            int count = 1;
            if (strlen > 0) {
                retStr += strArr[0];
                for (int i = 1; i < strlen ; i++) {
                    if(strArr[i] == strArr[i-1]) {
                        count++;
                    } else {
                        if(count > 1) {
                            retStr += String.valueOf(count);
                        }
                        count = 1;
                        retStr += strArr[i];
                    }
                }
                if(count > 1) {
                    retStr += String.valueOf(count);
                }

            }

        }

        return retStr;
    }

    public static void main(String[] args) {
        System.out.println("Return " + compress("aaaaabbbbbbbbbccccdeeeeeeej"));
    }
}
