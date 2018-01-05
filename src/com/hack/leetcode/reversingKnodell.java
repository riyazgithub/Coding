package com.hack.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by rafthab on 9/16/17.
 * https://leetcode.com/problems/reverse-nodes-in-k-group/description/
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

 k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 */
public class reversingKnodell {

    ListNode head;  // head of list

    /* Linked list Node*/
    class ListNode
    {
        int data;
        ListNode next;
        ListNode(int d) {data = d; next = null; }
    }

    ListNode reverse(ListNode head, int k, int round, int limit)
    {
        ListNode current = head;
        ListNode next = null;
        ListNode prev = null;

        int count = 0;

       /* Reverse first k nodes of linked list */
        while (count < k && current != null)
        {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
//                count++;
        }

       /* next is now a pointer to (k+1)th node
          Recursively call for the list starting from current.
          And make rest of the list as next of first node */
        if (next != null && round < limit)
            head.next = reverse(next, k, round +1, limit);
        else {
            head.next = current;
        }

        // prev is now head of input list
        return prev;
    }


    /* Utility functions */

    /* Inserts a new Node at front of the list. */
    public void push(int new_data)
    {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
        ListNode new_node = new ListNode(new_data);

        /* 3. Make next of new Node as head */
        new_node.next = head;

        /* 4. Move the head to point to new Node */
        head = new_node;
    }

    /* Function to print linked list */
    void printList()
    {
        ListNode temp = head;
        while (temp != null)
        {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    public ListNode reverseKGroup(ListNode head, int k) {

        int len = length(head);
        int limit = len / k;
        System.out.println("Given Linked List");

        printList();
        this.head = reverse(head, 3, 1, limit);
        System.out.println("Reversed Linked List");

        printList();

        return this.head;

    }

    public int length(ListNode head) {
        int len = 0;
        ListNode tmp = head;
        while (tmp !=null) {
            len++;
            tmp = tmp.next;
        }
        return len;
    }

    public ListNode reverseNKNode(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;

        while(curr!=null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    /* Drier program to test above functions */
    public static void main(String args[])
    {
        reversingKnodell llist = new reversingKnodell();

        ArrayList<HashMap<String, String>> content = new ArrayList<>();
        HashMap<String, String> hm = new HashMap<>();




        /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
        llist.push(14);
        llist.push(13);
        llist.push(12);
        llist.push(11);
        llist.push(10);
        llist.push(9);
        llist.push(8);
        llist.push(7);
        llist.push(6);
        llist.push(5);
        llist.push(4);
        llist.push(3);
        llist.push(2);
        llist.push(1);

        System.out.println("Given Linked List");
        llist.printList();

        llist.head = llist.reverseNKNode(llist.head);
//        llist.head = llist.reverseKGroup(llist.head, 3);

        System.out.println("Reversed list");
        llist.printList();
    }
}
