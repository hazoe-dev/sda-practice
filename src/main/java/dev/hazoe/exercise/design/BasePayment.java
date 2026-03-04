package dev.hazoe.exercise.design;

public abstract class BasePayment {
    public void pay(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
    }
}
