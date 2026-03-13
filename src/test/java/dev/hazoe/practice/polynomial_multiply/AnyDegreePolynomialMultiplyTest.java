package dev.hazoe.practice.polynomial_multiply;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnyDegreePolynomialMultiplyTest {

    @Test
    void testPolynomialMultiplyAdvanced() {

        assertEquals(
                "2x^4+3x^3+9x^2+12x+4",
                AnyDegreePolynomialMultiply.multiply("(2x^2+3x+1)(x^2+4)")
        );
    }
}