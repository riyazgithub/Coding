package com.hack.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rafthab on 4/23/17.
 */
public class geneticMutation {
    public static void main(String[] args) {
//        String start = "AAAAACCC";
//        String end = "AACCCCCC";
//        String[] bank = {"AAAACCCC", "AAACCCCC", "AACCCCCC"};
        String start = "AACCTTGG";
        String end = "AATTCCGG";
        String[] bank = {"AATTCCGG","AACCTGGG","AACCCCGG","AACCTACC"};

        geneticMutation gm = new geneticMutation();
        System.out.println(gm.minMutation(start,end,bank));
    }

    public int minMutation(String start, String end, String[] bank) {
        char[] sArr = start.toCharArray();
        char[] eArr = end.toCharArray();
        int count = 0;
        int cursor = 0;
        boolean circleFlag = true;
        if(bank.length == 0) return -1;
        List<Integer> ci = identifyChange(sArr, eArr);
        while (ci.size() >0) {
            int index = ci.get(cursor);
            if(isValid(index, sArr, eArr, bank)) {
                ci.remove(cursor);
                cursor = 0;
                System.out.println("Change " + new String (sArr));
                count++;
            } else {
                cursor++;
                if(cursor >= ci.size() && circleFlag) {
                    cursor =0;
                    circleFlag = false;
                } else if(cursor >= ci.size()) {
                    return -1;
                }
            }
        }
        return count;
    }

    private boolean isValid(int index, char[] start, char[] end, String[] bank) {
        char tmp = start[index];
        start[index] = end[index];
        String tmpStr = new String(start);
        if(inBank(bank, tmpStr)) {
            return true;
        } else {
            start[index] = tmp;
            return false;
        }

    }

    private boolean inBank(String[] bank, String tmpStr) {
        for(String str : bank) {
            if(str.equals(tmpStr)) {
                return true;
            }
        }
        return false;
    }


    private List<Integer> identifyChange(char[] start, char[] end) {
        List<Integer> retArr = new ArrayList<Integer>();
        for(int i = 0; i<start.length ; i++) {
            if(start[i] != end[i]) {
                retArr.add(i);
            }
        }
        return retArr;
    }
}
