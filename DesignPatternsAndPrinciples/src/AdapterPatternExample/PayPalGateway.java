package AdapterPatternExample;


public class PayPalGateway {
    public void sendMoney(String userEmail, double amount) {
        System.out.println("PayPal: Sent $" + amount + " via account " + userEmail);
    }
}
