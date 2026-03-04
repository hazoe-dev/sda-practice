package dev.hazoe.exercise.design;

public abstract class BasePayment implements PaymentMethod{
    @Override
    public void pay(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        processPayment(amount);
    }

    protected abstract void processPayment(double amount);
}
