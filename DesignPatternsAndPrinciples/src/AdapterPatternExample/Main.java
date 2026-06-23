package AdapterPatternExample;


public class Main {
    public static void main(String[] args) {

        System.out.println(" Initiating Checkout : ");
        double orderTotal = 50.00;

        // 1. Using Stripe
        StripeGateway stripeAPI = new StripeGateway();
        PaymentProcessor stripeProcessor = new StripeAdapter(stripeAPI);

        stripeProcessor.processPayment(orderTotal);


        System.out.println(" Switching Payment Methods : ");

        // 2. Using PayPal
        PayPalGateway payPalAPI = new PayPalGateway();
        PaymentProcessor payPalProcessor = new PayPalAdapter(payPalAPI, "customer@example.com");

        payPalProcessor.processPayment(orderTotal);
    }
}
