package task1;

public class Main {
    public static void main(String[] args) {
        PaymentProcessor paymentProcessor = new PaymentProcessor();
        double discount = paymentProcessor.calculateDiscount("Premium", 1000);
        System.out.println("Discount: " + discount);
    }
}

class PaymentProcessor {
    public double calculateDiscount(String customerType, double amount) {
        if (customerType.equals("Regular")) {
            return amount * 0.05;
        } else if (customerType.equals("Premium")) {
            return amount * 0.10;
        } else {
            return 0;
        }
    }
}