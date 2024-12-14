package task1.Fixed;

public class PaymentProcessor {
    public double calculateDiscount(DiscountStrategy discountStrategy, double amount) {
        return discountStrategy.applyDiscount(amount);
    }
}