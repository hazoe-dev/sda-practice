package dev.hazoe.practice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PolynomialMultiplicationTest {
    PolynomialMultiplication calc;
    @BeforeEach
    void setUp() {
        calc = new PolynomialMultiplication();
    }

    @Test
    void multiply_basicPolynomial() {
        int[] p1 = {2, 1};
        int[] p2 = {3, 4};

        int[] result = calc.multiply(p1, p2);

        assertArrayEquals(new int[]{6, 11, 4}, result);
    }

    @Test
    void multiply_higherDegreePolynomial() {
        int[] p1 = {1, 2, 3};
        int[] p2 = {4, 5};

        int[] result = calc.multiply(p1, p2);

        assertArrayEquals(new int[]{4, 13, 22, 15}, result);
    }

    @Test
    void multiply_withZeroPolynomial() {
        int[] p1 = {0};
        int[] p2 = {3, 4};

        int[] result = calc.multiply(p1, p2);

        assertArrayEquals(new int[]{0, 0}, result);
    }

    @Test
    void multiply_withNegativeCoefficients() {
        int[] p1 = {2, -1};
        int[] p2 = {3, 4};

        int[] result = calc.multiply(p1, p2);

        assertArrayEquals(new int[]{6, 5, -4}, result);
    }

    @Test
    void multiply_singleTermPolynomial() {
        int[] p1 = {5};
        int[] p2 = {2};

        int[] result = calc.multiply(p1, p2);

        assertArrayEquals(new int[]{10}, result);
    }

    @Test
    void multiply_sparsePolynomial() {
        int[] p1 = {1, 0, 2};
        int[] p2 = {3, 0};

        int[] result = calc.multiply(p1, p2);

        assertArrayEquals(new int[]{3, 0, 6, 0}, result);
    }

    @Test
    void multiply_emptyArray() {
        int[] p1 = {};
        int[] p2 = {1, 2};

        int[] result = calc.multiply(p1, p2);

        assertArrayEquals(new int[]{}, result);
    }
}