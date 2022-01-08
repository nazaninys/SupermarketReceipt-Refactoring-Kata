package dojo.supermarket.model;

public class ThreeForTwoSpecialOffer extends SpecialOffer{

    @Override
    public String getDescription(double argument) {
        return "3 for 2";
    }

    @Override
    public double calculateDiscountAmount(double quantity, double unitPrice, double argument) {
        double discountAmount = 0;
        int quantityAsInt = (int) quantity;
        if(quantityAsInt > 2) {
            int numberOfXs = quantityAsInt / 3;
           discountAmount = quantity * unitPrice - ((numberOfXs * 2 * unitPrice) + quantityAsInt % 3 * unitPrice);

        }
        return discountAmount;
    }

}
