package com.hack.datastructure;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by rafthab on 3/5/17.
 */
public class LLUtils {
    public LLNode getHead() {
        return head;
    }

    public LLNode head;
    public boolean isEmpty() {
        if(head == null) {
            return true;
        } else {
            return false;
        }
    }
    public void insertAtHead(String val) {

        LLNode newHead = new LLNode(val);
        if(isEmpty()) {
            this.head = newHead;
        } else {
            newHead.next = this.head;
            this.head = newHead;
        }
    }

    public String removeNode(String val) {
        if(isEmpty()) {
            return null;
        } else if(this.head.value.equals(val)){
            // If head just move on
            this.head = this.head.next;
            return val;
        }
        LLNode traverse = this.head.next;
        LLNode prev = this.head;
        while(traverse != null) {
            if(traverse.value.equals(val)){
                prev.next = traverse.next;
                return val;
            }
            prev = traverse;
            traverse = traverse.next;
        }
        return null;
    }

    public int length() {
        int retCount = 0;
        LLNode traverse = this.head;
        while (traverse != null) {
            retCount++;
            traverse = traverse.next;
        }
        return retCount;
    }

    public String getValueAt(int index) {
        int parseThrough = 0;
        LLNode traverse = this.head;
        while (parseThrough != index && traverse!=null) {
            traverse = traverse.next;
            parseThrough++;
        }
        if(parseThrough == index && traverse!=null) {
            return traverse.value;
        }
        return null;
    }

    public Integer getIntAt(int index) {
        int parseThrough = 0;
        LLNode traverse = this.head;
        while (parseThrough != index && traverse!=null) {
            traverse = traverse.next;
            parseThrough++;
        }
        if(parseThrough == index && traverse!=null) {
            return Integer.parseInt(traverse.value);
        }
        return -1;
    }

    public void revNode() {
        LLNode revNode = null;
        LLNode traverse = this.head;
        while (traverse !=null) {
            LLNode curr = revNode;
            revNode = new LLNode(traverse.value);
            revNode.next = curr;
            traverse = traverse.next;
        }
        this.head = revNode;
    }

    // Duplicate of the below one revinplace
    public void reverseWhile() {
        LLNode revNode = this.head;
        LLNode nextNode = revNode.next;
        revNode.next = null;
        while(nextNode !=null) {
            LLNode curr = nextNode;
            nextNode = nextNode.next;
            curr.next = revNode;
            revNode =curr;
        }
        this.head = revNode;

    }


















    public void revNodeInPlace() {
        if(this.head !=null) {
            LLNode revNode = this.head;
            LLNode nextNode = this.head.next;
            revNode.next = null;
            while (nextNode != null) {
                LLNode currNode = nextNode;
                nextNode = nextNode.next;
                currNode.next = revNode;
                revNode = currNode;
            }
            this.head = revNode;
        }
    }
    @Test
    public void testInsertion() {
        LLUtils llUtils = new LLUtils();
        llUtils.insertAtHead("1");
        llUtils.insertAtHead("2");
        llUtils.insertAtHead("3");
        llUtils.insertAtHead("4");
        llUtils.insertAtHead("5");
        Assert.assertTrue( llUtils.length() == 5 , "Size doesnot match");
    }
    @Test
    public void testInsertionOrder() {
        LLUtils llUtils = new LLUtils();
        llUtils.insertAtHead("1");
        llUtils.insertAtHead("2");
        llUtils.insertAtHead("3");
        llUtils.insertAtHead("4");
        llUtils.insertAtHead("5");
        Assert.assertTrue(llUtils.getValueAt(0) == "5", "Oder dont match for 5");
        Assert.assertTrue(llUtils.getValueAt(2) == "3", "Oder dont match for 3");
        Assert.assertTrue(llUtils.getValueAt(4) == "1", "Oder dont match for 1");
    }


    @Test
    public void testReverseNode() {
        LLUtils llUtils = new LLUtils();
        llUtils.insertAtHead("1");
        llUtils.insertAtHead("2");
        llUtils.insertAtHead("3");
        llUtils.insertAtHead("4");
        llUtils.insertAtHead("5");
        Assert.assertTrue(llUtils.getValueAt(0) == "5", "Oder dont match for 5");
        Assert.assertTrue(llUtils.getValueAt(2) == "3", "Oder dont match for 3");
        Assert.assertTrue(llUtils.getValueAt(4) == "1", "Oder dont match for 1");
        llUtils.revNode();
        Assert.assertTrue(llUtils.getValueAt(4) == "5", "Oder dont match for 5");
        Assert.assertTrue(llUtils.getValueAt(2) == "3", "Oder dont match for 3");
        Assert.assertTrue(llUtils.getValueAt(0) == "1", "Oder dont match for 1");

    }
    @Test
    public void testReverseNodeInPlace() {
        LLUtils llUtils = new LLUtils();
        llUtils.insertAtHead("1");
        llUtils.insertAtHead("2");
        llUtils.insertAtHead("3");
        llUtils.insertAtHead("4");
        llUtils.insertAtHead("5");
        Assert.assertTrue(llUtils.getValueAt(0) == "5", "Oder dont match for 5");
        Assert.assertTrue(llUtils.getValueAt(2) == "3", "Oder dont match for 3");
        Assert.assertTrue(llUtils.getValueAt(4) == "1", "Oder dont match for 1");
        llUtils.reverseWhile();
        Assert.assertTrue(llUtils.getValueAt(4) == "5", "Oder dont match for 5");
        Assert.assertTrue(llUtils.getValueAt(2) == "3", "Oder dont match for 3");
        Assert.assertTrue(llUtils.getValueAt(0) == "1", "Oder dont match for 1");

    }

}
