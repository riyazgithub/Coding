package com.hack.leetcode;

import com.hack.datastructure.LLNode;
import com.hack.datastructure.LLUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by rafthab on 3/6/17.
 * https://leetcode.com/problems/add-two-numbers/?tab=Description
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes
 * contain a single digit. Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8

 */
public class LListAddition {
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//
//    }

    public LLNode addTwoNumbers(LLUtils l1, LLUtils l2) {
        LLNode retNode = null;

        return  retNode;


    }

    @Test
    public void testBasicLL() {
        LLUtils l1 = new LLUtils();
        LLUtils l2 = new LLUtils();
        l1.insertAtHead("3");
        l1.insertAtHead("4");
        l1.insertAtHead("2");
        Assert.assertTrue(l1.getIntAt(0) == 2, "Oder dont match for 2");
        Assert.assertTrue(l1.getIntAt(2) == 3, "Oder dont match for 3");
    }
}
