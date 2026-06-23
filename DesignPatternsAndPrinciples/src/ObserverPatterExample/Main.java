package ObserverPatterExample;

public class Main {
    public static void main(String[] args) {

        StockMarket appleStock = new StockMarket("AAPL");

        Observer mobileUser = new MobileAppClient("Veera");
        Observer webDashboard = new WebAppDashboard();

        appleStock.registerObserver(mobileUser);
        appleStock.registerObserver(webDashboard);

        System.out.println(" First Price Update: ");
        appleStock.setStockPrice(150.00);

        System.out.println(" Mobile User Unsubscribes: ");
        appleStock.deregisterObserver(mobileUser);

        System.out.println(" Second Price Update: ");
        appleStock.setStockPrice(155.50);
    }
}
