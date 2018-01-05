package com.hack.leetcode;

/**
 * Created by rafthab on 1/5/18.
 */

class ListNode {
   int val;
   ListNode next;
   ListNode(int x) { val = x; }
}
public class deleteNodell {


    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */

    ListNode head = null;

    public ListNode insertAtHead(int num) {
        ListNode newNode = new ListNode(num);
        newNode.next = this.head;
        this.head = newNode;
        return newNode;
    }

    public void printNode() {
        String out = new String();
        ListNode point = this.head;
        while(point!=null) {
            out += point.val;
            if(point.next !=null) {
                out += "->";
            }
            point = point.next;
        }

        System.out.println("Out Put ---> "+out);

    }
        public void deleteNode(ListNode node) {
        if(node.next == null) return;
        node.val = node.next.val;
        node.next = node.next.next;
        }

    public static void main(String[] args) {
        deleteNodell ll = new deleteNodell();
        ll.insertAtHead(1);
        ll.insertAtHead(2);
        ListNode del = ll.insertAtHead(3);
        ll.insertAtHead(4);
        ll.insertAtHead(5);
        ll.insertAtHead(6);

        ll.printNode();
        ll.deleteNode(del);
        ll.printNode();
    }
}
