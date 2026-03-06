package dev.hazoe.exercise.spring_top_total.exception.dto;

import java.time.Instant;

public record ErrorResponse(
        int statusCode,
        String message,
        Instant timestamp
) {
}
