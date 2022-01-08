package dojo.supermarket.model;

public class TenPercentDiscountSpecialOffer extends SpecialOffer {
    public TenPercentDiscountSpecialOffer() {
        super(1);
    }

    @Override
    public String getDescription(double argument) {
        return argument + "% off";
    }

    @Override
    public double calculateDiscountAmount(double quantity, double unitPrice, double argument) {
        Double discountAmount = quantity * unitPrice * argument / 100.0;
        return discountAmount;
    }
}
