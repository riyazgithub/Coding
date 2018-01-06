package com.hack.leetcode;

import com.hack.datastructure.BSTNode;
import com.hack.datastructure.BSTUtils;
import org.testng.Assert;

/**
 * Created by rafthab on 1/5/18.
 */
public class findMaxDepthInaBinaryTree {
    public static void main(String[] args) {
        BSTUtils bstUtils = new BSTUtils();
        // Checking empty
        Assert.assertTrue(bstUtils.isEmpty(), "The root is not empty at the beginning");
        bstUtils.insert(6); bstUtils.insert(4);bstUtils.insert(7);bstUtils.insert(3);bstUtils.insert(10);
        bstUtils.insert(1); bstUtils.insert(11);bstUtils.insert(2);bstUtils.insert(22);bstUtils.insert(5);
        findMaxDepthInaBinaryTree fmd = new findMaxDepthInaBinaryTree();
        System.out.println(fmd.maxDepth(bstUtils.getRoot()));
    }
    public int maxDepth(BSTNode root) {
        if(root == null) {
            return 0;
        }
        int ldepth = maxDepth(root.left);
        int rdepth = maxDepth(root.right);
        if(ldepth > rdepth)
            return ldepth +1;
        else
            return rdepth +1;
    }
}
