package com.hack.g2g;

/**
 * Created by rafthab on 1/11/18.
 */
public class printCombinationOfLr {

    public void combinationUtil(char[] input, int start, int end, char[] out, int index, int r) {
        if(index == r) {
            String printStr = new String();
            for(int i =0; i< out.length; i ++){
                printStr += out[i];
            }
            System.out.println(printStr);
            return;
        }

        for(int i = start; i<=end && end-i+1 >= r-index; i++) {
            out[index] = input[i];
            combinationUtil(input,start +1, end,out, index +1, r);
        }


    }
    public void printCombination(char[] input, int r) {
        char[] out = new char[r];
        combinationUtil(input, 0, input.length -1, out, 0, r);
    }
    public static void main(String[] args) {
        char[] arr = {'1', '2', '3', '4', '5'};
        printCombinationOfLr plr = new printCombinationOfLr();
        plr.printCombination(arr, 3);
    }
}
