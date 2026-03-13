package dev.hazoe.dsa.sort;

import java.util.Arrays;

public class InsertionSort {
    public int[] insertionSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }

        for (int i = 1; i < nums.length; i++) {
            int key = nums[i];
            int j = i - 1;

            while (j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = key;
        }

        // Time: O(n^2)
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1};
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.insertionSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
