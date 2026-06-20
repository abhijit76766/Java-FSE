public class WebApp implements Observer {
    @Override
    public void update(String stockName, double price) {
        System.out.println("Web app update: " + stockName + " is now Rs. " + price);
    }
}

