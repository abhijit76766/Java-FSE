public class Main {
    public static void main(String[] args) {
        PaymentProcessor paypalProcessor = new PayPalAdapter(new PayPalGateway());
        PaymentProcessor stripeProcessor = new StripeAdapter(new StripeGateway());

        paypalProcessor.processPayment(1500.00);
        stripeProcessor.processPayment(2200.50);
    }
}

