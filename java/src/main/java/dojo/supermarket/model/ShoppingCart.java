package dojo.supermarket.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingCart {

    private final List<ProductQuantity> items = new ArrayList<>();
    Map<Product, Double> productQuantities = new HashMap<>();


    List<ProductQuantity> getItems() {
        return new ArrayList<>(items);
    }

    void addItem(Product product) {
        this.addItemQuantity(product, 1.0);
    }

    Map<Product, Double> productQuantities() {
        return productQuantities;
    }


    public void addItemQuantity(Product product, double quantity) {
        items.add(new ProductQuantity(product, quantity));
        if (productQuantities.containsKey(product)) {
            productQuantities.put(product, productQuantities.get(product) + quantity);
        } else {
            productQuantities.put(product, quantity);
        }
    }

    void handleOffers(Receipt receipt, Map<Product, Offer> offers, SupermarketCatalog catalog) {
        for (Product p: productQuantities().keySet()) {
            double quantity = productQuantities.get(p);
            if (offers.containsKey(p)) {
                Offer offer = offers.get(p);
                double unitPrice = catalog.getUnitPrice(p);
                int quantityAsInt = (int) quantity;
                Discount discount = getDiscount(p, quantity, offer, unitPrice, quantityAsInt);
                if (discount != null)
                    receipt.addDiscount(discount);
            }

        }
    }

    private Discount getDiscount(Product p, double quantity, Offer offer, double unitPrice, int quantityAsInt) {
        Discount discount = null;
        int offerTypeNumber = offer.specifyType();
        if (offerTypeNumber == 2 && quantityAsInt >= 2) {

            int intDivision = quantityAsInt / offerTypeNumber;
            double pricePerUnit = offer.argument * intDivision;
            double theTotal = (quantityAsInt % 2) * unitPrice;
            double total = pricePerUnit + theTotal;
            double discountN = unitPrice * quantity - total;
            discount = new Discount(p, "2 for " + offer.argument, -discountN);


        }
        int numberOfXs = quantityAsInt / offerTypeNumber;
        if (offerTypeNumber == 3 && quantityAsInt > 2) {
            double discountAmount = quantity * unitPrice - ((numberOfXs * 2 * unitPrice) + quantityAsInt % 3 * unitPrice);
            discount = new Discount(p, "3 for 2", -discountAmount);
        }
        if (offerTypeNumber == 1) {
            discount = new Discount(p, offer.argument + "% off", -quantity * unitPrice * offer.argument / 100.0);
        }
        if (offerTypeNumber == 5 && quantityAsInt >= 5) {
            double discountTotal = unitPrice * quantity - (offer.argument * numberOfXs + quantityAsInt % 5 * unitPrice);
            discount = new Discount(p, offerTypeNumber + " for " + offer.argument, -discountTotal);
        }
        return discount;
    }


}
