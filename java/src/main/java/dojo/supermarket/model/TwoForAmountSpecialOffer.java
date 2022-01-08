package dojo.supermarket.model;

public class TwoForAmountSpecialOffer extends SpecialOffer {

    public TwoForAmountSpecialOffer() {
        super(2);
    }

    @Override
    public String getDescription(double argument) {
        return "2 for " + argument;
    }

    @Override
    public double calculateDiscountAmount(double quantity, double unitPrice, double argument) {
        int numberOfXs = ((int) quantity) / typeNumber;
        double discountAmount = unitPrice * quantity - (argument * numberOfXs + ((int) quantity) % typeNumber * unitPrice);
        return discountAmount;
    }
}
