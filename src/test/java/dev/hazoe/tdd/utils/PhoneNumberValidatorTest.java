package dev.hazoe.tdd.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PhoneNumberValidatorTest {
    private PhoneNumberValidator underTest;
    @BeforeEach
    void setUp(){
        underTest = new PhoneNumberValidator();
    }

    @ParameterizedTest
    @CsvSource({
            "+44 5555-1234, true",
            "44 5555-1234, false",
            "+44 5555-123456, false"
    })
    void isShouldValidatePhoneNumber(String phoneNumber, boolean expectedResult) {

        //When
        boolean isValid = underTest.test(phoneNumber);
        //Then
        assertThat(isValid).isEqualTo(expectedResult);
    }
}
