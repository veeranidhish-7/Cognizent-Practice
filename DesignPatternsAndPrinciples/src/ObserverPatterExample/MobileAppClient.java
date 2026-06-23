package ObserverPatterExample;

public class MobileAppClient implements Observer {
    private String username;

    public MobileAppClient(String username) {
        this.username = username;
    }

    @Override
    public void update(String stockSymbol, double stockPrice) {
        System.out.println("Mobile Push to " + username + ": " + stockSymbol + " is now $" + stockPrice);
    }
}
