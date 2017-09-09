package com.hack.leetcode;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by rafthab on 9/9/17.
 * Converting Decimal Number lying between 1 to 3999 to Roman Numerals
 * https://leetcode.com/problems/integer-to-roman/description/
 */
public class decimalToRoman {
    public static void main(String[] args) {

        decimalToRoman decimalToRomanObj = new decimalToRoman();
        decimalToRomanObj.intToRoman(3999);
    }

    public String intToRoman(int num) {
        LinkedHashMap<Integer, String> initHM = initHashMap();
        String romanOutPut = buildRoman(initHM, num);
//        System.out.println("Roman Conversion "+romanOutPut);
        return romanOutPut;
    }
    public String buildRoman(LinkedHashMap<Integer, String> initHM, Integer in ) {
        String retStr = new String();
        Integer tmp = in;
        do {
            Integer higestVal = getHighestVar(tmp);
            Map.Entry<Integer, String> retRomanEntry = getRomanIndex(initHM, higestVal);
            retStr += retRomanEntry.getValue();
            tmp -= retRomanEntry.getKey();
//            System.out.println("Tmp "+tmp+" higestval "+higestVal+"RomanVal "+retStr);
        } while (tmp > 0);
        return retStr;
    }


    public Map.Entry<Integer, String> getRomanIndex(LinkedHashMap<Integer, String> initHM, Integer highesInteger) {
        Map.Entry<Integer, String> prev = null;
        for(Map.Entry<Integer, String> me : initHM.entrySet()) {
            if(highesInteger >= me.getKey()) {
                prev = me;
            }
        }
        return prev;
    }
    public Integer getHighestVar(Integer smartInt) {
        // starting at 10
        Integer start = 10;
        while(smartInt > start) {
            start = start * 10;
        }
        return (smartInt/(start/10)) * (start /10);
    }
    public LinkedHashMap<Integer, String> initHashMap() {
        LinkedHashMap<Integer, String> init = new LinkedHashMap<>();
        init.put(1,"I");
        init.put(4,"IV");
        init.put(5,"V");
        init.put(9, "IX");
        init.put(10, "X");
        init.put(40, "XL");
        init.put(50, "L");
        init.put(90, "XC");
        init.put(100, "C");
        init.put(400, "CD");
        init.put(500, "D");
        init.put(900, "CM");
        init.put(1000, "M");
        return init;
    }
}
