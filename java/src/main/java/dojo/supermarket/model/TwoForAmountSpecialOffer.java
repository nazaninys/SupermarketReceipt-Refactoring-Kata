package dojo.supermarket.model;

public class TwoForAmountSpecialOffer extends SpecialOffer {

    @Override
    public String getDescription(double argument) {
        return "2 for " + argument;
    }

    @Override
    public double calculateDiscountAmount(double quantity, double unitPrice, double argument) {
        double discountAmount = 0;
        int quantityAsInt = (int) quantity;
        if (quantityAsInt >= 2) {
            int numberOfXs = quantityAsInt / 2;
            double pricePerUnit = argument * numberOfXs;
            double theTotal = (quantityAsInt % 2) * unitPrice;
            double total = pricePerUnit + theTotal;
            discountAmount = unitPrice * quantity - total;

        }
        return discountAmount;
    }
}
