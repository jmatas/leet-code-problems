package org.jmatas;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> trackNumbers = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int currentNumber = nums[i];

            if (trackNumbers.containsKey(target - currentNumber)) {
                return new int[] {trackNumbers.get(target - currentNumber), i};
            }
            trackNumbers.put(currentNumber, i);
        }

        throw new IllegalArgumentException("No solution found for the given input");
    }
}
