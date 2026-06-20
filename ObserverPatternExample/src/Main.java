public class Main {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();
        Observer mobileApp = new MobileApp();
        Observer webApp = new WebApp();

        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);

        stockMarket.setStockPrice("COGNIZANT", 3715.25);

        stockMarket.deregisterObserver(webApp);
        stockMarket.setStockPrice("COGNIZANT", 3742.80);
    }
}

