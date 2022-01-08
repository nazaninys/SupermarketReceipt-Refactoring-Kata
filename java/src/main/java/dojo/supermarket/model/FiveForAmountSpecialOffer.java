package dojo.supermarket.model;

public class FiveForAmountSpecialOffer extends SpecialOffer{
    public FiveForAmountSpecialOffer() {
        super(5);
    }

    @Override
    public String getDescription(double argument) {
        return typeNumber + " for " + argument;
    }

    @Override
    public double calculateDiscountAmount(double quantity, double unitPrice, double argument) {
        int numberOfXs = (int) quantity / typeNumber;
        double discountAmount = unitPrice * quantity - (argument * numberOfXs + (int) quantity % typeNumber * unitPrice);
        return discountAmount;
    }
}
