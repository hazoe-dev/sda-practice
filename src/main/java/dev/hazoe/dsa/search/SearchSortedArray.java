package dev.hazoe.dsa.search;

import dev.hazoe.dsa.search.dto.SearchResult;

public class SearchSortedArray {

    public static SearchResult linearSearch(int[] arr, int key) {

        int steps = 0;
        for (int i = 0; i < arr.length; i++) {
            steps++;
            if (arr[i] == key) {
                return new SearchResult(steps, i);
            }
        }
        return new SearchResult(steps, -1);
    }

    public static SearchResult binarySearchWithRecursion(int[] arr, int low, int high, int key, int steps) {
        steps++;
        if (low > high) {
            return new SearchResult(steps, -1);
        }
        int mid = (low + high) / 2;
        if (arr[mid] == key) {
            return new SearchResult(steps, mid);
        } else if (arr[mid] > key) {
            return binarySearchWithRecursion(arr, low, mid - 1, key, steps);
        } else {
            return binarySearchWithRecursion(arr, mid + 1, high, key, steps);
        }
    }

    public static SearchResult binarySearch(int[] arr, int key) {
        int steps = 0;

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            steps++;
            int mid = (low + high) / 2;
            if (arr[mid] == key) {
                return new SearchResult(steps, mid);
            } else if (arr[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return new SearchResult(steps, -1);
    }


}
