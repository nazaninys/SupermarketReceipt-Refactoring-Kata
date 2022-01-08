package dojo.supermarket.model;

public class Offer {
    SpecialOffer specialOffer;
    private final Product product;
    double argument;

    public Offer(SpecialOfferType offerType, Product product, double argument) {
        this.setSpecialOfferType(offerType);
        this.argument = argument;
        this.product = product;
    }

    Product getProduct() {
        return this.product;
    }

    private void setSpecialOfferType(SpecialOfferType offerType) {
        if (offerType == SpecialOfferType.ThreeForTwo)
            specialOffer = new ThreeForTwoSpecialOffer();
        else if (offerType == SpecialOfferType.TwoForAmount)
            specialOffer = new TwoForAmountSpecialOffer();
        else if (offerType == SpecialOfferType.FiveForAmount)
            specialOffer = new FiveForAmountSpecialOffer();
        else
            specialOffer = new TenPercentDiscountSpecialOffer();
    }

    public Discount getDiscount(Product p, double quantity, double unitPrice) {
        double discountAmount = specialOffer.calculateDiscountAmount(quantity, unitPrice, argument);
        if (discountAmount == 0)
            return null;
        else
            return new Discount(p, specialOffer.getDescription(argument), -discountAmount);
    }



}
