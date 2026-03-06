package dev.hazoe.practice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeIntervalsTest {

    @Test
    void testNormalCase() {
        int[][] input = {
                {1,3},
                {2,6},
                {8,10},
                {15,18}
        };

        int[][] expected = {
                {1,6},
                {8,10},
                {15,18}
        };

        assertArrayEquals(expected, MergeIntervals.merge(input));
    }

    @Test
    void testNoOverlap() {
        int[][] input = {
                {1,2},
                {3,4},
                {5,6}
        };

        int[][] expected = {
                {1,2},
                {3,4},
                {5,6}
        };

        assertArrayEquals(expected, MergeIntervals.merge(input));
    }

    @Test
    void testFullOverlap() {
        int[][] input = {
                {1,10},
                {2,3},
                {4,5}
        };

        int[][] expected = {
                {1,10}
        };

        assertArrayEquals(expected, MergeIntervals.merge(input));
    }

    @Test
    void testSingleInterval() {
        int[][] input = {
                {1,5}
        };

        int[][] expected = {
                {1,5}
        };

        assertArrayEquals(expected, MergeIntervals.merge(input));
    }

    @Test
    void testEmptyInput() {
        int[][] input = {};

        int[][] expected = {};

        assertArrayEquals(expected, MergeIntervals.merge(input));
    }

    @Test
    void testNegativeNumbers() {
        int[][] input = {
                {-10,-1},
                {-5,0},
                {1,3}
        };

        int[][] expected = {
                {-10,0},
                {1,3}
        };

        assertArrayEquals(expected, MergeIntervals.merge(input));
    }

    @Test
    void testTouchingIntervals() {
        int[][] input = {
                {1,4},
                {4,5}
        };

        int[][] expected = {
                {1,5}
        };

        assertArrayEquals(expected, MergeIntervals.merge(input));
    }
}