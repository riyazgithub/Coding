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

    public LLNode addTwoNumbers(LLNode l1, LLNode l2) {
        LLNode retNode = null;
        LLNode lastNode = null;
        int carryOver = 0;
        while(l1 != null || l2 != null) {
            int sum = 0;
            if(l1!=null) {
                sum += l1.intValue;
            }
            if(l2 != null) {
                sum += l2.intValue;
            }
            if(carryOver !=0) {
                sum += carryOver;
                carryOver =0;
            }
            if(sum > 9) {
                carryOver = sum - 9;
                sum = sum % 10;
            }
            LLNode newNode = new LLNode(sum);
            if(retNode == null) {
                retNode = newNode;
                lastNode = newNode;
            } else {
                lastNode.next = newNode;
                lastNode = newNode;
            }
            if(l1 !=null) {
                l1 =l1.next;
            }
            if(l2 !=null) {
                l2 =l2.next;
            }

        }
        return  retNode;
    }

    @Test
    public void testBasicLL() {
        LLUtils l1 = new LLUtils();
        l1.insertAtHead("3");
        l1.insertAtHead("4");
        l1.insertAtHead("2");
        Assert.assertTrue(l1.getIntAt(0) == 2, "Oder dont match for 2");
        Assert.assertTrue(l1.getIntAt(2) == 3, "Oder dont match for 3");
    }
    @Test
    public void testAddition() {
        LLUtils l1 = new LLUtils();
        LLUtils l2 = new LLUtils();
        l1.insertAtHead("3");
        l1.insertAtHead("4");
        l1.insertAtHead("2");
        Assert.assertTrue(l1.getIntAt(0) == 2, "Oder dont match for 2");
        Assert.assertTrue(l1.getIntAt(2) == 3, "Oder dont match for 3");
        l2.insertAtHead("4");
        l2.insertAtHead("6");
        l2.insertAtHead("5");
        LLUtils retUtils = new LLUtils();
        LListAddition lListAddition = new LListAddition();
        retUtils.head = lListAddition.addTwoNumbers(l1.head, l2.head);
        Assert.assertTrue(retUtils.getIntAt(0) == 7, "Oder dont match for 7");
        Assert.assertTrue(retUtils.getIntAt(1) == 0, "Oder dont match for 0");
        Assert.assertTrue(retUtils.getIntAt(2) == 8, "Oder dont match for 8");

    }
}
