package com.hack.leetcode;

import com.hack.datastructure.LLNode;
import com.hack.datastructure.LLUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by rafthab on 1/7/18.
 */
public class mergeLinkedList {

    public LLNode mergeTwoLists(LLNode l1, LLNode l2) {
        if(l1 == null) {
            return l2;
        }
        LLNode mixNode = new LLNode(l1.value);
        LLNode head = mixNode;
        l1 = l1.next;
        while (l1 !=null && l2!=null) {
            mixNode.next = new LLNode(l2.value);
            mixNode = mixNode.next;
            mixNode.next = new LLNode(l1.value);
            mixNode = mixNode.next;
            l1 = l1.next; l2 = l2.next;
        }
        LLNode rem;
        if (l1 == null) {
            rem = l2;
        } else {
            rem = l1;
        }
        while(rem!= null) {
            mixNode.next = new LLNode(rem.value);
            rem = rem.next;
        }
        return head;
    }

    public int length(LLNode l1) {
        int count = 0;
        while (l1 != null) {
            count++;
            l1 = l1.next;
        }
        return count;
    }

    public void printLength(LLNode l1) {
        String str = new String();
        while (l1!=null) {
            str += l1.value;
            if(l1.next !=null)
                str += "->";
            l1 = l1.next;
        }
        System.out.println(" LL " + str);
    }

    @Test
    public void testMerging() {
        LLUtils llUtils = new LLUtils();
        llUtils.insertAtHead("1");
        llUtils.insertAtHead("2");
        llUtils.insertAtHead("3");
        llUtils.insertAtHead("4");
        llUtils.insertAtHead("5");
        LLNode l1 = llUtils.getHead();
        llUtils = new LLUtils();
        llUtils.insertAtHead("1");
        llUtils.insertAtHead("2");
        llUtils.insertAtHead("3");
        llUtils.insertAtHead("4");
        llUtils.insertAtHead("5");
        LLNode l2 = llUtils.getHead();
        mergeLinkedList mll = new mergeLinkedList();
        LLNode mixNode = mll.mergeTwoLists(l1, l2);
        int len = mll.length(mixNode);
        mll.printLength(mixNode);
        Assert.assertEquals(len, 10, "Length mismatch");

    }

}
