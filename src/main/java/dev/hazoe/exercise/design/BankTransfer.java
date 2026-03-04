package dev.hazoe.exercise.design;

public class BankTransfer implements PaymentMethod{
    @Override
    public void pay(double amount) {
        System.out.println("Paying by bank transfer: " + amount);
    }
}
