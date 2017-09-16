package com.hack.leetcode;

import java.util.ArrayList;

/**
 * Created by rafthab on 9/13/17.
 */
public class zigzagConversion {
    public static void main(String[] args) {
        zigzagConversion zz = new zigzagConversion();
        zz.convert("paypalishiring", 3);
    }
    public String convert(String s, int numRows) {
        String newStr = new String();
        String[] arrStr = generateArrayofStr(s, numRows);
        int middle = numRows/2;
        for(int i =0; i<numRows; i++) {
            int incr = 2;
            if(i == middle) incr =1;
            for(int j =0; j< arrStr.length; j=j+incr) {
                if(j%2 == 1){
                    newStr+=arrStr[j].charAt(0);
                }
                else if(arrStr[j].length() > i)
                newStr+=arrStr[j].charAt(i);
            }
        }
       return newStr;
    }

    public String[] generateArrayofStr(String s, int numRows){
        ArrayList<String> insert = new ArrayList<>();
        String newStr = new String();
        char[] cArr = s.toCharArray();
        int tmpCounter = 0;
        boolean even = false;
        for(int i =0; i<cArr.length; i++) {
            if(!even && tmpCounter<numRows) {
                newStr += cArr[i];
                tmpCounter++;
            } else if(even) {
                newStr += cArr[i];
                even = !even;
                System.out.println("Tmp Str "+ newStr);
                insert.add(newStr);
                tmpCounter = 0;
                newStr = new String();
            } else {
                tmpCounter = 0;
                i--;
                even = !even;
                System.out.println("Tmp Str "+ newStr);
                insert.add(newStr);
                newStr = new String();
            }
        }
        System.out.println("Tmp Str "+ newStr);
        insert.add(newStr);
        String[] stockArr = new String[insert.size()];
        stockArr = insert.toArray(stockArr);
        return stockArr;
    }
}
