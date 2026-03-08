package dev.hazoe.dsa.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SelectionSortTest {

    SelectionSort sorter = new SelectionSort();

    @Test
    void testRandomArray() {
        int[] nums = {8, 9, 3, 4, 0, 6, 7};
        int[] expected = {0, 3, 4, 6, 7, 8, 9};

        assertArrayEquals(expected, sorter.selectionSort(nums));
    }

    @Test
    void testAlreadySorted() {
        int[] nums = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};

        assertArrayEquals(expected, sorter.selectionSort(nums));
    }

    @Test
    void testReverseSorted() {
        int[] nums = {5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5};

        assertArrayEquals(expected, sorter.selectionSort(nums));
    }

    @Test
    void testDuplicates() {
        int[] nums = {4, 2, 5, 2, 3, 2};
        int[] expected = {2, 2, 2, 3, 4, 5};

        assertArrayEquals(expected, sorter.selectionSort(nums));
    }

    @Test
    void testSingleElement() {
        int[] nums = {10};
        int[] expected = {10};

        assertArrayEquals(expected, sorter.selectionSort(nums));
    }

    @Test
    void testEmptyArray() {
        int[] nums = {};
        int[] expected = {};

        assertArrayEquals(expected, sorter.selectionSort(nums));
    }

    @Test
    void testNegativeNumbers() {
        int[] nums = {-3, -1, -7, -4};
        int[] expected = {-7, -4, -3, -1};

        assertArrayEquals(expected, sorter.selectionSort(nums));
    }

}