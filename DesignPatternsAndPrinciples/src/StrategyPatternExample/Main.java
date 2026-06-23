package StrategyPatternExample;

public class Main {
    public static void main(String[] args) {

        PaymentContext checkout = new PaymentContext();
        int cartTotal = 150;

        System.out.println(" User selects PayPal: ");
        checkout.setPaymentStrategy(new PayPalPayment("veera@example.com"));
        checkout.executePayment(cartTotal);

        System.out.println(" User changes mind, switches to Credit Card: ");
        checkout.setPaymentStrategy(new CreditCardPayment("Veera Nidhish", "9876543210"));
        checkout.executePayment(cartTotal);
    }
}
