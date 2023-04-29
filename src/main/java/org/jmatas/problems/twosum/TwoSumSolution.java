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

}
