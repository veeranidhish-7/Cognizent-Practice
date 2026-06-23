package AdapterPatternExample;


public class PayPalAdapter implements PaymentProcessor {
    private PayPalGateway payPalGateway;
    private String userEmail;

    public PayPalAdapter(PayPalGateway payPalGateway, String userEmail) {
        this.payPalGateway = payPalGateway;
        this.userEmail = userEmail;
    }

    @Override
    public void processPayment(double amount) {
        payPalGateway.sendMoney(userEmail, amount);
    }
}
