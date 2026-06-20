public class Main {
    public static void main(String[] args) {
        PaymentContext paymentContext = new PaymentContext();

        paymentContext.setPaymentStrategy(new CreditCardPayment("1234567812345678"));
        paymentContext.pay(2500.00);

        paymentContext.setPaymentStrategy(new PayPalPayment("student@example.com"));
        paymentContext.pay(1750.50);
    }
}

