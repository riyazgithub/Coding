package com.hack.datastructure;

/**
 * Created by rafthab on 1/9/17.
 */

public class BinaryTree {

    public static TreeNode head;
     private TreeNode insertLeft(TreeNode at, int val) {
         at.left = new TreeNode(val);
         return at.left;
     }
    private TreeNode insertRight(TreeNode at, int val) {
        at.right = new TreeNode(val);
        return at.right;
    }
    public void printTree(TreeNode pointer) {
         if(pointer == null) {
             return;
         }
         printTree(pointer.left);
        System.out.print(pointer.val + " ");
        printTree(pointer.right);
    }

    public void printTreeWithLevel(TreeNode pointer,int level) {
        if(pointer == null) {
            return;
        }
        printTreeWithLevel(pointer.left, level+1);
        System.out.print("v:" + pointer.val + " l: " + level);
        printTreeWithLevel(pointer.right, level+1);
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        // define head
        BinaryTree.head = new TreeNode(0);
        TreeNode one = bt.insertLeft(BinaryTree.head,1);
        TreeNode two = bt.insertRight(BinaryTree.head,2);

        TreeNode oneone = bt.insertLeft(one, 11);
        TreeNode onetwo = bt.insertRight(one, 12);

        TreeNode twoone = bt.insertLeft(two, 21);

        bt.printTree(BinaryTree.head);
    }
}
