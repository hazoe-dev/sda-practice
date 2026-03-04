package dev.hazoe.exercise.design;

public class PaymentProcessor {
    private PaymentMethod paymentMethod;
    public PaymentProcessor(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void pay(double amount) {
        paymentMethod.pay(amount);
    }

    static void main() {
        PaymentMethod method = new BankTransfer();
        PaymentProcessor processor1 = new PaymentProcessor(method);
        processor1.pay(500);

        PaymentMethod method2 = new CreditCard();
        PaymentProcessor processor2 = new PaymentProcessor(method2);
        processor2.pay(500);

        processor2.setPaymentMethod(new EWallet());
        processor2.pay(500);

    }
}
