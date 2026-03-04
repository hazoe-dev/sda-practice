package dev.hazoe.exercise.algorithms;

import java.util.*;

public class TwoSumAllPairs {
    public static List<List<Integer>> twoSumBruteForce(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }

    public static List<List<Integer>> twoSumOptimized(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                for (int k : map.get(complement)) {
                    result.add(Arrays.asList(k,i));
                }
            }

            map.computeIfAbsent(nums[i], val -> new ArrayList<>()).add(i);

        }
        return result;
    }
}
