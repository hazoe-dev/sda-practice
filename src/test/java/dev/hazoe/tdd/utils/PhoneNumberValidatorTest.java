package dev.hazoe.tdd.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PhoneNumberValidatorTest {
    private PhoneNumberValidator underTest;
    @BeforeEach
    public void setUp(){
        underTest = new PhoneNumberValidator();
    }

    @Test
    public void isShouldValidatePhoneNumber() {
        //Given
        String phoneNumber = "+44 5555-1234";
        //When
        boolean isValid = underTest.test(phoneNumber);
        //Then
        assertTrue(isValid);
    }

    @Test
    @DisplayName("Should fail when phone number does not start with +")
    public void isShouldValidatePhoneNumberWhenIncorrectNumberWithoutStartingByPlusSign() {
        //Given
        String phoneNumber = "44 5555-1234";
        //When
        boolean isValid = underTest.test(phoneNumber);
        //Then
        assertFalse(isValid);
    }

    @Test
    @DisplayName("Should fail when length is bigger than 11")
    public void isShouldValidatePhoneNumberWhenIncorrectNumberAndLengthBiggerThan11() {
        //Given
        String phoneNumber = "+44 5555-123456";
        //When
        boolean isValid = underTest.test(phoneNumber);
        //Then
        assertFalse(isValid);
    }
}
