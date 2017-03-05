package com.hack.datastructure;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rafthab on 5/16/16.
 */
public class StackUtils {

    public StackNode head = null;

    public void push(int val) {
        StackNode newNode = new StackNode(val);
        if(isStackEmpty()) {
            this.head = newNode;
        } else  {
            newNode.next = head;
            this.head = newNode;

        }
    }

    public int pop() {
        if( isStackEmpty() ) {
           // Stack empty
            return -1;
        }
        StackNode popnode = this.head;
        this.head = this.head.next;
        return popnode.val;
    }

    public boolean isStackEmpty() {
        if( head == null ) {
            return true;
        }
        return false;
    }

    public List<Integer> returnList() {
        List<Integer> ret = new ArrayList<Integer>();
        StackNode tmp = this.head;
        while(tmp !=null ) {
            ret.add(tmp.val);
            tmp = tmp.next;
        }
        return ret;
    }
    public static void main(String[] args) {

    }

    @Test
    public void verifyStackInsert() {
        StackUtils stackUtils1 = new StackUtils();
        stackUtils1.push(1);
        stackUtils1.push(2);
        stackUtils1.push(3);
        List<Integer> ret = stackUtils1.returnList();
        Assert.assertEquals(ret.size(), 3, "Size doesnot match");

    }
}
