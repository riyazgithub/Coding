package com.hack.datastructure;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.w3c.dom.ls.LSInput;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rafthab on 3/19/17.
 */
public class BSTUtils {

    BSTNode root;

    public BSTUtils() {
        this.root = null;
    }

    public boolean isEmpty() {
        if (this.root == null)  {
            return true;
        }
        return false;
    }

    public void insert(int nodeValue) {
        if(isEmpty()) {
            this.root = new BSTNode((nodeValue));
        }
        this.root = insertHelper(this.root, nodeValue);
    }

    private BSTNode insertHelper(BSTNode root1, int nodeValue) {
        if(root1 == null) {
            return new BSTNode(nodeValue);
        } else if (root1.val > nodeValue) {
            root1.left = insertHelper(root1.left, nodeValue);
        } else {
            root1.right = insertHelper(root1.right, nodeValue);
        }
        return root1;
    }

    public List<Integer> inOrder() {
        List<Integer> returnString = new ArrayList<>();

        inOrderHelper(this.root, returnString);

        return returnString;
    }

    private void inOrderHelper(BSTNode root1, List<Integer> inOr) {
        if(root1 == null) {
            return;
        }
        inOrderHelper(root1.left, inOr);
        inOr.add(root1.val);
        inOrderHelper(root1.right, inOr);
    }

    public BSTNode findNode(int find) {
        BSTNode findNode  = findNodeHelper(this.root,  find);
        return findNode;
    }

    private BSTNode findNodeHelper(BSTNode root1, int find) {
        if(root1 == null) {
            return null;
        } else if(root1.val > find) {
            return findNodeHelper(root1.left, find);
        } else if(root1.val < find) {
            return findNodeHelper(root1.right, find);
        } else {
            return root1;
        }
    }

    @Test
    public void testInsert() {
        BSTUtils bstUtils = new BSTUtils();
        // Checking empty
        Assert.assertTrue(bstUtils.isEmpty(), "The root is not empty at the beginning");
        bstUtils.insert(6); bstUtils.insert(4);bstUtils.insert(7);bstUtils.insert(3);bstUtils.insert(10);
        bstUtils.insert(1); bstUtils.insert(11);bstUtils.insert(2);bstUtils.insert(22);bstUtils.insert(5);
        List<Integer> inorder = bstUtils.inOrder();
        Assert.assertTrue(inorder.get(inorder.size()-1) == 22, "The inOrder traversal is incorrect");
    }
     @Test
    public void testFindNode() {
         BSTUtils bstUtils = new BSTUtils();
         // Checking empty
         Assert.assertTrue(bstUtils.isEmpty(), "The root is not empty at the beginning");
         bstUtils.insert(6); bstUtils.insert(4);bstUtils.insert(7);bstUtils.insert(3);bstUtils.insert(10);
         bstUtils.insert(1); bstUtils.insert(11);bstUtils.insert(2);bstUtils.insert(22);bstUtils.insert(5);
        BSTNode node1 = bstUtils.findNode(11);
        Assert.assertTrue(node1.val == 11, "Node not found !!");
     }

}


