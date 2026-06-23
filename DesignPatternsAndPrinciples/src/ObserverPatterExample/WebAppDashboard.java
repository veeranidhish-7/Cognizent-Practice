package ObserverPatterExample;

public class WebAppDashboard implements Observer {
    @Override
    public void update(String stockSymbol, double stockPrice) {
        System.out.println("Web Dashboard Updated: [" + stockSymbol + "] tick: $" + stockPrice);
    }
}
