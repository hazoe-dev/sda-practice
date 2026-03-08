package dev.hazoe.dsa.sort;

import java.util.Arrays;

public class SelectionSort {

    public int[] selectionSort(int[] nums) {
        int size = nums.length;

        // not need sorting for 1 size
        for (int i = 0; i < size - 1; i++) {
            int minIndex = i;
            //select minimum index
            for (int j = i + 1; j < size; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            System.out.print("Selected index: " + minIndex );
            // swap when found minimum
            if (minIndex != i) {
                swap(nums, minIndex, i);
            }
            System.out.println("; Array after selection: " + Arrays.toString(nums));
        }

        // Time: O(n^2)
        return nums;
    }

    private void swap(int[] nums, int minIndex, int i) {
        int temp = nums[minIndex];
        nums[minIndex] = nums[i];
        nums[i] = temp;
    }

    public int[] stableSelectionSort(int[] nums) {

        for (int i = 0; i < nums.length - 1; i++) {

            int minIndex = i;

            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }

            int minValue = nums[minIndex];

            while (minIndex > i) {
                nums[minIndex] = nums[minIndex - 1];
                minIndex--;
            }

            nums[i] = minValue;
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1};
        SelectionSort sort = new SelectionSort();
        int[] result = sort.selectionSort(nums);
        System.out.println(Arrays.toString(result));
    }
}
