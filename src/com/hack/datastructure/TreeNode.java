package com.hack.datastructure;

/**
 * Created by rafthab on 1/9/17.
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
    public String toString() {
        return this.val + " " + this.left + " " + this.right;
    }

    public static void main(String[] args) {

    }

}
