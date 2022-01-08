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

    public Discount getDiscount(Product p, double quantity, double unitPrice) {
        if (offerType == SpecialOfferType.ThreeForTwo)
            return calculateDiscountThreeForTwo(p, quantity, unitPrice);
        else if (offerType == SpecialOfferType.TwoForAmount)
            return calculateDiscountTwoForAmount(p, quantity, unitPrice);
        else if (offerType == SpecialOfferType.FiveForAmount)
            return calculateDiscountFiveForAmount(p, quantity, unitPrice);
        else
            return calculateDiscountTenPercentDiscount(p, quantity, unitPrice);
    }

    private Discount calculateDiscountThreeForTwo(Product p, double quantity, double unitPrice) {
        int quantityAsInt = (int) quantity;
        Discount discount = null;
        if(quantityAsInt > 2) {
            int numberOfXs = quantityAsInt / 3;
            double discountAmount = quantity * unitPrice - ((numberOfXs * 2 * unitPrice) + quantityAsInt % 3 * unitPrice);
            discount = new Discount(p, "3 for 2", -discountAmount);
        }
        return discount;
    }

    private Discount calculateDiscountTwoForAmount(Product p, double quantity, double unitPrice) {
        Discount discount = null;
        int quantityAsInt = (int) quantity;
        if (quantityAsInt >= 2) {
            int numberOfXs = quantityAsInt / 2;
            double pricePerUnit = argument * numberOfXs;
            double theTotal = (quantityAsInt % 2) * unitPrice;
            double total = pricePerUnit + theTotal;
            double discountN = unitPrice * quantity - total;
            discount = new Discount(p, "2 for " + argument, -discountN);
        }
        return discount;
    }

    private Discount calculateDiscountFiveForAmount(Product p, double quantity, double unitPrice) {
        Discount discount = null;
        int quantityAsInt = (int) quantity;
        if (quantityAsInt >= 5) {
            int numberOfXs = quantityAsInt / 5;
            double discountTotal = unitPrice * quantity - (argument * numberOfXs + quantityAsInt % 5 * unitPrice);
            discount = new Discount(p, 5 + " for " + argument, -discountTotal);
        }
        return discount;
    }

    private Discount calculateDiscountTenPercentDiscount(Product p, double quantity, double unitPrice) {
        Discount discount = new Discount(p, argument + "% off", -quantity * unitPrice * argument / 100.0);
        return discount;
    }

}
