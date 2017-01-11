package com.hack.datastructure;

/**
 * Created by rafthab on 1/9/17.
 */

public class BinaryTree {

    TreeNode head;
     private void insertLeft(TreeNode at, int val) {
         at.left = new TreeNode(val);
     }
    private void insertRight(TreeNode at, int val) {
        at.right = new TreeNode(val);
    }
    public void printTree(TreeNode head) {

    }

}
