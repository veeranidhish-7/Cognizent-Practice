package AdapterPatternExample;

public class StripeGateway {
    public void makeCharge(double amountInCents) {
        System.out.println("Stripe: Charged " + amountInCents + " cents.");
    }
}
