package dev.hazoe.exercise.spring.dto;

public record ProductResponse(
        Long id,
        String name,
        double price,
        int stock
) {
}