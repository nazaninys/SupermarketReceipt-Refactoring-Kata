package dojo.supermarket.model;

public class FiveForAmountSpecialOffer extends SpecialOffer{
    @Override
    public String getDescription(double argument) {
        return 5 + " for " + argument;
    }

    @Override
    public double calculateDiscountAmount(double quantity, double unitPrice, double argument) {
        double discountAmount = 0;
        int quantityAsInt = (int) quantity;
        if (quantityAsInt >= 5) {
            int numberOfXs = quantityAsInt / 5;
            discountAmount = unitPrice * quantity - (argument * numberOfXs + quantityAsInt % 5 * unitPrice);
        }
        return discountAmount;
    }
}
