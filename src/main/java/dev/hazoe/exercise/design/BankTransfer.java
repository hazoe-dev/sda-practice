package dev.hazoe.exercise.design;

public class BankTransfer extends BasePayment{

    @Override
    protected void processPayment(double amount) {
        System.out.println("Paying by bank transfer: " + amount);
    }
}
