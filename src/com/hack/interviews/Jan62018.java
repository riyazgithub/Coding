package com.hack.interviews;

/**
 * Created by rafthab on 1/6/18.
 */

class Jan62018 {

    public static void main(String[] args) {
        Jan62018 j6 = new Jan62018();

        System.out.println(j6.solution(new int[]{1,2,2,3,5},5));
        System.out.println(j6.solution(new int[]{1,2,2,3,4,5},5));
        System.out.println(j6.solution(new int[]{1,2,2,4,3,5},5));
        System.out.println(j6.solution(new int[]{1,3,3,3,4,5},5));
        System.out.println(j6.solution(new int[]{2,2,3,4,5},5));

    }
public boolean solution(int[] A, int K) {
int n = A.length;
for (int i = 0; i < n - 1; i++) {
if ( A[i]+1 < A[i + 1]) // Added check for negative integers or 0 in A
return false;
}
if (A[0] != 1 || A[n - 1] != K)
return false;
else
return true;
}
}