package dev.hazoe.exercise.design;

public class CreditCard  implements PaymentMethod{
    @Override
    public void pay(double amount) {
        System.out.println("Paying by credit card: " + amount);

    }
}
