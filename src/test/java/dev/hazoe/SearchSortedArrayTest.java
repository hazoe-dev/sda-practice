package dev.hazoe;

import dev.hazoe.dsa.search.dto.SearchResult;
import dev.hazoe.dsa.search.SearchSortedArray;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchSortedArrayTest {

    // ------------------ LINEAR SEARCH ------------------

    @Test
    void linearSearch_shouldReturnIndexAndSteps_whenKeyExists() {
        int[] arr = {1, 3, 5, 7, 9};

        SearchResult result = SearchSortedArray.linearSearch(arr, 7);

        assertEquals(3, result.index());
        assertEquals(4, result.steps());
    }

    @Test
    void linearSearch_shouldReturnMinusOne_whenKeyNotExists() {
        int[] arr = {1, 3, 5, 7, 9};

        SearchResult result = SearchSortedArray.linearSearch(arr, 4);

        assertEquals(-1, result.index());
        assertEquals(5, result.steps());
    }

    @Test
    void linearSearch_shouldReturnMinusOneWith1000Items_whenKeyNotExists() {
        int[] arr = new int[1000];

        SearchResult result = SearchSortedArray.linearSearch(arr, 4);

        assertEquals(-1, result.index());
        assertEquals(1000, result.steps());
    }

    @Test
    void linearSearch_shouldReturnMinusOne_whenArrayEmpty() {
        int[] arr = {};

        SearchResult result = SearchSortedArray.linearSearch(arr, 1);

        assertEquals(-1, result.index());
        assertEquals(0, result.steps());
    }


    // ------------------ BINARY SEARCH (ITERATIVE) ------------------

    @Test
    void binarySearch_shouldReturnIndex_whenKeyExists() {
        int[] arr = {1, 3, 5, 7, 9};

        SearchResult result = SearchSortedArray.binarySearch(arr, 5);

        assertEquals(2, result.index());
        assertEquals(1, result.steps());
        // your steps is never incremented
    }

    @Test
    void binarySearch_shouldReturnMinusOne_whenKeyNotExists() {
        int[] arr = {1, 3, 5, 7, 9};

        SearchResult result = SearchSortedArray.binarySearch(arr, 8);

        assertEquals(-1, result.index());
        assertEquals(3, result.steps());
    }


    // ------------------ BINARY SEARCH (RECURSIVE) ------------------

    @Test
    void binarySearchWithRecursion_shouldReturnIndex_whenKeyExists() {
        int[] arr = {1, 3, 5, 7, 9};

        SearchResult result = SearchSortedArray.binarySearchWithRecursion(
                arr, 0, arr.length - 1, 3, 0
        );

        assertEquals(1, result.index());
        assertEquals(3, result.steps());
    }

    @Test
    void binarySearchWithRecursion_shouldReturnMinusOne_whenKeyNotExists() {
        int[] arr = {1, 3, 5, 7, 9};

        SearchResult result = SearchSortedArray.binarySearchWithRecursion(
                arr, 0, arr.length - 1, 10, 0
        );

        assertEquals(-1, result.index());
        assertEquals(4, result.steps());
    }

    @Test
    void binarySearchWithRecursion_shouldReturnMinusOneWith1000Items_whenKeyNotExists() {
        int[] arr = new int[1000];

        SearchResult result = SearchSortedArray.binarySearchWithRecursion(
                arr, 0, arr.length - 1, 10, 0
        );

        assertEquals(-1, result.index());
        assertEquals(11, result.steps());
    }


    @Test
    void compareTimeComplexityBetweenLinearSearchAndBinarySearch_shouldBinarySearchStepNumIsSmaller_whenNoKeyExists() {
        int[] arr = new int[1000];

        SearchResult binaryResult = SearchSortedArray.binarySearch(arr, 1);
        SearchResult linearResult = SearchSortedArray.linearSearch(arr, 1);

        assertTrue(binaryResult.steps() < linearResult.steps());
    }

}