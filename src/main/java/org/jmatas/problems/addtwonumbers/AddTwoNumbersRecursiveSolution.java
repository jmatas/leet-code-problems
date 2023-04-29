package org.jmatas.problems.addtwonumbers;

import java.math.BigDecimal;

public class AddTwoNumbersRecursiveSolution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        BigDecimal summand1 = new BigDecimal(toDecimal(l1));
        BigDecimal summand2 = new BigDecimal(toDecimal(l2));
        return toListNode(summand1.add(summand2).toString());
    }

    public ListNode toListNode(String number) {
        if (number.length() <= 1) {
            return new ListNode(Integer.parseInt(number));
        }
        return new ListNode(
                Integer.parseInt(number.substring(number.length() - 1)),
                toListNode(number.substring(0, number.length() - 1)));
    }

    public String toDecimal(ListNode l1) {
        if (l1.next == null) {
            return String.valueOf(l1.val);
        }
        return toDecimal(l1.next) + l1.val;
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
