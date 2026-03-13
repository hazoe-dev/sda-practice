package dev.hazoe.dsa.sort;

import java.util.Arrays;

public class MergeSort {
    // Average time complexity: O(n log n)
    public void mergeSort(int[] nums, int low, int high) {
        if (low < high) {
            // divide
            // (log n) levels of recursion
            int mid = low + (high - low) / 2;
            mergeSort(nums, low, mid);
            mergeSort(nums, mid + 1, high);

            // conquer
            // each level merges n elements
            merge(nums, low, mid, high);
        }

    }

    public void merge(int[] arr, int low, int mid, int high) {
        int lSize = mid - low + 1;
        int[] lArr = new int[lSize];
        int rSize = high - mid;
        int[] rArr = new int[rSize];

        for (int i = 0; i < lSize; i++) {
            lArr[i] = arr[low + i];
        }

        for (int i = 0; i < rSize; i++) {
            rArr[i] = arr[mid + 1 + i];
        }
        int x = 0;
        int y = 0;
        int k = low;
        while (x < lSize && y < rSize) {
            // left element wins when equal → stable.
            if (lArr[x] <= rArr[y]) {
                arr[k] = lArr[x];
                x++;
            } else {
                arr[k] = rArr[y];
                y++;
            }
            k++;
        }
        while (x < lSize) {
            arr[k] = lArr[x];
            x++;
            k++;
        }

        while (y < rSize) {
            arr[k] = rArr[y];
            y++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1};
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}
