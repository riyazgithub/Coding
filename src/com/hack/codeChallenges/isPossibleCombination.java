package com.hack.codeChallenges;

/**
 * Created by rafthab on 2/28/17.
 */
public class isPossibleCombination {
    static String isPossible(int a, int b, int c, int d) {
        String possibility = "No";
        Boolean firstPass = false;
        Boolean secondPass = false;
        int tmpC = c;
        int tmpD = d;
        int tmpA = a;
        int tmpB = b;
        tmpC -= tmpA;
        while (tmpC > 0) {
            tmpC -= tmpB;
        }
        if (tmpC == 0) {
            firstPass = true;
        }
        tmpA = c;
        tmpD -= tmpB;
        while (tmpD > 0) {
            tmpD -= tmpA;
        }
        if (tmpD == 0) {
            secondPass = true;
        }
        if(firstPass && secondPass) {
            possibility = "Yes";
        }
        return possibility;
    }

    public static void main(String[] args) {
        System.out.println(isPossible(1,4,5,9));
        System.out.println(isPossible(1,2,3,6));
    }
}
