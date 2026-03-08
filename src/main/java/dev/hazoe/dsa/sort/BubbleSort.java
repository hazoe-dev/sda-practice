package dev.hazoe.dsa.sort;

import java.util.Arrays;

public class BubbleSort {

    public int[] bubbleSort(int[] nums) {
        int size = nums.length;
        for (int i = 0; i < size - 1; i++) {
            boolean swapped = false;

            // the largest element in the end
            for (int j = 0; j < size - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
            System.out.println("Step " + i + ": " + Arrays.toString(nums));
        }

        // Time complexity: O(n^2)
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{9, 2, 3, 4, 5, 6, 7, 8, 9};
        BubbleSort bubbleSort = new BubbleSort();
        System.out.println(Arrays.toString(bubbleSort.bubbleSort(nums)));
    }
}
