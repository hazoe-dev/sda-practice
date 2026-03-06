package dev.hazoe.exercise.spring.dto;

public record ProductRequest(
        String name,
        double price,
        int stock
) {
}