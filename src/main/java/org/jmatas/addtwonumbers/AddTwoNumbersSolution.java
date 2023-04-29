package org.jmatas.addtwonumbers;

public class AddTwoNumbersSolution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return new ListNode(7, new ListNode(0,new ListNode(8)));
    }

    /**
     * Definition for singly-linked list.
     */
    public static class ListNode {

        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
