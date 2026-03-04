package dev.hazoe.exercise.algorithms;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.*;

class TwoSumAllPairsTest {
    @Test
    void twoSumBruteForce_normalCase() {
        int[] nums = {2, 7, 4, 1, 11, 7};
        int target = 9;

        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(0, 1),
                Arrays.asList(0, 5)
        );

        List<List<Integer>> result = TwoSumAllPairs.twoSumBruteForce(nums, target);

        assertEquals(expected, result);
    }

    @Test
    void twoSumBruteForce_noPairCase() {
        int[] nums = {1, 2, 3};
        int target = 10;

        List<List<Integer>> result = TwoSumAllPairs.twoSumBruteForce(nums, target);

        assertTrue(result.isEmpty());
    }

    @Test
    void twoSumBruteForce_emptyArrayCase() {
        int[] nums = {};
        int target = 5;

        List<List<Integer>> result = TwoSumAllPairs.twoSumBruteForce(nums, target);

        assertTrue(result.isEmpty());
    }

    @Test
    void twoSumOptimized_normalCase() {
        int[] nums = {2, 7, 4, 1, 11, 7};
        int target = 9;

        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(0, 1),
                Arrays.asList(0, 5)
        );

        List<List<Integer>> result = TwoSumAllPairs.twoSumOptimized(nums, target);

        assertEquals(expected, result);
    }

    @Test
    void twoSumOptimized_noPairCase() {
        int[] nums = {1, 2, 3};
        int target = 10;

        List<List<Integer>> result = TwoSumAllPairs.twoSumOptimized(nums, target);

        assertTrue(result.isEmpty());
    }

    @Test
    void twoSumOptimized_emptyArrayCase() {
        int[] nums = {};
        int target = 5;

        List<List<Integer>> result = TwoSumAllPairs.twoSumOptimized(nums, target);

        assertTrue(result.isEmpty());
    }

    @Test
    void twoSumOptimized_duplicateCase() {
        int[] nums = {3,3,3};
        int target = 6;

        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(0, 1),
                Arrays.asList(0, 2),
                Arrays.asList(1,2)
        );

        List<List<Integer>> result = TwoSumAllPairs.twoSumOptimized(nums, target);

        assertEquals(expected, result);
        assertEquals(3, result.size());
    }
    @Test
    void bruteForceMatchesOptimized() {
        int[] nums = {2, 7, 4, 1, 11, 7};
        int target = 9;

        List<List<Integer>> brute = TwoSumAllPairs.twoSumBruteForce(nums, target);
        List<List<Integer>> optimized = TwoSumAllPairs.twoSumOptimized(nums, target);

        assertEquals(brute, optimized);
    }
}