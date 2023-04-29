package org.jmatas.problems.twosum;

import java.util.HashMap;
import java.util.Map;

public class TwoSumSolution {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> trackNumbers = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if (trackNumbers.containsKey(target - nums[i])) {
                return new int[] {trackNumbers.get(target - nums[i]), i};
            }
            trackNumbers.put(nums[i], i);
        }

        throw new IllegalArgumentException("No solution found for the given input");
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Integer current = l1.val;

        int i = 1;
        ListNode currentList = l1.next;
        while (currentList.next != null) {
            current = current + (currentList.val * 10^i);
            currentList = currentList.next;
        }
        System.out.println(current);

        return null;
    }


    public static void main(String [] a) {

        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(4, l1);
        ListNode l3 = new ListNode(2, l2);

        addTwoNumbers(l3, null);

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
