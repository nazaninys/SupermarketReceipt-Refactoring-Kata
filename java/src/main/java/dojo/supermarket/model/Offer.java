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

    Product getProduct() {
        return this.product;
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



    public Discount getDiscount(Product p, double quantity, double unitPrice) {
        int quantityAsInt = (int) quantity;
        Discount discount = null;
        int offerTypeNumber = specifyType();
        if (offerTypeNumber == 2 && quantityAsInt >= 2) {

            int intDivision = quantityAsInt / offerTypeNumber;
            double pricePerUnit = argument * intDivision;
            double theTotal = (quantityAsInt % 2) * unitPrice;
            double total = pricePerUnit + theTotal;
            double discountN = unitPrice * quantity - total;
            discount = new Discount(p, "2 for " + argument, -discountN);


        }
        int numberOfXs = quantityAsInt / offerTypeNumber;
        if (offerTypeNumber == 3 && quantityAsInt > 2) {
            double discountAmount = quantity * unitPrice - ((numberOfXs * 2 * unitPrice) + quantityAsInt % 3 * unitPrice);
            discount = new Discount(p, "3 for 2", -discountAmount);
        }
        if (offerTypeNumber == 1) {
            discount = new Discount(p, argument + "% off", -quantity * unitPrice * argument / 100.0);
        }
        if (offerTypeNumber == 5 && quantityAsInt >= 5) {
            double discountTotal = unitPrice * quantity - (argument * numberOfXs + quantityAsInt % 5 * unitPrice);
            discount = new Discount(p, offerTypeNumber + " for " + argument, -discountTotal);
        }
        return discount;
    }
}
