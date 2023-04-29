package org.jmatas.problems.addtwonumbers;

public class AddTwoNumbersPerfomanceBasedSolution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode firstNumber = null;
        ListNode previousNumber = null;

        ListNode current1 = l1;
        ListNode current2 = l2;
        int remaining = 0;
        do {

            int value1 = 0;
            if (current1 != null) {
                value1 = current1.val;
            }

            int value2 = 0;
            if (current2 != null) {
                value2 = current2.val;
            }

            int currentValue = value1 + value2 + remaining;
            int value = currentValue % 10;
            remaining = currentValue / 10;

            if (firstNumber == null) {
                firstNumber = new ListNode(value);
                previousNumber = firstNumber;
            } else {
                previousNumber.next = new ListNode(value);
                previousNumber = previousNumber.next;
            }


            if (current1 != null) {
                current1 = current1.next;
            }
            if (current2 != null) {
                current2 = current2.next;
            }

        } while (current1 != null || current2 != null || remaining > 0);

        return firstNumber;
    }

    private static int getValue(ListNode current1) {
        int value1 = 0;
        if (current1 != null) {
            value1 = current1.val;
        }
        return value1;
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
