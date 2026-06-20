public class CreditCardPayment implements PaymentStrategy {
    private final String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        String lastFourDigits = cardNumber.substring(cardNumber.length() - 4);
        System.out.println("Paid Rs. " + amount + " using credit card ending with " + lastFourDigits);
    }
}

