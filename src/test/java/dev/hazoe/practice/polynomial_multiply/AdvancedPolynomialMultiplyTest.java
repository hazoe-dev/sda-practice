package dev.hazoe.practice.polynomial_multiply;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdvancedPolynomialMultiplyTest {

    @Test
    void testPolynomialMultiply() {
        AdvancedPolynomialMultiply pm = new AdvancedPolynomialMultiply();

        assertEquals("6x^2+11x+4",
                pm.multiply("(2x+1)(3x+4)"));
    }

}