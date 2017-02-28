package com.hack.leetcode;

/**
 * Created by rafthab on 1/17/17.
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 *
 * https://leetcode.com/problems/number-of-islands/

 11000
 11000
 00100
 00011
 Solution 3

 11110
 11010
 11000
 00000
 Solution 1

 char [][] gridArray = {{'1','1','1','1','0'}, {'1','1','0','1','0'}, {'1','1','0','0','0'}, {'0','0','0','0','0'}};
 */
public class NumberofIslands {



    private boolean validate (int row, int col, char[][] grid, boolean[][] visitedArray, int rolLength, int colLength) {
        if (row >= 0 && row < rolLength && col >= 0 && col < colLength) {
            if(grid[row][col] == '1' && visitedArray[row][col] == false) {
                return true;
            }
        }
        return false;
    }

    private int numIslandsHelper(char[][] grid, int currx, int curry, boolean[][] visitedArray) {
//        int[] rArr = new int[]{0, -1, 1, 0, -1, 1, -1, 1};
//        int[] cArr = new int[]{1, 1, 1, -1, -1, -1, 0, 0};
        int[] rArr = new int[]{-1, 0, 1, 0};
        int[] cArr = new int[]{0, 1, 0, -1};

        visitedArray[currx][curry] = true;
        for(int i = 0; i< rArr.length; i++) {
            if(validate(currx+rArr[i], curry+cArr[i], grid, visitedArray, grid.length, grid[0].length)) {
                numIslandsHelper(grid, currx+rArr[i], curry+cArr[i], visitedArray);
            }
        }

        return -1;
    }
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = 0;
        if(row > 0) {
            col = grid[0].length;
        }
        int count = 0;
        boolean [][] visitedArray = new boolean[row][col];
        for(int i =0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(visitedArray[i][j] == false && grid[i][j] == '1') {
                    count++;
                    numIslandsHelper(grid, i, j, visitedArray);
                }
            }
        }
        System.out.println("Before Returning" + count);
        return count;
    }

    public static void main(String[] args) {
//        char [][] gridArray = {{'1','1','0','0','0'}, {'1','1','0','0','0'}, {'0','0','1','0','0'}, {'0','0','0','1','1'}};
        char [][] gridArray = {{'1','1','1','1','0'}, {'1','1','0','1','0'}, {'1','1','0','0','0'}, {'0','0','0','0','0'}};
//        char [][] gridArray = {"11110","11010","11000","00000"};
//        char [][] gridArray = {{'1','2','3','4','5'}, {'6','7','8','9','a'}, {'b','c','d','e','f'}, {'g','h','i','j','k'}};
        NumberofIslands numberofIslands = new NumberofIslands();
        numberofIslands.numIslands(gridArray);

    }
}
