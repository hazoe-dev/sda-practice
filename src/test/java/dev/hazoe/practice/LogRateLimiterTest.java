package dev.hazoe.practice;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LogRateLimiterTest {



    @Test
    void testViolation() {
        List<String> logs = List.of(
                "u1 100",
                "u1 101",
                "u1 102",
                "u1 103"
        );

        List<String> result = LogRateLimiter.findViolatedUsers(logs);

        assertEquals(List.of("u1"), result);
    }

    @Test
    void testViolation1() {
        List<String> logs = List.of(
                "u1 10",
                "u1 101",
                "u1 102",
                "u1 103"
        );

        List<String> result = LogRateLimiter.findViolatedUsers(logs);

        assertEquals(List.of(), result);
    }

    @Test
    void testViolation2() {
        List<String> logs = List.of(
                "u1 105",
                "u1 100",
                "u1 101",
                "u1 102"
        );

        List<String> result = LogRateLimiter.findViolatedUsers(logs);

        assertEquals(List.of("u1"), result);
    }
}