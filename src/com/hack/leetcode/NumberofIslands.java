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

 */
public class NumberofIslands {

    private int numIslandsHelper(char[][] grid, int currx, int curry, int row, int col) {
        if(currx >= col || curry >= row) {
            return 0;
        }
        System.out.print(grid[currx][curry]);
        numIslandsHelper(grid, currx, curry+1,row,col);
        numIslandsHelper(grid, currx+1, curry,row,col);
        return -1;
    }
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = 0;
        if(row > 0) {
            col = grid[0].length;
        }
        numIslandsHelper(grid,0,0,col,row);
        return -1;
    }

    public static void main(String[] args) {
//        char [][] gridArray = {{'1','1','0','0','0'}, {'1','1','0','0','0'}, {'0','0','1','0','0'}, {'0','0','0','1','1'}};
        char [][] gridArray = {{'1','2','3','4','5'}, {'6','7','8','9','a'}, {'b','c','d','e','f'}, {'g','h','i','j','k'}};
        NumberofIslands numberofIslands = new NumberofIslands();
        numberofIslands.numIslands(gridArray);

    }
}
