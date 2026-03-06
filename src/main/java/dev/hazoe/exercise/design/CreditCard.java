package dev.hazoe.exercise.design;

public class CreditCard  extends BasePayment{

    @Override
    protected void processPayment(double amount) {
        System.out.println("Paying by credit card: " + amount);
    }
}
