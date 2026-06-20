public class PayPalAdapter implements PaymentProcessor {
    private final PayPalGateway gateway;

    public PayPalAdapter(PayPalGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public void processPayment(double amount) {
        gateway.makePayment(amount);
    }
}

