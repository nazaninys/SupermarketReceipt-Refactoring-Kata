package dojo.supermarket.model;

public class Offer {
    SpecialOfferType offerType;
    private final Product product;
    double argument;

    public Offer(SpecialOfferType offerType, Product product, double argument) {
        this.offerType = offerType;
        this.argument = argument;
        this.product = product;
    }

    public int specifyType() {
        if (offerType == SpecialOfferType.ThreeForTwo)
            return 3;
        else if (offerType == SpecialOfferType.TwoForAmount)
            return 2;
        else if (offerType == SpecialOfferType.FiveForAmount)
            return 5;
        else
            return 1;
    }

    Product getProduct() {
        return this.product;
    }

}
