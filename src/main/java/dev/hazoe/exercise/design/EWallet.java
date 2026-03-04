package dev.hazoe.exercise.design;

public class EWallet  implements PaymentMethod{
    @Override
    public void pay(double amount) {
        System.out.println("Paying by e-wallet: " + amount);
    }
}
