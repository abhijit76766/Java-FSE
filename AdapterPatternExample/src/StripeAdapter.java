public class StripeAdapter implements PaymentProcessor {
    private final StripeGateway gateway;

    public StripeAdapter(StripeGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public void processPayment(double amount) {
        gateway.charge(amount);
    }
}

