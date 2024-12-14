package task1.Fixed;

public class RegularDiscountStrategy implements DiscountStrategy {
    @Override
    public double applyDiscount(double amount) {
        return amount * 0.05;
    }
}