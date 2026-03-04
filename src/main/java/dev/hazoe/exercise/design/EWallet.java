package dev.hazoe.exercise.design;

public class EWallet  extends BasePayment{

    @Override
    protected void processPayment(double amount) {
        System.out.println("Paying by e-wallet: " + amount);
    }
}
