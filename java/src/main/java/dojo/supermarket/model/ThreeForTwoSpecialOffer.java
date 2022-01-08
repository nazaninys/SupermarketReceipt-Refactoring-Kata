package dojo.supermarket.model;

public class ThreeForTwoSpecialOffer extends SpecialOffer{

    public ThreeForTwoSpecialOffer() {
        super(3);
    }

    @Override
    public String getDescription(double argument) {
        return "3 for 2";
    }

    @Override
    public double calculateDiscountAmount(double quantity, double unitPrice, double argument) {
        int numberOfXs = ((int) quantity) / typeNumber;
        double discountAmount = quantity * unitPrice - ((numberOfXs * 2 * unitPrice) + ((int) quantity) % typeNumber * unitPrice);
        return discountAmount;
    }
}
