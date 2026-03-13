package dev.hazoe.dsa.sort;

import java.util.Arrays;

public class QuickSort {
    // Average time complexity: O(n log n)
    public int[] quickSort(int[] nums, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(nums, low, high);

            quickSort(nums, low, pivotIndex - 1);
            quickSort(nums, pivotIndex + 1, high);
        }
        return nums;
    }

    private int partition(int[] nums, int low, int high) {
        int i = low - 1;
        int pivot = nums[high];

        for (int j = low; j < high; j++) {
            if (nums[j] < pivot) {
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, high, i + 1);
        return i + 1;
    }

    private static void swap(int[] nums, int high, int i) {
        int temp = nums[high];
        nums[high] = nums[i];
        nums[i] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1};
        QuickSort sorter = new QuickSort();
        sorter.quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}
